(ns looper.dice)

(defn d6[]
	(inc (rand-int 6)))

(defn dice-roll [] (repeatedly 2 d6))