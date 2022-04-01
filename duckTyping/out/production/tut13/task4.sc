
import scala.collection.mutable

def wordCounter(myString: String):mutable.Map[String,Int] = {
  val counter = mutable.Map.empty[String, Int].withDefaultValue(0)//starts counting from 0 occurences
 myString.split(" ").foreach(word => counter(word)=counter(word)+1)//when a word occures, num increases


counter

}

wordCounter("That is a really really easy example, but not as easy as previous example ")