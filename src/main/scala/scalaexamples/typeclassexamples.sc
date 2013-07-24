package scalaexamples

object typeclassexamples {
  import Fractional._
  
  def specificMean(ds: Seq[Double]) = {
    ds.reduce(_ + _) / ds.size
  }                                               //> specificMean: (ds: Seq[Double])Double
  
  sum(1.0, 2.0, 3.0)                              //> res0: Double = 6.0
  
  List(1.0, 2.0).mean                             //> res1: Double = 1.5
  
  List(1f, 2f).mean                               //> res2: Float = 1.5
  
  Vector(BigDecimal(1), BigDecimal(2)).mean       //> res3: scala.math.BigDecimal = 1.5
}