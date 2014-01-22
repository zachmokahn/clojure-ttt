(ns ttt.board-spec
  (:require [speclj.core :refer :all]
            [ttt.board :refer :all]))

(describe "has the correct marks"
  (it "blank = '-'"
    (should= "-"
             (:blank mark)))
  (it "player = 'x'"
    (should= "x"
            (:player mark)))
  (it "computer = 'o'"
    (should= "o"
            (:computer mark))))

(let [board ["-" "-" "-" "-" "-" "-" "-" "-" "-"]
 full-board ["x" "o" "x" "x" "o" "x" "o" "x" "o"]]
(describe "new-board"
  (it "is an empty vector"
    (should= board
             new-board)))

(describe "valid-move"
  (it "returns true if space is bank"
    (should= true
             (valid-move? board 0)))
  (it "returns false if spaces is occupied"
    (should= false
             (valid-move? full-board 0))
    (should= false
             (valid-move? full-board 1))))

(describe "move"
  (it "return a vector with players move"
    (should= ["-" "-" "-" "-" "x" "-" "-" "-" "-"]
             (move board 4 :player)))
  (it "returns a vector with the computers move"
    (should= ["-" "-" "-" "-" "o" "-" "-" "-" "-"]
             (move board 4 :computer)))
  (it "returns the same vector if the move is invalid"
    (should= ["x" "o" "x" "x" "o" "x" "o" "x" "o"]
             (move full-board 0 :computer))
    (should= ["x" "o" "x" "x" "o" "x" "o" "x" "o"]
             (move full-board 1 :player))))
  (describe "available-indexes"
    (it "returns a list of available indexes"
        (should= [0 1 2 3 4 5 6 7 8]
                 (available-indexes board)))
    (it "returns an empty list if none are available"
        (should= []
                 (available-indexes full-board))))

  (describe "winner?"
    (it "recognizes row wins"
      (let [row-winner1 ["x" "x" "x"
                         "-" "-" "-"
                         "-" "-" "-"]
            row-winner2 ["-" "-" "-"
                         "x" "x" "x"
                         "-" "-" "-"]
            row-winner3 ["-" "-" "-"
                         "-" "-" "-"
                         "x" "x" "x"]]
        (should= true
                 (winner? row-winner1 :player))
        (should= true
                 (winner? row-winner2 :player))
        (should= true
                 (winner? row-winner3 :player))))
    (it "recognizes column wins"
      (let [column-winner1 ["o" "-" "-"
                            "o" "-" "-"
                            "o" "-" "-"]
            column-winner2 ["-" "o" "-"
                            "-" "o" "-"
                            "-" "o" "-"]
            column-winner3 ["-" "-" "o"
                            "-" "-" "o"
                            "-" "-" "o"]]
        (should= true
                 (winner? column-winner1 :computer))
        (should= true
                 (winner? column-winner2 :computer))
        (should= true
                 (winner? column-winner3 :computer))))
    (it "recognizes diagonal wins"
      (let [diagonal-winner1 ["x" "-" "-"
                              "-" "x" "-"
                              "-" "-" "x"]
            diagonal-winner2 ["-" "-" "o"
                              "-" "o" "-"
                              "o" "-" "-"]]
        (should= true
                 (winner? diagonal-winner1 :player))
        (should= true
                 (winner? diagonal-winner2 :computer)))))
  (describe "draw"
    (it "empty board is not a draw"
      (should= false
         (draw? board)))
    (it "full board without winner is draw"
      (should= true
         (draw? full-board)))
    (let[win-board ["x" "o" "x" "o" "x" "o" "x" "o" "x"]]
    (it "full board with winner is not draw"
      (should= false
         (draw? win-board))))))
