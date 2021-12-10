
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.Operations;

/*
*The class implements a UserOperationCommand that allows to use User Defined Operations as a part of other User Defined Operations.
*/
public class UserOperationCommand implements Command{
    
    private String name;
    private Operations struct;

     /**
     * Initializes a newly created UserOperationCommand object. 
     * <p>
     * @param name the name of the user operation 
     * @param struct the Operations of the user operation
     */

    public UserOperationCommand(String name, Operations struct) {
        this.name = name;
        this.struct = struct;
    }

    /**
     * The method executes the operations of the struct.
     */    
    @Override
    public void execute() {
        for (Command c: struct.getOpers()){
            c.execute();
        }
    }
    
    /**
     * This method creates the string form of the UserOperationCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return  name;
    }
    
    
    
}
