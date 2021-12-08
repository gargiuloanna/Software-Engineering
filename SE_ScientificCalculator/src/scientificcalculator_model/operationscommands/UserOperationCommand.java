
package scientificcalculator_model.operationscommands;
 //DA SCRIVERE DOCUMENTAZIONE

public class UserOperationCommand implements Command{
    
    private String name;
    private Operations struct;

    /**
     * Initializes a newly created UserOperationCommand object. The c argument is the stack used to create a Command that allows to execute the operations of the defined operations.
     * <p>
     */
    public UserOperationCommand(String name, Operations struct) {
        this.name = name;
        this.struct = struct;
    }

    /**
     * The method executes the operation module on the ComplexNumber.
     * It calculates the absolute value of the complex number.
     * The result is pushed into the stack maintained by the command.
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
