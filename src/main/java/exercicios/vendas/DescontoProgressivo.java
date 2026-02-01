package exercicios.vendas;

public class DescontoProgressivo implements Desconto {
    @Override
    public double percentual(Venda venda) {
        return Math.min(venda.getValorTotal()/2500, 0.2);
    }
}
