package CompanyStructure;

abstract public class Employee{
    private String name;
    private double baseSalary;
    private static int employeeID = 0;
    private static Employee manager;
    private String employeeStatusVal;
    
    public Employee(String aName, double aBaseSalary){
        this.employeeID++;
        this.name = aName;
        this.baseSalary = aBaseSalary;
    }
    
    public int getEmployeeID(){
        return employeeID;
    }
    
    public double getBaseSalary(){
        return baseSalary;
    }
    
    public String getName(){
        return name;
    }
    
    public Employee getManager(){
        return manager;
    }
    
    public boolean equals(Employee other){
        return (this.getEmployeeID()==other.getEmployeeID());
    }
    
    public String toString(){
        String stringConv = "";
        stringConv += Integer.toString(getEmployeeID());
        stringConv += " " + getName();
        return stringConv;
    }
}
