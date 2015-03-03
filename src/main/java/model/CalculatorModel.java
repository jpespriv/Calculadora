package model;
import validador1.Validador;

public class CalculatorModel implements I_CalculatorModel {
	private int _result;
    private int _min;
    private int _max;
    private Validador _validador;
			
	public CalculatorModel() {
        this._min = Integer.MIN_VALUE;
        this._max = Integer.MAX_VALUE;
        _validador = new Validador(_min, _max);
		_result = 0;
	}
//
    public CalculatorModel(int min, int max){
        this._min = min;
        this._max = max;
        _validador = new Validador(_min, _max);
        _result = 0;
    }

	
	@Override
	public void add(int operand) throws Exception {
        long resultado = getResult() + operand;
        _validador.checkBounds(resultado);
	    setResult ((int) resultado);
	}

	@Override
	public void subtract(int operand) throws Exception {
        long resultado = getResult() - operand;
        _validador.checkBounds(resultado);
        setResult ((int) resultado);
	}

	@Override
	public void multiply(int operand) throws Exception {
        long resultado = getResult() * operand;
        _validador.checkBounds(resultado);
        setResult ((int) resultado);
	}

	@Override
	public void divide(int operand) throws Exception {
		if (operand == 0) {
	         throw new DivideByZero();
		}else{
            long resultado = getResult() / operand;
            _validador.checkBounds(resultado);
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
