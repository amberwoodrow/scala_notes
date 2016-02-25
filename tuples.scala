// Scala tuple combines a fixed number of items together so that they can be passed
// around as a whole. They are one indexed. Unlike an array or list, a tuple can hold
// objects with different types but they are also immutable. Here is an example of a
// tuple holding an integer, a string, and the console:
val tuple = ("apple", "dog")
val fruit = tuple._1
val animal = tuple._2

println(fruit) // should be("apple")
println(animal) // should be("dog")

val student = ("Sean Rogers", 21, 3.5)
val (name, age, gpa) = student

name should be("Sean Rogers")
age should be(21)
gpa should be(3.5)
