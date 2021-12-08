
package calculator_exception;


/**
 *The class ArithmeticException allows to throw an exception when the requirements of a calculator's methods are not met.
 */
public class ArithmeticException extends RuntimeException{

    /**
     * Creates a new instance of <code>ArithmeticException</code> without detail
     * message.
     */
    public ArithmeticException() {
    }

    /**
     * Constructs an instance of <code>ArithmeticException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ArithmeticException(String msg) {
        super(msg);
    }
}
