package challenges

object challenges extends App {

  def greet(name: String, age: Int): String =
    s"Hi! My name is $name and I'm $age years old."

  println(greet("Enania", 52))

  def factorial(n: Int): Int = {
    if (n == 0) 1
    else
      val step = if (n > 0) -1 else 1
      n * factorial(n + step)
  }

  println(factorial(-5))
  println(factorial(5))

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
      if (divider == 1)
        true
      else
        n % divider != 0 && check(divider - 1)
    }

    check((n / 2))
  }

  val list = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
    59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
    139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223,
    224)

  list.foreach(n =>
    if (isPrime(n))
      println(n)
  )
}
