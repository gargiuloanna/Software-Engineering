
package calculator_exception;

/*
* The class DivisionForZeroException allows to throw an exception when the user wants to make a divisione for zero.
*/
public class DivisionForZeroException extends RuntimeException {

    /**
     * Creates a new instance of <code>DivisionForZero</code> without detail
     * message.
     */
    public DivisionForZeroException() {
    }

    /**
     * Constructs an instance of <code>DivisionForZero</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DivisionForZeroException(String msg) {
        super(msg);
    }
}
