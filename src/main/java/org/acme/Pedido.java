package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Pedido{
    private List<ItemPedido> itens;
    private DescontoService descontoService;
    private static int chamadas = 0;
    private static boolean chamou = false;
        

    public Pedido(){

    }

    public Pedido(List<ItemPedido> itens, DescontoService descontoService) {
        this.itens = new ArrayList<>();
        this.descontoService = descontoService;
    }

    

    public double calcularValorTotal() {
    
    double valorTotal = 0.0;

    if(!itens.isEmpty()){

        RChamadas();

        for (ItemPedido item : itens) {
            valorTotal += item.getSubtotal();
        }
    }

        double desconto = descontoService.calcularDesconto(valorTotal);
        NChamadas();
        
        valorTotal = valorTotal - desconto;
        if (valorTotal < 0) {
            throw new IllegalArgumentException("Valor total não pode ser negativo");
        }
        return valorTotal;
        
    }

    public static void NChamadas(){
        chamadas = 1;
        chamou = true;
    }

    public static void RChamadas(){
        chamadas = 0;
        chamou = false;
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

    public static int getChamadas(){
        return chamadas;
    }

    public static void setChamadas(int chamadas){
        Pedido.chamadas = chamadas;
    }

    public static boolean getChamou(){
        return chamou;
    }

    public static void setChamou(boolean chamou){
        Pedido.chamou = chamou;
    }

}
