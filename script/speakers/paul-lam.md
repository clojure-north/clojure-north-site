{:name "Paul Lam"
 :title "Debugging Clojure Services Under Stress"
 :image "paul-lam.jpg"
 :social [{:link "" :icon ""}]}

Debugging service defects is a stressful job. You wake up in the middle of the night from an ops alarm (because system fail always happen in the middle of the night). You look at the stack trace and jump into your Clojure code base. Oh, that's strange, this condition shouldn't happen. You look into the database. Sure enough, the state of the task is really in this unlikely state. How did that occur? You load up your server logs to the timestamp where this exception happened. Oh, what's that above? A network hiccup. But surely we architected for network outages. You dig deeper. You noticed a race condition happened. It seems that the network hiccup happened at exactly the small part of your system that you didn't handle this error properly. You identified the problems. This isn't over yet.

By now, it has been more than a few minutes. A customer on the other side of the globe is starting their work day and noticed an error. They message your support. You pause some of your workers so the transient bad data doesn't mess things up even more. You update your database records to their expected state. By the time you're done, job queue is backed up. You turn your workers back on. Oh no! That was too much load to the system...

Debugging service defect is a stressful job. Your system is in an unexpected state. When one thing behaves unexpectedly, usually it affects other parts and you end up with multiple problems. You probably won't be in the best of mental state yourself when faced with this mess. And how much time do you have to figure all of this out? Well. Did I mention that debugging service defect is a stressful job?

---

### About Paul

Paul is the engineering lead at Motiva. He's been lucky in his software engineering career being able to work mainly with Clojure at various companies across the US and Europe. Prior to serving as a tech lead, Paul worked on data processing pipelines and helped maintain open source Clojure projects such as docker-clojure, Cascalog, and Incanter.