package lambda_practice;

public class Utulities {

    public static void intBoslukluYazdir(int a){System.out.print(a+" ");}
    public static void intSatirliYazdir(int a){System.out.println(a+" ");}
    public static void stringSatirliYazdir(String a){System.out.println(a+" ");}
    public static void stringBoslukluYazdir(String a){System.out.print(a+" ");}
    public static boolean negatifleriDondur(int a){boolean negatif=false;if(a<0){negatif=true;} return negatif; }
    public static boolean teklerileriDondur(int a){ return a%2!=0; }
    public static boolean ciftleriDondur(int a){ return a%2==0; }
    public static boolean pozitifleriDondur(int a){boolean pozitif=false;if(a>0){pozitif=true;} return pozitif; }
}
