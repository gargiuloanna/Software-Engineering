/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_scientificcalculator;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import scientificcalculator_model.*;
import scientificcalculator_model.personalizedoperations.*;

/**
 *
 * @author Anna
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField addTextfield;
    @FXML
    private ListView<ComplexNumber> history; 
    @FXML
    private ToggleGroup variables;
    @FXML
    private TextField addOperation;
    @FXML
    private GridPane radioGrid;
    @FXML
    private ToggleButton addOpButton;
    @FXML
    private Button addOperandButton;  
    @FXML
    private Button exeOpButton;
    
    private Alert alertBox;
    private ComplexStack hist;
    private Map<Character, ComplexNumber> variableMemory;
    private Map<String, Operations> personalizedOperations;
    private String opName;
    private ExecuteCommand exe;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variableMemory = new HashMap<>();
        personalizedOperations = new HashMap<>();
        hist = new ComplexStack();
        history.setItems(hist.getMemory());
        alertBox = new Alert(Alert.AlertType.ERROR);
        alertBox.setHeaderText("OPERANDI MANCANTI");
        alertBox.setTitle("ERRORE");
        radioGrid.disableProperty().bind(addOpButton.selectedProperty());
        addOperandButton.disableProperty().bind(addOpButton.selectedProperty());
        exeOpButton.disableProperty().bind(addOpButton.selectedProperty());
        addTextfield.disableProperty().bind(addOpButton.selectedProperty());
        opName = "";
        exe = new ExecuteCommand();
  
    }    

    @FXML
    private void prodButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"product");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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

    }

    @FXML
    private void subButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"subtraction");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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
    }

    @FXML
    private void addButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"addition");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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
    }

    @FXML
    private void invButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"invert");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"sqrt");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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

    }

    @FXML
    private void divButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"division");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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
    }

    @FXML
    private void dupButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"dup");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
        hist.dup();
             }
        }
    }

    @FXML
    private void dropButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"drop");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
            hist.drop();
            }
        }
    }

    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
    }

    @FXML
    private void overButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"over");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();
                           }
        else{
            hist.over();
            }
        }
    }

    @FXML
    private void swapButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"swap");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();
                          }
        else{
            hist.swap();
            }
        }
    }
    
      @FXML
    private void moduleButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"module");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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
    }

    @FXML
    private void phaseButton(ActionEvent event) {
        if(addOpButton.isSelected()){
            Command com = new AddOperationCommand(personalizedOperations.get(opName),"phase");
            exe.execute(com);
            System.out.println(personalizedOperations.get(opName).getOpers());
        }
        else{
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
    }

    @FXML
    private void addOperand(ActionEvent event) {
        if(addTextfield.getText().isEmpty()){
            alertBox.setContentText("Scrivi qualcosa nello spazio di testo");
            alertBox.showAndWait();
        }
        else{
            ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
            addTextfield.clear();
            hist.push(operand);
        }
    }

    private char selectedVariable(){
        String s = variables.getSelectedToggle().toString();
        return s.charAt(s.length()-2);
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
          if(addTextfield.getText().isEmpty()){
            alertBox.setContentText("Scrivi qualcosa nello spazio di testo");
            alertBox.showAndWait();
            }
            else{
                ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
                addTextfield.clear();
                hist.push(operand);
            }
        }
    }

    @FXML
    private void addOperation(ActionEvent event) {
           
           TextInputDialog addName = new TextInputDialog();
           addName.setTitle("Nuova Operazione");
           addName.setContentText("Aggiungere il nome dell'operazione che si vuole inserire");
           if (addOpButton.isSelected()){
               addOpButton.setText("Termina Operazione");
               addName.show();
               opName = addName.getEditor().getText();
               personalizedOperations.put(opName, new Operations());
           }
           else{
               addOpButton.setText("Aggiungi Operazione");
           }

           


    }

  

    
}
