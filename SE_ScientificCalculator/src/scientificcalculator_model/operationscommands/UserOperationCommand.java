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
public class UserOperationCommand implements Command{
    
    private String name;
    private Operations struct;

    public UserOperationCommand(String name, Operations struct) {
        this.name = name;
        this.struct = struct;
    }

    @Override
    public void execute() {
        for (Command c: struct.getOpers()){
            c.execute();
        }
    }

    @Override
    public String toString() {
        return  name;
    }
    
    
    
}
