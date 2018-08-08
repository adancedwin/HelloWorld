package CompanyStructure;

public class SoftwareEngineer extends Employee{
    private TechnicalLead managerSW;
    private boolean codeAccess;
    private int checkIns;
    
    public SoftwareEngineer(String name){
        super(name, 0);
        checkIns=0;
        codeAccess=false;
    }
    
    public boolean getCodeAccess(){
        return codeAccess;
    }
    
    public void setCodeAccess(boolean access){
        codeAccess=access;
    }
    
    public int getSuccessfulCheckIns(){
        return checkIns;
    }
    
    public boolean checkInCode(){
        
    }
}
