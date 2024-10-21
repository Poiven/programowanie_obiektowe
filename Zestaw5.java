import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
        ListaString.add("jeden");
        ListaString.add("jeden");
        ListaString.add("dwa");
        ListaString.add("osiem");
        ListaString.add("dwanaście");
        System.out.println(uniqueArrayListString(ListaString));
        System.out.println(checkDigit(Lista1, 2));





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
        for (int j=0;j<tab.size();j++)
        {
            for (int i = 0; i < tab.get(0).length(); i++) {
                if (tab.get(0).charAt(i) == znak)
                    return true;
            }
        }
        return false;
    }




    //zadanie 7
    public static ArrayList<ArrayList<Integer>> uniqueArrayList(ArrayList<Integer> tab)
    {
        int rozmiar = tab.size();
        ArrayList<Integer> Widziane= new ArrayList<>();
        ArrayList<ArrayList<Integer>> unikalna = new ArrayList<ArrayList<Integer>>();
        int i=0;

        for (Integer liczba:tab)
        {
            if (checkDigit(Widziane, liczba)) {
                continue;
            }else {
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
            if (Widziane.contains(litera)) {
                continue;
            }else {
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
}
