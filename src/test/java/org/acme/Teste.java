package org.acme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mock;

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

        when(descontoService.calcularDesconto(20.0)).thenReturn(0.0);

        ItemPedido item = new ItemPedido(20.0);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);

        pedido.setItens(itens);
        double valorTotal = pedido.calcularValorTotal();
        
         Assertions.assertEquals(20.0, valorTotal);
    }

    //TESTE RETIRADO

    /*@Test
    public void testarDesconto3() { 

        when(descontoService.calcularDesconto(20.0)).thenReturn(22.0);

        ItemPedido item = new ItemPedido(20.0);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);
        pedido.setItens(itens);
        
        assertEquals((0), pedido.calcularValorTotal());
    }*/
    
    @Test
    public void testarDesconto4() { 

       when(descontoService.calcularDesconto(20.0)).thenReturn(22.0);

       ItemPedido item = new ItemPedido(20.0);
       List<ItemPedido> itens = new ArrayList<>();
       itens.add(item);

       pedido.setItens(itens);
        
        //when(pedido.calcularValorTotal()).thenThrow(IllegalArgumentException("Valor total não pode ser negativo"));
       Assertions.assertThrows(IllegalArgumentException.class, () -> {
            pedido.calcularValorTotal();
       });
    }

    @Test
    public void testarDesconto5() { 
   
        List<ItemPedido> itens = new ArrayList<>();
        pedido.setItens(itens);
        
        Assertions.assertEquals(0.0, pedido.calcularValorTotal());
        Assertions.assertTrue(pedido.getItens().isEmpty());
    }

    @Test
    public void testarDesconto6() { 

       ItemPedido item = new ItemPedido(20.0);
       List<ItemPedido> itens = new ArrayList<>();
       itens.add(item);

       pedido.setItens(itens);

       when(descontoService.calcularDesconto(20.0)).thenReturn(4.00);
       Assertions.assertEquals(16.0, pedido.calcularValorTotal());

       when(descontoService.calcularDesconto(20.0)).thenReturn(2.00);
       Assertions.assertEquals(18.0, pedido.calcularValorTotal());
        
    }

     @Test
    public void testarDesconto7() { 

       when(descontoService.calcularDesconto(20.0)).thenReturn(4.00);
       
       ItemPedido item = new ItemPedido(20.0);
       List<ItemPedido> itens = new ArrayList<>();
       itens.add(item);

       pedido.setItens(itens);

       pedido.calcularValorTotal();

       Assertions.assertEquals(1, Pedido.getChamadas());  
    }


    /*Crie um teste unitário para a classe Pedido que configure um mock do DescontoService para simular um desconto de 10% e verifique se o método calcularValorTotal retorna o valor correto após aplicar o desconto. */
    
}
