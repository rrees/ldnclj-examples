(ns looper.fight
	(:require [looper.dice :as dice]))

(defn attack-score [participant]
	(reduce + (get participant :speed  0) (dice/dice-roll)))

(defn attack [hero monster]
	(let [hero-attack-score (attack-score hero)
		monster-attack-score (attack-score monster)
		damage (Math/abs (- hero-attack-score monster-attack-score))]
		(cond
			(= monster-attack-score hero-attack-score) {}
			(> monster-attack-score hero-attack-score) {:monster damage}
			:default {:hero damage}
			)))