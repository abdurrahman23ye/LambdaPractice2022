package lambda_practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {

        // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
        //range(int startInclusive, int endExclusive)

        IntStream.range(1,30).forEach(Utulities::intBoslukluYazdir);

        //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
        //rangeClosed(int startInclusive, int endInclusive)

        rangeClosed(1,30).forEach(Utulities::intBoslukluYazdir);

        //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim

        System.out.println("s3");

        System.out.println(rangeClosed(3, 5).sum());

        //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim

        System.out.println(rangeClosed(30, 40).average());

        //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?

        System.out.println(rangeClosed(325, 468).filter(t -> t%8 == 0).count());


        //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim

        IntStream.rangeClosed(325,468).filter(t->t%8==0).forEach(Utulities::intSatirliYazdir);

        // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim

        System.out.println(rangeClosed(325, 468).filter(t -> t%8 == 0).sum());
        // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim


        System.out.println(rangeClosed(7, 15).filter(Utulities::teklerileriDondur).reduce(Math::multiplyExact));

        //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim

        IntStream.iterate(1, t -> t + 2).limit(10).forEach(Utulities::intBoslukluYazdir);

        //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim

        IntStream.iterate(21,t->t+7).filter(Utulities::teklerileriDondur).limit(10).forEach(Utulities::intSatirliYazdir);

        //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim.


        IntStream.iterate(21,t->t+7).limit(20).forEach(Utulities::intSatirliYazdir);

    }



}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz