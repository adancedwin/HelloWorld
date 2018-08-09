package CompanyStructure;

public class TechnicalEmployee extends Employee{
    private int checkIns;

    /*
    Has a default base salary of 75000    
    */
    public TechnicalEmployee(String aName){
        super(aName, 75000.00);
    }
    
    /*
    Should return a String representation of this TechnicalEmployee that includes 
    their ID, name and how many successful check ins they have had. 
    Example: "1 Kasey has 10 successful check ins"
    */
    public String employeeStatus(){
        String representation = super.toString()+" has " + checkIns + " successful check ins";
        return representation;
    }

    /*
    public Employee getManager(){
        return super.getManager();
    }
    */
}
