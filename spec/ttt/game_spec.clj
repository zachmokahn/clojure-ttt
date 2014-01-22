(ns ttt.game-spec
  (:require [speclj.core :refer :all]
            [ttt.game :refer :all]))

(let [board      ["-" "-" "-" "-" "-" "-" "-" "-" "-"]
      draw-board ["x" "o" "x" "x" "o" "x" "o" "x" "o"]
      x-board    ["x" "x" "x" "-" "-" "-" "-" "-" "-"]
      o-board    ["o" "o" "o" "-" "-" "-" "-" "-" "-"]]
(describe "game-over?"
  (it "false if game is not over"
      (should= false
               (game-over? board)))
  (it "true if game is draw"
    (should= true
             (game-over? draw-board)))
  (it "true if game is won by player"
    (should= true
             (game-over? x-board)))
  (it "true if game is won by computer"
    (should= true
             (game-over? o-board))))

(describe "game"
  (describe "win/lose/draw"
    (it "returns if Draw"
      (should= (str
"\n x | o | x"
"\n__________"
"\n x | o | x"
"\n__________"
"\n o | x | o"
"\n\nGame Over! It's a Draw!\n")
                (with-out-str (game draw-board :player))))
    (it "returns if Computer Wins"
      (should= ( str
"\n o | o | o"
"\n__________"
"\n 3 | 4 | 5"
"\n__________"
"\n 6 | 7 | 8"
"\n\nComputer Wins!\n")
                (with-out-str (game o-board :player))))
    (it "returns if Draw"
      (should= (str
"\n x | x | x"
"\n__________"
"\n 3 | 4 | 5"
"\n__________"
"\n 6 | 7 | 8"
"\n\nHuman Wins!\n")
                (with-out-str (game x-board :player)))))))

(describe "prompt-for-move"
  (around [it]
    (with-out-str (it)))

  (it "prompts the user for an index"
    (should= "select your move!\n"
      (with-out-str (with-in-str "1"
        (prompt-for-move)))))

  (it "returns the index as integer"
    (should= 1
      (with-in-str "1"
        (prompt-for-move)))))
