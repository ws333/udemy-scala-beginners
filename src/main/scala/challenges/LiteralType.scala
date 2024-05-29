package challenges

object LiteralType extends App {
  type AllowedOptions = 3 | 4
  val option: AllowedOptions = 3
  println(option)

  def someFn(o: AllowedOptions) = o match
    case 4 => println("4! Yeah!")
    case x => println(x)

  someFn(3)
}
