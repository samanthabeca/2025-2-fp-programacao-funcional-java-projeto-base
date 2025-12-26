package exercicios;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamNumericas {

    static void main() {
//        var list = IntStream.range(0, 10)
//                .mapToObj(i -> new Sensor(i, i*2))
//                .toList();
//
//        System.out.println(list);

//        var list = IntStream.rangeClosed(0, 10)
//                .mapToObj(i -> new Sensor(i, i*2))
//                .toList();
//
//        System.out.println(list);

//        var list = IntStream.iterate(10, i -> i - 2)
//                .limit(10)
//                .mapToObj(i -> new Sensor(i, i*2))
//                .toList();
//
//        System.out.println(list);

//        var list = IntStream.iterate(10, i -> i >= 0, i -> i - 2)
//                .limit(10)
//                .mapToObj(i -> new Sensor(i, i*2))
//                .toList();
//
//        System.out.println(list);

        new Random().ints()
                .limit(10)
                .map(i -> Math.abs(i))
//                .takeWhile(i -> i > 0) //não dá garantia de quantos números serão gerados
                .forEach(System.out::println);
    }
}
