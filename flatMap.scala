// repeats each index in a list x num of times and maps them together
// ex: num = 2, arr = (1, 2, 3) result should be (1, 1, 2, 2, 3, 3)

def f(num:Int,arr:List[Int]):List[Int] = arr flatMap(i => List.fill(num)(i))
