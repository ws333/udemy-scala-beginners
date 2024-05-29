package myExamples

type MyType = (x: Any) => Unit

object matchCaseByType extends App {
  def takesManyTypes(value: Int | String | MyType) = value match {
    case fn: MyType => {
      println("takesManyTypes: MyType")
      fn("Scala rocks!")
      fn(3)
    }
    case _: Int    => println("takesManyTypes: Int")
    case _: String => println("takesManyTypes: String")
  }

  def paramFn(x: Any) = {
    x match {
      case _: Int    => println(s"Inside param fn: Int passed -> $x")
      case _: String => println(s"Inside param fn: String passed -> $x")
    }
  }

  takesManyTypes("abc")
  takesManyTypes(3)
  takesManyTypes(paramFn)
}
