package exercicios;

import exercicios.base.Aula;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

/**
 * Esta é uma classe para você poder implementar as atividades propostas no README.
 * Você <b>NÃO</b> deve alterar:
 * <ul>
 *     <li>a estrutura deste arquivo;</li>
 *     <li>o nome da classe, dos métodos ou dos atributos;</li>
 *     <li>parâmetros e tipo de retorno dos métodos.</li>
 * </ul>
 *
 * <b>Mas você PRECISA alterar valores dos atributos existentes</b>.
 *
 * <p>Você pode alterar o código interno dos métodos, criar métodos auxiliares que podem ser chamados
 * pelos existentes, mas não deve alterar a estrutura dos métodos disponíveis.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Aula06 extends Aula {
    /**
     * {@link Predicate<Estudante>} que seleciona somente as mulheres
     * matriculadas em algum curso e com nota maior ou igual a 6.
     * Este deve ser um predicado composto usando {@link Predicate#and(Predicate)}.
     * Você deve trocar o valor armazenado ao atributo para ele seguir a regra definida acima.
     */
    private final Predicate<Estudante> mulheresAprovadas = ((Predicate<Estudante>) Estudante::isMulher)
            .and(Estudante::hasCurso)
            .and(Estudante::isAprovado);

    /**
     * Você pode chamar os métodos existentes e outros que você criar aqui,
     * incluir prints e fazer o que desejar neste método para conferir os valores retornados pelo seu método.
     * Para verificar se sua implementação está correta, clique com o botão direito no nome do projeto na aba esquerda
     * do IntelliJ e selecione a opção "Run All Tests".
     */
    public Aula06() {

//        var novosEstudantes = estudantes.stream()
//                .filter(Estudante::hasCurso)
//                .filter(Estudante::isMulher)
//                .collect(groupingBy(Estudante::getCurso));
//
//        novosEstudantes.forEach(this::imprimirEstudantesCurso);


//        var novosEstudantes = estudantes.stream()
//                .filter(Estudante::hasCurso)
//                .filter(Estudante::isMulher)
//                .collect(groupingBy(Estudante::getCurso, averagingDouble(Estudante::getNota)));
//
//        novosEstudantes.forEach(
//                (curso, mediaNotas) -> System.out.printf("%s: %.2f\n", curso.getNome(), mediaNotas));



          System.out.println("Lista de mulheres matriculadas e aprovadas:");
          imprimirEstudantesAprovadas(getEstudantesMulheresAprovadas());

          System.out.println("\nLista de mulheres aprovadas ordenada por curso e nota:");
          imprimirEstudantesAprovadas(getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota());

          System.out.println("\nLista de mulheres aprovadas ordenadas decrescente pelo curso e crescente pela nota:");
          imprimirEstudantesAprovadas(getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente());

          System.out.println("\nLista modificável de estudantes aprovadas não ordenadas:");
          imprimirEstudantesAprovadas(getEstudantesMulheresAprovadasNaoOrdenadasModificavel());

          System.out.println("\nLista de mulheres aprovadas ordenada decrecente pelo curso e nota:");
          imprimirEstudantesAprovadas(getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente());

          System.out.println("\nLista de mulheres aprovadas com curso crescente e nota decrescente:");
          imprimirEstudantesAprovadas(getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente());

    }

    /**
     * Veja o método construtor {@link #Aula06()}.
     */
    public static void main(String[] args) {
        new Aula06();
    }

    private void imprimirEstudantesAprovadas(List<Estudante> estudantes) {
        estudantes.forEach(e -> System.out.printf("\tNome: %s - Curso: %s - Nota: %.2f\n", e.getNome(), e.getCurso().getNome(), e.getNota()));
    }


    /**
     * Obtém uma Lista <b>NÃO-MODIFICÁVEL</b> de mulheres matriculadas e aprovadas em algum curso
     * O método usa o predicado {@link #mulheresAprovadas} para filtrar a lista de estudantes.
     * Desta forma, você precisa definir um predicado composto com {@link Predicate#and(Predicate)}
     * para tal atributo.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadas() {

        return  estudantes.stream()
                .filter(mulheresAprovadas)
                .toList();
    }
    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada por curso e nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {

        var notaComparator = comparingDouble(Estudante::getNota);
        var comparator = comparing(Estudante::getCurso).thenComparing(notaComparator);

        return  estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(comparator).toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma decrescente pelo nome do curso e crescente pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        var notaComparator = comparingDouble(Estudante::getNota);
        var comparator = comparing(Estudante::getCurso).reversed().thenComparing(notaComparator);

        return  estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(comparator).toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas na ordem original retornada pela Stream.
     * A lista deve ser <b>MODIFICÁVEL</b>.
     *
     * @return uma Lista <b>MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {

        return  estudantes.stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma decrescente tanto pelo nome do curso quanto pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {

        var notaComparator = comparingDouble(Estudante::getNota).reversed();
        var comparator = comparing(Estudante::getCurso).reversed().thenComparing(notaComparator);

        return  estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(comparator).toList();
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma crescente pelo nome do curso e descrecente pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        var notaComparator = comparingDouble(Estudante::getNota).reversed();
        var comparator = comparing(Estudante::getCurso).thenComparing(notaComparator);

        return  estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(comparator).toList();
    }
}
