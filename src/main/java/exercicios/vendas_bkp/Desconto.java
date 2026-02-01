package exercicios.vendas_bkp;

/**
 * @author Manoel Campos
 */
@FunctionalInterface
public interface Desconto {
    double percentual(Venda venda);

    default boolean temDesconto(Venda venda){
        return percentual(venda) > 0;
    }
}
