package validador1;

/**
 * Created by JuanPablo on 03/03/2015.
 */
public class Validador {

    private int _min;
    private int _max;

    public Validador(int _min, int _max){
        this._min = _min;
        this._max = _max;
    }

    public  void checkBounds (long valor) throws Overflow, Underflow{
        if(valor <= _min){
            throw new Overflow();
        }else if(valor >= _max){
            throw new Underflow();
        /*}else{
            System.out.println("No se ha salido de los límites definidos"); */ // Para comprobar límites en los tests.
        }
    }


    public class Overflow extends Exception {
    }

    public class Underflow extends Exception {
    }
}
