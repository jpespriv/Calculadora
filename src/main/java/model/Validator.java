package model;

/**
 * Created by JuanPablo on 02/03/2015.
 */
public class Validator {

    private static int _min = Integer.MIN_VALUE;
    private static int _max = Integer.MAX_VALUE;

    public static void checkBounds (long valor) throws Overflow, Underflow{
        if(valor < _min){
            throw new Overflow();
        }else if(valor > _max){
            throw new Underflow();
        }
    }

    private static class Overflow extends Exception {
    }

    private static class Underflow extends Exception {
    }
}
