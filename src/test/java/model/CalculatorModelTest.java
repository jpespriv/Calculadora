package model;

import static org.junit.Assert.*;

import model.CalculatorModel;
import model.I_CalculatorModel;
import model.DivideByZero;
import validador1.Validador;

import org.junit.Before;
import org.junit.Test;

// Test del modelo de mi calculadora
public class CalculatorModelTest {
    I_CalculatorModel myCalc;
    I_CalculatorModel myCalc1;
    int min = -10;
    int max = 20;
    Validador myVal;

    @Before
    public void setUp() throws Exception {
        myCalc = new CalculatorModel();
        myCalc1 = new CalculatorModel(min, max);
        myVal = new Validador(min, max);
    }

    // --------------------------------------------------------	
    @Test
    public void t00initVal() {
        assertTrue (myCalc.getResult() == 0);
    }

    //Comentario en t00
    @Test
    public void t00setGet() {
        myCalc.setResult(12);
        assertTrue(myCalc.getResult() == 12);
    }

    @Test
    public void t00setReset() {
        myCalc.setResult(12);
        myCalc.reset();
        assertTrue(myCalc.getResult() == 0);
    }

    // --------------------------------------------------------	
    @Test
    public void t01add01() throws Exception {
        myCalc.add (5);
        assertTrue (myCalc.getResult() == 5);
    }

    @Test
    public void t01add02() throws Exception {
        myCalc.setResult(3);
        myCalc.add (7);
        assertTrue (myCalc.getResult() == 10);
    }

    @Test
    public void t01add03() throws Exception {
        myCalc.setResult(3);
        myCalc.add (7);
        myCalc.add(6);
        assertTrue (myCalc.getResult() == 16);
    }

    @Test
    public void t01add04() throws Exception {
        myCalc.add (-7);
        assertTrue (myCalc.getResult() == -7);
    }

    // --------------------------------------------------------
    @Test
    public void t02sub01() throws Exception {
        myCalc.subtract(5);
        assertTrue (myCalc.getResult() == -5);
    }

    @Test
    public void t02sub02() throws Exception {
        myCalc.setResult (3);
        myCalc.subtract (7);
        assertTrue (myCalc.getResult() == -4);
    }

    @Test
    public void t02sub03() throws Exception {
        myCalc.setResult (3);
        myCalc.subtract (7);
        myCalc.subtract (6);
        assertTrue (myCalc.getResult() == -10);
    }

    @Test
    public void t02sub04() throws Exception {
        myCalc.subtract(-7);
        assertTrue (myCalc.getResult() == 7);
    }


    // --------------------------------------------------------
    @Test
    public void t03mult01() throws Exception {
        myCalc.multiply (5);
        assertTrue (myCalc.getResult() == 0);
    }

    @Test
    public void t03mult02() throws Exception {
        myCalc.setResult(3);
        myCalc.multiply (7);
        assertTrue (myCalc.getResult() == 21);
    }

    @Test
    public void t03mult03() throws Exception {
        myCalc.setResult(-6);
        myCalc.multiply (6);
        myCalc.multiply (3);
        assertTrue (myCalc.getResult() == -108);
    }

    // --------------------------------------------------------
    @Test
    public void t04div01() throws Exception {
        myCalc.divide (5);
        assertTrue (myCalc.getResult() == 0);
    }

    @Test
    public void t04div02() throws Exception {
        myCalc.divide (7);
        assertTrue (myCalc.getResult() == 0);
    }

    @Test
    public void t04div03() throws Exception {
        myCalc.setResult (7);
        myCalc.divide (-2);
        assertTrue (myCalc.getResult() == -3);
    }

    @Test(expected=DivideByZero.class)
    public void t04divZero1() throws Exception {
        myCalc.setResult(5);
        myCalc.divide (0);
        fail("DivisionByZero not raised");
    }

    @Test
    public void t04divZero2() {
        myCalc.setResult(5);

        try {
            myCalc.divide (0);
            fail("DivisionByZero not raised");

        } catch (DivideByZero e) {
            assertTrue(true);

        } catch (Exception e) {
            fail("unknown exception");
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    //Tests del validador

    @Test
    public void TestResultadoPorDebajoDelLimiteResta() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.subtract(20);
        }catch(Validador.Overflow e){
            assertTrue(true);;
        }
    }

    @Test
    public void TestResultadoPorDebajoDelLimiteSuma() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.add(-20);
            fail("Overflow not raised");
        }catch(Validador.Overflow e){
            assertTrue(true);;
        }
    }

    @Test
    public void TestResultadoPorDebajoDelLimiteMultiplicacion() throws Exception{
        myCalc1.setResult(15);
        try{
            myCalc1.multiply(-1);
            fail("Overflow not raised");
        }catch(Validador.Overflow e){
            assertTrue(true);;
        }
    }

    @Test
    public void TestResultadoPorDebajoDelLimiteDivision() throws Exception{
        myCalc1.setResult(60);
        try{
            myCalc1.divide(-4);
            fail("Overflow not raised");
        }catch(Validador.Overflow e){
            assertTrue(true);
        }
    }

    @Test
    public void TestResultadoPorEncimaDelLimiteSuma() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.add(20);
            fail("Underflow not raised");
        }catch(Validador.Underflow e){
            assertTrue(true);
        }
    }

    @Test
    public void TestResultadoPorEncimaDelLimiteResta() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.subtract(-20);
            fail("Underflow not raised");
        }catch(Validador.Underflow e){
            assertTrue(true);
        }
    }

    @Test
    public void TestResultadoPorEncimaDelLimiteMultiplicacion() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.multiply(5);
            fail("Underflow not raised");
        }catch(Validador.Underflow e){
            assertTrue(true);
        }
    }
/* Este test no se puede hacer dado que, trabajando con enteros, es imposible que divida un número por otro y que el
            resultado de esta división sea superior al límite.
    @Test
    public void TestResultadoPorEncimaDelLimiteDivision() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.divide(1);
            fail("Underflow not raised");
        }catch(Validador.Underflow e){
            assertTrue(true);
        }
    }
    */

    @Test
    public void TestResultadoEnElLimiteSuperior() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.multiply(4);
            fail("Underflow not raised");
        }catch(Validador.Underflow e){
            assertTrue(true);
        }
    }

    @Test
    public void TestResultadoEnElLimiteInferior() throws Exception{
        myCalc1.setResult(5);
        try{
            myCalc1.add(-15);
            fail("Overflow not raised");
        }catch(Validador.Overflow e){
            assertTrue(true);
        }
    }


}
