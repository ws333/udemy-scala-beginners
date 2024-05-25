package challenges

import scala.annotation.tailrec

object Inheritance extends App {

  case class Node(i: Int) {
    val value: Int = i
    var next: Node | Null = null

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

  abstract class MyList {
    var head: Node
    var tail: Node
    def isEmpty: Boolean
    def add(e: Int): Unit
  }

  class ListA(i: Int = 0) extends MyList {
    var head = new Node(i)
    var tail: Node = head
    def isEmpty: Boolean = head == null
    def add(e: Int) = {
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

  var aList = new ListA(333)

  aList.add(777)
  aList.add(999)

  println(aList.toString())
}
