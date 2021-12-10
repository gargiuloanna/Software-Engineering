package se_scientificcalculator;

import scientificcalculator_model.Operations;
import calculator_exception.DivisionForZeroException;
import calculator_exception.OperationNotExistsException;
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
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import scientificcalculator_model.*;
import scientificcalculator_model.factorycomplexparser.*;
import scientificcalculator_model.statecalculator.*;

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
    private TableView<UserOperation> operationList;
    @FXML
    private TableColumn<UserOperation, String> nameClm;
    @FXML
    private TableColumn<UserOperation, Operations> opClm;
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
    private ObservableList<UserOperation> list;
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
        alertBox.setHeaderText("ATTENZIONE");
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
        } catch (DivisionForZeroException e) {
            alertBox.setContentText("Stai eseguendo una divisione per zero");
            alertBox.setHeaderText("OPERANDI ERRATI");
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
            ComplexNumber operand = ComplexNumberFactory.buildComplexNumberFromString(addTextfield.getText()); //FACTORY METHOD
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
       try{
           state.insertInVariable(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
       }catch (ArithmeticException e){
           alertBox.setContentText("Inserire un operando per effettuare l'operazione");
           alertBox.showAndWait();
       }catch(NullPointerException ex){
           alertBox.setContentText("Seleziona una variabile");
           alertBox.showAndWait();
       }
    }

    @FXML
    private void getFromVariable(ActionEvent event) {
       try{
           state.getFromVariable(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
       }catch(NullPointerException ex){
           alertBox.setContentText("Seleziona una variabile");
           alertBox.showAndWait();
       }
    }

    @FXML
    private void addToLast(ActionEvent event) {
        try{
            state.addToLast(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
        }catch (ArithmeticException ex){
           alertBox.setContentText("Inserire un operando per effettuare l'operazione");
           alertBox.showAndWait();
        }catch(NullPointerException ex){
           alertBox.setContentText("Seleziona una variabile");
           alertBox.showAndWait();
       }
    }

    @FXML
    private void subToLast(ActionEvent event) {
        try{
            state.subToLast(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
        }catch (ArithmeticException ex){
           alertBox.setContentText("Inserire un operando per effettuare l'operazione");
           alertBox.showAndWait();
        }catch(NullPointerException ex){
           alertBox.setContentText("Seleziona una variabile");
           alertBox.showAndWait();
       }
    }

    @FXML
    private void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
            if (addTextfield.getText().isEmpty() || !(inputCheck(addTextfield.getText()))) {
                alertBox.setContentText("Inserisci un numero valido");
                addTextfield.clear();
                alertBox.showAndWait();
            } else {
                ComplexNumber operand = ComplexNumberFactory.buildComplexNumberFromString(addTextfield.getText());
                state.push(hist, operand, personalizedOperations, opName);
                addTextfield.clear();
            }
        }
    }

    @FXML
    private void onEnterOperation(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
            setState(new OperationState());
            opName = addOperation.getText();
            exeOp.setText("Aggiungi");
            if (personalizedOperations.containsKey(opName)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Conferma");
                alert.setHeaderText("Attenzione, esiste già un'operazione con questo nome ");
                alert.setContentText("Vuoi continuare?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    addOperationTry.setDisable(true);
                    stopInsert.setDisable(false);
                    personalizedOperations.put(opName, new Operations());
                    for (UserOperation e : list) {
                        if (e.getName().equals(opName)) {
                            list.remove(e);
                            break;
                        }
                    }
                } else {
                    System.out.println("L'operazione è annullata");
                }
            } else {
                if (opName.equals("")) {
                    alertBox.setContentText("L'operazione non esiste oppure non hai inserito il nome dell'operazione da creare");
                    alertBox.setTitle("Errore");
                    alertBox.setHeaderText("Manca il nome dell'operazione");
                    alertBox.showAndWait();
                    exeOp.setText("Esegui");
                } else {
                    addOperationTry.setDisable(true);
                    stopInsert.setDisable(false);
                    personalizedOperations.put(opName, new Operations());
                    history.setDisable(true);
                }
            }
        }
    }

    @FXML
    private void executeOperation(ActionEvent event) {
        try{
            UserOperation user = operationList.getSelectionModel().getSelectedItem();
            state.userDefinition(user, personalizedOperations, opName);
        }catch(OperationNotExistsException | NullPointerException e){
            alertBox.setContentText("L'operazione da eseguire non è valida o è stata eliminata");
            alertBox.showAndWait();
        }

    }

    @FXML
    private void modifyOperation(ActionEvent event) {
        setState(new OperationState());
        exeOp.setText("Aggiungi");
        UserOperation selected = operationList.getSelectionModel().getSelectedItem();
        String name = selected.getName();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Conferma");
        alert.setHeaderText("Attenzione, stai per modificare l'operazione!");
        alert.setContentText("Vuoi continuare?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            addOperationTry.setDisable(true);
            stopInsert.setDisable(false);
            addOperation.setDisable(true);
            personalizedOperations.replace(name, new Operations());
            for (UserOperation e : list) {
                if (e.getName().equals(name)) {
                    list.remove(e);
                    break;
                }
            }
        } 
    }

    @FXML
    private void cancelOperation(ActionEvent event) {
        UserOperation selectedEntry = operationList.getSelectionModel().getSelectedItem();
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
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Alert aler = new Alert(Alert.AlertType.ERROR);
            aler.setContentText("File non trovato");
            aler.setTitle("Errore nel file");
    }
    }

    @FXML
    private void addOperationTryMethod(ActionEvent event) {
        setState(new OperationState());
        opName = addOperation.getText();
        exeOp.setText("Aggiungi");
        if (personalizedOperations.containsKey(opName)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Conferma");
            alert.setHeaderText("Attenzione, esiste già un'operazione con questo nome ");
            alert.setContentText("Vuoi continuare?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                addOperationTry.setDisable(true);
                stopInsert.setDisable(false);
                personalizedOperations.put(opName, new Operations());
                for (UserOperation e : list) {
                    if (e.getName().equals(opName)) {
                        list.remove(e);
                        break;
                    }
                }
            } else {
                System.out.println("L'operazione è annullata");
            }
        } else {
            if (opName.equals("")) {
                alertBox.setContentText("L'operazione non esiste oppure non hai inserito il nome dell'operazione da creare");
                alertBox.setTitle("Errore");
                alertBox.setHeaderText("Manca il nome dell'operazione");
                alertBox.showAndWait();
                exeOp.setText("Esegui");
            } else {
                addOperationTry.setDisable(true);
                stopInsert.setDisable(false);
                personalizedOperations.put(opName, new Operations());
                history.setDisable(true);
            }
        }
    }

    @FXML
    private void stopInsertMethod(ActionEvent event) {
        setState(new CalculatorState());
        addOperation.clear();
        exeOp.setText("Esegui");
        if(!personalizedOperations.isEmpty()) {
            list.add(new UserOperation(opName, personalizedOperations.get(opName)));
        }
        if(personalizedOperations.get(opName).getOpers().isEmpty()){
            personalizedOperations.remove(opName);
            for (UserOperation e : list) {
                if (e.getName().equals(opName)) {
                    list.remove(e);
                    break;
                }
            }
        }
        history.setDisable(false);
        addOperationTry.setDisable(false);
        stopInsert.setDisable(true);
        addOperation.setDisable(false);
        System.out.println(personalizedOperations);
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
