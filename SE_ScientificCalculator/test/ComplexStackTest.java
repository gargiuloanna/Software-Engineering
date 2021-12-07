/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;



/**
*
* @author Anna
*/
public class ComplexStackTest {
    
    ComplexStack stack;
    ComplexNumber three;
    ComplexNumber four;
    ComplexNumber five;

    @Before
    public void setUp() {
        stack= new ComplexStack();

        three=new ComplexNumber(3,0);
        four=new ComplexNumber(4,0);
        five=new ComplexNumber(5,0);

        stack.push(three);
        stack.push(four);
        stack.push(five);
    }

    @Test
    public void testGetMemory(){
        ObservableList list=FXCollections.observableArrayList();
        ObservableList memory = FXCollections.observableArrayList(stack.getMemory());
        list.add(stack.pop());
        list.add(stack.pop());
        list.add(stack.pop());

        assertEquals(list, memory);
    }
    @Test
    public void testClear(){
        assertEquals(0, stack.stackClear());
    }

   

}
