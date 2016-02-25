// Sometimes it makes sense to let people apply some arguments to your function now and others later.

def multiply(m: Int)(n: Int): Int = m * n
// multiply: (m: Int)(n: Int)Int

multiply(2)(3)
// res0: Int = 6
// You can fill in the first parameter and partially apply the second.

val timesTwo = multiply(2) _
// timesTwo: (Int) => Int = <function1>

timesTwo(3)
// res1: Int = 6
// You can take any function of multiple arguments and curry it. Let’s try with our earlier adder

val curriedAdd = (adder _).curried
// curriedAdd: Int => (Int => Int) = <function1>

val addTwo = curriedAdd(2)
// addTwo: Int => Int = <function1>

addTwo(4)
// res22: Int = 6
