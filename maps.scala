val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
myMap.size should be(4)

// Maps contain distinct pairings:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
myMap.size should be(3)

// Maps can be added to easily:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
val aNewMap = myMap + ("IL" -> "Illinois")
aNewMap.contains("IL") should be(true)

// Map values can be iterated:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
val mapValues = myMap.values
mapValues.size should be(3)
mapValues.head should be("Michigan") //Failed presumption: The order in maps is not guaranteed

val lastElement = mapValues.last
lastElement should be("Wisconsin") //Failed presumption: The order in maps is not guaranteed

// Maps insertion with duplicate key updates previous entry with subsequent value:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Meechigan")
val mapValues = myMap.values
mapValues.size should be(3)
myMap("MI") should be("Meechigan")

// Map keys may be of mixed type:
val myMap = Map("Ann Arbor" -> "MI", 49931 -> "MI")
myMap("Ann Arbor") should be("MI")
myMap(49931) should be("MI")

// Mixed type values can be added to a map:
val myMap = scala.collection.mutable.Map.empty[String, Any]
myMap("Ann Arbor") = (48103, 48104, 48108)
myMap("Houghton") = 49931

myMap("Houghton") // should be(49931)
myMap("Ann Arbor") // should be((48103, 48104, 48108))

// Maps may be accessed:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
myMap("MI") // should be("Michigan")
myMap("IA") // should be("Iowa")

// Map elements can be removed easily:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
val aNewMap = myMap - "MI"
aNewMap.contains("MI") // should be(false)
myMap.contains("MI") // should be(true)

// Accessing a map by key results in an exception if key is not found:
val myMap = Map("OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
var blewWithException = true

intercept[NoSuchElementException] {
  myMap("MI")
  blewWithException = false
}
blewWithException // should be(true)

// Map elements can be removed in multiple:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
val aNewMap = myMap -- List("MI", "OH")

aNewMap.contains("MI") // should be(false)
myMap.contains("MI") // should be(true)

aNewMap.contains("WI") should be(true)
aNewMap.size // should be(2)
myMap.size // should be(4)

// Map elements can be removed with a tuple:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
val aNewMap = myMap - ("MI", "WI") // Notice: single '-' operator for tuples

aNewMap.contains("MI") // should be(false)
myMap.contains("MI") // should be(true)
aNewMap.contains("OH") // should be(true)
aNewMap.size // should be(2)
myMap.size // should be(4)

// Attempted removal of nonexistent elements from a map is handled gracefully:
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
val aNewMap = myMap - "MN"
aNewMap.equals(myMap) // should be(true)

// Map equivalency is independent of order:
val myMap1 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
val myMap2 = Map("WI" -> "Wisconsin", "MI" -> "Michigan", "IA" -> "Iowa", "OH" -> "Ohio")

myMap1.equals(myMap2) // should be(true)
