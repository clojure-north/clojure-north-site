{:name  "Leon Talbot"
 :title "'You May Also Like': Clojure, Solr 7, Neural Networks & Movies"
 :image "leon-talbot.jpg"
 :talk "https://www.youtube.com/watch?v=3dJmdT28HTo"}

The talk will be practical. We are developing a movie recommendation engine taking TMDB dataset (movies metadata (title, genre, overview, global rating, movie budget, etc.)) and adding GroupLens datasets (user profiles (age, occupation, gender) and their movie ratings) for machine learning powered re-ranking.

First pass: we are going to use Solr More-Like-This built-in functionality. 

Second pass, we are going to improve recommendations using edismax query and optimize TMDB dataset columns weights.  

Third pass, we are going to re-rank top 100 results using Cortex/MxNet and Solr Learning-to-Rank capabilities, calculating user-movie relevance based on user ratings and user profiles.

There's also some open source goodies that will be released in tandem with this talk!

---

### About Leon

Clojure(script) Software Engineer working at Stylitics (NYC) passionate about algorithms & product design.