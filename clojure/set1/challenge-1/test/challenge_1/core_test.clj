(ns challenge-1.core-test
  (:require [clojure.test :refer :all]
            [challenge-1.core :refer :all]))

(deftest a-test
  (testing "hex-to-base64: convert hex string to base64"
    (is
     (=
      (hex-to-base64
       (clojure.string/join ""
        ["49276d206b696c6c696e6720796f757220627261696e206c696b6520612"
         "0706f69736f6e6f7573206d757368726f6f6d"]))
      "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"))))
