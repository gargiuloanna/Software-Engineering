/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_exception;

/**
 *
 * @author Luigina
 */
public class OperationNotExistsException extends RuntimeException {

    /**
     * Creates a new instance of <code>OperationNotExists</code> without detail
     * message.
     */
    public OperationNotExistsException() {
    }

    /**
     * Constructs an instance of <code>OperationNotExists</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OperationNotExistsException(String msg) {
        super(msg);
    }
}
