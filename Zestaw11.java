import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

class Box<T>{
    T objekt;
    public void setObjekt(T objekt){
        this.objekt = objekt;
    }
    public T getObjekt(){
        return objekt;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(objekt, box.objekt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(objekt);
    }*/
}
class Counter<T>{
    List<T> lista =  new ArrayList<>();
    public void add(T element){
        lista.add(element);
    }
    public int getCount(){
        return lista.size();
    }
}

//zad 21
class Animal implements Comparable<Animal>{
    public int wiek;

    public Animal(int wiek) {
        this.wiek = wiek;
    }
    @Override
    public int compareTo(Animal other){
        return wiek - other.wiek;
    }
}
class Dog extends Animal{
    public Dog(int wiek) {
        super(wiek);
    }
}

class Animal1{

}
class Dog1 extends Animal1{
    private int age;
    public Dog1(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

class Pair<T>{
    T min;
    T max;
}




public class Zestaw11 {
    public static <T> boolean isEqual(T objekt1, T objekt2){
        return objekt1.equals(objekt2);
    }
    // zad21
    public static <T extends Animal> T findMax(T element1,T element2){
        return element1.compareTo(element2) > 0 ? element1 : element2;
    }

    // zad28
    public static <T> void findMinMax(Dog1[] tab, Pair<?super Dog1> result){

        result.min = tab[0];
        result.max = tab[0];
        int min = tab[0].getAge();
        int maks = tab[0].getAge();
        for(int i=1;i<tab.length;i++){
            if(tab[i].getAge() < min) {
                result.min = tab[i];
                min = tab[i].getAge();
            }
            if(tab[i].getAge() > maks) {
                result.max = tab[i];
                maks = tab[i].getAge();
            }
        }

    }

    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setObjekt("Objekt 1");
        System.out.println(box1.getObjekt());

        Box<Integer> box2 = new Box<>();
        box2.setObjekt(2);
        System.out.println(box2.getObjekt());

        Box<Integer> box3 = new Box<>();
        box3.setObjekt(2);
//        System.out.println(box3.getObjekt());

        System.out.println(isEqual(box3.getObjekt(), box2.getObjekt()));

        Counter<String> stringCounter = new Counter<>();
        stringCounter.add("Jablko");
        stringCounter.add("gruszka");
        System.out.println(stringCounter.getCount());

        Counter<Integer> integerCounter = new Counter<>();
        integerCounter.add(1);
        integerCounter.add(2);
        integerCounter.add(3);
        System.out.println(integerCounter.getCount());


        Animal animal = new Animal(3);
        Dog dog = new Dog(2);
        System.out.println(findMax(animal, dog));

        dog.wiek = 4;
        System.out.println(findMax(animal, dog));

        Dog1 dog1 = new Dog1(3);
        Dog1 dog2 = new Dog1(5);
        Dog1 dog3 = new Dog1(4);


        Dog1[] tab = {dog1, dog2, dog3};
        Pair<Dog1> para = new Pair<>();
        //28
        findMinMax(tab, para);
        System.out.println("maks " + para.max.getAge());
        System.out.println("min " + para.min.getAge());

    }
}
