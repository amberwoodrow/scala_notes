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

println(Movie.academyAwardBestMoviesForYear(1932).get.name) //should be("Grand Hotel")

class SecretAgent(val name: String) {
  def shoot(n: Int) {
    SecretAgent.decrementBullets(n)
  }
}

object SecretAgent {
  //This is encapsulated!
  var bullets: Int = 3000

  private def decrementBullets(count: Int) {
    if (bullets - count <= 0) bullets = 0
    else bullets = bullets - count
  }
}

val bond = new SecretAgent("James Bond")
val felix = new SecretAgent("Felix Leitner")
val jason = new SecretAgent("Jason Bourne")
val _99 = new SecretAgent("99")
val max = new SecretAgent("Max Smart")

bond.shoot(800)
felix.shoot(200)
jason.shoot(150)
_99.shoot(150)
max.shoot(200)

println(SecretAgent.bullets) // should be(1500)
