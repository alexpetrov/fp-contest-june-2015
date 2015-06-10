# fp-contest-june-2015

A Clojure library designed to ... well, that part is up to you.
This program implements some data transformations on hexapods habitat statistics.
Task description in Russian language is here in Roman's blog post: http://haskell98.blogspot.ru/2015/06/blog-post_5.html

Check out code in [core.clj](https://github.com/alexpetrov/fp-contest-data-transformations/blob/master/src/fp_contest_data_transformations/core.clj).

Check out tests to see basic examples of what algorithm is about [core_test.clj](https://github.com/alexpetrov/fp-contest-data-transformations/blob/master/test/fp_contest_data_transformations/core_test.clj).

## Usage

To run program enter following in console:

``` bash
./run.sh
```

It will compile program to one uberjar and run it.

To run tests:

``` bash
lein test
```

## Output

If you run this program, you will get this output in console:

```
"Elapsed time: 15.191876 msecs"
Пятёрка стран с самым большим количеством видов насекомых из коллекции:
(["Уганда" 10] ["Россия" 10] ["Эфиопия" 9] ["ЮАР" 8] ["Вевелония" 6])
```

FIXME

## License

Copyright © 2015 Alexander Petrov (a.k.a. Lysenko by passport)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
