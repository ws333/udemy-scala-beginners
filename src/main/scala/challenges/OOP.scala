package challenges

import scala.annotation.tailrec

object OOP extends App {

  class Writer(firstName: String, lastName: String, val age: Int) {
    def fullName: String = firstName + " " + lastName
  }

  class Novel(var name: String, var year: Int, var author: Writer) {
    def authorAge: Int = author.age

    def isWrittenBy: String = author.fullName

    def copy(year: Int): Novel = new Novel(name, year, author)
  }

  var donald = new Writer("Donald", "Duck", 19)
  var aBook = new Novel("Ducktown memories", 1972, donald)
  println(
    s"Vintage book for sale! ${aBook.isWrittenBy} at the age of ${aBook.authorAge} is proud to announce ${aBook.name}"
  )

  class Counter(val count: Int) {

    def inc: Counter = {
      println("Inc")
      new Counter(count + 1)
    }
    def dec: Counter = {
      println("Dec")
      new Counter(count - 1)
    }

    @tailrec
    final def inc(n: Int): Counter = {
      if (n <= 0) return this
      else inc.inc(n - 1)
    }

    @tailrec
    final def dec(n: Int): Counter = {
      if (n <= 0) return this
      else dec.dec(n - 1)
    }

    def print = println(count)
  }

  var c = new Counter(13)

  c.print
  c.inc.print
  c.inc(11).print
  c.dec.print
  c.dec(3).print

}
