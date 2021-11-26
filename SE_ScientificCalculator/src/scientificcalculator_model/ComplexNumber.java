/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model;

/**
 *
 * @author marco
 */
public class ComplexNumber {
    
    double real, imaginary;
    
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    
    @Override
    public String toString(){
        if (imaginary > 0)
            return real + "+" + imaginary + "j"; 
        else if (imaginary < 0)
            return real + "" + imaginary + "j"; 
        return "";
    }
    
    
    
}
