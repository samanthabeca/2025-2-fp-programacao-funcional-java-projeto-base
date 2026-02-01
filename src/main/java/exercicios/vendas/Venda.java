package exercicios.vendas;

import java.util.function.Function;

public class Venda {
    private Desconto descontoStrategy;
    private double valorTotal;
    private double percentualDesconto;

    public Venda() {
        this(venda -> 0.0);
    }

    public Venda(Desconto descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        this.percentualDesconto =
                descontoStrategy.percentual(this);
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    @Override
    public String toString() {
        return "Venda{valorTotal=%s, percentualDesconto=%.2f%%}"
                .formatted(valorTotal, percentualDesconto*100);
    }
}
