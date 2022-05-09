package lambda_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> l= Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");

        // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
        l.stream().map(String::toUpperCase).forEach(Utulities::stringBoslukluYazdir);

        //S2: Stringleri uzunluklarina gore siralayip yaziniz

        l.stream().sorted(Comparator.comparing(String::length)).forEach(Utulities::stringSatirliYazdir);

        //S3: E ILE Baslayanlari yazdiralim

        l.stream().map(String::toLowerCase).filter(t->t.startsWith("e")).forEach(Utulities::stringSatirliYazdir);






    }





}
