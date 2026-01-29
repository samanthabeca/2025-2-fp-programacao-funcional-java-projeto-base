package exercicios;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Aula12 {

    private final int[][] teatro = new int[10][6];

    public Aula12() {
        definirValoresAssentos();
        imprimir();
        System.out.println("Total de assentos menores ou iguais a R$ 80: " +
                contar(valorCol -> valorCol <= 80));

        System.out.println("Total de assentos menores ou iguais a R$ 80: " +
                contar(valorCol -> valorCol > 100));

        System.out.println("Total de assentos menores ou iguais a R$ 80: " +
                contar(valorCol -> valorCol < 50));
    }

    private void imprimir() {
        for (int[] linha : teatro) {
            for (int valorCol : linha) {
                System.out.printf("%5d ", valorCol);
            }
            System.out.println();
        }
    }

    private long contar(IntPredicate condicao) {
//        int total = 0;
//
//        for (int[] linha : teatro) {
//            for (int valorCol : linha) {
//                if (condicao.test(valorCol))
//                    total++;
//            }
//        }

        return Arrays.stream(teatro).flatMapToInt(Arrays::stream)
                .filter(condicao)
                .count();
    }

    private void definirValoresAssentos(){
        for (int i = 0; i < teatro.length; i++) {
            for (int j = 0; j < teatro[i].length; j++) {
                teatro[i][j] = (int)(50 + Math.random() * 100);
            }
        }
    }

    static void main() {
        new Aula12();
    }
}
