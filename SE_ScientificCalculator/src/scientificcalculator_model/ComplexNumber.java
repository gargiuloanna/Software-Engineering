
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
