package challenges

import scala.annotation.tailrec

object Inheritance extends App {

  case class Node[T](i: T) {
    val value: T = i
    var next: Node[T] | Null = null

    // @tailrec
    def getElementsAsString(acc: String = ""): String = {
      val newValue = acc + ", " + value
      if (next == null) newValue
      else {
        val a = if (acc == "") value.toString() else newValue
        next.getElementsAsString(a)
      }
    }

    override def toString: String = s"[${getElementsAsString()}]"
  }

  abstract class MyList[T] {
    var head: Node[T]
    var tail: Node[T]
    def isEmpty: Boolean
    def add(e: T): Unit
  }

  class ListA[T](i: T) extends MyList[T] {
    var head = new Node(i)
    var tail = head
    def isEmpty: Boolean = head == null
    def add(e: T) = {
      tail.next = new Node(e)
      tail = tail.next
    }

    override def toString: String = {
      head.toString()
    }

    // override def toString: String = {

    //   val c = head.next
    //   val a = head.value.toString()

    //   @tailrec
    //   def trScanList(current: Node = c, acc: String = a): String = {
    //     if (current == null) return acc
    //     if (current.next == null) return acc + ", " + current.value
    //     else trScanList(current.next, acc + ", " + current.value)
    //   }

    //   trScanList()
    // }
  }

  var aList = new ListA[Int](333)

  aList.add(777)
  aList.add(999)

  println(aList.toString())

  var sList = new ListA[String]("I")

  sList.add("am")
  sList.add("a list of strings")

  println(sList.toString())
}
