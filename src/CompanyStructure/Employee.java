package CompanyStructure;

abstract public class Employee{
    public String name;
    public double baseSalary;
    public static int employeeID = 0;
    public static Employee manager;
    
    /*
    Should construct a new employee object and take in two parameters, one for 
    the name of the user and one for their base salary
    */
    public Employee(String aName, double aBaseSalary){
        this.employeeID++;
        this.name = aName;
        this.baseSalary = aBaseSalary;
    }
    
    /*
    Should return the employee's ID. The ID should be issued on behalf of the 
    employee at the time they are constructed. The first ever employee should 
    have an ID of "1", the second "2" and so on
    */
    public int getEmployeeID(){
        return employeeID;
    }
    
    /*
    Should return the employee's current salary
    */
    public double getBaseSalary(){
        return baseSalary;
    }
    
    /*
    Should return the employee's current name
    */
    public String getName(){
        return name;
    }
    
    /*
    Should return a reference to the Employee object that represents this 
    employee's manager
    */
    public Employee getManager(){
        return manager;
    }
    
    /*
    Should return true if the two employee IDs are the same, false otherwise
    */
    public boolean equals(Employee other){
        return (this.getEmployeeID()==other.getEmployeeID());
    }
    
    /*
    Should return a String representation of the employee that is a combination 
    of their id followed by their name. Example: "1 Kasey"
    */
    public String toString(){
        String stringConv = "";
        stringConv += Integer.toString(getEmployeeID());
        stringConv += " " + getName();
        return stringConv;
    }
    
    abstract public String employeeStatus();
}
