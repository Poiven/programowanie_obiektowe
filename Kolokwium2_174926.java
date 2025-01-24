//zadanie 1

import java.util.Arrays;

class Building{
    public int height;
    public String color;

    public Building(int height, String color) {
        this.height = height;
        this.color = color;
    }

}
class House extends Building{
    public int numberOfRooms;

    public House(int height, String color, int numberOfRooms) {
        super(height, color);
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "numberOfRooms=" + numberOfRooms +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}

//zadanie 2

abstract class ComputerGraphic{
    public int width;
    public int height;
    public String fileName;
    public abstract void loadFile();
    public abstract void saveFile();

}
class Bitmap extends ComputerGraphic {
    @Override
    public void loadFile() {
        System.out.println("wczytuje bitmape");
    }

    @Override
    public void saveFile() {
        System.out.println("zapisuje bitmape");
    }
}
class Vector extends ComputerGraphic {

    @Override
    public void loadFile() {
        System.out.println("wczytuje vector");
    }

    @Override
    public void saveFile() {
        System.out.println("zapisuje vector");
    }
}

// zadanie 3

interface MediaPlayer{
    public abstract void play(String trackName);
    public abstract void pause();
    public abstract String getCurrentTrack();
}

class AudioPlayer implements MediaPlayer{

    @Override
    public void play(String trackName) {
        System.out.println("odpalam audio: "+trackName);
    }

    @Override
    public void pause() {
        System.out.println("pausuje audio");
    }

    @Override
    public String getCurrentTrack() {
        return "zwracam obecna piosenke";
    }
}
class VideoPlayer implements MediaPlayer{

    @Override
    public void play(String trackName) {
        System.out.println("odpalam video: "+trackName);
    }

    @Override
    public void pause() {
        System.out.println("pausuje video");
    }

    @Override
    public String getCurrentTrack() {
        return "zwracam obecny filmik";
    }

}

//zadanie 4

class Storage<T>{
    T obiekt;

    public void store(T obiekt){
        this.obiekt = obiekt;
    }

    public T retrieve(){
        return obiekt;
    }
}

//zadanie 5
interface Authentication{
    public abstract boolean login(String username, String password);
    public abstract void logout();
    public abstract boolean resetPassword(String username, String oldPassword, String newPassword);
}
class UserAuthentication implements Authentication{


    @Override
    public boolean login(String username, String password) {
        return username != null && password != null;
    }

    @Override
    public void logout() {
        System.out.println("wylogowano usera");
    }

    @Override
    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        return true;
    }
}

class AdminAuthentication implements Authentication{

    @Override
    public boolean login(String username, String password) {
        return username != null && password != null;
    }

    @Override
    public void logout() {
        System.out.println("wylogowano admina");
    }

    @Override
    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        return true;
    }
}




public class Kolokwium2_174926 {
    public static void main(String[] args) {
        //zadanie 1

        System.out.println("zadanie 1");

        House house = new House(12,"blue",3);
        System.out.println(house);

        System.out.println();

        //zadanie2
        System.out.println("zadanie 2");

        Bitmap bitmap = new Bitmap();
        bitmap.loadFile();
        bitmap.saveFile();

        System.out.println();

        Vector vector = new Vector();
        vector.loadFile();
        vector.saveFile();

        System.out.println();

        //zadanie 3
        System.out.println("zadanie 3");

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("Radioactive");
        audioPlayer.pause();
        System.out.println(audioPlayer.getCurrentTrack());

        System.out.println();

        VideoPlayer videoPlayer = new VideoPlayer();
        videoPlayer.play("Breaking Bad");
        videoPlayer.pause();
        System.out.println(videoPlayer.getCurrentTrack());

        System.out.println();

        //zadanie 4
        System.out.println("zadanie 4");

        Storage<Integer> storage = new Storage<>();
        storage.store(3);
        System.out.println("obiekt zwrocony z storage to: " + storage.retrieve());

        System.out.println();

        //zadanie 5
        System.out.println("zadanie 5");

        UserAuthentication userAuthentification = new UserAuthentication();
        System.out.println(userAuthentification.login(null,null));
        System.out.println(userAuthentification.login("nick", "haslo"));
        System.out.println(userAuthentification.resetPassword("nick", "haslo", "haslo1"));
        userAuthentification.logout();

        System.out.println();

        AdminAuthentication adminAuthentification = new AdminAuthentication();
        System.out.println(adminAuthentification.login("Admin", "Admin"));
        System.out.println(adminAuthentification.resetPassword("Admin", "Admin", "Admin1"));
        adminAuthentification.logout();

        System.out.println();

        //zadanie 6

        System.out.println("zadanie 6");

        Integer[] tablica = {12,2,1,15,14,256};
        sortDescending(tablica);

        for(var a: tablica){
            System.out.println(a);
        }

        System.out.println();

        Double[] tablica2 = {12.0,3.2,2.3,1.4,15.5,14.6,257.7};
        sortDescending(tablica2);

        for(var a: tablica2){
            System.out.println(a);
        }


    }
    //zadanie 6
    public static <T extends Comparable<T>> void sortDescending(T[] tablica){
        for (int i = 0; i < tablica.length-1; i++) {
            for (int j = 0; j < tablica.length-1; j++) {
                if(tablica[j].compareTo(tablica[j+1]) < 0) {
                    T temp = tablica[j];
                    tablica[j] = tablica[j+1];
                    tablica[j+1] = temp;
                }
            }
        }
    }

}
