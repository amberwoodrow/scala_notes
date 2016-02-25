object Notes {
  def main(args: Array[String]): Unit = {

    println(sqrt(25))
    println(sumInts(4,5))

    val age = 20
    // println(canVote(12)) // No
    // println(canVote(age)) // Yes
    goToGrade(16) // grade 11

    // (0 to 10) foreach(println) // 0...10

    val a1 = Array(1, 2, 3)
    val a2 = a1 map(_ + 1) // 2 3 4
    // println(a2 mkString(" "))

    val a3 = a2 filter (_ % 2 != 0) // 3
    // println(a3 mkString(" "))

    // for (i <- 1 to 10) println(i)

    // val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    // for (i <- 0 until randLetters.length) println(i) // 0...25
    // randLetters foreach(println) // A...Z

    val aList = List(1, 2, 3)
    val bList = aList map(_ * 2)
    println(bList mkString(" "))
    val cList = aList filter(_ % 2 == 0)
    println(cList mkString(" "))

    // Tuple - mixed type List
    // use if you want to return more then one type from a function like an http request where the first res
    // in the body is an error, the second is the data etc
    // var bento:(Sushi, Sushi) = (new Sashimi, new Onigiri)
    // var (first, second) = bento // bind and unpack tuple to bento

    // Functions that take one parameter can omit parens
    // Or can use braces instead
    // No dot needed preceeding a method

    // Void functions are type Unit in Scala

    // val addOne:Int => Int = x => x + 1
    // addOne is:
    //   A function which
    //     Takes a single parameter
    //     => Returns a value of type Int
    //   The parameter will be named x
    //     => this function returns x + 1

  }

  def canVote(age:Int) = if (age >= 18) "Yes" else "No"

  def goToGrade(age:Int) {
    if (age >= 5 && age <= 6)
      println("Go to Kindergarten")
    else if (age > 6 && age <= 7)
      println("Go to grade 1")
    else
      println("Go to grade " + (age - 5))
  }

  // array selections are written
  // a(i) rather than a[i]

  // Array types are written Array[T]

  //   The declared type of a symbol is given after the symbol and a colon. The declared
  // type can often be omitted, because the compiler can infer it from the
  // context.

  // quick sort
  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs // If array is empty or has single element, it is already sorted, so return
    else {
      val pivot = xs(xs.length / 2) // If array is not empty, pick an element in the middle as a pivot
      Array.concat(
        sort(xs filter (pivot >)),
        xs filter (pivot ==),
        sort(xs filter (pivot <)))
    }
    // Partition the array into two sub-arrays containing elements that are less than,
    // respectively greater than the pivot element, and a third array which contains
    // elements equal to pivot.
    // Sort the first two sub-arrays by a recursive invocation of the sort function.1
    // The result is obtained by appending the three sub-arrays together.

    // arrays are instances of Seq all sequence methods are available for them
  }

  // filter which takes as argument a predicate function.
  // This predicate function must map array elements to boolean values. The result
  // of filter is an array consisting of all the elements of the original array for which the
  // given predicate function is true. The filter method of an object of type Array[T]
  // thus has the signature
  // def filter(p: T => Boolean): Array[T]
  // Here, T => Boolean is the type of functions that take an element of type t and return
  // a Boolean. Functions like filter that take another function as argument or return
  // one as result are called higher-order functions.
  // Scala does not distinguish between identifiers and operator names. An identifier
  // can be either a sequence of letters and digits which begins with a letter, or it can be
  // a sequence of special characters, such as “+”, “*”, or “:”. Any identifier can be used
  // as an infix operator in Scala. The binary operation E op E0
  // is always interpreted as
  // the method call E.op(E
  // 0
  // ). This holds also for binary infix operators which start with
  // a letter. Hence, the expression xs filter (pivot >) is equivalent to the method
  // call xs.filter(pivot >).

  // def swap(i: Int, j: Int) {
  //   val t = xs(i); xs(i) = xs(j); xs(j) = t
  //   ()
  // }
  // If no explicit return expression is given, the value (), which is pronounced “unit”, is assumed.

  // Scala uses call-by-value by default, but it switches to call-by-name evaluation if the
  // parameter type is preceded by =>.

  def abs(x: Double) = if (x >= 0) x else -x
  // scala ternary

  // def sqrtIter(n: Double, guess: Option[Int] = None): Double =
  //
  //   var g = 0
  //
  //   if (guess == null) g = n/2
  //
  //   val BMGuess = (g + (n / g)) / 2;
  //   if (guess == BMGuess)  BMGuess // compare our guess to the Babylonian Method guess return if matching
  //   sqrtIter(n, BMGuess);

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2
    def isGoodEnough(guess: Double, x: Double) =
      abs((guess*guess) - x) < 0.001
      sqrtIter(1.0, x)
  }
  // ex
  // - The isGoodEnough test is not very precise for small numbers and
  // might lead to non-termination for very large ones (why?). Design a different version
  // of isGoodEnough which does not have these problems.
  // - Trace the execution of the sqrt(4) expression.

  // def abs(x: Double) = if (x >= 0) x else -x
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
  // ex
  // - Design a tail-recursive version of factorial

  // Write a function to sum all integers between two given numbers a and b:
  // def sumInts(a: Int, b: Int): Int =
  //   if (a > b) 0 else a + sumInts(a + 1, b)

  //   A function in Scala is a “first-class value”. Like any other value, it may be passed as
  // a parameter or returned as a result. Functions which take other functions as parameters
  // or return them as results are called higher-order functions.

  //   Write a function to sum the squares of all integers between two given numbers
  // a and b:
  // def square(x: Int): Int = x * x
  // def sumSquares(a: Int, b: Int): Int =
  //   if (a > b) 0 else square(a) + sumSquares(a + 1, b)

  // Write a function to sum the powers 2n of all integers n between two given
  // numbers a and b:
  // def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
  // def sumPowersOfTwo(a: Int, b: Int): Int =
  //   if (a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)

  // -vs-

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  // 22 First-Class Functions
  // The type Int => Int is the type of functions that take arguments of type Int and
  // return results of type Int. So sum is a function which takes another function as a
  // parameter. In other words, sum is a higher-order function.
  // Using sum, we can formulate the three summing functions as follows.
  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
  def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
  // def sumInts(a: Int, b: Int): Int = sum((x: Int) => x, a, b) // anonymous
  // def sumSquares(a: Int, b: Int): Int = sum((x: Int) => x * x, a, b) // anonymous
  // less redundant because compiler is smart no need to definr type twice
  // def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
  // def sumSquares(a: Int, b: Int): Int = sum(x => x * x, a, b)
  // anonymous function is equivalent to the block

  def id(x: Int): Int = x
  def square(x: Int): Int = x * x
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

  // The part before the arrow ‘=>’ are the parameters of the function, whereas the part
  // following the ‘=>’ is its body. For instance, here is an anonymous function which
  // multiples its two arguments.
  (x: Int, y: Int) => x * y

  // scala> def adder(m: Int, n: Int) = m + n
  // adder: (m: Int, n: Int)Int

  // scala> val add2 = adder(2, _:Int)
  // add2: Int => Int = <function1>

  // scala> add2(3)
  // res6: Int = 5

}
