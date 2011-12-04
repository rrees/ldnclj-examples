(ns looper.core
	(:require [looper.fight :as fight]
		[looper.health :as health]))

(defn fight [hero monster]
	(let [initial {:hero hero :monster monster}]
		(loop [participants initial]
			(if (some health/dead? (vals participants))
				(println "The winner is" (apply str (map :name (health/winner participants))))
				(recur (fight/attack participants))))))