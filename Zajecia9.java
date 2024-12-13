import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;



record BookDTO(String title, String author, double price, LocalDate yearOfPublication) {}
record Adress(String street, String houseNumber, int postalCode, String city){}
record Person(String firstName, String lastName, Adress adress){}
record Car(String brand, String model, int fuelConsumptionPer100km){
    public double fuelCost(double fuelPrice, double distance){
        return (fuelPrice * distance)/this.fuelConsumptionPer100km;
    }
}
record Person2(String imie,int wiek){
    public Person2(String imie,int wiek){
        this.imie = imie;
        if(wiek<=0){
            this.wiek = 0;
        }
        else {
            this.wiek = wiek;
        }
    }
}
record BankAccount(int numerKonta, double saldo){
    public BankAccount(int numerKonta){
        this(numerKonta,0);
    }

}


// zad1



class MusicAlbum{
    private String title;
    private String artist;
    private ArrayList<Double> ratings;

    public MusicAlbum(String title, String artist, ArrayList<Double> ratings) {
        this.title = title;
        this.artist = artist;
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Double> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Double> ratings) {
        this.ratings = ratings;
    }
    @Override
    public String toString() {
        return this.title+", "+this.artist+", "+this.ratings+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicAlbum that = (MusicAlbum) o;
        return Objects.equals(title, that.title) && Objects.equals(artist, that.artist) && Objects.equals(ratings, that.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, ratings);
    }
}
class RockAlbum extends MusicAlbum{
    private String rockGenre;

    public RockAlbum(String title, String artist, ArrayList<Double> ratings, String rockGenre) {
        super(title, artist, ratings);
        this.rockGenre = rockGenre;
    }

    public String getRockGenre() {
        return rockGenre;
    }

    public void setRockGenre(String rockGenre) {
        this.rockGenre = rockGenre;
    }
    @Override
    public String toString() {
        return super.toString()+"rockGenre="+rockGenre+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RockAlbum rockAlbum = (RockAlbum) o;
        return Objects.equals(rockGenre, rockAlbum.rockGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rockGenre);
    }
}





class Processor{
    private int frequency;
    private int cores;
    private int threads;
    private String manufacturer;

    public Processor(int frequency, int cores, int threads, String manufacturer) {
        this.frequency = frequency;
        this.cores = cores;
        this.threads = threads;
        this.manufacturer = manufacturer;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return frequency == processor.frequency && cores == processor.cores && threads == processor.threads && Objects.equals(manufacturer, processor.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, cores, threads, manufacturer);
    }
    @Override
    public String toString() {
        return this.manufacturer+" "+this.frequency+" "+this.cores+" "+this.threads;
    }
}

class Computer{
    private String brand;
    private String model;
    private Processor processor;

    public Computer(String brand, String model, Processor processor) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(brand, computer.brand) && Objects.equals(model, computer.model) && Objects.equals(processor, computer.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, processor);
    }
    @Override
    public String toString() {
        return this.brand+", "+this.model+", "+this.processor;
    }
}

class Electronics{
    public final void turnOn(){
        System.out.println("Turn On");
    }
}
/*class Television extends Electronics{
    @Override
    public final void turnOn(){
        System.out.println("Turn off");
    }
}*/

class ImmutablePoint{
    private final double x;
    private final double y;
    private final double z;

    public ImmutablePoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePoint that = (ImmutablePoint) o;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0 && Double.compare(z, that.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "ImmutablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}








public class Zajecia9 {
    public static void main(String[] args) {

        /*var nowaData = LocalDate.now();

        BookDTO ksiazka = new BookDTO("kszyszaczy","Juliusz Sienkiewicz",15.50, nowaData);
        System.out.println(ksiazka);
        Adress adress = new Adress("a","12",14200,"kroYweN");
        Person osoba = new Person("osoba","Osoba",adress);
        System.out.println(osoba);
        Car car = new Car("a","a", 15);
        System.out.println(car);
        System.out.println(car.fuelCost(15,2));
        */
        var lista = new ArrayList<Double>();
        lista.add(12.0);
        lista.add(12.5);

        RockAlbum rockowy = new RockAlbum("a","b",lista,"new");
        var innyRockowy = new RockAlbum("c","g",lista,"old");

        System.out.println(rockowy);
        System.out.println(innyRockowy);
        System.out.println(rockowy.equals(innyRockowy));


    }


}


