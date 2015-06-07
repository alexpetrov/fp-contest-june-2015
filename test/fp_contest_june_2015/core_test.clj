(ns fp-contest-june-2015.core-test
  (:use expectations)
  (:require [fp-contest-june-2015.core :refer :all]))

(expect {"Hexapod1" ["Country1", "Country2"]
         "Hexapod2" ["Country3", "Country4"]}
        (parse-hexapods
"
Hexapod1: Country1, Country2
Hexapod2: Country3, Country4"))
