package oops.encapsulation;

class Laptop{
  String ram;
  private int price;

  public void setPrice(int price){
    //is the user admin
    boolean isAdmin=true;
    if(!isAdmin){
      System.out.println("You cannot set the price");
    }
    else this.price=price;
  }
  public void getPrice(){
    System.out.println("New Price: "+price);
  }
}
public class encapsulation {
 
  public static void main(String[] args) {
    Laptop l1=new Laptop();
    l1.ram=134+"GB";
    l1.setPrice(31110);
    l1.getPrice();
  }
}
