type Interface = {
  def method(input: String):String
};
class Foo {
  def method(input: String):String = input
}
class Bar {
  def method(input: String):String = input
}
var foo: Interface = new Bar();
foo=new Foo()
