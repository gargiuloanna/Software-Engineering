/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marco
 */
public class Calculator {
    
    /**
     * This method makes the arithmetical addition between two operands
     * ComplexNumber object (a+bj)*(c+dj).
     * <p>
     * @param a
     * @param b
     * @return a new ComplexNumber that contains the result.
     */
    public static ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getReal() + b.getReal(),a.getImaginary() + b.getImaginary());
    }
    /**
     * This method makes the arithmetical subtraction between two operands
     * ComplexNumber object (a+bj)-(c+dj).
     * <p>
     * @param a
     * @param b
     * @return a new ComplexNumber that contains the result.
     */
    public static ComplexNumber subtraction(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getReal() - b.getReal(),a.getImaginary() - b.getImaginary());
        
    }
    
    /**
     * This method makes the arithmetical product between two operands
     * ComplexNumber object (a+bj)*(c+dj).
     * <p>
     * @param a
     * @param b
     * @return a new ComplexNumber that contains the result.
     */
    public static ComplexNumber product(ComplexNumber a, ComplexNumber b){
        double aa = a.getReal() * b.getReal();
        double aib_1 = a.getReal() * b.getImaginary();
        double aib_2 = a.getImaginary()* b.getReal();
        double iibb = -1 * b.getImaginary() * a.getImaginary();
        return new ComplexNumber((aa + iibb), (aib_1 + aib_2));
    }
    
    private static ComplexNumber conjugated(ComplexNumber x){
        return new ComplexNumber(x.getReal(), -x.getImaginary());
    }
    
    /**
     * This method makes the arithmetical division between two operands
     * ComplexNumber object (a+bj)/(c+dj).
     * <p>
     * @param a
     * @param b
     * @return a new ComplexNumber that contains the result.
     */
    public static ComplexNumber division(ComplexNumber a, ComplexNumber b){
        ComplexNumber N = product(a, conjugated(b));
        ComplexNumber D = product(b, conjugated(b));
        
        if (D.getImaginary()==0 && D.getReal()==0)
            throw new ArithmeticException();
        
        return new ComplexNumber(N.getReal()/D.getReal(), N.getImaginary()/D.getReal());
    }  
    /**
     * This method acts like a - before the entire ComplexNumber to invert the sign
     * for the real and imaginary part.
     * <p>
     * @param x
     * @return a new ComplexNumber with -real and -imaginary.
     */
    public static ComplexNumber invert(ComplexNumber x){
        return new ComplexNumber(-x.getReal(), -x.getImaginary());
    }
    
    /**
     * This method makes the module of a ComplexNumber.
     * <p>
     * @param x
     * @return the module 
     */
    public static Double module(ComplexNumber x){
        return Math.sqrt(Math.pow(x.getReal(), 2) + Math.pow(x.getImaginary(), 2));
    }
    
    /**
     * This method makes the square root of a ComplexNumber.
     * <p>
     * @param x
     * @return a new ComplexNumber that contains the result
     */
    public static ComplexNumber sqrt(ComplexNumber x){
        double bABS = x.getImaginary()/Math.abs(x.getImaginary());
        double xABS = module(x);
        
        double a1 = Math.sqrt((xABS+x.getReal())/2);
        double a2 = Math.sqrt((xABS-x.getReal())/2);
        
        return new ComplexNumber(a1, (x.getImaginary()/bABS)*a2);
    }
    
    /**
    * The method saves into variable the last element of the stack.
    * variable should be stored into a map that stores for different variables their specific values.
    * <p>
    * @param  variables The map where the variable and its values are stored.     
    * @param  variable  the variable where the last value of the stack should be saved.
    * @return      true if the element has been copied successfully.
    */
    
    public static boolean insertInVariable(ComplexStack s, Map<Character, ComplexNumber> variables, char variable){

        variables.put(variable, (ComplexNumber) s.peek());
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
        
        ComplexNumber last = (ComplexNumber) s.peek();
        ComplexNumber variableNumber = variables.get(variable);
        variables.put(variable,addition(last, variableNumber));
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
        
        ComplexNumber last = (ComplexNumber) s.peek();
        ComplexNumber variableNumber = variables.get(variable);
        variables.put(variable,subtraction(last, variableNumber));
        return true;  
    }
}
