

/**
 *
 * @author Estudiante
 */

public class DividendStock extends Stock{
    private double dividends;

    public DividendStock(double dividends, int totalShares, String symbol, double totalCost, double currentPrice) {
        super(totalShares, symbol, totalCost, currentPrice);//importante orden en que se pasan los parametros dependiendo del constructor del padre
        this.dividends = dividends;
    }
    
    @Override
    
    public double getMarketValue(){
       return (this.totalShares*this.currentPrice)+this.dividends; 
    }
    
    public void add(){};
}
