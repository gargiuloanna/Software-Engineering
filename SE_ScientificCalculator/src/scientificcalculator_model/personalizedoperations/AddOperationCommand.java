/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.personalizedoperations;

/**
 *
 * @author Anna
 */
public class AddOperationCommand implements Command{
    private Operations struct;
    private String op;

    public AddOperationCommand(Operations struct, String op) {
        this.struct = struct;
        this.op = op;
    }

    @Override
    public void execute() {
        struct.addOperation(op);
    }
    
}
