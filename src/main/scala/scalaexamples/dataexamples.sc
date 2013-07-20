package scalaexamples

object dataexamples {

  import ExampleFunctions._
  
  val ab = List("a", "b")                         //> ab  : List[String] = List(a, b)
  val cd = List("c", "d")                         //> cd  : List[String] = List(c, d)
  val abcd = ab ++ cd                             //> abcd  : List[String] = List(a, b, c, d)
  val abc = ab :+ "c"                             //> abc  : List[String] = List(a, b, c)
  val bcd = "b" :: cd                             //> bcd  : List[String] = List(b, c, d)
  val ints = Set(1,2,3)                           //> ints  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  ints - 2                                        //> res0: scala.collection.immutable.Set[Int] = Set(1, 3)
  ints + 4                                        //> res1: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  ab                                              //> res2: List[String] = List(a, b)
  cd                                              //> res3: List[String] = List(c, d)
  
  
  concat(ab, cd)                                  //> res4: List[String] = List(a, b, c, d)
  
  
  val starks = List(Person("Eddard", "Stark", 35),
                    Person("Robb", "Stark", 14),
                    Person("Arya", "Stark", 9))   //> starks  : List[scalaexamples.Person] = List(Person(Eddard,Stark,35), Person(
                                                  //| Robb,Stark,14), Person(Arya,Stark,9))
                    
  val lannisters = List(Person("Tywin", "Lannister", 56),
                        Person("Cersei", "Lannister", 39),
                        Person("Tyrion", "Lannister", 26))
                                                  //> lannisters  : List[scalaexamples.Person] = List(Person(Tywin,Lannister,56), 
                                                  //| Person(Cersei,Lannister,39), Person(Tyrion,Lannister,26))
  
  
  val tywin = Person("Tywin", "Lannister", 56)    //> tywin  : scalaexamples.Person = Person(Tywin,Lannister,56)
  val joanna = Person("Joanna", "Lannister", 55)  //> joanna  : scalaexamples.Person = Person(Joanna,Lannister,55)
  val jaime = Person("Jaime", "Lannister", 38)    //> jaime  : scalaexamples.Person = Person(Jaime,Lannister,38)
  val cersei = Person("Cersei", "Lannister", 38)  //> cersei  : scalaexamples.Person = Person(Cersei,Lannister,38)
  val joffrey = Person("Joffrey", "Lannister", 13)//> joffrey  : scalaexamples.Person = Person(Joffrey,Lannister,13)
  
  //val tywinTree = Member(tywin)
  //val joannaTree = Member(joanna)
  //val jaimeTree = Member(jaime, mother = joannaTree, father = tywinTree)
  //val cerseiTree = Member(cersei, mother = joannaTree, father = tywinTree)
  //val joffreyTree = Member(joffrey, cerseiTree, jaimeTree)
}