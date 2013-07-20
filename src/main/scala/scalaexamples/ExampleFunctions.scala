package scalaexamples

object ExampleFunctions {
  
  // Simple method example to illustrate expressions, type inf, etc.
  def older(a: Person, b: Person) =
    if (a.age >= b.age) a else b 
  
  // Naive concatenation example to illustrate recursion w/ immutable structures
  def concat[A](as: List[A], bs: List[A]): List[A] = {
    if (as == Nil) bs
    else as.head :: concat(as.tail, bs)
  }
  
}