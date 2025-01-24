import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Zestaw10 {
    public static void main(String[] args) {
        var student = new Student("tomek",3.4,12);
        var student2 = new Student("romek",3.2,11);
        ArrayList<Student> studenci = new ArrayList<>();
        studenci.add(student);
        studenci.add(student2);
        studenci.add(student2);

        studenci.sort(null);
        System.out.println(studenci);

        Car car1 = new Car("audi",456,123);
        Car car2 = new Car("lambo",67,1233);
        Car car3 = new Car("porshe",1,1234);
        Car car4 = new Car("bugatti",218,1235);

        Car[] tablica = {car1,car2,car3,car4};
        Arrays.sort(tablica);
        for(var i:tablica){
            System.out.println(i);
        }
        /*
        Dog dog = new Dog();
        dog.makeHappySound();
        dog.makeSound();
        */
        //zad11
        Student2[] studentTest ={
                new Student2("a",3.14,2),
                new Student2("b", 2.12,1),
                new Student2("d",3.14,1),
                new Student2("c",3.14,3)
        };
        Arrays.sort(studentTest);
        for(var i: studentTest){
            System.out.println(i);
        }

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Smith", "Manager"));
        employees.add(new Employee("Alice", "Johnson", "Developer"));
        employees.add(new Employee("Bob", "Lee", "Designer"));
        employees.add(new Employee("Charlie", "Davis", "Analyst"));

        Collections.sort(employees);
        System.out.println(employees);

        //zad 22
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal("Cat", 5));
        animalList.add(new Animal("Elephant", 10));
        animalList.add(new Dog("Dog", 3, "Bulldog"));
        animalList.add(new Dog("Dog", 3, "Labrador"));
        animalList.add(new Dog("Dog", 5, "Poodle"));

        Collections.sort(animalList);

        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }

}
//zad1
class Student implements Comparable<Student>
{
    public String name;
    public double averageGrade;
    public int yearOfBirth;

    Student(String name, double averageGrade, int yearOfBirth)
    {
        this.name = name;
        this.averageGrade = averageGrade;
        this.yearOfBirth = yearOfBirth;
    }
    //porownanie po stringach
    /*
    @Override
    public int compareTo(MyString o) {
        return value.compareTo(o.value);
    }
    @Override
    public int compareTo(MyString o) {
        return this.value.compareToIgnoreCase(o.value);
    }
    */


    @Override
    public int compareTo(Student other) {
        return Double.compare(this.averageGrade, other.averageGrade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
//zad7
class Car implements Comparable<Car>{
    public String name;
    public int mileage;
    public int yearOfProduction;

    public Car(String name, int mileage, int yearOfProduction) {
        this.name = name;
        this.mileage = mileage;
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public int compareTo(Car o) {
        if(this.mileage < o.mileage) return -1;
        if(this.mileage > o.mileage) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
//zad11
/*interface AnimalSound{
    void makeSound();
}
interface DomesticAnimalSound extends AnimalSound{
    void makeHappySound();
}
class Dog implements DomesticAnimalSound{

    @Override
    public void makeHappySound() {
        System.out.println("Wag tail");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}*/
class Student2 implements Comparable<Student2>{
    public String name;
    public double averageGrade;
    public int yearOfStudy;

    public Student2(String name, double averageGrade, int yearOfStudy) {
        this.name = name;
        this.averageGrade = averageGrade;
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public int compareTo(Student2 o) {
        int porownanieDoubli = Double.compare(o.averageGrade, this.averageGrade);
        if(porownanieDoubli == 0)
            return Integer.compare(this.yearOfStudy, o.yearOfStudy);
        return porownanieDoubli;
    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', averageGrade=" + averageGrade + ", yearOfStudy=" + yearOfStudy + "}";
    }
}
//zad12
class Order implements Comparable<Order>{
    public String name;
    public int quantity;
    public double unitPrice;

    public Order(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }


    @Override
    public int compareTo(Order o) {
        int porownanie = Double.compare(o.unitPrice, this.unitPrice);
        if(porownanie == 0) return (Integer.compare(this.quantity, o.quantity));
        return porownanie;
    }
}
class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private String position;

    public Employee(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.lastName.length(), o.lastName.length());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
//zad 22
class Animal implements Comparable<Animal> {
    private String species;
    private int age;

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Animal other) {
        int ageComparison = Integer.compare(this.age, other.age);
        if (ageComparison == 0) {
            return this.species.compareTo(other.species);
        }
        return ageComparison;
    }

    @Override
    public String toString() {
        return "Animal{species='" + species + "', age=" + age + "}";
    }
}
class Dog extends Animal {
    private String breed;

    public Dog(String species, int age, String breed) {
        super(species, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public int compareTo(Animal other) {
        if (other instanceof Dog) {
            int comparison = super.compareTo(other);
            if (comparison == 0) {
                return this.breed.compareTo(((Dog) other).breed);
            }
            return comparison;
        }

        return super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Dog{species='" + getSpecies() + "', age=" + getAge() + ", breed='" + breed + "'}";
    }
}


