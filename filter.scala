object Solution {

    def main(args: Array[String]) {
      println(f(3, List(2,3,4,5)))
      println(getOddIndexes(List(2,3,4,5)))
    }

    // returns numbers only less than delim
    def f(delim:Int,arr:List[Int]):List[Int] = arr filter (x => x < delim)

    def getOddIndexes(l: List[Int]) = l.zipWithIndex.filter{case (x, i) => i % 2 == 0}.map(_._1)
}
