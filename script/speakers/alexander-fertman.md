{:name "Alexander Fertman"
 :title "[Lightning] Gluing Clojure Microservices"
 :image "placeholder.jpg"
 :social [{:link "https://linkedin.com/in/sfertman" :icon "fa-linkedin"}]}

In this talk Alexander will present two small utilities, which make it almost trivial to start breaking away libraries from your monolithic prototype into scalable micro-services.

The first one is called "easy-rpc". As its name suggests it makes remote calls easy; as easy as local function invocation. It does that by abstracting away api and client boilerplate and automatically wrapping it up with your library's own api.

The second one is called "redis-atom". It allows you to safely share state between your Clojure micro-services. It does that by implementing the familiar Clojure atom api on top of Redis backend.


---

### About Alexander

Alexander is a backend software engineer with TodaQ. He's been hacking professionally and otherwise in Clojure for about a year and a half now. He has been involved with backend micro-service architectures in one way or another since 2016. Prior to software engineering he had adventures in aerospace, biomedical and electrical engineering.
