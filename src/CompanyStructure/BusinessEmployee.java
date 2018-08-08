package CompanyStructure;

public class BusinessEmployee extends Employee implements EmployeeInterface{
    private double bonusBudget;
    
    public BusinessEmployee(String aName){
        super(aName, 50000);
    }
    
    public String employeeStatus(){
        String representation = super.toString()+" with a budget of " + bonusBudget;
        return representation;
    }
    
    public double getBonusBudget(){
        //super.getBaseSalary();
    }
}
