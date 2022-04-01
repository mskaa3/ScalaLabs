import scala.annotation.tailrec

object lab3 extends App {

  def ang(boolean1: Boolean, boolean2: Boolean): Boolean =
    (boolean1, boolean2) match {

      case (true, true) => true
      case (true, false) => false
      case (false, false) => false
      case (false, true) => false
      //or we can just assume all cases which are not true,true situation are resulting in false so
      //    case(_,_)=>false
    }

  println(ang(false, true))

  def combine(listOfString: List[String], separator: String): String = {
    if (listOfString.length == 0) " "
    else if (listOfString.length == 1) listOfString.head
    else listOfString.head + separator + combine(listOfString.tail, separator)
  }

  println(combine(List("this", "is", "string"), "-"))


  def geometricSequence(firstNumber: Double, ratioNumber: Double, numberOfElements: Int): Array[Double] = {
    if (numberOfElements <= 1) Array(firstNumber / 2)
    else Array(firstNumber / 2) ++ geometricSequence(firstNumber * ratioNumber, ratioNumber, numberOfElements - 1)

  }

  geometricSequence(1, 3, 3)
}