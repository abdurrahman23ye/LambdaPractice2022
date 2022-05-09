package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };

        // S1 : tum elemanlari list yapayim

        Arrays.stream(arr).flatMap(Arrays::stream).forEach(Utulities::stringSatirliYazdir);

        // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim

        Arrays.stream(arr).flatMap(Arrays::stream).map(String::toLowerCase).
                filter(t->t.startsWith("e")).map(t->t+t).forEach(Utulities::stringSatirliYazdir);

        // S3: E ile baslayan elemanlari liste olarak yazdiralim

        Arrays.stream(arr).flatMap(Arrays::stream).map(String::toLowerCase).
                filter(t->t.startsWith("e")).forEach(Utulities::stringSatirliYazdir);
        //S4 : k ile bitenlerin sonuna '*' ekleyelim
        Arrays.stream(arr).flatMap(Arrays::stream).map(String::toLowerCase).
                filter(t->t.endsWith("k")).map(t->t+"*").forEach(Utulities::stringSatirliYazdir);



    }





}
