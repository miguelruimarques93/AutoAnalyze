feup-comp-2014
==============

AutoAnalyze
==============

**IMPORTANT**:
To visualize automata you must have the "deps" folder in the same directory as the jar (or working directory).

SUMMARY
==============
The project parses dot files and generates automata from the parsed data. It then allows for several operations and analysis with the automata.

To specify what operations/analysis should be executed we created the AutoScript language with haskell-like syntax. This languages allows creation of variables, control expressions (with inner scopes) and several operations. Additionally, the program can be run as a REPL without needing to specify a script file.

For the grammar of the created language see aa.g4 (ANTLR grammar).

We also extended the dot language to allow the user to explicitly declare specific components of an FSA such as the alphabet and the initial state.

If the initial state is not explicitly declared, it will be the first state declared in the dot file.

Final states are declared with the attribute "shape = doublecircle" for visualization purposes.

If no label is declared for a transition (edge), it is assumed to be a null transition.

Labels can be simple characters or strings. They can also be marked with the additional attribute "regex = true" to parse the label as a regex instead of a normal string.

Example of a complete .dot file:

        digraph finite_state_machine {
            rankdir=LR;
            initialstate=LR_0;
            alphabet="efabc";
            alphabethasnull=false;
            alphabethasdoublequote=false;
            node [shape = doublecircle]; qf1 qf2 qf3;
            node [shape = circle];
            q0 -> qf1 [ label = "ef" ; regex = true ];
            q0 -> qf2 [ label = "a*bb*" ; regex = true ];
            q0 -> qf3 [ label = "aa*bc*" ; regex = true ];
        }

As for our language, every statement must end with ';'. Functions are called by writing the function name and the arguments separated by spaces.

The arguments may be the result of other functions, however those functions and their arguments must be enclosed by parentheses.

To attribute a value to a variable, you must write the identifier followed by '=' and the desired value.

Also note variables are immutable (haskell style approach).

We also allow control expressions (if, else if, else). However, the statement list in each expression must be enclosed by braces.

Example of a .aa script:

    a = loadf "dot_dfa_examples/COMP_HW1_REGEX.gv";
    b = loadr "aut1" "ef|a*bb*|aa*bc*";
    if (equivalent a b) {
        write_code "haskell" a "dot_dfa_examples/success.hs";
        write_code "c#" a "dot_dfa_examples/success.cs";
    }
    else {
        println "Failed ";
    }
    show a;
    show (minimize a) "Pneato";
        
For a complete list of the implemented operations see the documentation of the operations class in the folder "operations_doc". Functions are called with the same names as the methods and the arguments are separated by spaces (as shown in the example above).

Additionally, to quit the REPL mode you should use the command ":quit".
 
DEALING WITH SYNTACTIC ERRORS
==============
When syntactic errors are found, an appropriate error message is displayed indicating the error and the line in which it occurred.

The application does not exit after the syntactic error, indicating further errors in the file. However, if any syntactic errors did occurr, the script will not be executed.


SEMANTIC ANALYSIS
==============
Out tool has several semantic analysis such as verifying the type of the arguments in the functions (FSA, booleans or strings).

Additionally, it verifies if the number of arguments for each function is valid and if the arguments are variables it checks if they have been declared.

It also checks if the functions exists during the semantic analysis as our function names are not defined in the grammar.

It is also worth mentioning it indicates the line where the error occurred.


INTERMEDIATE REPRESENTATIONS (IRs)
==============
We used ANTLR4 for grammar specification and parsing, as such we did not need to create our own IRs for our language since ANTLR4 generates the tree and treewalkers, allowing us to traverse the parse tree using Tree Visitors which will then interpret the code directly.
 
We do however have an intermediate representation for the parsed DOT files as we created out own FSA class to store this information.

We have a high level IR which contains all of the data in the dot file (name, nodes, edges, attributes). We then convert it to a lower level IR which are our FSAs, stripping out unnecessary data and performing semantic checks.

These structures are essentially composed of a Map of string (state name) to a list of edges (our edges are all directed). They also have additional attributes to store other relevant information such as the initial state name, final states and the alphabet of the automaton.


CODE GENERATION
==============
For the language we specified we built an interpreter and not a compiler, therefore it does not generate code to execute the scripts.

We do allow users to generate the implementation of the automata in a programming language of their choice (currently we allow Haskell, Prolog and C#).

To generate the code we have pre-made templates which we then complete with information related to the automaton to implement. Namely the automaton states, transitions, initial state and final states. We also generate an acceptance method to allow a user to easily import the generated code into their project and use the accept method to validate strings.
We also allow generation of dot files for the automata which works similarly to the implementation generation.


OVERVIEW
==============
Initially we specified the dot grammar in ANTLR4 syntax. Using the Visitor pattern, generated by ANTLR4, we convert the syntax tree to a high level IR that maps the dot attributes to their string values. We then implemented the FSABuilder to create an FSA from the previous IR. These FSA accurately represent the automata.
 
We then proceded to specify our AutoScript grammar and began to implement automaton operations and analysis. We used the Visitor pattern to implement an interpreter that allows running our scripts. We also implemented a REPL mode.
 
During the development of our project, we implemented several unit tests and other test cases to allow us to verify and validate our project.

All of our operations are implemented as static methods in the Operations class. In the autoscript visitor we use reflection to perform a semantic analysis

 to validate operation and the number and types of their arguments (using the Java type system). Also, we call the operations using the same method.
 
It is also worth noting that our variables are lazy, only being evaluated when necessary (to produce output). This ensures a minimum resource usage.

We also implemented the short-circuit optimizations for our boolean logic operators.

In regards to the algorithms used to implement the automata operations, we resorted to several sources:

    - Slides of the TCOM (Theory of Computation) class in FEUP/MIEIC
    - http://www.cs.um.edu.mt/gordon.pace/Research/Software/Relic/
    - https://www.cs.cmu.edu/~flac/pdf/FSMAlgorithms-6up.pdf
    - http://cs.wellesley.edu/~cs235/fall09/lectures/14_DFA_operations/14_DFA_operations_revised.pdf
    - http://web.cecs.pdx.edu/~harry/compilers/slides/LexicalPart3.pdf
    - http://web.cecs.pdx.edu/~sheard/course/CS311/Fall2013/ppt/NfaEpsilonDefined.pdf
    - http://www.cs.umd.edu/class/fall2009/cmsc330/lectures/discussion2.pdf

Additionally, we used the brics automaton library to implement the regex parser as it was not the main purpose of our project. (http://www.brics.dk/automaton/)
For visualizing the automaton we used ZGRViewer. (Requires GraphViz to be installed). (http://zvtm.sourceforge.net/zgrviewer.html)


TESTSUITE AND TEST INFRASTRUCTURE
==============
As for file examples we have 17 files. 10 files with script examples for our language and 7 dot files defining automata.
We also have several unit tests (JUNIT) covering dot parsing, FSA building and every operation and analysis we implemented. This allows us to quickly retest the entire project after applying a patch or implementing a new feature.
