package scalaexamples

trait Fractional[A] {
  def add(a: A, b: A): A
  def divide(a: A, b: A): A
  def fromInt(i: Int): A
}

object Fractional {
  
  def mean[A](as: Seq[A])(implicit frac: Fractional[A]) = {
    frac.divide(as.reduce(frac.add(_, _)), frac.fromInt(as.size))
  }
  
  implicit object doubleIsFractional extends Fractional[Double] {
    override def add(a: Double, b: Double) = a + b
    override def divide(a: Double, b: Double) = a / b
    override def fromInt(i: Int) = i.toDouble
  }
  
  implicit object floatIsFractional extends Fractional[Float] {
    override def add(a: Float, b: Float) = a + b
    override def divide(a: Float, b: Float) = a / b
    override def fromInt(i: Int) = i.toFloat
  }
  
  implicit object bigDecimalIsFractional extends Fractional[BigDecimal] {
    override def add(a: BigDecimal, b: BigDecimal) = a + b
    override def divide(a: BigDecimal, b: BigDecimal) = a / b
    override def fromInt(i: Int) = i // implicit conversion
  }
  
  // Technically Int is Integral, not Fractional...but oh well
  implicit object intIsFractional extends Fractional[Int] {
    override def add(a: Int, b: Int) = a + b
    override def divide(a: Int, b: Int) = a / b
    override def fromInt(i: Int) = i
  }
  
  implicit class MeanOps[A : Fractional](lhs: Seq[A]) {
    def mean() = Fractional.mean(lhs)
  }
}