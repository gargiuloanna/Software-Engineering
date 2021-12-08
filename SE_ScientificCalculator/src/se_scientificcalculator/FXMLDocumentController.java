/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_scientificcalculator;

import scientificcalculator_model.operationscommands.*;
import java.io.*;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import scientificcalculator_model.*;
import scientificcalculator_model.statecalculator.CalculatorState;
import scientificcalculator_model.statecalculator.OperationState;
import scientificcalculator_model.statecalculator.State;

/**
 *
 * @author Anna
 */
public class FXMLDocumentController implements Initializable {
    
    //GUI Elements
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
    private Button addOperandButton;  
    @FXML
    private Button exeOpButton;
    @FXML
    private TableView<Entry> operationList;
    @FXML
    private TableColumn<Entry, String> nameClm;
    @FXML
    private TableColumn<Entry, Operations> opClm;
    @FXML
    private MenuItem modifyOp;
    @FXML
    private MenuItem cancelOp;
    @FXML
    private MenuItem SaveFile;
    
    //Memory Structures
    private ObservableList<Entry> list;
    private ComplexStack hist;
    private Map<Character, ComplexNumber> variableMemory;
    private Map<String, Operations> personalizedOperations;
    private String opName;
    
    private Alert alertBox;
    
    //Command Executer for the pattern implementation
    private ExecuteCommand exe;
    
    //State for State Pattern implementation
    private State state;
    
    @FXML
    private Button addOperationTry;
    @FXML
    private Button stopInsert;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        variableMemory = new HashMap<>();
        personalizedOperations = new HashMap<>();
        list = FXCollections.observableArrayList();
        nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
        opClm.setCellValueFactory(new PropertyValueFactory<>("op"));
        operationList.setItems(list); 
        hist = new ComplexStack();
        history.setItems(hist.getMemory());
        alertBox = new Alert(Alert.AlertType.ERROR);
        alertBox.setHeaderText("OPERANDI MANCANTI");
        alertBox.setTitle("ERRORE");
        opName = "";
        exe = new ExecuteCommand();
        
        setState(new CalculatorState());
    }    

    @FXML
    private void prodButton(ActionEvent event) {
       try {
        state.product(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }

    }

    @FXML
    private void subButton(ActionEvent event) {
        try {
        state.subtraction(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void addButton(ActionEvent event) {
        try {
        state.addition(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void invButton(ActionEvent event) {
      try {
        state.invert(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        try {
        state.sqrt(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }

    }

    @FXML
    private void divButton(ActionEvent event) {
        try {
        state.division(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void dupButton(ActionEvent event) {
        try {
        state.dup(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void dropButton(ActionEvent event) {
       try {
        state.drop(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
    }

    @FXML
    private void overButton(ActionEvent event) {
       try {
        state.over(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void swapButton(ActionEvent event) {
       try {
        state.swap(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }
    
      @FXML
    private void moduleButton(ActionEvent event) {
       try {
        state.module(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void phaseButton(ActionEvent event) {
        try {
        state.phase(hist, personalizedOperations, opName);
        }catch(ArithmeticException e){
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void addOperand(ActionEvent event) {       
        if(addTextfield.getText().isEmpty() || !(inputCheck(addTextfield.getText()))){
            alertBox.setContentText("Inserisci un numero valido");
            addTextfield.clear();
            alertBox.showAndWait();
        }
        else{            
            ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
            state.push(hist,operand, personalizedOperations, opName);
            addTextfield.clear();
        }
    }

    private char selectedVariable(){
        String s = variables.getSelectedToggle().toString();
        return s.charAt(s.length()-2);
    }
    
    @FXML
    private void exeOperation(ActionEvent event) {
        for(Command c: personalizedOperations.get(addOperation.getText()).getOpers()){
            exe.execute(c);
        }
    }

    @FXML
    private void insertInVariable(ActionEvent event) {
        VariablesOperations.insertInVariable(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void getFromVariable(ActionEvent event) {
        VariablesOperations.getFromVariable(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void addToLast(ActionEvent event) {
       VariablesOperations.addToLast(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void subToLast(ActionEvent event) {
        VariablesOperations.subToLast(hist, variableMemory, selectedVariable());
    }

    @FXML
    private void onEnter(KeyEvent event) {
       if(event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
            if(addTextfield.getText().isEmpty()  || !(inputCheck(addTextfield.getText()))){
                alertBox.setContentText("Inserisci un numero valido");
                addTextfield.clear();
                alertBox.showAndWait();
            }
            else{            
                ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
                state.push(hist,operand, personalizedOperations, opName);
                addTextfield.clear();
            }                
        }
    }

    @FXML
    private void modifyOperation(ActionEvent event) {
    }

    @FXML
    private void cancelOperation(ActionEvent event) {
    }

    @FXML
    private void saveOnFile(ActionEvent event) {
        FileChooser file = new FileChooser();
        File fileChosen = file.showSaveDialog(null);
        PrintWriter writer; 
        if (fileChosen != null)
            try {
                writer = new PrintWriter(fileChosen, "UTF-8");
                for(String s : personalizedOperations.keySet()){
                    writer.println(s + ": " + personalizedOperations.get(s).getOpers());
                }
                writer.close();
        } catch (FileNotFoundException ex) {
            Alert aler = new Alert(Alert.AlertType.ERROR);
            aler.setContentText("File not found");
            aler.setTitle("File Error");
                    
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addOperationTryMethod(ActionEvent event) {
        setState(new OperationState());
        opName = addOperation.getText();
        String str = "";
        addOperation.clear();
        if (opName.isEmpty()){
            alertBox.setContentText("Inserire un nome valido");
            alertBox.showAndWait();
        }
        Operations o = new Operations();
        personalizedOperations.put(opName, o);
        
        
        radioGrid.setDisable(true);
        exeOpButton.setDisable(true);
        history.setDisable(true);
    }

    @FXML
    private void stopInsertMethod(ActionEvent event) {
        setState(new CalculatorState());
        Entry e = new Entry(opName,personalizedOperations.get(opName));
        list.add(e);
        radioGrid.setDisable(false);
        exeOpButton.setDisable(false);
        history.setDisable(false);
    }
    
    @FXML
    private void userDefinition(MouseEvent event) {
 
        Entry e = operationList.getSelectionModel().getSelectedItem();
        Command o = new UserOperationCommand(e.getName(),e.getOp());
        personalizedOperations.get(opName).addOperation(o);
               
    }
       
    private void setState(State s){
        state = s;
    }
    private boolean inputCheck(String s){
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)>='A' && s.charAt(i)<='z')
                if(! (s.charAt(i) == 'j'))
                    return false;       
        
        return true;
    }
    
}
