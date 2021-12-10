
package scientificcalculator_model.operationscommands;


import java.util.ArrayList;


/**
 * The class Operations allows to save an undefined number of operations.
 */
public class Operations {
    private ArrayList<Command> opers;
    
    /**
     * Initializes a newly created Operations object. 
     * The Operations are saved into an ArrayList of Commands.
     */
    public Operations(){
        opers= new ArrayList();
    }

    /**
     * The method allows to get the Operations saved.
     * @return the operations saved into the ArrayList.
     */
    public ArrayList<Command> getOpers() {
        return opers;
    }

    /**
     * The method allows to add a new Operation to the ArrayList of already saved operations.
     * @param op the operation to add
     */    
    public void addOperation(Command op){
        opers.add(op);
    }

    /**
     * This method creates the string form of the oeprations.
     * <p>
     * @return the string form of the ArrayList of operations
     */ 
    @Override
    public String toString() {
        String str = opers.get(0).toString();
        for(int i = 1; i < opers.size(); i++){
            str = str + " " + opers.get(i).toString();
        }
        return str;
    }
    
    
}
    

