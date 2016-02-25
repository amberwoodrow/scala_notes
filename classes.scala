object classes {
  def main(args: Array[String]): Unit = {



  }
}

class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  override def toString(): String = "(" + x + ", " + y + ")";
}

// The program defines an executable application Classes in form of a top-level
// singleton object with a main method.
object Classes {
  def main(args: Array[String]) {
    val pt = new Point(1, 2)
    println(pt)
    pt.move(10, 10)
    println(pt)
  }
}

// You can define class with public fields via val or var in parameters
class ClassWithValParameter(val name: String)
val aClass = new ClassWithValParameter("Gandalf")
aClass.name should be("Gandalf")

// You can define class with private fields via no val or var in parameters
class ClassWithPrivateFields(name: String)
val aClass = new ClassWithPrivateFields("name")
