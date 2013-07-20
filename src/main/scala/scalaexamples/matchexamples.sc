package scalaexamples

object matchexamples {
  def crazyMatch(x: Any) = x match {
    case 1 => "The number 1"
    case num: Int if (num > 2) => "A number greater than two"
    case "hello" => "The string 'hello'"
    case Person(name, "Lannister", _) => "A Lannister named " + name
    case List(a, _, _) => "A list of size 3 starting with " + a
    case _ => "I'm not sure"
  }                                               //> crazyMatch: (x: Any)String
  
  crazyMatch(1)                                   //> res0: String = The number 1
  crazyMatch(5)                                   //> res1: String = A number greater than two
  crazyMatch("hello")                             //> res2: String = The string 'hello'
  crazyMatch(Person("Cersei", "Lannister", 33))   //> res3: String = A Lannister named Cersei
  crazyMatch(List(1,2,3))                         //> res4: String = A list of size 3 starting with 1
  crazyMatch("blah")                              //> res5: String = I'm not sure
}