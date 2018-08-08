package CompanyStructure;

public class TechnicalEmployee extends Employee{
    private int checkIns;

    public TechnicalEmployee(String aName){
        super(aName, 75000.00);
    }
                
    public String employeeStatus(){
        String representation = super.toString()+" has " + checkIns + " successful check ins";
        return representation;
    }

    public Employee getManager(){
        return super.getManager();
    }
}
