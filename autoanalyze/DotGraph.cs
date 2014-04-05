using System.Collections.Generic;
using System.Text;

namespace autoanalyze
{
    public class DotGraph
    {
        public class Edge
        {
            public Edge()
            {
                Attributes = new Dictionary<string, string>();
            }

            protected bool Equals(Edge other)
            {
                return string.Equals(Destination, other.Destination) && Equals(Attributes, other.Attributes);
            }

            public override int GetHashCode()
            {
                unchecked
                {
                    return ((Destination != null ? Destination.GetHashCode() : 0)*397) ^ (Attributes != null ? Attributes.GetHashCode() : 0);
                }
            }

            public string Destination { get; set; }
            public IDictionary<string, string> Attributes { get; private set; }
            public bool Directed { get; set; }

            public override string ToString()
            {
                var sb = new StringBuilder();
                if (Directed)
                    sb.Append("directed ");
                sb.Append(Destination);
                sb.Append("[");
                foreach (var attribute in Attributes)
                {
                    sb.AppendFormat("{0} - {1}, ", attribute.Key, attribute.Value);
                }
                sb.Append("]");
                return sb.ToString();
            }

            public override bool Equals(object obj)
            {
                if (ReferenceEquals(null, obj)) return false;
                if (ReferenceEquals(this, obj)) return true;
                if (obj.GetType() != GetType()) return false;
                return Equals((Edge) obj);
            }
        }

        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.AppendFormat("Name: {0}\nStrict: {1}\nBidirectional: {2}\n",
                Name, Strict, Bidirectional);

            foreach (var node in Nodes)
            {
                sb.AppendFormat("{0} -> [", node.Key);
                foreach (var edge in node.Value)
                    sb.Append(edge + " ");
                sb.AppendLine("]");
            }

            return sb.ToString();
        }

        public bool Strict { get; set; }
        public bool Bidirectional { get; set; }
        public string Name { get; set; }
        public ISet<string> FinalStats { get; private set; }
        public IDictionary<string, IList<Edge>> Nodes { get; private set; }

        public DotGraph()
        {
            FinalStats = new HashSet<string>();
            Nodes = new Dictionary<string, IList<Edge>>();
        }
    }
}