package scientificcalculator_model.statecalculator;

import calculator_exception.OperationNotExistsException;
import scientificcalculator_model.Operations;
import java.util.Map;
import scientificcalculator_model.*;
import scientificcalculator_model.operationscommands.*;

/**
 * The CalculatorState class implements the State of the Calculator that allows
 * the user to execute normal operations using inserted operands.
 */
public class CalculatorState extends State {

    ExecuteCommand exe;

    public CalculatorState() {
        exe = new ExecuteCommand();
    }

    /**
     * The method sums two elements of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void addition(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command add = new AdditionCommand(stack);
        exe.execute(add);
    }

    /**
     * The method multiplies two elements of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void product(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command prod = new ProductCommand(stack);
        exe.execute(prod);
    }

    /**
     * The method subtracts two elements of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void subtraction(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command sub = new SubtractionCommand(stack);
        exe.execute(sub);
    }

    /**
     * The method divides two elements of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void division(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command div = new DivisionCommand(stack);
        exe.execute(div);

    }

    /**
     * The method eliminates the last element of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void drop(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command drop = new DropCommand(stack);
        exe.execute(drop);
    }

    /**
     * The method duplicates the last element of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void dup(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command dup = new DupCommand(stack);
        exe.execute(dup);
    }

    /**
     * The method inverts the sign of the last element of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void invert(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command invert = new InvertCommand(stack);
        exe.execute(invert);
    }

    /**
     * The method calculates the absolute value of the last element of the param
     * Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void module(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command module = new ModuleCommand(stack);
        exe.execute(module);
    }

    /**
     * The method duplicates the second last element of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void over(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command over = new OverCommand(stack);
        exe.execute(over);
    }

    /**
     * The method calculates the phase of the last element of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void phase(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command phase = new PhaseCommand(stack);
        exe.execute(phase);
    }

    /**
     * The method calculates the square root of the last element of the param
     * Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void sqrt(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command sqrt = new SqrtCommand(stack);
        exe.execute(sqrt);
    }

    /**
     * The method swaps the last two elements of the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void swap(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        Command swap = new SwapCommand(stack);
        exe.execute(swap);
    }

    /**
     * The method pushes the element number in the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param number the number to push on the stack
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void push(ComplexStack stack, ComplexNumber number, Map<String, Operations> operations, String operationName) {
        Command push = new PushCommand(stack, number);
        exe.execute(push);
    }

    /**
     * The method executes the commands which compose the user definition
     * operation
     * <p>
     * @param user the object representing the user defined operation
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws OperationNotExistsException if an user defined operation that was previously defined has been cancelled
     */
    @Override
    public void userDefinition(UserOperation user, Map<String, Operations> operations, String operationName) {
         for (Command c : operations.get(user.getName()).getOpers()) {
             if(c.getClass().getSimpleName().equals("UserOperationCommand"))
                if ( ! operations.containsKey(c.toString()))
                    throw new OperationNotExistsException();
        }
        
        for (Command c : operations.get(user.getName()).getOpers()) 
            exe.execute(c);
            
        

    }

    /**
     * The method inserts the last element of the param Stack into the param v
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param variables the map where tha variables are located
     * @param v the variable input
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void insertInVariable(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName) {
        Command insert = new InsertInVariableCommand(stack, variables, v);
        exe.execute(insert);
    }

    /**
     * The method pushes the value of the param v into the param Stack.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param variables the map where tha variables are located
     * @param v the variable input
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void getFromVariable(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName) {
        Command get = new GetFromVariableCommand(stack, variables, v);
        exe.execute(get);
    }

    /**
     * The method adds the last element of the param stack to the value of the
     * param v.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param variables the map where tha variables are located
     * @param v the variable input
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void addToLast(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName) {
        Command add = new AddToLastCommand(stack, variables, v);
        exe.execute(add);
    }

    /**
     * The method subs the last element of the param stack to the value of the
     * param v.
     * <p>
     * @param stack the stack containing the complex number inputs
     * @param variables the map where tha variables are located
     * @param v the variable input
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     */
    @Override
    public void subToLast(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName) {
        Command sub = new SubToLastCommand(stack, variables, v);
        exe.execute(sub);
    }

}
