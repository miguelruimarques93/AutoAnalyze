module Aut_COMP_HW1(accept) where

delta :: Int -> Char -> Int
delta 0 c	|c=='e' = 5|c=='a' = 6|c=='b' = 3
delta 2 c	|c=='b' = 3|c=='c' = 4
delta 3 c	|c=='b' = 3
delta 4 c	|c=='c' = 4
delta 5 c	|c=='f' = 1
delta 6 c	|c=='a' = 6|c=='b' = 2
delta _ _ = -1

initialState::Int
initialState = 0

finalStates::[Int]
finalStates = [1,2,3,4]

accept::String -> Bool
accept str = foldl delta initialState str `elem` finalStates
