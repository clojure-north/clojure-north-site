{:name  "Morri Feldman"
 :title "Lessons in Building a System that Processes More than 70 Billion Events Daily"
 :image "morri.jpg"
 :talk "https://www.youtube.com/watch?v=VBIlk3GMmNc"}

AppsFlyer’s mobile attribution and analysis platform is used by the biggest and most popular applications on Earth, generating a constant “storm” of 70B+ events (HTTP Requests) on their microservices, cloud based platform daily. In this talk, Morri will share their technological choices which include Clojure as their leading backend language - and the decisions to migrate from Python for improved multi-threading and concurrency.

The backend was to built to be a robust system based on a diversity of open source tooling such as: Kafka, RabbitMQ, Aerospike, Redis and a host of proprietary in-house developed tools and services that enable the testing and adoption of new data technologies, continuous deployment, and large-scale monitoring of the system - including open sourcing production libraries for interoperability with core technologies.

This talk will also dive into AppFlyer's real-time back-end architecture & functional programming philosophy, what it is like to be a developer at AppsFlyer, and overall attitude towards performance, redundancy and resiliency for processing 35 Million events/minute at an average latency of hundreds of milliseconds per event.

---

### About Morri

Morri Feldman joined AppsFlyer as the first member of their data team about 5 years ago. Before AppsFlyer, he was in academia training as a Biophysicist. Since joining AppsFlyer he has been loving the fast pace of development and exciting technologies that used to handle the enormous scale of AppsFlyer data. Most of his coding at AppsFlyer is in Clojure with some work in Scala for Spark jobs. The functional paradigms in Clojure really help to quickly write correct code that performs well in a multi-threaded environment. Morri holds a PhD in Biophysics from UCSF.