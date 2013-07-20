package scalaexamples

object simpleexamples {

  import ExampleFunctions._
  val jon = Person("Jon", "Snow", 14)             //> jon  : scalaexamples.Person = Person(Jon,Snow,14)
  val arya = Person("Arya", "Stark", 9)           //> arya  : scalaexamples.Person = Person(Arya,Stark,9)
  var elder = older(jon, arya)                    //> elder  : scalaexamples.Person = Person(Jon,Snow,14)
  
  
  val characters = List(Person("Robb", "Stark", 14),
                        Person("Jon", "Snow", 14),
                        Person("Arya", "Stark", 9))
                                                  //> characters  : List[scalaexamples.Person] = List(Person(Robb,Stark,14), Perso
                                                  //| n(Jon,Snow,14), Person(Arya,Stark,9))
                        
  val starks1 = characters collect {
    case Person(first, "Stark", _) => first + " Stark"
  }                                               //> starks1  : List[String] = List(Robb Stark, Arya Stark)
  
  val starks2 = for {
    c <- characters if c.surname == "Stark"
  } yield (c.first + " " + c.surname)             //> starks2  : List[String] = List(Robb Stark, Arya Stark)
  
  val starks3 =
    characters.filter(_.surname == "Stark").map(c => c.first + " " + c.surname)
                                                  //> starks3  : List[String] = List(Robb Stark, Arya Stark)
}