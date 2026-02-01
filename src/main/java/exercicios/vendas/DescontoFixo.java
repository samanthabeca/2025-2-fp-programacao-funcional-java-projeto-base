package exercicios.vendas;

public class DescontoFixo implements Desconto {
    @Override
    public double percentual(Venda venda) {
        return 0.1;
    }
}
