package validador;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by JuanPablo on 03/03/2015.
 */

//Test del validador
public class ValidadorTest {
    Validador myVal;
    int min = -10;
    int max = 20;

    @Before
    public void setUp() throws Exception {
        myVal = new Validador(min, max);
    }

    @Test
    public void TestOverFlowDebajoDelLimite() throws Validador.Underflow, Validador.Overflow {
        try{
            myVal.checkBounds(-15);
        }catch(Validador.Overflow e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestOverFlowEnElLimite() throws Validador.Underflow, Validador.Overflow {
        try{
            myVal.checkBounds(-10);
        }catch(Validador.Overflow e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestUnderFlowEncimaDelLimite() throws Validador.Underflow, Validador.Overflow {
        try{
            myVal.checkBounds(30);
        }catch(Validador.Underflow e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestUnderFlowEnElLimite() throws Validador.Underflow, Validador.Overflow {
        try{
            myVal.checkBounds(20);
        }catch(Validador.Underflow e){
            e.printStackTrace();
        }
    }
}
