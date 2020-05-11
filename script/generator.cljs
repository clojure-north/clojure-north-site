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
(defn read-speakers-file [year fname]
  (try
    (remove clojure.string/blank? (string/split (slurp (path "speakers" year fname)) #"\n"))
    (catch js/Error e
      [])))

(defn gen-site [year]
  (let [speaker-order 
        (read-speakers-file year "order.txt")
        
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
                speaker-order)
        
        qas-file
        (read-speakers-file year "qas.txt")

        qas
        (reduce (fn [v speaker]
                  (let [stub (-> speaker (string/lower-case) (string/replace #"[^a-z]" "-"))]
                    (conj v {:name speaker
                             :link (path year (str stub ".html"))})))
                []
                qas-file)
        ]
    (spit (path year "index.html") (nj/render (path year "index.njk") (clj->js {:speakers speaker-meta
                                                                                :qas qas})))))

(gen-site "2019")
(gen-site nil)
