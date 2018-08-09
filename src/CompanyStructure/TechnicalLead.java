package CompanyStructure;

public class TechnicalLead extends TechnicalEmployee{
    private double baseSalary;
    private int headCount;
    private int directReports=0;
    
    /*
    Should create a new TechnicalLead that is a Manager. The TechnicalLead's 
    base salary should be 1.3 times that of a TechnicalEmployee. TechnicalLeads 
    should have a default head count of 4.
    */
    public TechnicalLead(String aName){
        super(aName);
        baseSalary = calcSalary();
        headCount=4;
    }
    
    private double calcSalary(){
        double aBaseSalary = super.getBaseSalary()*1.3;
        return aBaseSalary;
    }
    
    /*
    Should return true if the number of direct reports this manager has is less 
    than their headcount.
    */
    public boolean hasHeadCount(){
        return (headCount>directReports);
    }
    
    
    /*
    Should accept the reference to a SoftwareEngineer object, and if the 
    TechnicalLead has head count left should add this employee to their list of 
    direct reports. If the employee is successfully added to the TechnicalLead's 
    direct reports true should be returned, false should be returned otherwise    
    */
    public boolean addReport(SoftwareEngineer softwEngin){
        if(headCount!=0){
            directReports+=directReports;
            return true;
        }else{
            return false;
        }
    }
    
    /*
    Should see if the employee passed in does report to this manager and if their 
    code access is currently set to "true". If both those things are true, true is 
    returned, otherwise false is returned
    */
    public boolean approveCheckIn(SoftwareEngineer softwEngin){
        if((softwEngin.getCodeAccess())&&(softwEngin.getSuccessfulCheckIns()!=0)){
            return true;
        }else{
            return false;
        }
    }
    
    /*
    Should check if the bonus amount requested would be approved by the BusinessLead 
    supporting this TechnicalLead. If it is, that employee should get that bonus 
    and true should be returned. False should be returned otherwise
    */
    public boolean requestBonus(Employee empl, double bonus){
        
    }
    
    /*
    Should return a String that gives insight into this Manager and all their 
    direct reports. It should return a string that is a combination of the 
    TechnicalLead's employee status followed by each of their direct employee's 
    status on subsequent lines. If the TechnicalLead has no reports it should 
    print their employee status followed by the text " and no direct reports yet ". 
    Example: "10 Kasey has 5 successful check ins and no direct reports yet". 
    If the TechnicalLead does have reports it might look something like 
    "10 Kasey has 5 successful check ins and is managing: /n 5 Niky has 2 successful check ins"
    */
    public String getTeamStatus(){
        String result = "";
        
        if()
            " and no direct reports yet "
    }
    
    public String employeeStatus(){
        
    }

}
