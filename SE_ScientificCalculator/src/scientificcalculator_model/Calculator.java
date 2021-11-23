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
        
        ComplexNumber c;
        double real = 0;
        double immaginary = 0;
        
        int sign_index = -1;
        
        //Prelevo la posizione di j se esiste nella stringa:
        int j_index = s.indexOf('j');  
        
        //Prelevo il segno dall'espressione se esiste nella stringa:
        if (s.substring(1, s.length()).indexOf('+')!=-1)
            sign_index = s.substring(1, s.length()).indexOf('+')+1;
        else if (s.substring(1, s.length()).indexOf('-')!=-1)
            sign_index = s.substring(1, s.length()).indexOf('-')+1;
        
        //Significa che il segno non è presente nell'operando, quindi abbiamo o parte R o parte Imm.
        if (sign_index == -1){ 
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
            }
            else if (j_index>sign_index){ //Se j sta a sinistra significa che il primo numero è la parte reale
                if (s.substring(s.length()-1, s.length()).equals("j")){
                    if (s.substring(s.length()-2, s.length()-1).equals("+") || s.substring(s.length()-2, s.length()-1).equals("-"))
                        immaginary = Double.parseDouble(s.charAt(sign_index) + "1");
                }
                else{
                    immaginary = Double.parseDouble(s.substring(sign_index, s.length()-1));
                }
                real = Double.parseDouble(s.substring(0, sign_index));    
            }
        }
        
        return new ComplexNumber(real, immaginary);
    }
    
    public ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(0,0);
    }
}
