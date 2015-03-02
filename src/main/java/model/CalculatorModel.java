package model;


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

	
	@Override
	public void add(int operand) throws Exception {
        long resultado = getResult() + operand;
        Validator.checkBounds(resultado);
	    setResult ((int) resultado);
	}

	@Override
	public void subtract(int operand) throws Exception {
        long resultado = getResult() - operand;
        Validator.checkBounds(resultado);
        setResult ((int) resultado);
	}

	@Override
	public void multiply(int operand) throws Exception {
        long resultado = getResult() * operand;
        Validator.checkBounds(resultado);
        setResult ((int) resultado);
	}

	@Override
	public void divide(int operand) throws Exception {
		if (operand == 0) {
	         throw new DivideByZero();
		}else{
            long resultado = getResult() / operand;
            Validator.checkBounds(resultado);
            setResult ((int) resultado);
        }
	}
	
	@Override
	public int getResult() {
		return _result;
	}
	
	@Override
	public void setResult(int value) {
        _result = value;
    }


	@Override
	public void reset() {
		_result = 0;
	}

}
