// Scala Lists are quite similar to arrays which means, all the elements of a list
// have the same type but there are two important differences. First, lists are
// immutable, which means elements of a list cannot be changed by assignment.
// Second, lists represent a linked list whereas arrays are flat. The type of a
// list that has elements of type T is written as List[T].
// Lists are immutable

// eq tests identity (same object)
val a = List(1, 2, 3)
val b = List(1, 2, 3)
println(a eq b) // should be(false)
// == tests equality (same content)
println(a == b) // should be(true)

// Nil lists are identical, even of different types
val c: List[String] = Nil
val d: List[Int] = Nil

println(c == Nil) // should be(true)
println(c eq Nil) // should be(true)

println(d == Nil) // should be(true)
println(d eq Nil) // should be(true)

println(c == d) // should be(true)
println(c eq d) // should be(true)

// Lists can be accessed via head and tail
println(a.head) // should equal(1)
println(a.tail) // should equal(List(2, 3))

// Lists can be accessed by position
val e = List(1, 3, 5, 7, 9)
println(e(0)) // should equal(1)
println(e(2)) // should equal(5)
println(e(4)) // should equal(9)

val f = e.filterNot(v => v == 5) // remove where value is 5

// e should equal(List(1, 3, 5, 7, 9))
// f should equal(List(1, 3, 7, 9))
println(e.length) // should equal(5) // length
println(e.reverse) // should equal(List(9, 7, 5, 3, 1)) // reverse
println(e.toString) // should equal("List(1, 3, 5, 7, 9)") // to string

// map a function to double the numbers over the list
println(e.map {v => v * 2}) // should equal(List(2, 6, 10, 14, 18))

// filter any values divisible by 3 in the list
println(e.filter {v => v % 3 == 0}) // should equal(List(3, 9))

// Functions over lists can use _ as shorthand
println(a.map {_ * 2}) // should equal(List(2, 4, 6))
println(a.filter {_ % 2 == 0}) // should equal(List(2))

// Functions over lists can use () instead of {}
println(a.map(_ * 2)) // should equal(List(2, 4, 6))
println(a.filter(_ % 2 != 0)) // should equal(List(1, 3))

// Lists can be reduced with a mathematical operation
val g = List(1, 3, 5, 7)
println(g.reduceLeft(_ + _)) // should equal(16)
println(g.reduceLeft(_ * _)) // should equal(105)

// Foldleft is like reduce, but with an explicit starting value
// NOTE: foldLeft uses a form called currying that we will explore later
println(g.foldLeft(0)(_ + _)) // should equal(16)
println(g.foldLeft(10)(_ + _)) // should equal(26)
println(g.foldLeft(1)(_ * _)) // should equal(105)
println(g.foldLeft(0)(_ * _)) // should equal(0)

// You can create a list from a range
val h = (1 to 5).toList
println(h) // should be(List(1, 2, 3, 4, 5))

// Lists reuse their tails
val l = Nil
val k = 3 :: d
val j = 2 :: c
val i = 1 :: b

println(i) // should be(List(1, 2, 3))
println(i.tail) // should be(List(2, 3))
println(j.tail) // should be(List(3))
println(k.tail) // should be(Nil)
