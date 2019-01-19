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

;;================= MAIN ============================

(let [speaker-order (string/split (slurp "speakers/order.txt") #"\n")
      speaker-meta (reduce (fn [v speaker]
                             (let [rdr (->> (str "speakers/" speaker ".md")
                                            (slurp)
                                            (string-push-back-reader))
                                   meta (read rdr)
                                   details (md->html (read-to-eof rdr))]
                               (spit (str speaker ".html") (nj/render "speaker-details.html" (clj->js (assoc meta :details details))))
                               (conj v (assoc meta :details (str speaker ".html")))))
                           []
                           speaker-order)]
  (spit "index.html" (nj/render "index.html" (clj->js {:speakers speaker-meta}))))
