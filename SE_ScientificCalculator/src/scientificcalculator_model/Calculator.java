/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model;

/**
 *
 * @author marco
 */
public class Calculator {
    
    
    /**
     * This method makes the arithmetical addition between two operands
     * ComplexNumber object (a+bj)*(c+dj).
     * @param a
     * @param b
     * @return a new ComplexNumber that contains the result.
     */
    public static ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getReal() + b.getReal(),a.getImaginary() + b.getImaginary());
    }
    /**
     * This method makes the arithmetical subtraction between two operands
     * ComplexNumber object (a+bj)*(c+dj).
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
     * @param x
     * @return a new ComplexNumber with -real and -imaginary.
     */
    public static ComplexNumber invert(ComplexNumber x){
        return new ComplexNumber(-x.getReal(), -x.getImaginary());
    }
    
    public static Double module(ComplexNumber x){
        return Math.sqrt(Math.pow(x.getReal(), 2) + Math.pow(x.getImaginary(), 2));
    }
    
    /**
     * 
     * @param x
     * @return 
     */
    public static ComplexNumber sqrt(ComplexNumber x){
        double bABS = x.getImaginary()/Math.abs(x.getImaginary());
        double xABS = module(x);
        
        double a1 = Math.sqrt((xABS+x.getReal())/2);
        double a2 = Math.sqrt((xABS-x.getReal())/2);
        
        return new ComplexNumber(a1, (x.getImaginary()/bABS)*a2);
    }
}
