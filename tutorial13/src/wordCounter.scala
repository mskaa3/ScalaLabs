
import scala.collection.mutable.Map;
object Main extends App {
  def wordCounter(string: String): Map[String, Int] = {
    val wordCount: Map[String, Int] = Map().withDefaultValue(0)
    string.split(' ').foreach(word => wordCount(word) += 1)
    return wordCount
  }

  val words=wordCounter("I needed an example so I gave an example to proove that my example is correct ")
  println(words)
}
