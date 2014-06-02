code_example3_f(C):- "f" = [C]. code_example3_e(C):- "e" = [C]. code_example3_b(C):- "b" = [C]. code_example3_c(C):- "c" = [C]. code_example3_a(C):- "a" = [C]. 

transition_example3(q0, C, q1):- code_example3_e(C).
transition_example3(q0, C, q3):- code_example3_a(C).
transition_example3(q0, C, q2):- code_example3_b(C).

transition_example3(q1, C, q4):- code_example3_f(C).

transition_example3(q2, C, q2):- code_example3_b(C).

transition_example3(q3, C, q3):- code_example3_a(C).
transition_example3(q3, C, q5):- code_example3_b(C).

transition_example3(q5, C, q6):- code_example3_c(C).
transition_example3(q5, C, q2):- code_example3_b(C).

transition_example3(q6, C, q6):- code_example3_c(C).


initial_state_example3(q0).

final_state_example3(q2). final_state_example3(q4). final_state_example3(q5). final_state_example3(q6). 
accept_example3(String):-
        initial_state_example3(State), accept_example3(String,State).

accept_example3([],State):- final_state_example3(State). %state must be a final state after all of the input has been tested
accept_example3([C|Cs],State):-
        transition_example3(State,C,NextState), accept_example3(Cs,NextState).
