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
                      countries (map trim (split countries-str #","))]]
            [hexapod-name countries]))))

(comment
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
