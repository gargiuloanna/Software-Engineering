/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_scientificcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import scientificcalculator_model.*;

/**
 *
 * @author Anna
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @FXML
    private TextField addTextfield;
    @FXML
    private ListView<ComplexNumber> history;
    private ComplexStack hist;
    private ObservableList<ComplexNumber> list;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list= FXCollections.observableArrayList();
        hist= new ComplexStack();
        history.setItems(list);
    }    

    @FXML
    private void prodButton(ActionEvent event) {
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        ComplexNumber secondOperand = (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        list.remove(secondOperand);
        ComplexNumber sum=Calculator.product(firstOperand, secondOperand);
        list.add(sum);
        hist.add(sum);
       
    }

    @FXML
    private void subButton(ActionEvent event) {
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        ComplexNumber secondOperand = (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        list.remove(secondOperand);
        ComplexNumber sum=Calculator.subtraction(firstOperand, secondOperand);
        list.add(sum);
        hist.add(sum);
    }

    @FXML
    private void addButton(ActionEvent event) {
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        ComplexNumber secondOperand = (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        list.remove(secondOperand);
        ComplexNumber sum=Calculator.addition(firstOperand, secondOperand);
        list.add(sum);
        hist.add(sum);
    }

    @FXML
    private void invButton(ActionEvent event) {
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        ComplexNumber sum=Calculator.invert(firstOperand);
        list.add(sum);
        hist.add(sum);
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        ComplexNumber sum=Calculator.sqrt(firstOperand);
        list.add(sum);
        hist.add(sum);
    }

    @FXML
    private void divButton(ActionEvent event) {
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        ComplexNumber secondOperand = (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        list.remove(secondOperand);
        ComplexNumber sum=Calculator.division(firstOperand, secondOperand);
        list.add(sum);
        hist.add(sum);
    }

    @FXML
    private void dupButton(ActionEvent event) {
        hist.dup();
        list.add((ComplexNumber) hist.peek());
    }

    @FXML
    private void dropButton(ActionEvent event) {
        hist.drop();
        list.remove(list.size()-1);
    }

    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
        list.clear();
    }

    @FXML
    private void overButton(ActionEvent event) {
        hist.over();
        list.add(list.get(list.size()-2));
    }

    @FXML
    private void swapButton(ActionEvent event) {
        hist.swap();
        ComplexNumber last=list.get(list.size()-1);
        ComplexNumber secondLast=list.get(list.size()-2);
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        
        list.add(last);
        list.add(secondLast);
    }

    @FXML
    private void addOperand(ActionEvent event) {
        ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
        hist.add(operand);
        list.add(operand);
    }
    
}
