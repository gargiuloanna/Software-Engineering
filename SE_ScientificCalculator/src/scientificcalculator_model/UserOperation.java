
package scientificcalculator_model;

import scientificcalculator_model.operationscommands.Operations;


/**
 * The class implements a UserOperation 
 */
public class UserOperation {
    
    private final String name;
    private final Operations op;
    
    /**
     * Initializes a new UserOperation object.
     * <p>
     * @param name the name of the user operation defined
     * @param op the Operations object that composes the user operation
     */
    public UserOperation(String name,Operations op) {
        this.name = name;
        this.op = op;
    }
    
    /**
     * This method gets the name of the user operation.
     * <p>
     * @return the name of the user operation
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the operations of the user operation.
     * <p>
     * @return the operations of the user operation
     */
    public Operations getOp() {
        return op;
    }

    
    
    
}
