import java.util.ArrayList;
import java.util.Arrays;

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

