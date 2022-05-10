package lambda_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/*
dosya eklemek icin 2 yol var
1) Files.lines(Path.of("path")  buradan stream e eklemek icin
Stream <String> satir=Files.lines(Path.of(".........."));
bu bize tekrardan stream tanimlamadan kullanmayi saglar
2) //Files.lines(Paths.get("..........")).  kullanilir
==========================================================
intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
sonrasinda copy path seciyoruz bundan sonra iki secenek var
1) absolute path seciyoruz yada
2) path from content root seciyoruz
her ikisinde de path kopyalamis oluyoruz

cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
*/
public class C7_DosyaOkuma {
    public static void main(String[] args) throws IOException {

        Stream<String> satir= Files.lines(Path.of("src/lambda_practice/C7_TextFile"));
        //NOT PATH cift tirnak icine alinmali
        //artik stream e donustu methodlari kullanabiliriz


    // S1: Yazdiralim

        Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).forEach(Utulities::stringSatirliYazdir);

        System.out.println();
    //S2: tum harflari buyuk harf ile yazdiralim

        Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).map(String::toUpperCase).forEach(Utulities::stringSatirliYazdir);

        System.out.println();
    // S3: son satiri buyuk harfle yazdiralim


        Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).
                sorted(Comparator.reverseOrder()).limit(1).map(String::toUpperCase).forEach(Utulities::stringSatirliYazdir);

    //S4: 2.ve 3. satirlari yazdiralim

        Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).sorted().skip(1).limit(2).forEach(Utulities::stringSatirliYazdir);


    //S5: kac tane "icin" kelimesi vardir

        System.out.println(Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).filter(t -> t.contains("icin")).count());


        //S6: tum kelimelerin tum kelimeleri natural order  yazdiriniz.

        Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).
                map(t->t.split(" ")).flatMap(Arrays::stream).sorted().forEach(Utulities::stringSatirliYazdir);


        // S7:  metinde kac tane "a"  vardir

        System.out.println(Files.lines(Paths.get("src/lambda_practice/C7_TextFile")).
                map(t -> t.split("")).
                flatMap(Arrays::stream).filter(t -> t.equals("a")).count());


    }

}
