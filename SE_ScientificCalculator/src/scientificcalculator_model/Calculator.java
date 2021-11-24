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
    
    
  
    public ComplexNumber stringToComplex(String s){
        
        double real = 0;
        double immaginary = 0;
        
        int sign_index = -1;
        
        //Prelevo la posizione di j se esiste nella stringa:
        int j_index = s.indexOf('j');
        System.out.println(j_index);
        
        //Prelevo il segno dall'espressione se esiste nella stringa:
        if (s.substring(1, s.length()).indexOf('+')!=-1)
            sign_index = s.substring(1, s.length()).indexOf('+')+1;
        else if (s.substring(1, s.length()).indexOf('-')!=-1)
            sign_index = s.substring(1, s.length()).indexOf('-')+1;     
        
        if (sign_index != -1){
            if (j_index<sign_index){ //Se j sta a sinistra significa che il primo numero è la parte immaginaria
                if (s.substring(0, 1).equals("+")){
                    immaginary = 1;
                }
                else if (s.substring(0, 1).equals("-")){
                    immaginary = -1;
                }
                else if (s.substring(0, 1).equals("j")){
                    immaginary = 1;
                }
                else{
                    immaginary = Double.parseDouble(s.substring(0, s.indexOf('j')));
                }
                real = Double.parseDouble(s.substring(sign_index, s.length()));
                System.out.println(real);
            }
            else if (j_index>sign_index){ //Se j sta a destra significa che il primo numero è la parte reale
                if (s.substring(s.length()-1, s.length()).equals("j")){
                    if (s.substring(s.length()-2, s.length()-1).equals("+") || s.substring(s.length()-2, s.length()-1).equals("-")){
                        immaginary = Double.parseDouble(s.charAt(sign_index) + "1");
                    }
                    else{
                        immaginary = Double.parseDouble(s.substring(sign_index, s.length()-1));
                    }
                real = Double.parseDouble(s.substring(0, sign_index));   
                }
            }
        }
        else if (sign_index == -1){ //Significa che il segno non è presente nell'operando, quindi abbiamo o parte R o parte Imm.
            if (j_index == -1){
                real = Double.parseDouble(s);
                immaginary = 0;
            }
            else if (j_index != -1){
                if (s.substring(0, 1).equals("+")){
                    immaginary = 1;
                }
                else if (s.substring(0, 1).equals("-")){
                    immaginary = -1;
                }
                else if (s.substring(0, 1).equals("j")){
                    immaginary = 1;
                }
                else{
                    immaginary = Double.parseDouble(s.substring(0, s.length()-1));
                    real = 0;
                }
                
            }
        }
        
        return new ComplexNumber(real, immaginary);
    }
    
    public ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getReal() + b.getReal(),a.getImaginary() + b.getImaginary());
    }
    
    public ComplexNumber subtraction(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getReal() - b.getReal(),a.getImaginary() - b.getImaginary());
        
    }
    
    public ComplexNumber product(ComplexNumber a, ComplexNumber b){
        double aa = a.getReal() * b.getReal();
        double aib_1 = a.getReal() * b.getImaginary();
        double aib_2 = a.getImaginary()* b.getReal();
        double iibb = -1 * b.getImaginary() * a.getImaginary();
        return new ComplexNumber((aa + iibb), (aib_1 + aib_2));
    }
    
    public ComplexNumber conjugated(ComplexNumber x){
        return new ComplexNumber(x.getReal(), -x.getImaginary());
    }
    
    public ComplexNumber division(ComplexNumber a, ComplexNumber b){
        ComplexNumber N = product(a, conjugated(b));
        ComplexNumber D = product(b, conjugated(b));
        
        return null;
    }
}
