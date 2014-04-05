using System.Collections.Generic;
using System.Linq;
using grammars;

namespace autoanalyze
{
    public class DotGraphVisitor : dotBaseVisitor<DotGraph>
    {
        private class StringDotVisitor : dotBaseVisitor<string>
        {
            public override string VisitNode_id(dotParser.Node_idContext context)
            {
                return context.id().GetText();
            }
        }

        private class AttributesDotVisitor : dotBaseVisitor<IDictionary<string, string>>
        {
            public override IDictionary<string, string> VisitA_list(dotParser.A_listContext context)
            {
                var ids = context.id();
                var result = new Dictionary<string, string>();

                for (var i = 0; i < ids.Count; i += 2)
                {
                    var lhs = ids[i].GetText();
                    var rhs = ids[i + 1].GetText();
                    result[lhs] = rhs;
                }

                return result;
            }

            public override IDictionary<string, string> VisitAttr_list(dotParser.Attr_listContext context)
            {
                var result = new Dictionary<string, string>();
                foreach (var kp in context.a_list().SelectMany(Visit))
                    result[kp.Key] = kp.Value;
                return result;
            }
        }

        private readonly StringDotVisitor _stringVisitor = new StringDotVisitor();
        private readonly AttributesDotVisitor _attributesVisitor = new AttributesDotVisitor();
        private readonly DotGraph _graph = new DotGraph();

        public override DotGraph VisitGraph(dotParser.GraphContext context)
        {
            _graph.Strict = context.STRICT() != null;
            _graph.Bidirectional = context.directed.Type == dotLexer.DIGRAPH;
            _graph.Name = context.id().GetText();
            return Visit(context.stmt_list());
        }

        public override DotGraph VisitEdge_stmt(dotParser.Edge_stmtContext context)
        {
            var lhsId = _stringVisitor.Visit(context.lhs);
            var rhsId = _stringVisitor.Visit(context.rhs);
            var attributes = _attributesVisitor.Visit(context.attributes);

            IList<DotGraph.Edge> edgeList;
            if (!_graph.Nodes.TryGetValue(lhsId, out edgeList))
            {
                var newEdgeList = new List<DotGraph.Edge>();
                _graph.Nodes[lhsId] = newEdgeList;
                edgeList = newEdgeList;
            }

            var edge = new DotGraph.Edge {Destination = rhsId, Directed = context.op.Type == dotLexer.DIEDGE_OP};
            foreach (var attr in attributes)
                edge.Attributes.Add(attr);

            edgeList.Add(edge);
            return _graph;
        }

        public override DotGraph VisitStmt_list(dotParser.Stmt_listContext context)
        {
            var stmts = context.stmt();
            foreach (var stmt in stmts)
                Visit(stmt);
            return _graph;
        }
    }
}
