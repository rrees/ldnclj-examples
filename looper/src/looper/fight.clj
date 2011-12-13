(ns looper.fight
	(:require [looper.dice :as dice]
		[looper.damage :as damage]))

(defn attack-score [participant]
	(reduce + (get participant :speed  0) (dice/dice-roll)))

(defn resolve-attack [hero monster]
	(let [hero-attack-score (attack-score hero)
		monster-attack-score (attack-score monster)
		damage (Math/abs (- hero-attack-score monster-attack-score))]
		(cond
			(= monster-attack-score hero-attack-score) {}
			(> monster-attack-score hero-attack-score) {:loser :monster :damage (damage/calculate damage hero monster)}
			:default {:loser :hero :damage (damage/calculate damage monster hero)})))

(defn round [participants]
	(let [result (resolve-attack (participants :hero) (participants :monster))
		loser (:loser result)]
		(if loser
			(do
				(println (str (:name (loser participants)) " takes " (:damage result) " points of damage"))
				(update-in participants [loser :health]
					#(- % (get result :damage 0))))
			participants)))
		