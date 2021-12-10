
package calculator_exception;

/*
* The class CommandExistsException allows to throw an exception when the command is not present.
*/
public class CommandExistsException extends RuntimeException{

    /**
     * Creates a new instance of <code>CommandExistsException</code> without
     * detail message.
     */
    public CommandExistsException() {
    }

    /**
     * Constructs an instance of <code>CommandExistsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CommandExistsException(String msg) {
        super(msg);
    }
}
