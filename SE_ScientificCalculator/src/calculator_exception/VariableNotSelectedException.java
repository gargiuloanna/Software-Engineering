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
public class VariableNotSelectedException extends RuntimeException {

    /**
     * Creates a new instance of <code>VariableNotSelected</code> without detail
     * message.
     */
    public VariableNotSelectedException() {
    }

    /**
     * Constructs an instance of <code>VariableNotSelected</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VariableNotSelectedException(String msg) {
        super(msg);
    }
}
