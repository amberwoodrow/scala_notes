// An anonymous function can also take on a different look by taking out the brackets

def lambda = (x: Int) => x + 1
def result = lambda(5)
println(result) // should be(6)
// Meet closure. A closure is a function, whose return value depends on the value of
// one or more variables declared outside this function. Consider the following piece of
// code with anonymous function:

val multiplier = (i:Int) => i * 10
// Here the only variable used in the function body, i * 10, is i,
// which is defined as a parameter to the function.

var incrementer = 1

def closure = {
  x: Int => x + incrementer
}

val result1 = closure(10)
println(result1) // should be(11)

incrementer = 2

val result2 = closure(10)
println(result2) // should be(12)

def addWithoutSyntaxSugar(x: Int) = {
  new Function1[Int, Int]() {
    def apply(y: Int): Int = x + y
  }
}
println(addWithoutSyntaxSugar(1).
  isInstanceOf[Function1[Int,Int]]) // should be(true)

println(addWithoutSyntaxSugar(2)(3)) // should be(5)

def fiveAdder = addWithoutSyntaxSugar(5)
println(fiveAdder(5)) // should be(10)
