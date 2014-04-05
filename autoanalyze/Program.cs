using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using grammars;

namespace autoanalyze
{
    static class Program
    {
        static void Main(string[] args)
        {
            const string inputFile = @"C:\Users\Duarte\Desktop\Comp\ws\feup-comp-2014\dot_dfa_examples\fsm.gv";
            var input = new AntlrFileStream(inputFile);
            var lexer = new dotLexer(input);
            var tokens = new CommonTokenStream(lexer);
            var parser = new dotParser(tokens);
            var tree = parser.graph();

            var eval = new DotGraphVisitor();
            var graph = eval.Visit(tree);
            Console.WriteLine(graph);
            Console.ReadKey();
        }
    }
}
