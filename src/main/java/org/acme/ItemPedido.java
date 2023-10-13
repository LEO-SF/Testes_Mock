package org.acme;

public class ItemPedido {

    private double subtotal;

    public ItemPedido() {

    }

    public ItemPedido(double subtotal) {

        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    private void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "subtotal=" + subtotal +
                '}';
    }
}

