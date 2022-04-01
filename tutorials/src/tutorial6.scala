

  import scala.annotation.tailrec

  object tutorial6 {
    def main(args: Array[String]): Unit = {
      println(fibonacciSequenceImperative(5))
      println(fibonacciSequence(5))
      println(divide(10,5))
      //println(divide(10,0))
    }

    //reursive way
    def fibonacciSequence(n: Int): Int = {
      @tailrec
      def helper(i: Int, acc: Int, acc1: Int): Int = {
        if (i >= n) acc
        else helper(i + 1, acc + acc1, acc)
      }

      if (n <= 2) 1
      else helper(2, 1, 1)
    }
  //imperative way
    def fibonacciSequenceImperative(n: Int): Int = {
      var n1 = 0
      var n2 = 1
      var n3 = 0;
      if (n <= 2) 1
      for (i <- 1 until n) {
        n3 = n1 + n2
        n1 = n2
        n2 = n3
      }
      return n3
    }
//division with an exception
  def divide (numberToDivide:Int, numberToDivideBy:Int): Int ={
    if (numberToDivideBy==0) throw new ArithmeticException("You cant divide by 0")
    else numberToDivide/numberToDivideBy
  }



}
