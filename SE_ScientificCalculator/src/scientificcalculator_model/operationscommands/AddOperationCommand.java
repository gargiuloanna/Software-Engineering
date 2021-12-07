/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

/**
 *
 * @author Anna
 */
public class AddOperationCommand extends Command{
    private Operations struct;
    private Command op;

    public AddOperationCommand(Operations struct, Command op) {
        this.struct = struct;
        this.op = op;
    }

    @Override
    public void execute() {
        struct.addOperation(op);
    }
    
}
