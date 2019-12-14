(ns day-one.core
  (:gen-class))

(defn calculate-fuel-by-mass [mass]
  (-> mass
      (/ 3)
      (Math/floor)
      (- 2)))

(defn calculate-fuel-by-module
  ([mass]
   (calculate-module-fuel 0 mass))
  ([acc mass]
   (let [fuel (calculate-fuel mass)]
     (if (<= fuel 0)
       acc
       (calculate-module-fuel (+ acc fuel) fuel)))))

(defn -main
  [& args]
  (let [fuel-requeriments (reduce calculate-module-fuel 0 args)]
    (println "The sum of fuel requeriments is " fuel-requeriments)))
