package model;

import java.nio.BufferUnderflowException;

public class CalculatorModel implements I_CalculatorModel {
	private int _result;
    private int _min;
    private int _max;
			
	public CalculatorModel() {
        _min = Integer.MIN_VALUE;
        _max = Integer.MAX_VALUE;
		_result = 0;
	}
//
    public CalculatorModel(int min, int max){
        _min = min;
        _max = max;
        _result = 0;
    }

    private void checkBounds (long value) throws Overflow, Underflow {
        if(value > _max) {
            throw new Overflow();
        }else if(value < _min) {
            throw new Underflow();
        }
    }
	
	@Override
	public void add(int operand) throws Exception {
        long resultado = getResult() + operand;
        checkBounds(resultado);
	    setResult ((int) resultado);
	}

	@Override
	public void subtract(int operand) throws Exception {
	    setResult (getResult() - operand);
	}

	@Override
	public void multiply(int operand) throws Exception {
	    setResult (getResult() * operand);		
	}

	@Override
	public void divide(int operand) throws Exception {
		if (operand == 0) {
	         throw new DivideByZero();
		}
		
	    setResult (getResult() / operand);
	}
	
	@Override
	public int getResult() {
		return _result;
	}
	
	@Override
	public void setResult(int value) {
        try {
            checkBounds(value);
        } catch (Overflow overflow) {
            overflow.printStackTrace();
        } catch (Underflow underflow) {
            underflow.printStackTrace();
        }
        _result = value;
    }


	@Override
	public void reset() {
		_result = 0;
	}


    private class Overflow extends Exception {
    }

    private class Underflow extends Exception {
    }
}
