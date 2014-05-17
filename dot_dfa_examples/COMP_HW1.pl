code_COMP_HW1_f(C):- "f" = [C]. code_COMP_HW1_e(C):- "e" = [C]. code_COMP_HW1_b(C):- "b" = [C]. code_COMP_HW1_c(C):- "c" = [C]. code_COMP_HW1_a(C):- "a" = [C]. 

transition_COMP_HW1(q1, C, q2):- code_COMP_HW1_b(C).
transition_COMP_HW1(q1, C, q3):- code_COMP_HW1_c(C).

transition_COMP_HW1(q2, C, q2):- code_COMP_HW1_b(C).

transition_COMP_HW1(q3, C, q3):- code_COMP_HW1_c(C).

transition_COMP_HW1(q4, C, q5):- code_COMP_HW1_e(C).
transition_COMP_HW1(q4, C, q6):- code_COMP_HW1_a(C).
transition_COMP_HW1(q4, C, q2):- code_COMP_HW1_b(C).

transition_COMP_HW1(q5, C, q0):- code_COMP_HW1_f(C).

transition_COMP_HW1(q6, C, q6):- code_COMP_HW1_a(C).
transition_COMP_HW1(q6, C, q1):- code_COMP_HW1_b(C).


initial_state_COMP_HW1(q4).

final_state_COMP_HW1(q0). final_state_COMP_HW1(q1). final_state_COMP_HW1(q2). final_state_COMP_HW1(q3). 
accept_COMP_HW1(String):-
        initial_state_COMP_HW1(State), accept_COMP_HW1(String,State).

accept_COMP_HW1([],State):- final_state_COMP_HW1(State). %state must be a final state after all of the input has been tested
accept_COMP_HW1([C|Cs],State):-
        transition_COMP_HW1(State,C,NextState), accept_COMP_HW1(Cs,NextState).
