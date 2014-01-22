(ns ttt.game
  (:require [ttt.board :refer :all]))

(defn game-over? [board]
  (or (draw? board)
      (or (winner? board :player)
          (winner? board :computer))))

(defn render [board index]
  (if (= (get board index) (:blank mark))
        (str index)
        (get board index)))

(defn draw-board [board]
  (println (str "\n "  (render board 0) " | "
                       (render board 1) " | "
                       (render board 2) "\n"
                       "__________\n "
                       (render board 3) " | "
                       (render board 4) " | "
                       (render board 5) "\n"
                       "__________\n "
                       (render board 6) " | "
                       (render board 7) " | "
                       (render board 8) "\n")))

(defn get-winner [board]
  (if (winner? board :player)
        (println "Human Wins!")
        (println "Computer Wins!")))

(defn get-outcome-of [board]
  (if (draw? board)
        (println "Game Over! It's a Draw!")
        (get-winner board)))

(defn prompt-for-move []
    (println "select your move!")
    (read-string (read-line)))

(defn computer-move [board]
  (rand-nth (available-indexes board)))

(defn get-move [turn board]
  (if (= turn :player)
        (prompt-for-move)
        (computer-move board)))

(defn switch-turn [player]
  (if (= player :player) :computer :player))

(defn game [board turn]
  (draw-board board)
  (if (game-over? board)
    (get-outcome-of board)
    (let [index (get-move turn board)]
      (if (valid-move? board index)
    (recur (move board index turn) (switch-turn turn))
    (recur board turn)))))
