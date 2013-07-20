package scalaexamples

object functionexamples {

  import FamilyTree._
  
  val tree =
    Member(Person("1", "1", 1),
           Member(Person("2", "2", 2)),
           Member(Person("3", "3", 3)))           //> tree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(1,1,1),Me
                                                  //| mber(Person(2,2,2),End,End),Member(Person(3,3,3),End,End))
  
  tree map { _.age }                              //> res0: scalaexamples.Member[Int] = Member(1,Member(2,End,End),Member(3,End,En
                                                  //| d))
  
  val tywin = Person("Tywin", "Lannister", 56)    //> tywin  : scalaexamples.Person = Person(Tywin,Lannister,56)
  val joanna = Person("Joanna", "Lannister", 55)  //> joanna  : scalaexamples.Person = Person(Joanna,Lannister,55)
  val jaime = Person("Jaime", "Lannister", 34)    //> jaime  : scalaexamples.Person = Person(Jaime,Lannister,34)
  val cersei = Person("Cersei", "Lannister", 34)  //> cersei  : scalaexamples.Person = Person(Cersei,Lannister,34)
  val joffrey = Person("Joffrey", "Lannister", 13)//> joffrey  : scalaexamples.Person = Person(Joffrey,Lannister,13)
  val robert = Person("Robert", "Baratheon", 35)  //> robert  : scalaexamples.Person = Person(Robert,Baratheon,35)
  
  val tywinTree = Member(tywin)                   //> tywinTree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Tywi
                                                  //| n,Lannister,56),End,End)
  val joannaTree = Member(joanna)                 //> joannaTree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Joa
                                                  //| nna,Lannister,55),End,End)
  val jaimeTree = Member(jaime, joannaTree, tywinTree)
                                                  //> jaimeTree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Jaim
                                                  //| e,Lannister,34),Member(Person(Joanna,Lannister,55),End,End),Member(Person(Ty
                                                  //| win,Lannister,56),End,End))
  val cerseiTree = Member(cersei, joannaTree, tywinTree)
                                                  //> cerseiTree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Cer
                                                  //| sei,Lannister,34),Member(Person(Joanna,Lannister,55),End,End),Member(Person(
                                                  //| Tywin,Lannister,56),End,End))
  val robertTree = Member(robert)                 //> robertTree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Rob
                                                  //| ert,Baratheon,35),End,End)
  val joffreyTree = Member(joffrey, cerseiTree, robertTree)
                                                  //> joffreyTree  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Jo
                                                  //| ffrey,Lannister,13),Member(Person(Cersei,Lannister,34),Member(Person(Joanna,
                                                  //| Lannister,55),End,End),Member(Person(Tywin,Lannister,56),End,End)),Member(Pe
                                                  //| rson(Robert,Baratheon,35),End,End))
  replace(joffreyTree, robertTree, jaimeTree)     //> res1: scalaexamples.FamilyTree[scalaexamples.Person] = Member(Person(Joffrey
                                                  //| ,Lannister,13),Member(Person(Cersei,Lannister,34),Member(Person(Joanna,Lanni
                                                  //| ster,55),End,End),Member(Person(Tywin,Lannister,56),End,End)),Member(Person(
                                                  //| Jaime,Lannister,34),Member(Person(Joanna,Lannister,55),End,End),Member(Perso
                                                  //| n(Tywin,Lannister,56),End,End)))
  val agedByOne = joffreyTree map { p => Person(p.first, p.surname, p.age + 1) }
                                                  //> agedByOne  : scalaexamples.Member[scalaexamples.Person] = Member(Person(Joff
                                                  //| rey,Lannister,14),Member(Person(Cersei,Lannister,35),Member(Person(Joanna,La
                                                  //| nnister,56),End,End),Member(Person(Tywin,Lannister,57),End,End)),Member(Pers
                                                  //| on(Robert,Baratheon,36),End,End))
  val treeOfNames = joffreyTree.map(_.first)      //> treeOfNames  : scalaexamples.Member[String] = Member(Joffrey,Member(Cersei,M
                                                  //| ember(Joanna,End,End),Member(Tywin,End,End)),Member(Robert,End,End))
  
  List(1,2,3) map { _ + "s" }                     //> res2: List[String] = List(1s, 2s, 3s)
  List(1,2,3) filter { _ > 1 }                    //> res3: List[Int] = List(2, 3)
  List(1,2,3) foreach { print(_) }                //> 123
  List(1,2,3) filter { _ != 2 }                   //> res4: List[Int] = List(1, 3)
  List(1,2,3) exists { _ == 2 }                   //> res5: Boolean = true
  List(1,2,3) takeWhile { _ < 3 }                 //> res6: List[Int] = List(1, 2)
  List(1,2,3) span { _ < 3 }                      //> res7: (List[Int], List[Int]) = (List(1, 2),List(3))
  List(1,2,3) flatMap { i => List(i, i * 2) }     //> res8: List[Int] = List(1, 2, 2, 4, 3, 6)
  
  val lannisterFunc = boundTreeAndInit(joffreyTree, 0)
                                                  //> lannisterFunc  : ((scalaexamples.Person, Int, Int) => Int) => Int = <functi
                                                  //| on1>
  val maxAge = lannisterFunc((p, a, b) => max(p.age, max(a, b)))
                                                  //> maxAge  : Int = 56
  val sumAge = lannisterFunc((p, a, b) => p.age + a + b)
                                                  //> sumAge  : Int = 193
  val avgAge = avg(joffreyTree.map(_.age))        //> avgAge  : Int = 38
}