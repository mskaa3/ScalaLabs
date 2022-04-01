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
// type is a string, a boolean, an object, or a class, and they have names and structures. Primitives(strings,booleans)
// have a simple structure and only go by a name.
//previous error was generated because of the different names (that's how it works in nominal typing)
//now, since their structure is same (structural typing) it's allowed to assing foo to bar and other way round