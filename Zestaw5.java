import java.util.ArrayList;
import java.util.Arrays;

public class Zestaw5 {
    public static void main(String[] args) {
        ArrayList<Integer> Lista1 = new ArrayList<>();
        Lista1.add(1);
        Lista1.add(3);
//    Lista1.add(5);
//    Lista1.add(7);

        ArrayList<Integer> Lista2 = new ArrayList<>();
        Lista2.add(2);
        Lista2.add(2);
        Lista2.add(2);
        Lista2.add(4);
        Lista2.add(4);
        Lista2.add(6);
        Lista2.add(8);
        Lista2.add(9);

//        ArrayList<Integer> Nowalista = merge(Lista1,Lista2);
//        System.out.println(Nowalista);

//        zadanie7
        ArrayList<ArrayList<Integer>> Zadanie7=uniqueArrayList(Lista2);
        System.out.println(Zadanie7);


        ArrayList<String> ListaString= new ArrayList<>();
        ListaString = toArrayListString("eedcbaa");
        System.out.println(ListaString);
        /*ListaString.add("jeden");
        ListaString.add("jeden");
        ListaString.add("dwa");
        ListaString.add("osiem");
        ListaString.add("dwanaście");*/

        System.out.println(uniqueArrayListString(ListaString));
//        System.out.println(checkDigit(Lista1, 2));
        //

//        System.out.println(toArrayListString("edcba"));
//        System.out.println(toArrayList(421));
//        System.out.println(MergeSorted(Lista1,Lista2));
        System.out.println(countArrayList(Lista2));
        System.out.println(countArrayListString(ListaString));




    }

    public static ArrayList<Integer> append(ArrayList<Integer> tab1, ArrayList<Integer> tab2){
        ArrayList<Integer> wynik = new ArrayList<Integer>(tab1.size()+tab2.size());
        /*for(Integer liczba: tab1){
            wynik.add(liczba);
        }
        for(Integer liczba: tab2){
            wynik.add(liczba);
        }
        return wynik;
        */
        wynik.addAll(tab1);
        wynik.addAll(tab2);
        return wynik;
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> tab1, ArrayList<Integer> tab2)
    {
        ArrayList<Integer> wynik = new ArrayList<Integer>(tab1.size()+tab2.size());
        int k =0;
        int j=0;
        for (int i=0; i<(tab1.size()+tab2.size());i++)
        {
            if (i%2==0){
                if (k>=tab1.size())
                {
                    wynik.add(tab2.get(j));
                    j++;
                }else {
                    wynik.add(tab1.get(k));
                    k++;
                }
            }
            else {
                if (j>=tab2.size()) {
                    wynik.add(tab1.get(k));
                    k++;
                }else {
                    wynik.add(tab2.get(j));
                    j++;
                }
            }
        }
        return wynik;
    }
    public static ArrayList<Integer> MergeSorted(ArrayList<Integer> tab1, ArrayList<Integer> tab2)
    {
        ArrayList<Integer> posortowana1 = sortowanie(tab1);
        ArrayList<Integer> sorted2 = sortowanie(tab2);

        ArrayList<Integer> wynik = new ArrayList<>();
        int i = 0, j = 0;

        while (i < posortowana1.size() && j < sorted2.size()) {
            if (posortowana1.get(i) <= sorted2.get(j)) {
                wynik.add(posortowana1.get(i));
                i++;
            } else {
                wynik.add(sorted2.get(j));
                j++;
            }
        }
        while (i < posortowana1.size()) {
            wynik.add(posortowana1.get(i));
            i++;
        }
        while (j < sorted2.size()) {
            wynik.add(sorted2.get(j));
            j++;
        }
        return wynik;
    }

    public static ArrayList<Integer> sortowanie(ArrayList<Integer> array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    // Zamiana elementów
                    int temp = array.get(j);
                    array.set(j, array.get(j+1)); //= array.get(j + 1);
                    array.set(j + 1, temp);// = temp;
                }
            }
        }
        return array;
    }
