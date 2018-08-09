package CompanyStructure;

public class Accountant extends BusinessEmployee{
    private BusinessEmployee BusiEmpl;
            
/*
Should start with a bonus budget of 0 and no team they are officially supporting
*/
    public Accountant(String aName){
        super(aName);
        BusiEmpl.getBonusBudget=0;
        
    }
}
