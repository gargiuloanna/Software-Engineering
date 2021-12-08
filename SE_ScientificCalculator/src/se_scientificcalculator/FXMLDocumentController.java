/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_scientificcalculator;

import calculator_exception.CommandExistsException;
import scientificcalculator_model.operationscommands.*;
import java.io.*;
import javafx.scene.input.KeyEvent;
import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import scientificcalculator_model.*;
import scientificcalculator_model.statecalculator.*;

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
    private TableView<Entry> operationList;
    @FXML
    private TableColumn<Entry, String> nameClm;
    @FXML
    private TableColumn<Entry, Operations> opClm;
    @FXML
    private MenuItem exeOp;
    @FXML
    private MenuItem modifyOp;
    @FXML
    private MenuItem cancelOp;
    @FXML
    private MenuItem SaveFile;
    @FXML
    private Button addOperationTry;
    @FXML
    private Button stopInsert;

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
        stopInsert.setDisable(true);
        setState(new CalculatorState());
        exeOp.setText("Esegui");
    }

    @FXML
    private void prodButton(ActionEvent event) {
        try {
            state.product(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }

    }

    @FXML
    private void subButton(ActionEvent event) {
        try {
            state.subtraction(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void addButton(ActionEvent event) {
        try {
            state.addition(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void invButton(ActionEvent event) {
        try {
            state.invert(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void sqrtButton(ActionEvent event) {
        try {
            state.sqrt(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }

    }

    @FXML
    private void divButton(ActionEvent event) {
        try {
            state.division(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void dupButton(ActionEvent event) {
        try {
            state.dup(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void dropButton(ActionEvent event) {
        try {
            state.drop(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
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
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void swapButton(ActionEvent event) {
        try {
            state.swap(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire due operandi per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void moduleButton(ActionEvent event) {
        try {
            state.module(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void phaseButton(ActionEvent event) {
        try {
            state.phase(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Inserire un operando per effettuare l'operazione");
            alertBox.showAndWait();
        }
    }

    @FXML
    private void addOperand(ActionEvent event) {
        if (addTextfield.getText().isEmpty() || !(inputCheck(addTextfield.getText()))) {
            alertBox.setContentText("Inserisci un numero valido");
            addTextfield.clear();
            alertBox.showAndWait();
        } else {
            ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText()); //FACTORY METHOD
            state.push(hist, operand, personalizedOperations, opName);
            addTextfield.clear();
        }
    }

    private char selectedVariable() {
        String s = variables.getSelectedToggle().toString();
        return s.charAt(s.length() - 2);
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
        if (event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
            if (addTextfield.getText().isEmpty() || !(inputCheck(addTextfield.getText()))) {
                alertBox.setContentText("Inserisci un numero valido");
                addTextfield.clear();
                alertBox.showAndWait();
            } else {
                ComplexNumber operand = ComplexNumber.stringToComplex(addTextfield.getText());
                state.push(hist, operand, personalizedOperations, opName);
                addTextfield.clear();
            }
        }
    }
    
    @FXML
    private void executeOperation(ActionEvent event) {
         try{
            Entry user = operationList.getSelectionModel().getSelectedItem();
            state.userDefinition(user, personalizedOperations, opName);
        }catch(CommandExistsException | NullPointerException e){
            alertBox.setContentText("L'operazione da eseguire non è valida o non è stata ancora inserita");
            alertBox.showAndWait();
        }

    }


    @FXML
    private void modifyOperation(ActionEvent event) {
    }

    @FXML
    private void cancelOperation(ActionEvent event) {
        Entry selectedEntry = operationList.getSelectionModel().getSelectedItem();
        String selectedName = selectedEntry.getName();
        personalizedOperations.remove(selectedName);
        list.remove(selectedEntry);
    }

    @FXML
    private void saveOnFile(ActionEvent event) {
        FileChooser file = new FileChooser();
        File fileChosen = file.showSaveDialog(null);
        PrintWriter writer;
        if (fileChosen != null)
            try {
            writer = new PrintWriter(fileChosen, "UTF-8");
            for (String s : personalizedOperations.keySet()) {
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
        exeOp.setText("Aggiungi");
        if (personalizedOperations.containsKey(opName)){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                addOperationTry.setDisable(true);
                stopInsert.setDisable(false);
                personalizedOperations.put(opName, new Operations());
                for(Entry e: list){
                    if(e.getName().equals(opName)){
                        list.remove(e);
                        break;
                    }
                }     
            }
            else{
                System.out.println("L'operazione è annullata");
            }
        }else{
            if (opName.equals("")) {
                alertBox.setContentText("L'operazione non esiste oppure non hai inserito il nome dell'operazione da creare");
                alertBox.setTitle("Errore");
                alertBox.setHeaderText("Manca il nome dell'operazione");
                alertBox.showAndWait();
                exeOp.setText("Esegui");
            }else{
                addOperationTry.setDisable(true);
                stopInsert.setDisable(false);
                personalizedOperations.put(opName, new Operations());
                radioGrid.setDisable(true);
                history.setDisable(true);
            }
        }
    }

    @FXML
    private void stopInsertMethod(ActionEvent event) {
        setState(new CalculatorState());
        addOperation.clear();
        exeOp.setText("Esegui");
        if (!personalizedOperations.isEmpty()) {
            list.add(new Entry(opName, personalizedOperations.get(opName)));
        }
        radioGrid.setDisable(false);
        history.setDisable(false);
        addOperationTry.setDisable(false);
        stopInsert.setDisable(true);
    }

    private void setState(State s) {
        state = s;
    }

    private boolean inputCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z') {
                if (!(s.charAt(i) == 'j')) {
                    return false;
                }
            }
        }
        return true;
    }

    
}
