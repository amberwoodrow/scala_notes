// returns numbers only greater then delim

def f(delim:Int,arr:List[Int]):List[Int] = arr filter (x => x < delim)
