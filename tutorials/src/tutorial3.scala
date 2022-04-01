import scala.annotation.tailrec

object tutorial3 {

  def main(args: Array[String]): Unit = {
   val atm= convertPressure(5)_  // idea of currying i can first enter one parameter, an then use it
    println(atm("bar"))                       // for entering a second parameter independently , as in this example i can
   println( atm("torr"))                      //first set up atm value as a number, and then convert this value in different units
                                              //by simply entering a second paramter which we want
    println(fibonacciSequence(6))
    println(sumAList(List(1,2,3,4,5)))
    println(replaceNth(List(2,5,7,4,3),3,455))
    println(isSorted(List(1,2,7,4,5)))
    println(isSorted(List(1,2,3,4,5)))
    println(splitIntoTwoList(List(1,2,3,4,5)))
    println(mergeList(List(1,2,3),List(5,6,7)))
    println(reverseList(List(1,2,3,4,5)))
    println(reverseListRec(List(1,2,3,4)))
  }
  //task1
  @tailrec
  def sumAList(list:List[Int],acc:Int=0): Int= {
    if (list.length == 0) acc
    else if (list.head % 2 != 0)
      sumAList(list.tail, acc + list.head)
    else
      sumAList(list.tail, acc)
  }

  //task2
  @tailrec
  def reverseListRec(list: List[Any] ,acc:List[Any]=List()):List[Any]={
    if (list.length<=1)  List(list.head)++acc
    else reverseListRec(list.tail,List(list.head)++acc)


  }
  //not tail recursive
  def reverseList(list: List[Any]):List[Any]={
    if (list.length<=1)  List(list.head)
   else reverseList(list.tail)++List(list.head)

  }
  //task3
  @tailrec
  def mergeList(list: List[Any] ,list2: List[Any],acc:List[Any]=List()):List[Any]= {
    if(list.isEmpty) acc++list2
    else if(list2.isEmpty) acc++list
    else mergeList(list.tail,list2.tail,acc++List(list.head,list2.head))
  }
  //task4
  def fibonacciSequence(n:Int):Int= {
    @tailrec
    def helper(i:Int,acc:Int,acc1:Int):Int= {
      if(i>=n) acc
      else helper(i+1,acc+acc1,acc)
    }
    if (n<=2) 1
    else helper(2,1,1)
  }
  //task5
  @tailrec
  def splitIntoTwoList(list:List[Int],accOdd:List[Int]=List(),accEven:List[Int]=List()): (List[Int],List[Int])= {
    if (list.length == 0) (accOdd,accEven)
    else if (list.head % 2 != 0)
      splitIntoTwoList(list.tail, accOdd ++ List(list.head) ,accEven)
    else
      splitIntoTwoList(list.tail, accOdd,accEven++List(list.head))
  }
  //task6
  @tailrec
def isSorted(list:List[Int]):Boolean={
  if(list.isEmpty) true
  else if(list.head>list.min) false
  else isSorted(list.tail)
}
  //task7

  def replaceNth(list: List[Any], indexNumber:Int, elementToSwitch:Any):List[Any]={
    if (list.isEmpty) List()
    else if(indexNumber>list.length) list
    else if(indexNumber==0) List(elementToSwitch)++list.tail
    else List(list.head)++replaceNth(list,indexNumber-1,elementToSwitch)
  }
  //tail recursive version would require storing the elements before the index in the accumulator
  //@tailrec
//  def replaceNth(list: List[Any], indexNumber:Int, elementToSwitch:Any, acc:List[Any]=List()):List[Any]={
//    if (list.isEmpty) List()
//    else if(indexNumber>list.length) list
//    else if(indexNumber==0) acc++List(elementToSwitch)++list.tail
//    else replaceNth(list,indexNumber-1,elementToSwitch,List(list.head)+acc)


  //task8

  def convertPressure(pressureInAtm:Double)(unitOfMeasurement:String):Double=(unitOfMeasurement.toLowerCase ) match{
    case ("bar") =>pressureInAtm*1.01325
    case ("torr") =>pressureInAtm*760
    case ("pa") =>pressureInAtm*101325
    case ("psi") =>pressureInAtm*14.6956
    case _ => -1
  }

}
