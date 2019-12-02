#!/usr/bin/env lumo
(ns genenerator.core
  (:require
   [cljs.tools.reader :as reader :refer [read]]
   [cljs.tools.reader.reader-types :refer [string-push-back-reader read-char]]
   [clojure.string :as string]
   ["fs" :as fs]
   ["nunjucks" :as nj]
   ["marked" :as marked])
  (:import goog.string.StringBuffer))

(nj/configure "templates")

(defn slurp [path]
  (fs/readFileSync path #js{:encoding "UTF-8"}))

(defn spit [f content]
  (fs/writeFile (str "../" f)
                content
                (fn [err]
                  (if err (println err) (println "wrote file " f)))))

(defn read-to-eof [rdr]
  (loop [c (read-char rdr)
         s (StringBuffer.)]
    (if c
      (recur (read-char rdr) (.append s c))
      (str s))))

(defn md->html [s]
  (marked/parse s #js{:headerIds false}))

(defn path [& args]
  (clojure.string/join "/" (remove nil? args)))

;;================= MAIN ============================


(defn gen-site [year]
  (let [speaker-order 
        (remove clojure.string/blank? (string/split (slurp (path "speakers" year "order.txt")) #"\n"))
        
        speaker-meta  
        (reduce (fn [v speaker]
                  (let [rdr     (->> (path "speakers" year (str speaker ".md"))
                                     (slurp)
                                     (string-push-back-reader))
                        meta    (read rdr)
                        details (md->html (read-to-eof rdr))]
                    (spit (path year (str speaker ".html"))
                          (nj/render (path year "speaker-details.njk") (clj->js (assoc meta :details details))))
                    (conj v (assoc meta :details (str speaker ".html")))))
                []
                speaker-order)]
    (spit (path year "index.html") (nj/render (path year "index.njk") (clj->js {:speakers speaker-meta})))))

(gen-site "2019")
(gen-site nil)
