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
    
    double real, immaginary;
    String total;
    
    public ComplexNumber(double real, double immaginary){
        this.real = real;
        this.immaginary = immaginary;
    }
    
    
    @Override
    public String toString(){
        if (immaginary > 0)
            return real + "+" + immaginary + "j"; 
        else if (immaginary < 0)
            return real + "" + immaginary + "j"; 
        return "";
    }
    
}
