public class rozwiazanieKol1 {
    public static void main(String[] args) {
        int[] tab = zad1(10,1,3,new int[]{1,1});

        for (int i:tab)
        {
            System.out.println(i);
        }
        System.out.println(zad2(tab));
        System.out.println(zad3(new int[]{1,8,27,64,125},3));

    }

    public static int[] zad1(int n, int m, int a1, int[] r){
        int[] wynik = new int[n];
        wynik[0] = a1;
        for(int i = 1; i < n; i++){
            int suma = a1;
            for(int j = 0; j < m; j++){
                suma += Math.pow(i, j+1)*r[j];
            }
            wynik[i] = suma;
        }
        return wynik;
    }

    public static boolean zad2(int[] tab){
        int roznica = tab[1]-tab[0];
        for(int i = 2; i < tab.length; i++){
            if(tab[i]-tab[i-1] != roznica)
                return false;
        }
        return true;
    }

    public static boolean zad3(int[] tab, int m){
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < tab.length-1-i; j++){
                tab[j] = tab[j+1]-tab[j];
            }
        }
        int[] wynik = new int[tab.length-(m-1)];
        for (int i=0;i<tab.length-(m-1);i++)
        {
            wynik[i] = tab[i];
        }
        return zad2(wynik);
    }
    public static int zad4(int[] tab){
        int wynik = 0;
        int indeksStart = 0;
        int indeksStop = 0;
        for(int i = 0; i<tab.length; i++){
            if(tab[i+1]>tab[i]){
                indeksStop = i;
            }
            else
            {
                if(indeksStop-indeksStart+1>wynik){
                    wynik = indeksStop-indeksStart+1;
                }
                indeksStart=i+1;

            }
        }
        if(indeksStop-indeksStart+1>wynik){
            wynik = indeksStop-indeksStart+1;
        }
        return wynik;

    }
    public static void zad6(int n, int c){
        System.out.println(c);
        while (n>1){
            if (c%2==0){
                c/=2;
            }else {
                c=3*c+1;
            }
            System.out.println(c);
            n--;
        }
    }
    public static void zad7(int n, int c){
        int max=c;
        int min = c;
        System.out.println(c);
        while (n>1){
            if (c%2==0){
                c/=2;
            }else {
                c=3*c+1;
            }
            System.out.println(c);
            n--;
            if(c<min)
                min=c;
            if (c>max)
                max=c;
        }
    }
    public static boolean zad1_2(double x, double y,int k){
        return Math.abs(x-y)<=Math.pow(10,-k);
    }
    public static int zad2_2(int S){
        int i=0;
        while(Math.pow(i,2)<S && Math.pow(i+1,2)>S){
            i++;
        }
        if(Math.abs(Math.pow(i,2)-S)>Math.abs(Math.pow(i+1,2)-S)){
            return i+1;
        }
        return i;
    }

    /*public static double zad3_2(int S, int n, int k){
        double x = zad2_2(S);
        double x_next = ((n-1)*x+(S/Math.pow(x,n-1)))/n;
        while(zad1_2(x_next,x,k))
    }*/

}
