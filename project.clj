(defproject fp-contest-june-2015 "0.1.0-SNAPSHOT"
  :description "June 2015 Functional Programming contest."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [expectations "2.0.9"]]
  :main ^:skip-aot fp-contest-june-2015.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
