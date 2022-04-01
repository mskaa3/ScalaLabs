import scala.annotation.tailrec

object Tutorial2 {
  def main(args: Array[String]): Unit = {
    println( fibonacciSequence(7))
    val numbersList: List[Int]=List(1,2,3,4,5,6,7,8)
    val stringList: List[String]=List("Mark","Steven","Anna","Karen")
    val repeatingNumbers: List[Int]=List(1,2,3,2,4,2,7,2,2,8,2,8,2)
    println("Sum of odd numbers of the list with accumulator "+sumAList(numbersList))
    // println("Sum of odd numbers of the list without accumulator "+sumAList(numbersList))
    println("Connected string with separator is: \n"+connectStrings(stringList," and "));
    println("Specific element calculated with accumulator "+countSpecificElem(2,repeatingNumbers))
    //println("Specific element calculated without accumulator "+countSpecificElem(repeatingNumbers,2))
  }

  //Some task i wrote in two ways since i didnt know which one is required. In othose versions
  //Im using a "helping" functions(function inside a function) or accumulators because sometimes if we use just a simple recursion
  //then with huge numbers we will get stackoverflow,since all the numbers will be left on the top of stack and then when we reach the last one they
  //will be add or multiplied 'backwards'. The way i used accumulator solves the problem in case

  // TASK1
  // sum odd number from the list

  @tailrec
  def sumAList(list:List[Int],acc:Int=0): Int= {
    if (list.length == 0) acc
    else if (list.head % 2 != 0)
      sumAList(list.tail, acc + list.head)
    else
      sumAList(list.tail, acc)
  }
  //without using the accumulator;

  //  def sumAList(list:List[Int]): Int= {
  //    if (list.length == 0) 0
  //    else{
  //      if (list.head % 2 == 0)
  //        sumAList(list.tail)
  //      else
  //        list.head+ sumAList(list.tail)
  //    }
  //  }

  //TASK2
  //connection strings from list with a separator

  def connectStrings(listOfString: List[String], separator: String): String = {
    if (listOfString.length == 0) " "
    else if(listOfString.length==1) listOfString.head
    else  listOfString.head + separator + connectStrings(listOfString.tail,separator)
  }
  //TASK3
  // i assumed we are taking a list of integers
  @tailrec
  def countSpecificElem(elem:Int,list:List[Int],acc:Int=0):Int={
    if(list.length==0) acc
    else if(list.head==elem) countSpecificElem(elem,list.tail,acc+1)
    else countSpecificElem(elem,list.tail,acc)
  }
  //   without accumulator
  //
  //  def countSpecificElem(list:List[Int],elem:Int):Int={
  //    if(list.length==0) 0
  //    else if(list.head==elem) countSpecificElem(list.tail,elem)+1
  //    else countSpecificElem(list.tail,elem)
  //  }

  //TASK 4
  def fibonacciSequence(n:Int):Int= {
    @tailrec
    def helper(i:Int,acc:Int,acc1:Int):Int= {
      if(i>=n) acc
      else helper(i+1,acc+acc1,acc)
    }
    if (n<=2) 1
    else helper(2,1,1)
  }
  // without accumulator
  //def fibonacciSequence(n:Int):Int= {
  //if (n<=2) 1
  //else fibbonacciSequence(n-1)+fibonacciSequence(n-2)
}