{:name  "Kapil Reddy"
 :title "Building Reliable, Scalable Services with Clojure and Core.async"
 :image "kapil-reddy.jpg"
 :social [{:link "https://github.com/kapilreddy/" :icon "fa-github"}
 		  {:link "https://twitter.com/KapilReddy" :icon "fa-twitter"}]}

Reliable systems must behave well in the face of many failure scenarios. These failures can be at different levels, and sometimes we don't even know them in advance.

This unpredictable, unexpected, nature of failures ("essential" complexity of the problem domain) perpetually threatens to inject itself into our solution, as implementation-specific "incidental" complexity.

Choosing the correct abstractions, including judicious use of Clojure's macro system, can help achieve these apparently conflicting goals of reliability, scalability, and simplicity.

In the talk Kapil will cover:

- Different failure scenarios and techniques to address them
- How to decide when to choose which abstraction?
- A FSM controlled by input and control signals
- Using components to build systems
- Verifying the systems using DSLs built with macros
- General Clojure good practices that make development a lot easier

---

### About Kapil

Kapil is a Software architect at Helpshift [Helpshift](https://www.helpshift.com/). He loves to code on the server, client and everything in between! Kapil likes movies, anime, books/manga, Clojure, JS, mecha, GITS, algos, and good music.