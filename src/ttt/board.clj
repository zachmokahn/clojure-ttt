(ns ttt.board)

(def mark
  { :blank "-"
    :player "x"
    :computer "o"
   })

(def new-board
  (vec (repeat 9 (:blank mark))))

(def winning-combos
  [[0 1 2] [3 4 5] [6 7 8]
   [0 3 6] [1 4 7] [2 5 8]
   [0 4 8] [2 4 6]])

(defn valid-move? [board index]
  (= (get board index) (:blank mark)))

(defn move [board index turn]
  (if (valid-move? board index) (vec (assoc board index (turn mark))) board ))

(defn available-indexes [board]
    (keep-indexed
      (fn [index value]
        (if (= value (:blank mark))
          index))
    board))

(defn map-winning-combos [board turn]
  (filter (fn [combo]
    (every? (fn [marker] (= marker(turn mark)))
              (map (fn [index] (get board index)) combo)))
    winning-combos))

(defn winner? [board turn]
  (not (empty? (map-winning-combos board turn))))

(defn draw? [board]
  (and (not-any? (fn [spaces] (= spaces (:blank mark))) board)
       (and (not (winner? board :player))
            (not (winner? board :computer)))))
