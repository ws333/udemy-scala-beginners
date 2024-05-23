package challenges

object callByName extends App {

  // Parameter evaluated every time it is used (fat arrow before the parameter type).
  def someByNameFunc(x: => Long) =
    println(x)
    println(x)

  someByNameFunc(System.nanoTime())

  // Parameter evaluated when function is called
  def someByValueFunc(x: Long) =
    println(x)
    println(x)

  someByValueFunc(System.nanoTime())
}
