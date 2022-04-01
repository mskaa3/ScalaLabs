
import java.util.Collection

import javafx.print.Collation


abstract class Set[A]
{
  var set: List[A]
  def addElement(newV : A) :  Boolean
  def removeElement(toRemove : A): Any
  def isEmpty(): Boolean
  def setSize(): Int
  def clearAll(): Unit
  def hashCode():Int
  def iterator(): Iterator[A]
  def contains(toFind : A): Boolean
  def containsAll(elem: Collection[A]):Boolean
  def toArray():Array[A]

  def diff(s1: Set[], s2 : Set[A]): Set[A]
  def sum(s1: Set[A], s2 : Set[A]): Set[A]
  def intersec(s1: Set[A], s2 : Set[A]): Set[A]


}




abstract class Map
{
  type Value
  type Key
  var value: List[Value] = List()
  var key: List[Key] = List()

  def addElement(k: Key, v: Value): Boolean
  def getValue(k:Key):Value
  def mapSize(): Int
  def isEmpty(): Boolean
  def clearAll(): Unit
  def removeElement(toRemove: Key): Value
  def hashCode():Int
  def newValue(k: Key, newV : Value): Value
  def values():Collection[Value]
  def keySet():Set[Key]
  def containsKey(k:Key):Boolean
  def containsValue(v:Value):Boolean
}

//TASK3

// LinkedList uses a doubly linked list to store elements. Can act both like list and queue because
// of its implementation.Each element is called node and it has two parts-one with data, and one with adress.
//They are connected one by one with a pointer,pointing to next one.That fact makes adding and removing
//elements fast, but access is more complicated, because we have to iterate through it.

//ArrayList uses dynamic array.It implements List only. Access to elements is easy because of indexing (direct access).
//While adding and removing elements , all the bits are shifted, because of internal use of array.

