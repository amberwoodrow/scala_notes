// Array Of N Elements
def f(num: Int) : List[Int] = (1 to num).map(i => i).toList

// f(10)
// res69: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// sum of odds
def f(arr:List[Int]):Int = arr.map((x) => if(x % 2 != 0) x else 0).sum

// get length with out using length, size, or count
def f(arr:List[Int]):Int = arr.indexOf(arr.last)+1

// absoutle vals in arr
def f(arr:List[Int]):List[Int] = arr.map(x => Math.abs(x))
