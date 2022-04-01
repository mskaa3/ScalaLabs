def con(list: List[List[Any]]): List[Any] = {
  def aroundLists(list: List[List[Any]]): List[List[Any]] = {
    
    def aroundElems(list: List[Any]): List[Any] = {
      if (list.isEmpty) List()
      else aroundElems(list.tail) ++ List(list.head)
    }
    if (list.isEmpty) List()
    else aroundLists(list.tail) ++ List(aroundElems(list.head))
  }
  def unpackLists(list: List[List[Any]]): List[Any] = {
    if (list.isEmpty) List()
    else if (list.head.isEmpty) unpackLists(list.tail)
    else List(list.head.head) ++ unpackLists(List(list.head.tail) ++ list.tail)

  }

  unpackLists(aroundLists(list))
}