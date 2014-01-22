(ns ttt.core
  (:require [ttt.board :refer :all]
            [ttt.game :refer :all]))


(defn -main []
  (game new-board :player))
