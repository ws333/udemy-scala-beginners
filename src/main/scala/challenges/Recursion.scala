package challenges

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Recursion extends App {

  /** Understanding tail recursion
    * https://www.scala-exercises.org/scala_tutorial/tail_recursion
    */

  println("\nmultiConcat(string, count)")

  @tailrec
  def multiConcat(a: String, n: Int, acc: String = ""): String = {
    if (n <= 0) acc else multiConcat(a, n - 1, acc + a)
  }

  println(multiConcat("_Test_", -2))
  println(multiConcat("_Test_", 0))
  println(multiConcat("_Test_", 1))
  println(multiConcat("_Test_", 3))
  println(multiConcat("_Test_", 11))

  /* Check for prime number with tail recursion
   */
  println("\nPrime numbers")
  def isPrime(n: Int): Boolean = {

    if (n < 0) {
      println("Negative numbers are not supported!")
      return false
    }

    @tailrec
    def checkIsPrime(divider: Int): Boolean = {
      if (divider <= 1)
        true
      else
        n % divider != 0 && checkIsPrime(divider - 1)
    }

    (n / 2) != 0 && checkIsPrime((n / 2))
  }

  val primeNumbersList = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
    43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
    127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
    199, 211, 223)

  val range = (-1 to primeNumbersList.last)
  var index = 0

  // Test isPrime
  range.toList.foreach(n =>
    if (isPrime(n))
      print(n + ", ")
      if (n != primeNumbersList(index))
        println(s"Mismatch for number $n, index $index")
      index += 1
  )
  print("\b\b \n") // Clean up comma etc

  println("\nGenerate Fibonacci")

  val range2 = (2 to 30)
  var fiboArray: ArrayBuffer[Int] = ArrayBuffer(0, 1)

  fiboArray.foreach(item => print(item + ", "))

  range2.toList.foreach(item =>
    fiboArray.append(fiboArray(item - 1) + fiboArray(item - 2))
    print(fiboArray.last + ", ")
  )
  print("\b\b \n") // Clean up comma etc

  def fibo(n: Int): BigInt | Unit = {

    if (n < 0) return ()
    if (n <= 1) return n

    @tailrec
    def fiboTailRec(
        i: Int = 2,
        secondLast: BigInt = 0,
        last: BigInt = 1
    ): BigInt = {
      if (n - i == 0)
        secondLast + last
      else
        fiboTailRec(i + 1, last, secondLast + last)
    }
    fiboTailRec()
  }

  (0 to 33).toList.foreach(n => println(fibo(n)))
}
