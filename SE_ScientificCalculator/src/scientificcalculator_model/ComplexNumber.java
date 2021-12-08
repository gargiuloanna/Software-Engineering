
package scientificcalculator_model;


/**
 * The class implements a ComplexNumber composed of both a real and imaginary part.
 */
public class ComplexNumber {
    
    double real, imaginary;
    
    /**
     * This method creates a new ComplexNumber using the real and imaginary arguments.
     * <p>
     * @param real the real part of the ComplexNumber to create
     * @param imaginary the imaginary part of the ComplexNumber to create
     */
    
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    /**
     * This method gets the real part of the complex number.
     * <p>
     * @return the real part of the complex number
     */
    public double getReal() {
        return real;
    }
    
    /**
     * This method gets the imaginary part of the complex number.
     * <p>
     * @return the imagianry part of the complex number
     */
    public double getImaginary() {
        return imaginary;
    }
    
    /**
     * This method acts as a parser for the input string that contains the complex number in algebraic (or Cartesian) form. 
     * The string is converted into a ComplexNumber object that simplifies its representation for any operations.
     * <p>
     * @param s the string to parse into a complex number
     * @return a new ComplexNumber with real and imaginary part divided in two different attribute
     */
    public static ComplexNumber stringToComplex(String s){
        
        double real = 0;
        double immaginary = 0;

        int sign_index = -1;
        
        
        int j_index = s.indexOf('j');
        
        
        if (s.substring(1, s.length()).indexOf('+')!=-1)
            sign_index = s.substring(1, s.length()).indexOf('+')+1;
        else if (s.substring(1, s.length()).indexOf('-')!=-1)
            sign_index = s.substring(1, s.length()).indexOf('-')+1;     
        
        if (sign_index != -1){
            if (j_index<sign_index){
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
            else if (j_index>sign_index){ 
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
        else if (sign_index == -1){ 
            if (j_index == -1){
                real = Double.parseDouble(s);
                immaginary = 0;
            }
            else if (j_index != -1){
                if (s.substring(0, 1).equals("+") && s.substring(1,2).equals("j")){
                    immaginary = 1;
                }
                else if (s.substring(0, 1).equals("-")&& s.substring(1,2).equals("j")){
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
    
    /**
     * This method creates the string form of the complex Number.
     * <p>
     * @return the string form of the complex number
     */
    @Override
    public String toString(){
        if (imaginary > 0)
            return real + "+" + imaginary + "j"; 
        else if (imaginary < 0)
            return real + "" + imaginary + "j"; 
        return real + "";
    }
    
}
