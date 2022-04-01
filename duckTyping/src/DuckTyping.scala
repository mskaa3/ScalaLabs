class Cow {
  def noise() {
    println("Muu Muuu")
  }
}
class Dog {
  def noise() {
    println("Bark Bark")
  }
}
class Cat {
  def noise() {
    println("Miau Miau")
  }
}
class Wolf {
  def noise() {
    println("Wooooooof")
  }
}
object DuckTyping  extends App{
  def makeNoise[A <: { def noise(): Unit }](obj: A) {
    obj.noise()
  }
  makeNoise(new Cow)
  makeNoise(new Dog)
  makeNoise(new Cat)
  makeNoise(new Wolf)
}
//takes only objects containing a particular method noise
//if I create a class without a method noise, than the object from it cannot be passed as an argument to the makeNoise