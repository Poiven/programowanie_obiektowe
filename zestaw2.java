import java.util.Scanner;


public class zestaw2 {
    public static void main(String[] args) {
        zadanie1();
        zadanie2();
        zadanie3();
        zadanie4();
        zadanie5();

    }

    public static void zadanie1() {
        System.out.println(23.0 + 76 + " double");
        System.out.println(41 * 2.0 + 3 + "double");
        System.out.println(5 - 33 + " int");
        System.out.println(109 % 3 + " int");
        System.out.println(50 / 2 + " int");
        System.out.println((4 | 2) + " int");//or, operacja na bitach 4=100, 2=010->110
        System.out.println((3^5) + " int");// xor, operacja na bitach 3=011, 5=101 -> 110=6
        System.out.println((7&9) + " int");// and, operacja na bitach 7=0111, 9=1001 -> 0001=1
    }

    public static void zadanie2(){
        double equasionOne = (Math.sqrt(7)-1)/2 + Math.pow(3,3)%2;
        System.out.println(equasionOne + " - wynik dzialania");
        System.out.println((int)equasionOne + " - na inta \n");

        double eqTwo = 2003.0 / (5*8);
        System.out.println(eqTwo);//wynik
        System.out.println((int)eqTwo+"\n");//na inta

        double eqThree = (3 + Math.sqrt(3)) / ((Math.sqrt(5) / 2) / 3) + 1;
        System.out.println(eqThree);
        System.out.println((int)eqThree+"\n");

        double eqFour = 127 % 4 % 2; // a=127, b= 4, c=2
        System.out.println(eqFour);

        double eqFive = ((11 % 5) + 1) / Math.sqrt(Math.sqrt(2));
        System.out.println(eqFive);
        System.out.println((int)eqFive);
    }

    public static void zadanie3(){
        Scanner skan = new Scanner(System.in);
        System.out.print("Podaj pierwsze słowo: ");
        String firstWord = skan.nextLine();
        System.out.print("\nPodaj drugie słowo: ");
        String secondWord = skan.nextLine();
        System.out.println(firstWord + " " + secondWord);
    }

    public static void zadanie4(){
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę: ");
        double firstNumber = skan.nextDouble();
        System.out.println("Podaj drugą liczbę: ");
        double secondNumber = skan.nextDouble();

        System.out.println("suma: " + (firstNumber + secondNumber));
        System.out.println("roznica: " + (firstNumber - secondNumber));
        System.out.println("iloczyn: " + (firstNumber * secondNumber));
        System.out.println("iloraz: " + (firstNumber / secondNumber));

    }

    public static void zadanie5(){
        Scanner skan = new Scanner(System.in);
        System.out.println("podaj liczbę: ");
        int x = skan.nextInt();

        System.out.println("x + 140 = " + (x + 140));
        System.out.println("x - 31 = " + (x - 31));
        System.out.println("x * 7 = " + x * 7);
        System.out.println("x / 13 = " + x / 13.);
        System.out.println("x % 7 = " + x % 7);
        System.out.println("x /(calkowite) 4 = " + x / 4);
        System.out.println("x ** 45 = " + Math.pow(x, 45));
        System.out.println("x and 67 = " + (x & 67));
        System.out.println("x or 59 = " + (x | 59));
        System.out.println("x xor 59 = " + (x ^ 23));
        System.out.println("x przesuniecie w lewo o 5 bitow = " + (x << 5));
        System.out.println("x przesuniecie w prawo o 6 bitow = " + (x >> 6));
    }

}
