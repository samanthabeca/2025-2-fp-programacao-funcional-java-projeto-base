package exercicios;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Aula11 {
    private Map<String, List<String>> estadoCidadeMap =
        Map.of("MG", List.of("Belo Horizonte"),
                "SP", List.of("São Paulo", "Campinas"),
                "RJ", List.of("Rio de Janeiro", "Niterói", "Cabo Frio"));


    public Aula11() {
//        estadoCidadeMap.forEach((estado, cidades) -> System.out.println(estado + ": " +  cidades));
//        List<String> list = estadoCidadeMap.values()
//                .stream()
//                .flatMap(cidades -> cidades.stream().map(String::toUpperCase))
//                .toList();
//
//        list.forEach(System.out::println);

        var totalCidadesPorEstado = estadoCidadeMap
                .entrySet()
                .stream()
                .collect(
                        toMap(Map.Entry::getKey, e -> e.getValue().size()));

            totalCidadesPorEstado
                    .forEach(
                        (estado, totalCidades) ->
                                System.out.println(
                                        "Estado: " + estado + ", Total Cidades:  " + totalCidades));
    }

    public static void main(String[] args) {
        new Aula11();
    }
}
