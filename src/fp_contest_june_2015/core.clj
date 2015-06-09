(ns fp-contest-june-2015.core
  (:gen-class)
  (:require [clojure.string :refer [split-lines split blank? trim join]]
            [clojure.pprint :refer [pprint print-table]]
            [clojure.java.io :as io]))

(defn parse-hexapods [raw-data]
  (let [hexapods (->> raw-data split-lines (remove blank?))]
    (into {}
          (for [hexapod hexapods
                :let [[hexapod-name countries-str] (split hexapod #":")
                      countries (into #{} (map trim (split countries-str #",")))]]
            [hexapod-name countries]))))

(defn process-hexapod-stats [country->hexapods [hexapod countries]]
  (reduce (fn [c->h country] (assoc c->h country (conj (get c->h country #{}) hexapod)))
          country->hexapods countries))

(defn country->hexapod [hexapod->country]
  (reduce #(process-hexapod-stats %1 %2)
          {} hexapod->country))

(defn country->quantity [hexapod->country]
  (into {} (for [[country hexapods] (country->hexapod hexapod->country)]
             [country (count hexapods)])))

(defn country->quantity-sorted [hexapod->country]
  (->> (country->quantity hexapod->country)
       (sort #(-(compare (last %1) (last %2))))))

(defn -main
  [& args]
  (let [path "resources"
        hexapod->country (parse-hexapods (slurp (str path "/" "hexapod-stats.txt")))
        result (time (take 5 (country->quantity-sorted hexapod->country)))]
    (println "Пятёрка стран с самым большим количеством видов насекомых из коллекции:" )
    (pprint result)))

(comment
  (country->quantity-sorted
   {"Hexapod1" #{"Country1"}
    "Hexapod4" #{"Country3"}
    "Hexapod2" #{"Country1", "Country2"}
    "Hexapod3" #{"Country1", "Country2"}})
  (country->quantity
   {"Hexapod1" #{"Country1"}
    "Hexapod2" #{"Country1", "Country2"}
    "Hexapod3" #{"Country1", "Country2"}
    "Hexapod4" #{"Country3"}})
  (process-hexapod-stats {} ["Hexapod1" #{"Country1" "Country2"}])

  (def hc {"Hexapod1" #{"Country1"}
       "Hexapod2" #{"Country1", "Country2"}
       "Hexapod3" #{"Country2", "Country3"}
       "Hexapod4" #{"Country3"}})

  (country->hexapod hc)

  (def data
  "
Hexapod1: Country1, Country2
Hexapod2: Country3, Country4")
  (parse-hexapods data)
  (split-lines data)
  (->> data split-lines (remove blank?))
  (def hexapods (->> data split-lines (remove blank?)))
  (for [hexapod hexapods
        :let [[hexapod-name countries] (split hexapod #":")]]
    [hexapod-name (into [] (split countries #","))])
  )
