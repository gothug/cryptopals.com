(ns challenge-1.core
  (:gen-class))

(defn hex-to-base64
  [hex-str]

  (defn base64-int-to-char
    "Maps a 6 bit number to a character in base64 encoding"
    [num]
    (cond (< num 26) (char (+ (int \A) num))
          (< num 52) (char (+ (int \a) (- num 26)))
          (< num 62) (char (+ (int \0) (- num (* 26 2))))
          (= num 62) \+
          (= num 63) \/
          :else (throw (IllegalArgumentException. "Number should be < 64"))))

  (defn split-num-into-6bit-nums
    [num]
    (defn split-and-accumulate
      [num nums]
      (if (> num 0)
          (split-and-accumulate
            (bit-shift-right num 6)
            (cons (bit-and num 0x3f) nums))
          nums))
  (split-and-accumulate num []))

  (apply
   str
   (map
    base64-int-to-char
    (mapcat
     (comp split-num-into-6bit-nums #(Integer/parseInt % 16) #(apply str %))
     (partition 6 hex-str)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Blank main."))
