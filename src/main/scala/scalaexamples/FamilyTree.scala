package scalaexamples

// Yes, this is just a binary search tree

sealed trait FamilyTree[+A] {
  def map[B](f: A => B): FamilyTree[B]
}

case class Member[+A](member: A,
                      mother: FamilyTree[A] = End,
                      father: FamilyTree[A] = End) extends FamilyTree[A] {
  
  // Higher-order function example on a class
  override def map[B](f: A => B) =
    Member(f(member), mother.map(f), father.map(f))
}

case object End extends FamilyTree[Nothing] {
  override def map[B](f: Nothing => B) = this
}

object FamilyTree {
  
  import Fractional._
  
  def fold[A, B](tree: FamilyTree[A])(z: B)(f: (A, B, B) => B): B = {
    tree match {
      case End => z
      case Member(a, mother, father) => f(a, fold(mother)(z)(f), fold(father)(z)(f))
    }
  }
  
  // Example of returning a function and currying
  def boundTreeAndInit[A, B](tree: FamilyTree[A], z: B): ((A, B, B) => B) => B = 
    fold(tree)(z)
  
  // Example of function as value
  val max = (a: Int, b: Int) => if (a > b) a else b
  
  def replace[A](tree: FamilyTree[A], 
                 repTree: FamilyTree[A], 
                 newTree: FamilyTree[A]): FamilyTree[A] = tree match {
    case End => End
    case Member(m, mother, father) =>
      if (mother == repTree) Member(m, newTree, father)
      else if (father == repTree) Member(m, mother, newTree)
      else Member(m, replace(mother, repTree, newTree), replace(father, repTree, newTree))
  }
  
  def avg[A](tree: FamilyTree[A])(implicit frac: Fractional[A]) = {
    val total = fold(tree)(List[A]()) { 
      (a, b, c) => List(a) ++ b ++ c 
    }
    total.mean
  }
}