package oops.Abstraction;

abstract class Car{
  int price;
  abstract void start();
}

class BMW extends Car{
  @Override
  void start() {
   System.out.println("BMW is Started");
  }
}
class Audi extends Car{

  @Override
  void start() {
   System.out.println("Audi is Started");
  }

}
public class abstraction {
  public static void main(String[] args) {
    Audi a1= new Audi();
    a1.start();
  }
}
