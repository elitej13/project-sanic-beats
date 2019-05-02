package com.sanicbeats;

public class ComplexNumber {

  public double x, y;

  public ComplexNumber(int a) {
    this.x = (double) a;
    this.y = 0;
  }
  public ComplexNumber(double real, double imaginary) {
    this.x = real;
    this.y = imaginary;
  }
  public ComplexNumber(ComplexNumber a) {
    this.x = a.x;
    this.y = a.y;
  }

  public double real() {
    return x;
  }
  public double imaginary() {
    return y;
  }
  public double magnitude() {
    return Math.sqrt(x * x + y * y);
  }
  public String toString() {
    return "{" + x + "," + y + "}";
  }

  public void add(ComplexNumber a) {
    x += a.x;
    y += a.y;
  }
  public void subtract(ComplexNumber a) {
    x -= a.x; 
    y -= a.y;
  }
  public void multiply(ComplexNumber a) {
    x = x * a.x - y * a.y;
    y = x * a.y + y * a.x;
  }
  public void divide(ComplexNumber a) {
     x = (x * a.x + y * a.y) / (Math.pow(a.x, 2) + Math.pow(a.y, 2));
     y = (-x * a.y + y * a.x) / (Math.pow(a.x, 2) + Math.pow(a.y, 2));
   }

   public void add(double a) {
    x += a;
    y += a;
  }
  public void subtract(double a) {
    x -= a;
    y -= a;
  }
  public void multiply(double a) {
    x *= a;
    y *= a;
  }
  public void divide(double a) {
    x /= a;
    y /= a;
   }

  public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
    return new ComplexNumber(a.x + b.x, a.y + b.y);
  }
  public static ComplexNumber subtract(ComplexNumber a, ComplexNumber b) {
    return new ComplexNumber(a.x - b.x, a.y - b.y);
  }
  public static ComplexNumber multiply(ComplexNumber b, ComplexNumber a) {
    return new ComplexNumber(b.x * a.x - b.y * a.y, b.x * a.y + b.y * a.x);
  }
  public static ComplexNumber divide(ComplexNumber b, ComplexNumber a) {
    return new ComplexNumber((b.x*a.x+b.y*a.y)/(Math.pow(a.x, 2)+Math.pow(a.y,2)),(-b.x*a.y+b.y*a.x)/(Math.pow(a.x, 2)+Math.pow(a.y,2)));
  }
   
 public boolean isGreaterThan(ComplexNumber a) {
	 if(a.x > x) {
		 return true;
	 }
	 if(a.x == x) {
		 if(a.y > y) {
			 return true;
		 }
	 }
	 return false;
 }  
 public boolean isEqual(ComplexNumber a) {
   return a.x == x && a.y == y;
}  
 public boolean isLessThan(ComplexNumber a) {
   return a.x < x || (a.x == x && a.y < y);
}  
}
