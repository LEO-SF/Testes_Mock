package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Pedido{
    private List<ItemPedido> itens;
    private DescontoService descontoService;

    public Pedido(){

    }

    public Pedido(List<ItemPedido> itens, DescontoService descontoService) {
        this.itens = new ArrayList<>();
        this.descontoService = descontoService;
    }

    

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubtotal();
        }

        double desconto = descontoService.calcularDesconto(valorTotal);
        valorTotal = valorTotal - desconto;
       /*  if (valorTotal < 0) {
            throw new IllegalArgumentException("Valor total não pode ser negativo");
        }*/
        return valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens){
        this.itens = itens;
    }

    public DescontoService getDescontoService() {
        return descontoService;
    }

    public void setDescontoService(DescontoService descontoService){
        this.descontoService = descontoService;
    }

}
