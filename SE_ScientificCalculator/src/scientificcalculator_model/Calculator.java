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
        
        
        else if (sign_index == -1){ //Significa che il segno non è presente nell'operando, quindi abbiamo o parte R o parte Imm.
            if (j_index == -1){
                c = new ComplexNumber(real, immaginary);
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
        return null;
    }
    
}
