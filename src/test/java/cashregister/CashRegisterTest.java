package cashregister;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);

        //when
        Purchase purchase = new Purchase(new Item[]{});
        cashRegister.process(purchase);

        //then
        verify(printer, times(1)).print("");
        verify(printer, never()).print("some string cool");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("mockString");
        //when
        cashRegister.process(purchase);

        //then
        verify(printer, times(1)).print("mockString");
        verify(printer, never()).print("");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        CashRegister cashRegister = mock(CashRegister.class);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("mockString");
        //when
        cashRegister.process(purchase);

        //then
        verify(cashRegister, times(1)).process(purchase);
//        verify(printer, never()).print("");
    }

}
