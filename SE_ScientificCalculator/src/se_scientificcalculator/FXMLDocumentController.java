/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_scientificcalculator;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
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
    private HashMap<Character, ComplexNumber> variableMemory;
    
    @FXML
    private ToggleGroup variables;
    @FXML
    private TextField addOperation;
    @FXML
    private RadioButton radioA;
    @FXML
    private RadioButton radioB;
    @FXML
    private RadioButton radioC;
    @FXML
    private RadioButton radioD;
    @FXML
    private RadioButton radioE;
    @FXML
    private RadioButton radioF;
    @FXML
    private RadioButton radioG;
    @FXML
    private RadioButton radioH;
    @FXML
    private RadioButton radioI;
    @FXML
    private RadioButton radioJ;
    @FXML
    private RadioButton radioK;
    @FXML
    private RadioButton radioL;
    @FXML
    private RadioButton radioM;
    @FXML
    private RadioButton radioN;
    @FXML
    private RadioButton radioO;
    @FXML
    private RadioButton radioP;
    @FXML
    private RadioButton radioQ;
    @FXML
    private RadioButton radioR;
    @FXML
    private RadioButton radioS;
    @FXML
    private RadioButton radioT;
    @FXML
    private RadioButton radioU;
    @FXML
    private RadioButton radioV;
    @FXML
    private RadioButton radioW;
    @FXML
    private RadioButton radioX;
    @FXML
    private RadioButton radioY;
    @FXML
    private RadioButton radioZ;
    private Alert alertBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variableMemory = new HashMap<>();
        hist = new ComplexStack();
        history.setItems(hist.getMemory());
        alertBox = new Alert(Alert.AlertType.ERROR);
        alertBox.setHeaderText("OPERANDI MANCANTI");
        alertBox.setTitle("ERRORE");
  
    }    

    @FXML
    private void prodButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                          }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            ComplexNumber prod = Calculator.product(firstOperand, secondOperand);
            hist.push(prod);
            }

    }

    @FXML
    private void subButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                          }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            ComplexNumber sub = Calculator.subtraction(firstOperand, secondOperand);
            hist.push(sub);
            }
    }

    @FXML
    private void addButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                          }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            ComplexNumber sum = Calculator.addition(firstOperand, secondOperand);
            hist.push(sum);
            }
    }

    @FXML
    private void invButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                        }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            ComplexNumber inv = Calculator.invert(firstOperand);
            hist.push(inv);
            }
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            ComplexNumber s = Calculator.sqrt(firstOperand);
            hist.push(s);
            }

    }

    @FXML
    private void divButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                         }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            ComplexNumber div = Calculator.division(firstOperand, secondOperand);
            hist.push(div);
            }
        
    }

    @FXML
    private void dupButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
        hist.dup();
             }
    }

    @FXML
    private void dropButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
            hist.drop();
            }
    }

    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
    }

    @FXML
    private void overButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();
                           }
        else{
            hist.over();
            }
    }

    @FXML
    private void swapButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();
                          }
        else{
            hist.swap();
            }
    }

    @FXML
    private void addOperand(ActionEvent event) {
        ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
        addTextfield.clear();
        hist.push(operand);
        
            
    }

    private char selectedVariable(){
        String s = variables.getSelectedToggle().toString();
        return s.charAt(s.length()-2);
    }
    
    @FXML
    private void moduleButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            double mod = Calculator.module(firstOperand);
            hist.push(mod);
          }
    }

    @FXML
    private void phaseButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
            ComplexNumber firstOperand = (ComplexNumber) hist.pop();
            double ph = firstOperand.phase();
            hist.push(ph);
          }
    }

    @FXML
    private void exeOperation(ActionEvent event) {
        //Da implementare
    }

    @FXML
    private void insertInVariable(ActionEvent event) {
        Calculator.insertInVariable(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void getFromVariable(ActionEvent event) {
        Calculator.getFromVariable(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void addToLast(ActionEvent event) {
       Calculator.addToLast(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void subToLast(ActionEvent event) {
        Calculator.subToLast(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void onEnter(KeyEvent event) {
       if(event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
          ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
          addTextfield.clear();
          hist.push(operand);
          
        }
    }
    

    
}
