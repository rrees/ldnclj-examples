(ns looper.damage)

(defn calculate [base-damage winner loser]
	(let [winners-brawn (get winner :brawn 0)
		losers-armour (get loser :armour 0)]
	(+ base-damage (max 0 (- winners-brawn losers-armour)))))