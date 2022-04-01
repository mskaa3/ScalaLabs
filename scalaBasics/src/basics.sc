import scala.annotation.tailrec
//subtract sum of the list tail from its head
def subtract(list:List[Int]):Int={
  def sumAList(list:List[Int],acc:Int=0): Int= {
    if (list.length == 0) acc
    else sumAList(list.tail, acc + list.head)
  }
  if(list.length==1) list.head
  else list.head-sumAList(list.tail)
}


def function(m:Int,n:Int):Int= {
  if (n != 0 && m == 0) n + 1

  else if (m != 0 && n == 0) function(m - 1, n)

  else function(m - 1, function(m, n - 1))
}
println(function(5,6))

//generating geometric sequence according to given values
def geometricSequence(firstNumber: Double, ratioNumber: Double, numberOfElements: Int): Array[Double] = {
  if (numberOfElements <= 1) Array(firstNumber / 2)
  else Array(firstNumber / 2) ++ geometricSequence(firstNumber * ratioNumber, ratioNumber, numberOfElements - 1)

}


//combining list of strings with a given separator
def combine(listOfString: List[String], separator: String): String = {
  if (listOfString.length == 0) " "
  else if(listOfString.length==1) listOfString.head
  else  listOfString.head + separator + combine(listOfString.tail,separator)
}
//println(combine(List("this","is","string"),"-"))



//tailrecursive
//divide list elements into lists of odd and even numbers
@tailrec
def divide(list:List[Int],accOdd:List[Int]=List(),accEven:List[Int]=List()): (List[Int],List[Int])= {
  if (list.length == 0) (accEven,accOdd)
  else if (list.head % 2 != 0)
    divide(list.tail, accOdd ++ List(list.head*3) ,accEven)
  else
    divide(list.tail, accOdd,accEven++List(list.head*list.head))
}


//non Tailrecursive
//divide list elements into lists of odd and even numbers, where even numbers are squared and odd multiplied by three
def divide(list:List[Int]): (List[Int],List[Int])= {
  def helperOdd (list:List[Int]):List[Int]= {
    if(list.isEmpty) List()
    else {
      if (list.head % 2 != 0)
        List(list.head * 3) ++ helperOdd(list.tail)
      else (helperOdd(list.tail))
    }
  }
  def helperEven (list:List[Int]):List[Int]= {
    if (list.isEmpty) List()
    else {
      if (list.head % 2 == 0)
        List(list.head * list.head) ++ helperEven(list.tail)
      else (helperEven(list.tail))
    }
  }

  (helperEven(list),helperOdd(list))
}


//Tailrecursive
//divide list elements into lists of odd and even numbers, where even numbers are squared and odd multiplied by three
@tailrec
def splitIntoTwoList(list:List[Int],accOdd:List[Int]=List(),accEven:List[Int]=List()): (List[Int],List[Int])= {
  if (list.length == 0) (accEven,accOdd)
  else if (list.head % 2 != 0)
    splitIntoTwoList(list.tail, accOdd ++ List(list.head*3) ,accEven)
  else
    splitIntoTwoList(list.tail, accOdd,accEven++List(list.head*list.head))
}



def sum(list1: List[Int], list2: List[Int]): List[Int] = {
  def helper(acc: List[Int], rest1: List[Int], rest2: List[Int]): List[Int] = {
    if(rest2.isEmpty&&rest1.isEmpty) return acc

    var newAcc =
      if(rest1.isEmpty) acc++ List(rest2.head)
      else if(rest2.isEmpty) acc ++ List(rest1.head)
      else acc++ List((rest2.head + rest2.head) )

    val RestOfA = if (rest1.isEmpty) List() else rest1.tail
    val RestOfB = if (rest2.isEmpty) List() else rest2.tail

    helper(newAcc, RestOfA, RestOfB)
  }

  helper(List(), list1, list2)
}