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
var mark =  Person("Mark", "Robin")
var john =  Person("John", "Wolf")
var ursula =  Person("Ursula" , "Dark")
var ron=Person("Ron","Wolf")
var daniel =Person("Daniel", "Dark" )
var michael =Person("Michael", "Monty" )

var peeopleList  : List[Person] = List(mark,john,ursula,ron,daniel,michael)
peeopleList .sorted