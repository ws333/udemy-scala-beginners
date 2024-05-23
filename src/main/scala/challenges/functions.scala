package challenges

// def main(args: Array[String]): Unit = {
object challenges extends App {

  def greet(name: String, age: Int): String =
    s"Hi! My name is $name and I'm $age years old."

  println(greet("Enania", 52))

  def factorial(n: Int): Int = {
    if (n == 0) 1
    else
      n * factorial(n - 1)
  }

  println(factorial(3))

  def fibo(n: Int): Int = {
    if (n <= 1)
      n
    else
      fibo(n - 1) + fibo(n - 2)
  }

  println(fibo(8))

  def isPrime(n: Int): Boolean = {
    //
    def check(divider: Int): Boolean = {
      if (divider == 1) {
        true
      } else if (n % divider == 0) {
        false
      } else
        check(divider - 1)
    }

    check(n - 1)
  }

  val list = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
    59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
    139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223)

  val range = List(1 to 230)
  list.foreach(n =>
    if (isPrime(n))
      println(n)
  )
}
