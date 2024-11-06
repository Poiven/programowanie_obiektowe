import java.util.Scanner;

public class Zestaw3 {
    public static void main(String[] args) {
//        trojkiPitagorejskie(40);
//        funKwaRozwiazania(20);
//        funKwaDelta(5);
//        liczbyPierwsze(20);
//        liczbyPodzielne(4,5);
//        System.out.println(silnia(0));
//        piramida(5,0);
//        System.out.println(silniaPodwojna(10));
//        System.out.println(silniaM(1,10));
//        dwumianNewtona(14,5);
//        System.out.println(NWD(56,98));
//        ciagFibonacciego(10);
//        DoskonalaPrint(6);
//        int[] nowaTablica = wczytajTablice();
//        int[] n = {1,2,4};
//        printSubsets(n);
//        TrojkatPascala(5);


    }
    //gotowe
    public static void trojkiPitagorejskie(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if (((i * i) + (j * j) == k*k) && i<j){
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
    // b**2-4ac>0
    //gotowe
    public static void funKwaRozwiazania(int n){
        for (int i = 1; i <= n; i++){
            for (int j = -n; j <= n; j++){
                for (int k = -n; k <= n; k++){
                    if(Math.pow(j, 2)-(4*i*k)>=0){
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }

    public static void funKwaDelta(int n){
        int delta = 0;
        for (int i = -n; i <= n; i++){
            if(i!=0){
                for (int j = -n; j <= n; j++) {
                    for (int k = -n; k <= n; k++) {
                        delta = j * j - (4 * i * k);
                        if (delta >= 0 && ((int) Math.sqrt(delta) * (int) Math.sqrt(delta) == delta)) {
                            System.out.println(i + "," + j + "," + k);
                        }
                    }
                }
            }
        }
    }
    //gotowe
    public static void liczbyPierwsze(int n) {
        for (int i = 2; i <= n; i++){
            if(czyPierwsza(i))
                System.out.println(i);
        }
    }
    //gotowe
    public static boolean czyPierwsza(int n){
        if (n<2)
            return false;
        for (int i=2;i*i<=n;i++){
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }

    //gotowe
    public static void liczbyPodzielne(int m, int n) {
        double i=Math.pow(10,m-1);
        while (i < Math.pow(10,m)){
            if (i%n==0)
                System.out.println(i);
            i++;
        }
    }
//    gotowe
    public static long silnia(int n){
        long wynik=1;
        for (int i = n;i > 0; i--){
            wynik*=i;
        }
        return wynik;
    }
//    gotowe
    public static int silniaPodwojna(int n){
        int wynik=1;
        for (int i = n;i > 0; i-=2){
            wynik*=i;
        }
        return wynik;
    }
    //gotowe
    public static int silniaM(int m, int n){
        int wynik=1;
        for (int i = n;i > 0; i-=m){
            wynik*=i;
        }
        return wynik;
    }




//polowa, jeszcze wycentrowana
    public static void piramida(int n,int variant){
        if (variant == 1){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        else if (variant == 0)
        {
            for (int i = 0; i < n; i++) {
                // Wypisanie odpowiedniej liczby spacji dla wyrównania trójkąta
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print("*" + " ");
                }
                System.out.println();
            }
        }
        else
            return;
    }

    public static void dwumianNewtonaPrint(int n, int k){
        if(n >= k) {
            long wynik = (silnia(n) / (silnia(k) * silnia(n - k)));
            System.out.println(wynik);
        }
    }

    public static long dwumianNewtona(int n, int k) {
        if (n >= k) {
            return silnia(n) / (silnia(k) * silnia(n - k));
        }
        return 0;
    }

    public static void TrojkatPascala(int n) {
        for (int i = 0; i < n; i++) {
            // Wypisanie odpowiedniej liczby spacji dla wyrównania trójkąta
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(dwumianNewtona(i, j) + " ");
            }
            System.out.println();
        }
    }


    public static int NWD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void ciagFibonacciego(int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.println(fibonacci(i));
        }
    }
    public static boolean czyDoskonala(int n) {
        if (n < 1) {
            return false;
        }
        int suma = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }
        return suma == n;
    }
    public static void DoskonalaPrint(int n)
    {
        if (czyDoskonala(n))
            System.out.println("Doskonala");
    }

    public static boolean czyPalindrom(String wyraz) {
        int length = wyraz.length();
        for (int i = 0; i < length / 2; i++) {
            if (wyraz.charAt(i) != wyraz.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static void wypiszPalindrom(String wyraz){
        if (czyPalindrom(wyraz))
            System.out.println(wyraz);
    }
    public static int sumaNaturalnych(int n)
    {
        int wynik=0;
        for(int i=0;i<n;i++)
        {
            wynik+=i;
        }
        return wynik;
    }
    public static int sumaParzystych(int n)
    {
        int wynik=0;
        for(int i=0;i<n;i++)
        {
            wynik += 2*i;
        }
        return wynik;
    }
    public static int sumaNieparzystych(int n)
    {
        int wynik=0;
        for(int i=0;i<n;i++)
        {
            wynik += 2*i;
        }
        return wynik;
    }
    public static int sumaKwaNaturalnych(int n)
    {
        int wynik=0;
        for(int i=0;i<n;i++)
        {
            wynik += i*i;
        }
        return wynik;
    }
    public static int sumaSzeNaturalnych(int n)
    {
        int wynik=0;
        for(int i=0;i<n;i++)
        {
            wynik += i*i*i;
        }
        return wynik;
    }
    public static int sumaOdwNaturalnych(int n)
    {
        int wynik=0;
        for(int i=0;i<n;i++)
        {
            if (i!=0)
                wynik += 1/i;
        }
        return wynik;
    }
    public static int[] wczytajTablice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę n: ");
        int n = scanner.nextInt();

        int[] tablica = new int[n];
        for (int i = 0; i < n; i++) {
            tablica[i] = scanner.nextInt();
        }

        return tablica;
    }
    public static void printSubsets(int[] array) {
        int n = array.length;
        int totalSubsets = (int) Math.pow(2, n); // 2^n

        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if (czyBit(i, j)) {
                    System.out.print(array[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    private static boolean czyBit(int num, int bit) {
        return (num / (int) Math.pow(2, bit)) % 2 == 1;
    }










}
