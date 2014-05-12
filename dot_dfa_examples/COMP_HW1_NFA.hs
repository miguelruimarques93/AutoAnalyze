module Aut_COMP_HW1_NFA(accept) where

delta :: Int -> Char -> Int
delta 0 c	|c=='e' = 1|c=='a' = 3|c=='b' = 2
delta 1 c	|c=='f' = 4
delta 2 c	|c=='b' = 2
delta 3 c	|c=='a' = 3|c=='b' = 5
delta 5 c	|c=='c' = 6|c=='b' = 2
delta 6 c	|c=='c' = 6
delta _ _ = -1

initialState::Int
initialState = 0

finalStates::[Int]
finalStates = [2,4,5,6]

accept::String -> Bool
accept str = foldl delta initialState str `elem` finalStates
