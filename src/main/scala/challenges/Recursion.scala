package challenges

object Recursion extends App {

  /** Understanding tail recursion
    * https://www.scala-exercises.org/scala_tutorial/tail_recursion
    */

  def multiConcat(a: String, n: Int, acc: String = ""): String = {
    if (n <= 0) acc else multiConcat(a, n - 1, acc + a)
  }

  println(multiConcat("SomeText-", -2))
  println(multiConcat("SomeText-", 0))
  println(multiConcat("SomeText-", 1))
  println(multiConcat("SomeText-", 3))
  println(multiConcat("SomeText-", 11))

}
