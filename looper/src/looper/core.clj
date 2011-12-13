(ns looper.core
	(:require [looper.fight :as fight]
		[looper.health :as health]
		[looper.status :as status]))

(defn fight [hero monster]
	(let [initial {:hero hero :monster monster}]
		(loop [participants initial]
			(if (some health/dead? (vals participants))
				(println "The winner is" (apply str (map :name (status/winner participants))))
				(recur (fight/round participants))))))