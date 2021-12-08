
package scientificcalculator_model.operationscommands;

/**
 * The class represents the Invoker of the Command. The Invoker allows to execute the specific command received as a parameter.
 */
public class ExecuteCommand {
    
    /**
     * The method executes the command received as an argument.
     * @param command the command to execute
     */
    public void execute(Command command){
        command.execute();
    }
    
    
}
