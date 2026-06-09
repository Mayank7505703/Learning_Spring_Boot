package oops;

import oops.encapsulation.encapsulation;

class Person {
  public String name;
  public int age;
  static int count;

  public Person() {
    count++;
    System.out.println("Creating an object");
  }

  public Person(int age, String name) {
    this(); // Calls default constructor
    this.age = age;
    this.name = name;
  }

  void walk() {
    System.out.println(name + " is walking");
  }

  void eat() {
    System.out.println(name + " is eating");
  }

  void havingCars(int cars) {
    System.out.println(name + " has " + cars + " cars");
  }

  void display() {
    System.out.println(age + " " + name);
  }
}

// Inheritance -> Child class acquires properties of parent.
class Developer extends Person {
  public Developer(int age, String name) {
    super(age, name);
  }
}

public class first {
  public static void main(String[] args) {

    // without constructor
    Person p1 = new Person();
    p1.name = "Mayank Sharma";
    p1.age = 21;

    // constructor
    Person p2 = new Person(23, "Rohan");
    Person p3 = new Person(30, "Anuj");
    Person p4 = new Person(32, "Shubham Sharma");

    p1.display();
    p2.display();

    p3.eat();
    p3.havingCars(3);

    p2.havingCars(4);

    p4.walk();
    p4.eat();

    System.out.println("Total Persons Created: " + Person.count);

    // Inheritance
    Developer d1 = new Developer(24, "Anuj kumar");
    System.out.println(d1.name);
    d1.walk();

    // Encapsulation concept
    // encapsulation e=new encapsulation();
    // e.doWork();
  }
}