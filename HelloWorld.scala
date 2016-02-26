import scala.collection.mutable

object HelloWorld {
  def main(args: Array[String]): Unit = {

    f(10)

  }

  def f(n: Int) = for (i <- 1 to n) println("Hello World")

}
