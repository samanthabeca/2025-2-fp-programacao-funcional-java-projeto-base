package exercicios.vendas;

import java.util.function.Function;

@FunctionalInterface
public interface Desconto {
    double percentual(Venda venda);

    default boolean temDesconto(Venda venda) {
        return percentual(venda) > 0;

    }
}
