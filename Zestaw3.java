
public class Zestaw3 {
    public static void main(String[] args) {
//        trojkiPitagorejskie(40);
//        funKwaRozwiazania(20);
//        funKwaDelta(20);
//        liczbyPierwsze(20);
//        liczbyPodzielne(4,5);
//        System.out.println(silnia(0));
//        piramida(5,1);
//        System.out.println(silniaPodwojna(10));
//        System.out.println(silniaM(1,10));
        dwumianNewtona(14,2);
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
            for (int j = 1; j <= n; j++){
                for (int k = 1; k <= n; k++){
                    if(Math.pow(j, 2)-(4*i*k)>=0){
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
    // sqrt == i*i
    public static void funKwaDelta(int n){
        int delta = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= n; j++){
                for (int k = 0; k <= n; k++){
                    delta = j * j - (4 * i * k);
                    if(delta >= 0){
                        for (int a=1; a*a*a*a == delta; a++){
                            System.out.println(i + " " + j + " " + k);
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
    public static int silnia(int n){
        int wynik=1;
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
    }

    public static void dwumianNewtona(int n, int k){
        double wynik = silnia(n)/(silnia(k)*silnia(n-k));
        System.out.println(wynik);
    }






}
