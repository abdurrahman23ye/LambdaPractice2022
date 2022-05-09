package lambda_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");

        // S1: ilk harfi d ve ya c olanlari listeleyelim

        System.out.println(list.stream().map(String::toLowerCase).
                filter(t -> t.startsWith("d") || t.startsWith("c")).collect(Collectors.toList()));

        //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim

        list.stream().forEach(t-> System.out.println("*"+t+"*"));


        //S3: alfabedik  gore siralayalim list olarak

        list.stream().sorted().forEach(Utulities::stringSatirliYazdir);

        //S4: tum 'l' leri silelim yazdiralim

        list.stream().map(t->t.replace("l","")).forEach(Utulities::stringSatirliYazdir);

        //S5 : icinde e olanlardan yeni bir list olusturunuz

        System.out.println(list.stream().filter(t -> t.contains("e")).collect(Collectors.toList()));

        // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi

        list.stream().map(t->t.substring(0,1)+t.substring(0,1)+t.substring(0,1)+t).
                forEach(Utulities::stringSatirliYazdir);
        // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
        list.stream().map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).forEach(Utulities::stringSatirliYazdir);

       // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz

        list.stream().filter(t-> t.length()!=4 && t.length()!=6).forEach(Utulities::stringSatirliYazdir);



    }









}
