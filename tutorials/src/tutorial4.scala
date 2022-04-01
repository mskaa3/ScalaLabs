import scala.math.sqrt

object tutorial4 {
  def main(args: Array[String]): Unit = {
    findPrimes(10).foreach(x=>println(x))
    println("==========================================================")
    findPrimes(100).foreach(x=>println(x))
    //findPrimes().foreach(x=>println(x))
    println("==========================================================")
    println(calculate(Plus(Literal(5.0),Literal(6.0))))
    println(calculate(Negation(Literal(5.0))))
    println("==========================================================")
    println(and (True,False))
    println(xor(True,False))
    println(nand(True,True))
    println(nor(False,False))
    println("==========================================================")
    println(whatType(3.45))
    println(whatType('d'))
    println(whatType("Hello"))
    println(whatType(true))
    println(whatType(List(1,2,3,4)))
  }

  //Task1
  //======================================================================================================================
  //in this one i assumed the user is entering the limit of values
  def findPrimes(maxNum:Int):List[Int]={
    if(maxNum<=200) {
      def sieveOfEratosthenes(list: List[Int], last: Int): List[Int] = {
        if (list.isEmpty) List()
        else if (list.head <= last) List(list.head)++sieveOfEratosthenes(list.filter(_% list.head != 0), last)
        else list
      }

      sieveOfEratosthenes((2 to maxNum).toList, sqrt(maxNum).toInt)
    } else List()
  }
  //And this one is immidiately limiting value to 200
  //
//  def findPrimes():List[Int]={
//
//    def sieveOfEratosthenes(list: List[Int], last: Int): List[Int] = {
//      if (list.isEmpty) List()
//      else if (list.head <= last) List(list.head)++sieveOfEratosthenes(list.filter(_% list.head != 0), last)
//      else list
//    }
//
//    sieveOfEratosthenes((2 to 200).toList, sqrt(200).toInt)
//
//  }

  //Task2
  //======================================================================================================================
  sealed abstract class Numbers
  final case class Plus(a: Numbers, b: Numbers) extends Numbers
  final case class Negation(a: Numbers) extends Numbers
  final case class Literal(v: Double) extends Numbers

  def calculate(expression: Numbers):Double ={
    expression match{
      case Literal(a) => a
      case Plus(a, b)=> calculate(a)+calculate(b)
      case Negation(a) => -calculate(a)
    }
  }

  //Task3
  //======================================================================================================================
  sealed abstract class Bool
  final case object True extends Bool
  final case object False extends Bool

  def and(bol1:Bool,bol2:Bool):Boolean=(bol1,bol2) match{
    case (True,True)=> true
    case(_,_) =>false

  }
  def or(bol1:Bool,bol2:Bool):Boolean=(bol1,bol2) match{
    case (False,False)=> false
    case(_,_) =>true

  }
  def xor(bol1:Bool,bol2:Bool):Boolean=(bol1,bol2) match{
    case (True,False)=> true
    case (False,True)=> true
    case(_,_) =>false

  }
  def nor(bol1:Bool,bol2:Bool):Boolean=(bol1,bol2) match{
    case (False,False)=> true
    case(_,_) =>false

  }
  def nand(bol1:Bool,bol2:Bool):Boolean=(bol1,bol2) match{
    case (True,True)=> false
    case(_,_) =>true

  }


  //Task4
  //======================================================================================================================

  def whatType(x: Any): String = x match{
    case c: Char => s"You typed a char: $c"
    case s: String => s"You typed a string: $s"
    case i: Int => s"You typed an int: $i"
    case f: Float => s"You typed a float: $f"
    case d: Double => s"You typed a double $d"
    case _=> "Sorry, i do not recognize ths type"
  }



}
