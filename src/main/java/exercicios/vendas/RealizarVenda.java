package exercicios.vendas;

import java.util.function.Function;

public class RealizarVenda {

    static void main() {

        var venda = new Venda(v -> Math.random());
        venda.setValorTotal(200);
        System.out.println(venda);
    }
}
