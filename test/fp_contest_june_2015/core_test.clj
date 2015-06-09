(ns fp-contest-june-2015.core-test
  (:use expectations)
  (:require [fp-contest-june-2015.core :refer :all]))

(expect {"Hexapod1" #{"Country1", "Country2"}
         "Hexapod2" #{"Country3", "Country4"}}
        (parse-hexapods
"
Hexapod1: Country1, Country2
Hexapod2: Country3, Country4"))


(expect {"Country1" #{"Hexapod1"}}
        (process-hexapod-stats {} ["Hexapod1" #{"Country1"}]))

(expect {"Country1" #{"Hexapod1" "Hexapod2"}
         "Country2" #{"Hexapod2" "Hexapod3"}
         "Country3" #{"Hexapod3" "Hexapod4"}}
        (country->hexapod
         {"Hexapod1" #{"Country1"}
          "Hexapod2" #{"Country1", "Country2"}
          "Hexapod3" #{"Country2", "Country3"}
          "Hexapod4" #{"Country3"}}))

(expect {"Country1" 3
         "Country2" 2
         "Country3" 1}
        (country->quantity
         {"Hexapod1" #{"Country1"}
          "Hexapod2" #{"Country1", "Country2"}
          "Hexapod3" #{"Country1", "Country2"}
          "Hexapod4" #{"Country3"}}))
