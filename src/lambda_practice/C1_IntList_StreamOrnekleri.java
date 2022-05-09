package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        // S1:listi aralarinda bosluk birakarak yazdiriniz //
        list.stream().forEach(Utulities::intBoslukluYazdir);

        System.out.println();
        //S2: sadece negatif olanlari yazdir.

        list.stream().filter(Utulities::negatifleriDondur).forEach(Utulities::intBoslukluYazdir);

        //S3: pozitif olanlardan yeni bir liste olustur
        System.out.println();

        List<Integer> pozitifSayilar = new ArrayList<>();

        pozitifSayilar=list.stream().
                filter(Utulities::pozitifleriDondur).collect(Collectors.toList());

        System.out.println(pozitifSayilar);

        // S4: list in elemanlarin karelerinden yeni bir list olusturalim
        System.out.println();

        list.stream().map(t->t*t).forEach(Utulities::intBoslukluYazdir);
        //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
        System.out.println();

        list.stream().map(t->t*t).distinct().forEach(Utulities::intBoslukluYazdir);

        //S6: listin elemanlarini kucukten buyuge siralayalim
        System.out.println();

        list.stream().sorted().forEach(Utulities::intBoslukluYazdir);
        //S7: listin elemanlarini buyukten kucuge siralayalim

        System.out.println();

        list.stream().sorted(Comparator.reverseOrder()).forEach(Utulities::intBoslukluYazdir);

        // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

        System.out.println("S8");

        List<Integer> list2= new ArrayList<>();
        list2=list.stream().filter(Utulities::pozitifleriDondur).
                map(t -> t*t*t).filter(t -> t%10 == 5).collect(Collectors.toList());

        System.out.println("list2 = " + list2);

        //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

        list2=list.stream().filter(Utulities::pozitifleriDondur).
                map(t -> t*t).filter(t -> t%10 != 5).collect(Collectors.toList());

        System.out.println("list2 = " + list2);

        // S10 :list elemanlarini toplamini bulalim

        System.out.println(list.stream().reduce(0, (x, y) -> x + y));

        // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim

        list.stream().filter(Utulities::negatifleriDondur).
                peek(t-> System.out.print(t+" sayısının karesi: ")).map(t->t*t).forEach(Utulities::intSatirliYazdir);

        // S12 : listeden 5 den buyuk  sayi var mi?

        System.out.println(list.stream().anyMatch(t -> t > 5));

        // S13 : listenin tum elemanlari sifirdan kucuk mu?

        System.out.println(list.stream().allMatch(t -> t < 0));

        // S14: listenin 100 e esit elemani yok mu ?

        System.out.println(list.stream().noneMatch(t -> t == 100));

        // S15: listenin sifira esit elemani yok mu?

        System.out.println(list.stream().noneMatch(t -> t == 0));

        // S16:  listenin ilk 5 elemanini topla?

        System.out.println(list.stream().limit(5).reduce(0, (x, y) -> x + y));

        //S17: listenin son bes elemaninin  listele

        list.stream().skip(list.size()-5).forEach(Utulities::intBoslukluYazdir);


    }




}