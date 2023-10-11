package org.acme;
import org.acme.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import groovy.util.logging.Slf4j;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class Teste {

    @Mock
    DescontoService descontoService;

    @InjectMocks
    Pedido pedido;

    @Test
    public void testarDesconto() {     
        when(descontoService.calcularDesconto(20.0)).thenReturn(2.0);

        ItemPedido item = new ItemPedido(20.0);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);
        pedido.setItens(itens);
        double valorTotal = pedido.calcularValorTotal();
        
        Assertions.assertEquals(18.0, valorTotal);
    }

    @Test
    public void testarDesconto2() { 
        ItemPedido item = new ItemPedido(20.0);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);
        descontoService =new DescontoService() {
        @Override
        public double calcularDesconto(double valorTotal) {
            return valorTotal * 0.0;
         }
    };
        Pedido pedido = new Pedido(itens, descontoService);
        when(descontoService.calcularDesconto(20.0)).thenReturn(0.0);
        assertEquals(20.0, pedido.calcularValorTotal());
    }

    /*@Test
    public void testarDesconto3() { 
        ItemPedido item = new ItemPedido(20.0);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);
        descontoService =new DescontoService() {
        @Override
        public double calcularDesconto(double valorTotal) {
            return valorTotal * 1.1;
         }
    };
        pedido = new Pedido(itens, descontoService);
        assertEquals((0), pedido.calcularValorTotal());
    }*/
    
    @Test
    public void testarDesconto3() { 
       ItemPedido item = new ItemPedido(20.0);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);
        descontoService =new DescontoService() {
        @Override
        public double calcularDesconto(double valorTotal) {
            return valorTotal * 1.1;
         }
    };
        Pedido pedido = new Pedido(itens, descontoService);
        //when(pedido.calcularValorTotal()).thenThrow(IllegalArgumentException("Valor total não pode ser negativo"));
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pedido.calcularValorTotal();
        });
    }


    /*Crie um teste unitário para a classe Pedido que configure um mock do DescontoService para simular um desconto de 10% e verifique se o método calcularValorTotal retorna o valor correto após aplicar o desconto. */
    
}
