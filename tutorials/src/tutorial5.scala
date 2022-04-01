object tutorial5 {
  def main(args: Array[String]): Unit = {
     println(fibs().take(3).toList)
    println(fibs().take(6).toList)
    println(lRepeat(4)(LazyList(1, 6, 2)).toList)
    println(lRepeat(5)(LazyList(1, 2, 7)).toList)
    println(search(create(5)).take(7).toList)
  }
  def fibs(current: Int = 0, next: Int = 1): LazyList[Int] = {
    LazyList.cons(current, fibs(next, current + next))
  }
  def lRepeat(k: Int)(list: LazyList[Any],acc:LazyList[Any]=LazyList()): LazyList[Any] =
  {
    if(k < 1) LazyList()
    else list++ lRepeat(k - 1)(list)
  }

  sealed trait Tree[+A]

  case object Leaf extends Tree[Nothing]

  case class Branch[+A](elem: A, left: () => Tree[A], right: () => Tree[A]) extends Tree[A]

  def create(num: Int): Tree[Int] = Branch(num, () => create(2 * num), () => create(1+ 2 * num ))

  def search[A](t: Tree[A]): LazyList[A] =
  {
    def check(lazyL: List[Tree[A]]): LazyList[A] = lazyL match
    {
      case Nil => LazyList()
      case Leaf :: n => check(n)
      case Branch(element, left, right) ::n => element #:: check(n ::: List(left(), right()))
    }

    check(List(t))
  }





}
