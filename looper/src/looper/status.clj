(ns looper.status
	(:require [looper.health :as health]))

(defn winner [participants]
	(filter #(not(health/dead? %)) (vals participants)))