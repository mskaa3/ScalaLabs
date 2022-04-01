object Task1 extends App {
  //we create a function that expects anything that can make noise(any object of the class that contain a method noise).
  def makeNoise[A <: { def noise(): Unit }](obj: A) {
    obj.noise()
  }
  makeNoise(new Dog)
  Thread.sleep(1500)
  makeNoise(new Cat)
  Thread.sleep(1500)
  makeNoise(new Bird)
  Thread.sleep(1500)
  makeNoise(new Mouse)
  Thread.sleep(1500)
  makeNoise(new Cow)
  Thread.sleep(1500)
  makeNoise(new Frog)
  Thread.sleep(1500)
  makeNoise(new Elephant)
  Thread.sleep(1500)
  println("But there's one sound")
  Thread.sleep(1500)
  println("That no one knows")
  Thread.sleep(1500)
  println("WHAT DOES THE FOX SAY? ")
  Thread.sleep(2500)
makeNoise(new Fox)
}

class Bird{
  def noise(): Unit ={
     println("Bird goes Tweet")
  }
}
class Cow {
  def noise() {
    println("Cow goes Moo")
  }
}
class Mouse {
  def noise(): Unit ={
    println("Mouse goes Squeek")
  }
}
class Frog {
  def noise(): Unit ={
    println("Frog goes croak")
  }
}
class Elephant {
  def noise(): Unit ={
    println("Elephant goes Toot")
  }
}
class Fox{
  def noise(): Unit ={
    println("Ring-ding-ding-ding-dingeringeding!\nGering-ding-ding-ding-dingeringeding!\nGering-ding-ding-ding-dingeringeding!")
  }
}
class Dog {
  def noise() {
    println("Dog goes Woof")
  }
}
class Cat {
  def noise() {
    println("Cat goes Meow")
  }
}

