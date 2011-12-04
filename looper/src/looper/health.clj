(ns looper.health)

(defn dead? [participant]
	(if (< (get participant :health 0) 1)
		true false))

(defn winner [participants]
	(filter #(not( dead? %)) (vals participants)))