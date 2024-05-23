package challenges

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int) {

    def apply(count: Int): Unit = println(
      s"$name watched $favoriteMovie $count times"
    )

    def +(nameToAppend: String): Person =
      new Person(s"$name ($nameToAppend)", favoriteMovie, age)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    infix def learns(subject: String): String = s"$name learns $subject"

    // Compiler warning about the notation below if the function learns not defined as infix
    def learnsScala: String = this learns "Scala"

    def log = println(s"$name, $age")
  }

  val sara = new Person("Sara", "Rango", 47)

  // Overloaded + function
  (sara + "The Cryptic").log

  // Overloaded unary_+ function
  (+sara).log

  // Infix notation below require: import scala.language.postfixOps
  println(sara learns "The Actor Model")

  // Two ways of calling the apply method
  sara.apply(3)
  sara(4)
}
