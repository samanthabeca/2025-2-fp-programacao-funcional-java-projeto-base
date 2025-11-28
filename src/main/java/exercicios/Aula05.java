package exercicios;

import exercicios.base.Aula;

import java.util.function.Predicate;

public class Aula05 extends Aula {

    public Aula05() {

        double menorNota = estudantes.stream()
                .filter(Estudante::isHomem)
                .filter(Estudante::hasNota)
                .mapToDouble(Estudante::getNota)
                .map(nota -> nota * 100)
                .min()
                .orElse(0);
    }

    public static void main(String[] args) {
        new Aula05();
    }

}
