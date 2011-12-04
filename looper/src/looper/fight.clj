(ns looper.fight
	(:require [looper.dice :as dice]))

(defn attack-score [participant]
	(reduce + (get participant :speed  0) (dice/dice-roll)))

(defn resolve-attack [hero monster]
	(let [hero-attack-score (attack-score hero)
		monster-attack-score (attack-score monster)
		damage (Math/abs (- hero-attack-score monster-attack-score))]
		(cond
			(= monster-attack-score hero-attack-score) {}
			(> monster-attack-score hero-attack-score) {:loser :monster :damage damage}
			:default {:loser :hero :damage damage}
			)))

(defn attack [participants]
	(let [result (resolve-attack (participants :hero) (participants :monster))
		loser (:loser result)]
		(if loser
			(update-in participants [loser :health]
				#(- % (get result :damage 0)))
			participants)))
		