#!/bin/bash
lein uberjar && time java -jar target/uberjar/fp-contest-june-2015-0.1.0-SNAPSHOT-standalone.jar
