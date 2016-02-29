def fizzbuzz() {
  def fb(num: Int) : Stream[String] = {
    var a = "";

    if (num % 5 == 0 && num % 3 == 0)  a = "fizzbuzz"
    else if (num % 3 == 0) a = "fizz"
    else if (num % 5 == 0) a = "buzz"
    else a = num.toString

    a #:: fb(num + 1)
  }

  println(fb(1).take(100).toList)
}

fizzbuzz()
