import java.util.Random;

public class Zestaw4 {
    public static void main(String[] args) {
        int[] tablicaPierwsze = GenerujTablice(10, -10,5);
//        Wypisz(tablicaPierwsze);
//        wypiszTablice(tablicaPierwsze, 2,6);

//        zadanie 7
        double[] tablicaNowa = generujZakres(2,1.25,6.25);
        WypiszDouble(tablicaNowa);
//      koniec zadania 7

    }
    public static int[] GenerujTablice(int n, int minWartosc, int maxWartosc){
        int[] tablica = new int[n];
        for (int i = 0; i < n; i++) {
            tablica[i] = RandomowyInt(minWartosc, maxWartosc);
        }
        return tablica;

    }
    public static int RandomowyInt(int min, int max){
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
    public static void Wypisz(int[] tablica){
        for (int i = 0; i < tablica.length; i++) {
            if (i==0)
                System.out.print("("+tablica[i]+" ");
            else if (i<tablica.length-1)
                System.out.print(tablica[i] + " ");
            else
                System.out.print(tablica[i]+")");
        }
    }
    public static void wypiszTablice(int[] tablica, int n, int m){
        int zmiennaKoncowa = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("(");
            for (int j = 0; j < m; j++) {
                if (zmiennaKoncowa+j < tablica.length){
                    System.out.printf("%d\t", tablica[zmiennaKoncowa+j]);
                }
                else
                    System.out.printf("\t");
            }
            System.out.print(")");
            zmiennaKoncowa += m;
            System.out.println();
        }
    }

//    zadanie 7
    public static double[] generujZakres(int n, double minWartosc, double maxWartosc){
        double[] tablica = new double[n];
        double krok = (maxWartosc-minWartosc)/(n-1);
        System.out.println("krok: "+krok);
        double temp=minWartosc;
        for (int i = 0; i < n; i++) {
            tablica[i] = temp;
            temp += krok;
        }
        return tablica;
    }
    public static void WypiszDouble(double[] tablica){
        for (int i = 0; i < tablica.length; i++) {
            if (i==0)
                System.out.print("("+tablica[i]+" ");
            else if (i<tablica.length-1)
                System.out.print(tablica[i] + " ");
            else
                System.out.print(tablica[i]+")");
        }
    }

    public static void ileNieparzystych(int[] tab)
    {
        int odd = 0;
//        System.out.println("nieparzyste: "+odd);
        for (int liczba:tab){
            if (liczba%2!=0){
                odd++;
            }
        }
        System.out.println("nieparzyste: " + odd);
    }
    public static void ileParzystych(int[] tab)
    {
        int even = 0;
        for (int liczba:tab){
            if (liczba%2==0){
                even++;
            }
        }
        System.out.println("nieparzyste: " + even);
    }
    public static void ileDodatnich(int[] tab)
    {
        int positive = 0;
        for (int liczba:tab){
            if (liczba>0){
                positive++;
            }
        }
        System.out.println("nieparzyste: " + positive);
    }
    public static void ileUjemnych(int[] tab)
    {
        int negative = 0;
        for (int liczba:tab){
            if (liczba<0){
                negative++;
            }
        }
        System.out.println("nieparzyste: " + negative);
    }
    public static void ileZerowych(int[] tab)
    {
        int positive = 0;
        for (int liczba:tab){
            if (liczba==0){
                positive++;
            }
        }
        System.out.println("nieparzyste: " + positive);
    }

    public static void ileMaxymalnych(int[] tab)
    {
        int max = 0;
        int maxValue;
        for ()
        for (int liczba:tab){

            if (liczba>=0){
                max++;
            }
        }
        System.out.println("nieparzyste: " + max);
    }
}
