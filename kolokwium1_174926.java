import java.util.ArrayList;

public class kolokwium1_174926 {
    public static void main(String[] args) {
        //zad 3
        System.out.println(pierwiastek(27,3,10));
        System.out.println(pierwiastek(20,2,10));

        // zad 2
        System.out.println("najblizszy sasiad 21: "+najblizszySasiad(21));
        System.out.println("najblizszy sasiad 20: "+najblizszySasiad(20));
        System.out.println("najblizszy sasiad 19: "+najblizszySasiad(19));

        //zad 1
        System.out.println(dokladnosc(1000000,1000000.00001, 3));

        // zad 4 i 5
        int[] tab ={5,2,5,3,1,6};
        int[] tab2 = {1,2,3,4,5,6};
        int[] tab3 = {6,5,4,3,1,2};
        System.out.println(podciag(tab));
        System.out.println("podciag(tab,2)"+podciag(tab, 2));
        System.out.println("podciag(tab2,2)"+podciag(tab2, 2));
        System.out.println("podciag(tab3,2)"+podciag(tab3, 2));


        //zad 6 i 7
        System.out.println("wynik palindrom(20): " + palindrom(20));
        System.out.println("wynik palindrom(2002): " + palindrom(2002));

        palindromLiczbowy(2);
    }

    public static boolean dokladnosc(double x, double y, int k) {
        double zmienna = x-y;
        double porownywana = Math.pow(10,-k);
        System.out.println(porownywana);
        if(zmienna < 0)
            zmienna = zmienna*(-1);
        if(zmienna <= porownywana)
            return true;
        else
            return false;
    }

    public static double pierwiastek(int S,int n,int k)
    {
        double x = S + 0.5;
        for (int i = 0;i<k;i++)
        {
            x = (x*(n-1)+(S/Math.pow(x,n-1)))/n;
        }
        return x;
    }
    /*public static double przyblizenie(int S)
    {
        double x = S + 0.5;
        for (int i = 0;i<10;i++)
        {
            x = (x+(S/x))/2;
        }
        return x;
    }*/

    public static int najblizszySasiad(int S){
        double pierwiastek = Math.sqrt(S);
//        System.out.println(pierwiastek);
        int sasiad = (int)pierwiastek;
        if(sasiad + 0.5 <= pierwiastek )
            return sasiad+1;
        else
            return sasiad;

    }
    public static int podciag(int[] tab){
        int dlugosc = 1;
        int max = 0;
        for (int i=1;i<tab.length;i++) {

            if(tab[i-1]>tab[i]){
                dlugosc++;
                if(dlugosc>=max){
                    max = dlugosc;
                }
            }
            else {
                dlugosc = 1;
            }
        }
        return max;
    }

    public static int podciag(int[] tab, int r)
    {
        int dlugosc = 1;
        int max = 0;
        for (int i=1;i<tab.length;i++) {

            if(tab[i-1]-r == tab[i]){
                dlugosc++;
                if(dlugosc>=max){
                    max = dlugosc;
                }
            }
            else {
                dlugosc = 1;
            }
        }
        return max;
    }

    public static boolean palindrom(int n) {
        int numer = n;
        int odTylu = 0;
        while(numer != 0)
        {
            int pozostale = numer % 10;
            odTylu = odTylu * 10 + pozostale;
            numer = numer /10;
        }
        return n - odTylu == 0;
    }

    public static void palindromLiczbowy(int m)
    {
        ArrayList<Integer> listaZliczbami= new ArrayList<>();
        int podloga = (int)Math.pow(10, m-1);
        int sufit = (int)Math.pow(10, m);
        for(int i=podloga;i<=sufit;i++)
        {
            listaZliczbami.add(i);
        }
        for(int i = 0;i<listaZliczbami.size();i++)
        {
            for (int j=0;j<listaZliczbami.size();j++)
            {
                if(palindrom(listaZliczbami.get(i)*listaZliczbami.get(j)))
                    System.out.println(listaZliczbami.get(i)+"x"+listaZliczbami.get(j)+"="+listaZliczbami.get(i)*listaZliczbami.get(j));
            }
        }
    }
    
}
