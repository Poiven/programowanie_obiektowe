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

        Wypisz(tablicaPierwsze);
        ileNieparzystych(tablicaPierwsze);
        ileParzystych(tablicaPierwsze);
        ileDodatnich(tablicaPierwsze);
        ileUjemnych(tablicaPierwsze);
        ileZerowych(tablicaPierwsze);
        ileMaxymalnych(tablicaPierwsze);
        ileMinnimalnych(tablicaPierwsze);
        ileUnikalnych(tablicaPierwsze);
        int dodatnie = SumaDodatnich(tablicaPierwsze);
        int ujemne = SumaUjemnych(tablicaPierwsze);
        double odwrotne = SumaOdwrotnych(tablicaPierwsze);
        var sredniaAry = SredniaArytmetyczna(tablicaPierwsze);
        var sredniaGeo = SredniaGeometryczna(tablicaPierwsze);
        var sredniaHar = SredniaHarmoniczna(tablicaPierwsze);
        Wypisz(FunkcjaLiniowa(tablicaPierwsze, 1,2));
        Wypisz(FunkcjaKwadratowa(tablicaPierwsze, 1,2,4));
        Wypisz(FunkcjaWykladanicza(tablicaPierwsze, 2));
        Wypisz(FunkcjaSignum(tablicaPierwsze));
        System.out.println(NajdluzszyCiagDodatnich(tablicaPierwsze));
        System.out.println(NajdluzszyCiagUjemnych(tablicaPierwsze));
        odwrocTablice(tablicaPierwsze);
        Wypisz(tablicaPierwsze);




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
                System.out.print(tablica[i]+") \n");
        }
    }
    public static void Wypisz(double[] tablica){
        for (int i = 0; i < tablica.length; i++) {
            if (i==0)
                System.out.print("("+tablica[i]+" ");
            else if (i<tablica.length-1)
                System.out.print(tablica[i] + " ");
            else
                System.out.print(tablica[i]+") \n");
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
            System.out.print(") \n");
            zmiennaKoncowa += m;
//            System.out.println();
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
                System.out.print(tablica[i]+") \n");
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
        System.out.println("parzyste: " + even);
    }
    public static void ileDodatnich(int[] tab)
    {
        int positive = 0;
        for (int liczba:tab){
            if (liczba>0){
                positive++;
            }
        }
        System.out.println("dodatnie: " + positive);
    }
    public static void ileUjemnych(int[] tab)
    {
        int negative = 0;
        for (int liczba:tab){
            if (liczba<0){
                negative++;
            }
        }
        System.out.println("ujemne: " + negative);
    }
    public static void ileZerowych(int[] tab)
    {
        int positive = 0;
        for (int liczba:tab){
            if (liczba==0){
                positive++;
            }
        }
        System.out.println("zer: " + positive);
    }

    public static void ileMaxymalnych(int[] tab)
    {
        int max = 0;
        int maxValue = tab[0];
        for (int number: tab)
        {
            if (number > maxValue)
            {
                max = 1;
                maxValue = number;
            }
            else if (number == maxValue){
                max++;
            }
        }
        System.out.println("ilosc maksymalnych wartości " + maxValue +": "+ max );
    }
    public static void ileMinnimalnych(int[] tab)
    {
        int min = 0;
        int minValue = tab[0];
        for (int number: tab)
        {
            if (number < minValue)
            {
                min = 1;
                minValue = number;
            }
            else if (number == minValue){
                min++;
            }
        }
        System.out.println("ilosc minimalnych wartości " + minValue +": "+ min );
    }

    public static void ileUnikalnych(int[] tab){
        int unique=0;
        for (int i = 0; i < tab.length; i++){
            int ilosc = 0;
            for (int j = 0; j < tab.length; j++){
                if (tab[i]==tab[j]){
                    ilosc++;
//                    System.out.println("ilosc zwiekszona" + tab[i] + tab[j]);
                }
            }
            if (ilosc==1)
                unique++;
        }
        System.out.println("ilosc unikalnych liczb: " + unique);
    }

    public static int SumaDodatnich(int[] tab)
    {
        int suma=0;
        for (int number: tab)
        {
            if (number>=0)
            {
                suma += number;
            }
        }
        return suma;
    }

    public static int SumaUjemnych(int[] tab)
    {
        int suma=0;
        for (int number: tab)
        {
            if (number<0)
            {
                suma += number;
            }
        }
        return suma;
    }
    public static double SumaOdwrotnych(int[] tab)
    {
        double suma=0;
        for (int number: tab)
        {
            suma += 1.0/number;
        }
        return suma;
    }
    public static double SredniaArytmetyczna(int[] tab)
    {
        double suma=0;
        for (int number: tab)
        {
            suma+=number;
        }
        return (suma / tab.length);
    }

    public static double SredniaGeometryczna(int[] tab)
    {
        double iloczyn = 1;
        for (int number: tab)
        {
            iloczyn *=number;
        }
        return (Math.pow(iloczyn, 1.0 / tab.length));
    }

    public static double SredniaHarmoniczna(int[] tab)
    {
        return (tab.length/SumaOdwrotnych(tab));
    }

    public static int[] FunkcjaLiniowa(int[] tab,int a,int b)
    {
        int []result = new int[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            result[i] = a*tab[i]+b;
        }
        return result;
    }

    public static double[] FunkcjaKwadratowa(int[] tab,int a,int b, int c)
    {
        double []result = new double[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            result[i] = a*tab[i]*tab[i]+b*tab[i]+c;
        }
        return result;
    }

    public static double[] FunkcjaWykladanicza(int[] tab,int a)
    {
        double []result = new double[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            result[i] = Math.pow(a,tab[i]);
        }
        return result;
    }

    public static int[] FunkcjaSignum(int[] tab)
    {
        int[] result = new int[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            if (tab[i]>0)
                result[i] = 1;
            else if (tab[i]==0)
                result[i] = 0;
            else
                result[i] = -1;
        }
        return result;
    }

    public static int NajdluzszyCiagDodatnich(int[] tab)
    {
        int ciag = 0;
        int sign = 1;
        int max = 0;
        for (int i : tab) {
            if (i >= 0) {
                ciag++;
                if (ciag >= max && sign == 1)
                    max = ciag;
                sign = 1;
            } else {
                sign = 0;
                ciag = 0;
            }
        }
        return max;
    }
    public static int NajdluzszyCiagUjemnych(int[] tab)
    {
        int ciag = 0;
        int sign = 0;
        int min = 0;
        for (int i : tab) {
            if (i < 0) {
                ciag++;
                if (ciag >= min && sign == 1)
                    min = ciag;
                sign = 1;
            } else {
                sign = 1;
                ciag = 0;
            }
        }
        return min;
    }

    public static void odwrocTablice(int[] tab){
        int start = 0;
        int end = tab.length - 1;
        while (start < end) {
            int temp = tab[start];
            tab[start] = tab[end];
            tab[end] = temp;
            start++;
            end--;
        }
    }
    public static void odwrocTablice(int[] tab, int indeksStart, int indeksStop) {
        if (indeksStart <0)
            indeksStart =0;
        if (indeksStop > tab.length-1)
            indeksStop = tab.length-1;
        while (indeksStart < indeksStop) {
            int temp = tab[indeksStart];
            tab[indeksStart] = tab[indeksStop];
            tab[indeksStop] = temp;
            indeksStart++;
            indeksStop--;
        }
    }
}
