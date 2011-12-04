(ns looper.core
	(:require [looper.fight :as fight]))

(defn fight [hero monster]
	(loop [hero monster]
		(if (any? dead? [hero monster])
			(println "Fight over")
			recur(fight/attack(hero monster)))))