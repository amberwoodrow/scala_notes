// import org.scalatest._

object Options {
  def main(args: Array[String]): Unit = {

    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    value1 getOrElse "No value" // should be("Found value")
    value2 getOrElse "No value" // should be("No value")
    value2 getOrElse {
      "default function"
    } // should be("default function")

    val value3 = maybeItWillReturnSomething(true)
    val value4 = maybeItWillReturnSomething(false)

    println(value3.isEmpty) // should be(false)
    println(value4.isEmpty) // should be(true)

    // Option can also be used with pattern matching:
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }
    println(value) // should be(20.0)
    val noValue: Option[Double] = None
    val value5 = noValue match {
      case Some(v) => v
      case None => 0.0
    }
    println(value5) // should be(0.0)

    // An alternative for pattern matching is performing collection style operations.
    // This is possible because an option could be looked at as a collection with either one or zero elements.
    // One of these operations is map. this operation allows to map the inner value to a different
    // type while preserving the option
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.map(_ * 1.5)
    val result2 = noNumber.map(_ * 1.5)

    // Note that the type of result1 is now Option[Double], thanks to the scala type inference.
    println(result1) // should be(Some(4.5))
    println(result2) // should be(None)

    // Another operation is fold. this operation will extract the value from the option, or provide
    // a default if the value is None
    val num: Option[Int] = Some(3)
    val noNum: Option[Int] = None
    val result3 = num.fold(0)(_ * 3)
    val result4 = noNum.fold(0)(_ * 3)

    println(result3) // should be(9)
    println(result4) // should be(0)
  }

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }

}
