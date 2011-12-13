(ns looper.health)

(defn dead? [participant]
	(if (< (get participant :health 0) 1)
		true false))

