package exercicios;

import exercicios.base.Aula;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Aula10 extends Aula {

    public Aula10() {
//        double somaNota =
//                estudantes
//                    .stream()
//                    .filter(e -> e.getSexo() == 'F')
//                    .mapToDouble(Estudante::getNota)
//                    .sum();
//        System.out.println(somaNota);
//
//        estudantes.stream()
//                .filter(e -> e.getSexo() == 'F')
//                .mapToDouble(Estudante::getNota)
//                .max()
//                .ifPresent(maiorNota -> System.out.println("A maior nota é " + maiorNota));

        double maiorNotaHomens = maiorNota(getEstudanteStream(), Estudante::isHomem);
        System.out.println(maiorNotaHomens);

        double maiorNotaMulheres = maiorNota(getEstudanteStream(), Estudante::isMulher);
        System.out.println(maiorNotaMulheres);

        List<Double> notas = notasEstudantesAprovados(getEstudanteStream());
        System.out.println(notas);
    }

    private List<Double> notasEstudantesAprovados(@NotNull Stream<Estudante> estudanteStream) {
        return estudanteStream.map(Estudante::getNota).toList();
    }

    private @NotNull Stream<Estudante> getEstudanteStream() {
        return estudantes
                .stream()
                .filter(Estudante::isAprovado);
    }

    private double maiorNota(Stream<Estudante> estudanteStream, Predicate<Estudante> estudantePredicate) {
        return estudanteStream.filter(estudantePredicate)
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        Aula10 a = new Aula10();
    }
}
