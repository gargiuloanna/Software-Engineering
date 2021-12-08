/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package calculator_exception;

/**
 *
 * @author marco
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
