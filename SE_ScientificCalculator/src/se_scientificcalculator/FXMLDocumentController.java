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
    private Button stopInsert;
    @FXML
    private Button CEButton;
    @FXML
    private Button addOperand;
    @FXML
    private Button addOperationButton;
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
        alertBox.setHeaderText("ATTENTION");
        alertBox.setTitle("ERROR");
        opName = "";
        exe = new ExecuteCommand();
        stopInsert.setDisable(true);
        setState(new CalculatorState());
        exeOp.setText("Execute");
    }

    /**
     * The method allows to either multiply the last two elements of the stack, or to add the product operation in an user defined operation.
     * It displays an alert box if the operands necessary for the operation are not defined.
     * <p>
     * @param event the event associated to the " * " button click
     */
    @FXML
    private void prodButton(ActionEvent event) {
        try {
            state.product(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        }

    }

    /**
     * The method allows to either subtract the last two elements of the stack, or to add the subtraction operation in an user defined operation.
     * It displays an alert box if the operands necessary for the operation are not defined.
     * <p>
     * @param event the event associated to the " - " button click
     */
    @FXML
    private void subButton(ActionEvent event) {
        try {
            state.subtraction(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to either addition the last two elements of the stack, or to add the addition operation in an user defined operation.
     * It displays an alert box if the operands necessary for the operation are not defined.
     * <p>
     * @param event the event associated to the " + " button click
     */
    @FXML
    private void addButton(ActionEvent event) {
        try {
            state.addition(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to either divide the last two elements of the stack, or to add the division operation in an user defined operation.
     * It displays an alert box if the operands necessary for the operation are not defined or if the denominator of the division is 0.
     * <p>
     * @param event the event associated to the " / " button click
     */
    @FXML
    private void divButton(ActionEvent event) {
        try {
            state.division(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        } catch (DivisionForZeroException e) {
            alertBox.setContentText("Division by 0");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to either invert the sign of the last element of the stack, or to add the invert operation in an user defined operation.
     * It displays an alert box if the operand necessary for the operation is not defined.
     * <p>
     * @param event the event associated to the " + - " button click
     */
    @FXML
    private void invButton(ActionEvent event) {
        try {
            state.invert(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert a number to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to either perform the square root of the last element of the stack, or to add the square root operation in an user defined operation.
     * It displays an alert box if the operand necessary for the operation is not defined.
     * <p>
     * @param event the event associated to the " SQRT " button click
     */
    @FXML
    private void sqrtButton(ActionEvent event) {
        try {
            state.sqrt(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert a number to execute the operation");
            alertBox.showAndWait();
        }
    }

    /**
     * The method allows to either duplicate the last element of the stack, or to add the dup operation in an user defined operation.
     * It displays an alert box if the operand necessary for the operation is not defined.
     * <p>
     * @param event the event associated to the " DUP " button click
     */
    @FXML
    private void dupButton(ActionEvent event) {
        try {
            state.dup(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert a number to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to either drop the last element of the stack, or to add the drop operation in an user defined operation.
     * It displays an alert box if the operand necessary for the operation is not defined.
     * <p>
     * @param event the event associated to the " DROP " button click
     */
    @FXML
    private void dropButton(ActionEvent event) {
        try {
            state.drop(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert a number to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to clear the stack.
     * <p>
     * @param event the event associated to the " CE " button click
     */
    @FXML
    private void clearButton(ActionEvent event) {
        hist.stackClear();
    }
    
    /**
     * The method allows to either duplicate the second last element of the stack, or to add the over operation in an user defined operation.
     * It displays an alert box if the operands necessary for the operation are not defined.
     * <p>
     * @param event the event associated to the " OVER " button click
     */
    @FXML
    private void overButton(ActionEvent event) {
        try {
            state.over(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to either swap the last two elements of the stack, or to add the swap operation in an user defined operation.
     * It displays an alert box if the operands necessary for the operation are not defined.
     * <p>
     * @param event the event associated to the " SWAP " button click
     */
    @FXML
    private void swapButton(ActionEvent event) {
        try {
            state.swap(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        }
    }

    /**
     * The method allows to either calculate the absolute value of the last element of the stack, or to add the module operation in an user defined operation.
     * It displays an alert box if the operand necessary for the operation is not defined.
     * <p>
     * @param event the event associated to the " MOD " button click
     */
    @FXML
    private void moduleButton(ActionEvent event) {
        try {
            state.module(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert a number to execute the operation");
            alertBox.showAndWait();
        }
    }

    /**
     * The method allows to either calculate the phase of the last element of the stack, or to add the phase operation in an user defined operation.
     * It displays an alert box if the operand necessary for the operation is not defined.
     * <p>
     * @param event the event associated to the " Arg(z) " button click
     */
    @FXML
    private void phaseButton(ActionEvent event) {
        try {
            state.phase(hist, personalizedOperations, opName);
        } catch (ArithmeticException e) {
            alertBox.setContentText("Insert a number to execute the operation");
            alertBox.showAndWait();
        }
    }
    
    /**
     * The method allows to add a ComplexNumber inside of the stack.
     * It displays an alert box if the input inserted is not a number.
     * <p>
     * @param event the event associated to the " Add Operand " button click
     */
    @FXML
    private void addOperandMethod(ActionEvent event) {
        if (addTextfield.getText().isEmpty() || !(inputCheck(addTextfield.getText()))) {
            addTextfield.clear();
            alertBox.setContentText("Insert a valid number");
            alertBox.showAndWait();
        } else {
            ComplexNumber operand = ComplexNumberFactory.buildComplexNumberFromString(addTextfield.getText()); //FACTORY METHOD
            state.push(hist, operand, personalizedOperations, opName);
            addTextfield.clear();
        }
    }

    /**
     * The method allows to either insert the value of the last element of the stack inside the selected variable, or to add the insertInVariable operation in an user defined operation.
     * It displays an alert box if no variable was selected or if no operand is defined.
     * <p>
     * @param event the event associated to the " > " button click
     */
    @FXML
    private void insertInVariable(ActionEvent event) {
       try{
           state.insertInVariable(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
       }catch (ArithmeticException e){
           alertBox.setContentText("Insert a number to execute the operation");
           alertBox.showAndWait();
       }catch(NullPointerException ex){
           alertBox.setContentText("Select a valid variable");
           alertBox.showAndWait();
       }
    }
    
    /**
     * The method allows to either get the value contained inside the selected value and copy it as the last element of the stack, or to add the getFromVariable operation in an user defined operation.
     * It displays an alert box if no variable was selected or if no operand is defined.
     * <p>
     * @param event the event associated to the " < " button click
     */
    @FXML
    private void getFromVariable(ActionEvent event) {
       try{
           state.getFromVariable(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
       }catch(NullPointerException ex ){
           alertBox.setContentText("Select a valid variable");
           alertBox.showAndWait();
       } catch (ArithmeticException ex){
           alertBox.setContentText("The variable selected is empty");
           alertBox.showAndWait();
       }
           
    }
    
    /**
     * The method allows to either add the value contained inside the selected value with the value of the last element of the stack, or to add the addToLast operation in an user defined operation.
     * It displays an alert box if no variable was selected or if no operand is defined.
     * <p>
     * @param event the event associated to the " + (variable) " button click
     */
    @FXML
    private void addToLast(ActionEvent event) {
        try{
            state.addToLast(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
        }catch (ArithmeticException ex){
           alertBox.setContentText("Insert a number to execute the operation");
           alertBox.showAndWait();
        }catch(NullPointerException ex){
           alertBox.setContentText("Select a valid variable");
           alertBox.showAndWait();
       }
    }
    
    /**
     * The method allows to either subtract the value contained inside the selected value with the value of the last element of the stack, or to add the subToLast operation in an user defined operation.
     * It displays an alert box if no variable was selected or if no operand is defined.
     * <p>
     * @param event the event associated to the " - (variable) " button click
     */
    @FXML
    private void subToLast(ActionEvent event) {
        try{
            state.subToLast(hist, variableMemory, selectedVariable(), personalizedOperations, opName);
        }catch (ArithmeticException ex){
           alertBox.setContentText("Insert a number to execute the operation");
           alertBox.showAndWait();
        }catch(NullPointerException ex){
           alertBox.setContentText("Select a valid variable");
           alertBox.showAndWait();
       }
    }
    
    /**
     * The method allows to press the key ENTER to insert an input inside of the stack.
     * It displays an alert box if the input inserted is not a number.
     * <p>
     * @param event the event associated with the ENTER key press
     */

    @FXML
    private void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
            if (addTextfield.getText().isEmpty() || !(inputCheck(addTextfield.getText()))) {
                alertBox.setContentText("Insert a valid number");
                addTextfield.clear();
                alertBox.showAndWait();
            } else {
                ComplexNumber operand = ComplexNumberFactory.buildComplexNumberFromString(addTextfield.getText());
                state.push(hist, operand, personalizedOperations, opName);
                addTextfield.clear();
            }
        }
    }
       
    /**
     * The method allows to either execute a selected operation (using the menuItem) or to add a specific user defined operation to another user defined operation.
     * It displays an alert box if the operation selected is nonexistent, or if the operands are not defined.
     * <p>
     * @param event the event associated with the " Add "/" Execute " menu item
     */
    @FXML
    private void executeOperation(ActionEvent event) {
        try{
            UserOperation user = operationList.getSelectionModel().getSelectedItem();
            state.userDefinition(user, personalizedOperations, opName);
        }catch(OperationNotExistsException | NullPointerException e){
            alertBox.setContentText("The operation selected is not valid\nor it has been deleted");
            alertBox.showAndWait();
        } catch (ArithmeticException ex){
            alertBox.setContentText("Insert two numbers to execute the operation");
            alertBox.showAndWait();
        }

    }
    
    /**
     * The method allows to modify the selected operation.
     * It displays an alert box to make sure the user wants to modify the operation.
     * The previous selected operation is replaced to allow to define a new operation.
     * <p>
     * @param event the event associated with the " Modify " menu item
     */
    @FXML
    private void modifyOperation(ActionEvent event) {
        setState(new OperationState());
        exeOp.setText("Add");
        UserOperation selected = operationList.getSelectionModel().getSelectedItem();
        opName = selected.getName();
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Attention, you're about to modify the operation!");
        alert.setContentText("Are you sure you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            addOperationButton.setDisable(true);
            stopInsert.setDisable(false);
            addOperation.setDisable(true);
            CEButton.setDisable(true);
            personalizedOperations.replace(opName, new Operations());
            for (UserOperation e : list) {
                    if (e.getName().equals(opName)) {
                       list.remove(e);
                        break;
                    }
                }
        } 
    }
    
    /**
     * The method allows to delete a previously defined operation. 
     * <p>
     * @param event the event associated with the " Delete " menu item.
     */
    @FXML
    private void cancelOperation(ActionEvent event) {
        UserOperation selectedEntry = operationList.getSelectionModel().getSelectedItem();
        String selectedName = selectedEntry.getName();
        personalizedOperations.remove(selectedName);
        list.remove(selectedEntry);
    }
    
    /**
     * The method allows to save the user defined operations on a text file.
     * It displays an alert box if the file is not found.
     * <p>
     * @param event the event asociated with the " Save Operations " menu item
     */
    @FXML
    private void saveOnFile(ActionEvent event) {
        FileChooser file = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        file.getExtensionFilters().add(extFilter);
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
            aler.setContentText("File not found");
    }
    }

    /**
     * The method allows to define a new operation.
     * If a name is added but no operation is selected, the operation is not saved.
     * It displays an alert box if the name chosen is already used for a previously defined operation.
     * If the user decides to continue, then the previous defined operation is replaced with the new one.
     * It displays and alert box if no name is inserted.
     * <p>
     * @param event the event associated with the " Add Operation " button
     */
    @FXML
    private void addOperationMethod(ActionEvent event) {
        setState(new OperationState());
        opName = addOperation.getText();
        exeOp.setText("Add");
        if (personalizedOperations.containsKey(opName)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Attention, an operation with this name already exists");
            alert.setContentText("Are you sure you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                addOperation.setDisable(true);
                addOperationButton.setDisable(true);
                stopInsert.setDisable(false);
                personalizedOperations.put(opName, new Operations());
                for (UserOperation e : list) {
                    if (e.getName().equals(opName)) {
                        list.remove(e);
                        break;
                    }
                }
            } 
        } else {
            if (opName.equals("")) {
                alertBox.setContentText("Insert a valid operation name");
                alertBox.showAndWait();
                exeOp.setText("Execute");
            } else {
                addOperation.setDisable(true);
                addOperationButton.setDisable(true);
                stopInsert.setDisable(false);
                personalizedOperations.put(opName, new Operations());
                history.setDisable(true);
                CEButton.setDisable(true);
            }
        }
    }
    
    /**
     * The method allows to press the key ENTER to define a new operation.
     * If a name is added but no operation is selected, the operation is not saved.
     * It displays an alert box if the name chosen is already used for a previously defined operation.
     * If the user decides to continue, then the previous defined operation is replaced with the new one.
     * It displays and alert box if no name is inserted.
     * <p>
     * @param event the event associated with the ENTER key press
     */
    @FXML
    private void onEnterOperation(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER) || event.getCharacter().getBytes()[0] == '\n' || event.getCharacter().getBytes()[0] == '\r') {
            setState(new OperationState());
            opName = addOperation.getText();
            exeOp.setText("Add");
            if (personalizedOperations.containsKey(opName)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Attention, an operation with this name already exists");
                alert.setContentText("Are you sure you want to continue?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    addOperation.setDisable(true);
                    addOperationButton.setDisable(true);
                    stopInsert.setDisable(false);
                    personalizedOperations.put(opName, new Operations());
                    for (UserOperation e : list) {
                        if (e.getName().equals(opName)) {
                            list.remove(e);
                            break;
                        }
                    }
                } 
            } else {
                if (opName.equals("")) {
                    alertBox.setContentText("Insert a valid operation name");
                    alertBox.showAndWait();
                    exeOp.setText("Execute");
                } else {
                    addOperation.setDisable(true);
                    addOperationButton.setDisable(true);
                    stopInsert.setDisable(false);
                    personalizedOperations.put(opName, new Operations());
                    history.setDisable(true);
                    CEButton.setDisable(true);
                }
            }
        }
    }
    
    /**
     * The method allows the user to confirm a new defined operation and to start using the calculator in the "CalculatorState".
     * If the operation was defined only by its name, but no operations were selected, the operation is not saved.
     * <p>
     * @param event the event associated with the " Finish Insertion" button
     */

    @FXML
    private void stopInsertMethod(ActionEvent event) {
        setState(new CalculatorState());
        addOperation.clear();
        exeOp.setText("Execute");
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
        addOperationButton.setDisable(false);
        stopInsert.setDisable(true);
        addOperation.setDisable(false);
        CEButton.setDisable(false);
    }
    
    /**
     * The method allows catch the variabe selected from all the possible variables displayed as radio buttons.
     * <p>
     * @return the variable selected
     */
    private char selectedVariable() {
        String s = variables.getSelectedToggle().toString();
        return s.charAt(s.length() - 2);
    }
    
    /**
     * The method allows to set the state of the controller, allowing the user to either perform the simple operations provided by the calculator or to define new complex operations.
     * The State CalculatorState makes it so that the button clicks perform the operations selected, whereas the OperationState makes it so that the button clicks add the selected operation to the new complex operation
     * to define or to modify.
     * @param s the new state of the controller
     */
    private void setState(State s) {
        state = s;
    }
    
    /**
     * The method performs a check on the input of the addOperand textfield.
     * @param s the string to check
     * @return true if the input string is a ComplexNumber
     */
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
