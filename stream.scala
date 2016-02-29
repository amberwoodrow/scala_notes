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

// fizzbuzz()


val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{
  n => {
    // println(fibs.zip(fibs.tail)) // puts BigInt(0) and BigInt(1) together -- (0,1), ? -- every iteration
    // println(n._1) // 0, 1, 1, 2
    // println(n._2) // 1, 1, 2, 3
    println(n._1 + n._2) // 1, 2, 3, 5
    n._1 + n._2 // ._ tuple selector
  }
}

println(fibs.take(6).toList) // List(0, 1, 1, 2, 3, 5)
println(fibs.take(2)) // Stream(0, ?)


println(((1 to 100).toStream)(3)) // returns 4


def fibonacci(n:Integer) : Integer = {
  if (n < 2) return n
  def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
  val fibs = fibFrom(1, 1).take(n)
  fibs(fibs.length-1) // another way to return
}
println(fibonacci(4))
