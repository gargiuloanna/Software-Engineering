
package scientificcalculator_model.operationscommands;

import calculator_exception.OperationNotExistsException;
import java.util.Map;
import scientificcalculator_model.Operations;

/*
*The class implements a UserOperationCommand that allows to use User Defined Operations as a part of other User Defined Operations.
*/
public class UserOperationCommand implements Command{
    
    private String name;
    private Map<String, Operations> struct;

     /**
     * Initializes a newly created UserOperationCommand object. 
     * <p>
     * @param name the name of the user operation 
     * @param struct the Operations of the user operation
     */

    public UserOperationCommand(String name, Map<String, Operations> struct) {
        this.name = name;
        this.struct = struct;
    }

    /**
     * The method executes the operations of the struct.
     * <p>
     * @throws OperationNotExistsException if the operation is not defined
     */    
    @Override
    public void execute() {
        if(struct.get(name) == null)
            throw new OperationNotExistsException();
        for (Command c: struct.get(name).getOpers()){
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
