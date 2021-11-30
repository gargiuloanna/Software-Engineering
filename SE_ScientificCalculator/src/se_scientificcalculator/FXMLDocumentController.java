/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_scientificcalculator;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
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
    private ObservableList<ComplexNumber> list;
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
        list= FXCollections.observableArrayList();
        hist= new ComplexStack();
        history.setItems(list);
        
        alertBox= new Alert(Alert.AlertType.ERROR);
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
            ComplexNumber firstOperand= (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            list.remove(firstOperand);
            list.remove(secondOperand);
            ComplexNumber sum=Calculator.product(firstOperand, secondOperand);
            list.add(sum);
            hist.add(sum);
        }

    }

    @FXML
    private void subButton(ActionEvent event) {
         if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
        else{
            ComplexNumber firstOperand= (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            list.remove(firstOperand);
            list.remove(secondOperand);
            ComplexNumber sum=Calculator.subtraction(firstOperand, secondOperand);
            list.add(sum);
            hist.add(sum);
        }
    }

    @FXML
    private void addButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
        else{
            ComplexNumber firstOperand= (ComplexNumber) hist.pop();
            ComplexNumber secondOperand = (ComplexNumber) hist.pop();
            list.remove(firstOperand);
            list.remove(secondOperand);
            ComplexNumber sum=Calculator.addition(firstOperand, secondOperand);
            list.add(sum);
            hist.add(sum);
        }
    }

    @FXML
    private void invButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
            ComplexNumber firstOperand= (ComplexNumber) hist.pop();
            list.remove(firstOperand);
            ComplexNumber sum=Calculator.invert(firstOperand);
            list.add(sum);
            hist.add(sum);
        }
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
            ComplexNumber firstOperand= (ComplexNumber) hist.pop();
            list.remove(firstOperand);
            ComplexNumber sum=Calculator.sqrt(firstOperand);
            list.add(sum);
            hist.add(sum);
        }
    }

    @FXML
    private void divButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
        else{
        ComplexNumber firstOperand= (ComplexNumber) hist.pop();
        ComplexNumber secondOperand = (ComplexNumber) hist.pop();
        list.remove(firstOperand);
        list.remove(secondOperand);
        ComplexNumber sum=Calculator.division(firstOperand, secondOperand);
        list.add(sum);
        hist.add(sum);
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
        list.add((ComplexNumber) hist.peek());
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
        list.remove(list.size()-1);
        }
    }

    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
        list.clear();
    }

    @FXML
    private void overButton(ActionEvent event) {
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();            
        }
        else{
        hist.over();
        list.add(list.get(list.size()-2));
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
        ComplexNumber last=list.get(list.size()-1);
        ComplexNumber secondLast=list.get(list.size()-2);
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        
        list.add(last);
        list.add(secondLast);
        }
    }

    @FXML
    private void addOperand(ActionEvent event) {
        ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
        addTextfield.clear();
        hist.add(operand);
        list.add(operand);
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
          //Da implementare
          }
    }

    @FXML
    private void phaseButton(ActionEvent event) {
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
          //Da implementare
          }
    }

    @FXML
    private void exeOperation(ActionEvent event) {
        //Da implementare
    }

    @FXML
    private void insertInVariable(ActionEvent event) {
         //Da implementare
    }

    @FXML
    private void getFromVariable(ActionEvent event) {
         //Da implementare
    }

    @FXML
    private void addToLast(ActionEvent event) {
         //Da implementare
    }

    @FXML
    private void subToLast(ActionEvent event) {
         //Da implementare
    }

    @FXML
    private void onEnter(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
        ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
        addTextfield.clear();
        hist.add(operand);
        list.add(operand);
        
        }
    }
    

    
}
