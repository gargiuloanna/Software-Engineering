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
    private ToggleButton addOpButton;
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
        
        setState(new CalculatorState(hist));
    }    

    @FXML
    private void prodButton(ActionEvent event) {
        Command prod = new ProductCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(prod);
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                          }
        else{
            exe.execute(prod);
            }
        }

    }

    @FXML
    private void subButton(ActionEvent event) {
        Command sub = new SubtractionCommand(hist);
        if(addOpButton.isSelected()){
           personalizedOperations.get(opName).addOperation(sub);
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                          }
        else{
            exe.execute(sub);
            }
        }
    }

    @FXML
    private void addButton(ActionEvent event) {
        //state.addition();
        System.out.println(personalizedOperations.get(opName).getOpers());
    }

    @FXML
    private void invButton(ActionEvent event) {
        Command inv = new InvertCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(inv);
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                        }
        else{
            exe.execute(inv);
            }
        }
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        Command sqrt = new SqrtCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(sqrt);
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
            exe.execute(sqrt);
            }
        }

    }

    @FXML
    private void divButton(ActionEvent event) {
        Command div = new DivisionCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(div);
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
                         }
        else{
            exe.execute(div);
            }
        }
    }

    @FXML
    private void dupButton(ActionEvent event) {
        Command dup = new DupCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(dup);
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
            exe.execute(dup);
             }
        }
    }

    @FXML
    private void dropButton(ActionEvent event) {
        Command drop = new DropCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(drop);
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();
                           }
        else{
            exe.execute(drop);
            }
        }
    }

    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
    }

    @FXML
    private void overButton(ActionEvent event) {
        Command over = new OverCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(over);
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();
                           }
        else{
            exe.execute(over);
            }
        }
    }

    @FXML
    private void swapButton(ActionEvent event) {
        Command swap = new SwapCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(swap);
        }
        else{
        if(hist.size()<2){
            alertBox.setContentText("Inserire almeno due operandi");
            alertBox.showAndWait();
                          }
        else{
            exe.execute(swap);
            }
        }
    }
    
      @FXML
    private void moduleButton(ActionEvent event) {
        Command mod = new ModuleCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(mod);
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
            exe.execute(mod);
          }
        }
    }

    @FXML
    private void phaseButton(ActionEvent event) {
        Command ph = new PhaseCommand(hist);
        if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(ph);
        }
        else{
        if(hist.isEmpty()){
            alertBox.setContentText("Inserire l'operando per effettuare l'operazione");
            alertBox.showAndWait();            
        }
        else{
            exe.execute(ph);
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
            Command ph = new PushCommand(hist, operand);
            if(addOpButton.isSelected()){
            personalizedOperations.get(opName).addOperation(ph);
            System.out.println("sto facendo l'op personalizzata");
                 }
            else{
                addTextfield.clear();
                exe.execute(ph);
                System.out.println("sto eseguendo l'op personalizzata");
        }
        }
    }

    private char selectedVariable(){
        String s = variables.getSelectedToggle().toString();
        return s.charAt(s.length()-2);
    }
    
    @FXML
    private void exeOperation(ActionEvent event) {
        System.out.println(personalizedOperations.get(addOperation.getText()).getOpers());
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

    private void addOperation(ActionEvent event) {
           
        TextInputDialog addName = new TextInputDialog();
        addName.setTitle("Nuova Operazione");
        addName.setHeaderText("Aggiungere il nome dell'operazione che si vuole inserire");
        if (addOpButton.isSelected()){
            addOpButton.setText("Termina Operazione");
            Optional<String> result = addName.showAndWait();
            opName = result.get();
            personalizedOperations.put(opName, new Operations());       
        }else{
            addOpButton.setText("Aggiungi Operazione");
            list.add(new Entry(opName, personalizedOperations.get(opName)));
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
        opName = addOperation.getText();
        if (opName.isEmpty()){
            return;
        }
        System.out.println(opName);
        personalizedOperations.put(opName, new Operations());
        System.out.println(personalizedOperations.get(opName));
        //setState(new OperationState(hist, personalizedOperations, opName));
        radioGrid.setDisable(true);
        exeOpButton.setDisable(true);
    }

    @FXML
    private void stopInsertMethod(ActionEvent event) {
        //setState(new CalculatorState(hist));
        radioGrid.setDisable(false);
        exeOpButton.setDisable(false);
    }
    
    private void setState(State s){
        state = s;
    }
    
}
