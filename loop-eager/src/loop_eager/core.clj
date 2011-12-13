(ns loop-eager.core
	(:gen-class))

(defn -main [& args]
	(loop []
		(if true
			(println "Loop executed")
			(recur))))