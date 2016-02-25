class Movie(val name: String, val year: Short)

object Movie {
  def academyAwardBestMoviesForYear(x: Short) = {
    //These are match statement, more powerful than Java switch statements!
    x match {
      case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
      case 1931 => Some(new Movie("Cimarron", 1931))
      case 1932 => Some(new Movie("Grand Hotel", 1932))
      case _ => None
    }
  }
}

Movie.academyAwardBestMoviesForYear(1932).get.name should be("Grand Hotel")