//    public static ArrayList<String> sortowanieString(ArrayList<String> array) {
//        int n = array.size();
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - 1 - i; j++) {
//                if (array.get(j) > array.get(j + 1)) {
//                    // Zamiana elementów
//                    String temp = array.get(j);
//                    array.set(j, array.get(j+1)); //= array.get(j + 1);
//                    array.set(j + 1, temp);// = temp;
//                }
//            }
//        }
//        return array;
//    }

    public static ArrayList<Integer> toArrayList(int liczba)
    {
        ArrayList<Integer> result = new ArrayList<>();
        String zamienionaLiczba = Integer.toString(liczba);
        String cyfra;
        for (int i = 0; i < zamienionaLiczba.length();i++)
        {
            cyfra = Character.toString(zamienionaLiczba.charAt(i));
            result.add(Integer.parseInt(cyfra));

        }
        result = sortowanie(result);

        return result;
    }
    public static ArrayList<String> toArrayListString(String teskt)
    {
        ArrayList<String> result = new ArrayList<>();
        char[] znaki = teskt.toCharArray();
//        String znak;
        Arrays.sort(znaki);
        for (int i =0 ;i<znaki.length;i++){
            result.add(Character.toString(znaki[i]));
        }

        return result;
    }






    public static boolean checkDigit(ArrayList<Integer>tab, int cyfra)
    {
        for (Integer liczba: tab)
        {
            if (liczba==cyfra)
                return true;
        }
        return false;
    }


    public static boolean checkChar(ArrayList<String>tab, char znak)
    {
        for (String s : tab) {
            if (s.equals(Character.toString(znak)))
                return true;
        }
        return false;
    }
    public static int countDigit(ArrayList<Integer> tab, int cyfra){
        int counter = 0;
        for (int liczba: tab)
        {
            if (liczba==cyfra)
                counter++;
        }
        return counter;
    }
    public static int countChar(ArrayList<String> tab, char znak){
        int counter = 0;
        for (String s : tab) {
            if (s.equals(Character.toString(znak)))
                counter++;
        }
        return counter;
    }









    //zadanie 7
    public static ArrayList<ArrayList<Integer>> uniqueArrayList(ArrayList<Integer> tab)
    {
//        int rozmiar = tab.size();
        ArrayList<Integer> Widziane= new ArrayList<>();
        ArrayList<ArrayList<Integer>> unikalna = new ArrayList<ArrayList<Integer>>();
        int i=0;

        for (Integer liczba:tab)
        {
            if (!checkDigit(Widziane, liczba)) {
                Widziane.add(liczba);
            }
        }
        for (Integer liczba:Widziane)
        {
            unikalna.add(new ArrayList<Integer>());
            unikalna.get(i).add(liczba);
            unikalna.get(i).add(0);
            i++;
        }


        return unikalna;
    }

    public static ArrayList<ArrayList<String>> uniqueArrayListString(ArrayList<String> tab)
    {
        int rozmiar = tab.size();
        ArrayList<String> Widziane= new ArrayList<>();
        ArrayList<ArrayList<String>> unikalna = new ArrayList<ArrayList<String>>();
        int i=0;

        for (String litera:tab)
        {
            if (!checkChar(Widziane,litera.charAt(0))) {
                Widziane.add(litera);
            }
        }
        for (String liczba:Widziane)
        {
            unikalna.add(new ArrayList<String>());
            unikalna.get(i).add(liczba);
            unikalna.get(i).add("0");
            i++;
        }
        return unikalna;
    }




    public static ArrayList<ArrayList<Integer>> countArrayList(ArrayList<Integer> tab)
    {
//        int rozmiar = tab.size();
        ArrayList<Integer> Widziane= new ArrayList<>();
        ArrayList<ArrayList<Integer>> policzona = new ArrayList<ArrayList<Integer>>();
        int i=0;

        for (Integer liczba:tab)
        {
            if (!checkDigit(Widziane, liczba)) {
                Widziane.add(liczba);
            }
        }
        for (Integer liczba:Widziane)
        {
            policzona.add(new ArrayList<Integer>());
            policzona.get(i).add(liczba);
            policzona.get(i).add(countDigit(tab, liczba));
            i++;
        }


        return policzona;
    }

    public static ArrayList<ArrayList<String>> countArrayListString(ArrayList<String> tab)
    {
        int rozmiar = tab.size();
        ArrayList<String> Widziane= new ArrayList<>();
        ArrayList<ArrayList<String>> unikalna = new ArrayList<ArrayList<String>>();
        int i=0;

        for (String litera:tab)
        {
            if (!checkChar(Widziane,litera.charAt(0))) {
                Widziane.add(litera);
            }
        }
        for (String liczba:Widziane)
        {
            unikalna.add(new ArrayList<String>());
            unikalna.get(i).add(liczba);
            unikalna.get(i).add(Integer.toString(countChar(tab,liczba.charAt(0))));
            i++;
        }
        return unikalna;
    }

}
