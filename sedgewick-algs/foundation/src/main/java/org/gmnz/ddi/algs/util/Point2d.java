package org.gmnz.ddi.algs.util;

/**
 * Point2d
 */
public class Point2d implements Comparable<Point2d> {

   private double a;
   private double b;

   public double getA() {
      return a;
   }



   public void setA(double a) {
      this.a = a;
   }



   public double getB() {
      return b;
   }



   public void setB(double b) {
      this.b = b;
   }



   public double modulus() {
      return Math.sqrt(a * a + b * b);
   }



   @Override
   public int compareTo(Point2d o) {
      double delta = this.modulus() - o.modulus();
      if (delta < 0) {
         return -1;
      } else {
         if (delta > 0) {
            return 1;
         } else {
            return 0;
         }
      }
   }



   @Override
   public String toString() {
      return "Point2d [a=" + a + ", b=" + b + "]";
   }



   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(a);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(b);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
   }



   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Point2d other = (Point2d) obj;
      if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
         return false;
      if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
         return false;
      return true;
   }

}