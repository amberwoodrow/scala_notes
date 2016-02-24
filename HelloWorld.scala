import scala.collection.mutable

object HelloWorld {
  def main(args: Array[String]): Unit = {

    println(list())

    // val allTheFruitInTheWorld = mutable.Set("apple", "orange", "peach", "banana")
    //
    // allTheFruitInTheWorld += "banono"
    // println(allTheFruitInTheWorld)

    // An iterator is not a collection, but rather a way to access the elements of a collection one by one.
  }

  // def square(a: Int) = a * a
  //
  // def squareWithBlock(a: Int) = {
  //     a * a
  // }
  //
  // // And like values, functions can also be assigned using var or val So it can be passed as an argument to another function.
  // val squareVal = (a: Int) => a * a
  //
  // def addOne(f: Int => Int, arg: Int) = f(arg) + 1
  //
  // println("square(2):" + square(2))
  // println("squareWithBlock(2):" + squareWithBlock(2))
  // println("squareVal(2):" + squareVal(2))
  // println("addOne(squareVal,2):" + addOne(squareVal, 2))

  def list(): Boolean = {
    val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    // days :+ "Madeupday"
    val newList = days diff List("Saturday")
    // search Saturday
    // newList.exists(x => x == "Saturday")
    // search Sunday
    newList.exists(x => x == "Sunday")
    // newList
  }

}
