object mutable-immutable {
  def main(args: Array[String]): Unit = {

    val stringArray:Array[String] = new Array(6)
    // stringArray: Array[String] = Array(null, null, null, null, null, null)

    stringArray = new Array(33)
    // <console>:11: error: reassignment to val
    //        stringArray = new Array(33)
    //                    ^

    stringArray(3) = "foo"

    stringArray
    // res26: Array[String] = Array(null, null, null, foo, null, null)

  }

}
