

/**
 *
 * @author Estudiante
 */

public class Cash implements Asset {
    private double amount;

    public Cash(double amount) {
        this.amount = amount;
    }
    
    @Override 
    public double getMarketValue(){
        return this.amount;
    }
    
    @Override
    public double getProfit(){
        return 0;
    }
    
    @Override
    public void darInformacion(){
        System.out.println("CASH: ");
        System.out.println("amount: " +this.amount);
    }

}
