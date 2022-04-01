case class Person(firstName : String, surnameName :String) extends Ordered[Person] {
  override def equals(that: Any) = {

    this.compare(that.asInstanceOf[Person]) == 0&& that.isInstanceOf[Person]
  }

  override def compare(that: Person) = {

  if ((this.surnameName compare that.surnameName) == 0) {
    this.firstName compare that.firstName
  }
  else
  {

    this.surnameName compare that.surnameName;
  }
}
}
var person1 =  Person("Jessica", "Stader")
var person2 =  Person("Sara", "Stader")
var person3 =  Person("Adam" , "Mirror")

var myList  : List[Person] = List(person1,person2,person3)
myList.sorted