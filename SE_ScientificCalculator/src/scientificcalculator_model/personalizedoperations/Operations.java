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
public class Operations {
    private ArrayList<String> opers;
    
    
    public Operations(){
        opers= new ArrayList();
    }

    public ArrayList<String> getOpers() {
        return opers;
    }
    
    public String getOpString(){
        String s = "";
        for(String oper: opers){
            s+=oper + ",";
        }
        s = s.substring(0, s.length()-1);
        return s;
    }
    
    public void addOperation(String op){
        opers.add(op);
    }
    
    public void exeOperation(ComplexStack stack){
        
        for (int i=0; i<opers.size(); i++){
            try {
                Calculator c = new Calculator();
                    if(opers.get(i).equals("addition") || opers.get(i).equals("subtraction") || opers.get(i).equals("product") || opers.get(i).equals("division")){
                        Method method = c.getClass().getMethod(opers.get(i), ComplexNumber.class, ComplexNumber.class);
                        ComplexNumber x = (ComplexNumber) method.invoke(c, stack.pop(), stack.pop());
                        stack.push(x);
                    }else if(opers.get(i).equals("dup") || opers.get(i).equals("drop") || opers.get(i).equals("swap") || opers.get(i).equals("over")){
                        Method method= stack.getClass().getMethod(opers.get(i));  
                        method.invoke(stack);
                    }
                    else{
                        Method method = c.getClass().getMethod(opers.get(i), ComplexNumber.class);  
                        ComplexNumber x = (ComplexNumber) method.invoke(c, stack.pop());
                        stack.push(x);
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
    

