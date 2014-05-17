module Aut_COMP_HW1(accept) where

delta :: Int -> Char -> Int
delta 1 c	|c=='b' = 2|c=='c' = 3
delta 2 c	|c=='b' = 2
delta 3 c	|c=='c' = 3
delta 4 c	|c=='e' = 5|c=='a' = 6|c=='b' = 2
delta 5 c	|c=='f' = 0
delta 6 c	|c=='a' = 6|c=='b' = 1
delta _ _ = -1

initialState::Int
initialState = 4

finalStates::[Int]
finalStates = [0,1,2,3]

accept::String -> Bool
accept str = foldl delta initialState str `elem` finalStates
