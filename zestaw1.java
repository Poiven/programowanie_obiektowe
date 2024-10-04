import java.text.SimpleDateFormat;  
import java.util.Date;  

class Main {
    public static void main(String[] args) {
        System.out.println("Dawid Sztachanski"); 
        //System.out.println("5, 11");
        String name = "Dawid";
        String surname ="Sztachanski";
        System.out.println(name.length()+", "+surname.length());
        System.out.println("Ala"+"ma"+"kota");
        System.out.println("                    *");
        System.out.println("                    * *");
        System.out.println("                    * * *");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("                    * * *");
        System.out.println("                    * *");
        System.out.println("                    *");
        
        System.out.println("     *");
        System.out.println("    * *");
        System.out.println("   * * *");
        System.out.println("  * * * *");
        System.out.println(" * * * * *");
        System.out.println("* * * * * *");
        System.out.println(" * * * * *");
        System.out.println("  * * * *");
        System.out.println("   * * *");
        System.out.println("    * *");
        System.out.println("     *");
        
        //5
        String text = "Ala ma kota";
        System.out.println(text.replaceAll("a","e"));
        //6
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println();
        //7
        System.out.print("A=");
        System.out.println((int)'A');
        System.out.print("! = ");
        System.out.println((int)'!');
        System.out.println((int)'@');
        System.out.println((int)'>');
        System.out.println((int)'~');
        System.out.println((int)'\n');
        System.out.println((int)'\b');
        System.out.println();
        //8
        System.out.println("male: "+(int)'a'+"-"+(int)'z');
        System.out.println("duze:"+(int)'A'+"-"+(int)'Z');
        System.out.println("cyfry: "+(int)'0'+"-"+(int)'9');
        System.out.println();
        //9
        String grzes="Grzesiek nie wiedzial dlaczego ... jest tak drapieznym ... mimo, ze jego ... na to nie wskazuje.";
        System.out.println(grzes.replace("...","komputer"));
        //10
        System.out.println("Lalka"+" to najlepsza ksiazka napisana przez "+"Boleslawa Prusa");
        System.out.println();
        //11
        System.out.println("wodrze".repeat(5));
        System.out.println();
        //12
        SimpleDateFormat formatterDays = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();  
        //System.out.println(formatterDays.format(date));
        //System.out.println(formatterTime.format(date));
        
        
        System.out.println("Dzisiaj jest "+formatterDays.format(date)+" godzina "+ formatterTime.format(date));
        //13
        System.out.println((char)54);
        System.out.println((char)103);
        System.out.println((char)241);
        System.out.println((char)67);
        System.out.println((char)9999);
        System.out.println((char)16);//5+11
        System.out.println((char)174926);
    }
}
