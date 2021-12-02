/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.personalizedoperations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import scientificcalculator_model.Calculator;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Anna
 */
class Operations {
    private ArrayList<String> opers;
    
    
    public Operations(){
        opers= new ArrayList();
    }

    public ArrayList<String> getOpers() {
        return opers;
    }
    
    public void addOperation(String op){
        opers.add(op);
    }
    
    public void exeOperation(ComplexStack stack){
        
        for (int i=0; i<opers.size(); i++){
            try {
                Calculator c= new Calculator();
                    if(opers.get(i).equals("addition") || opers.get(i).equals("subtraction") || opers.get(i).equals("prodcut") || opers.get(i).equals("division")){
                        Method method= c.getClass().getMethod(opers.get(i), ComplexNumber.class, ComplexNumber.class);
                        method.invoke(c, stack.pop(), stack.pop());
                    }else{
                        Method method= c.getClass().getMethod(opers.get(i), ComplexNumber.class);  
                        method.invoke(c, stack.pop());
                    }       
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
        
    }
    }


}
    

