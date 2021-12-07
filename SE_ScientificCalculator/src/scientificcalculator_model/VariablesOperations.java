/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model;


import java.util.Map;

/**
 *
 * @author marco
 */
public class VariablesOperations {
    
    /**
    * The method saves into variable the last element of the stack.
    * variable should be stored into a map that stores for different variables their specific values.
    * <p>
    * @param  variables The map where the variable and its values are stored.     
    * @param  variable  the variable where the last value of the stack should be saved.
    * @return      true if the element has been copied successfully.
    */
    
    public static boolean insertInVariable(ComplexStack s, Map<Character, ComplexNumber> variables, char variable){

        variables.put(variable, (ComplexNumber) s.pop());
        return true;
        
    }
    
    /**
    * The method saves into the stack the value stored in variable
    * variable should be stored into a map that stores for different variables their specific values.
    * <p>
    * @param  variables The map where the variable and its values are stored.     
    * @param  variable  the variable whose value should be stored into the stack.
    * @return      true if the element has been copied successfully.
    */
    
    public static boolean getFromVariable(ComplexStack s, Map<Character, ComplexNumber> variables, char variable){
        if(!variables.containsKey(variable))
            return false;
                
        s.push(variables.get(variable));
        return true;
        
    }
    
     /**
    * The method takes the top element from the stack and adds it to the value of the variable
    * variable should be stored into a map that stores for different variables their specific values
    * The result of the addition is stored into the variable.
    * <p>
    * @param  variables The map where the variable and its values are stored.     
    * @param  variable  the variable whose value should be stored into the stack.
    * @return      true if the addition has been performed successfully.
    */
    
    public static boolean addToLast(ComplexStack s, Map<Character, ComplexNumber> variables, char variable){
        if(!variables.containsKey(variable))
            return false;
        
        ComplexNumber last = (ComplexNumber) s.pop();
        ComplexNumber variableNumber = variables.get(variable);
        ComplexNumber sum = new ComplexNumber(last.getReal() + variableNumber.getReal(), last.getImaginary() + variableNumber.getImaginary());
        variables.put(variable,sum);
        return true;  
    }
    
     /**
    * The method takes the top element from the stack and subtracts it to the value of the variable
    * variable should be stored into a map that stores for different variables their specific values
    * The result of the subtraction is stored into the variable.
    * <p>
    * @param  variables The map where the variable and its values are stored.     
    * @param  variable  the variable whose value should be stored into the stack.
    * @return      true if the subtraction has been performed successfully.
    */
    
    public static boolean subToLast(ComplexStack s, Map<Character, ComplexNumber> variables, char variable){
        if(!variables.containsKey(variable))
            return false;
        
        ComplexNumber last = (ComplexNumber) s.pop();
        ComplexNumber variableNumber = variables.get(variable);
        ComplexNumber sub = new ComplexNumber(last.getReal() - variableNumber.getReal(), last.getImaginary() - variableNumber.getImaginary());
        variables.put(variable,sub);
        return true;  
    }
}
