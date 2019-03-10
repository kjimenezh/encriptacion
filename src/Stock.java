

/**
 *
 * @author Estudiante
 */

public class Stock extends ShareAsset{
    protected int totalShares;

    public Stock(int totalShares, String symbol, double totalCost, double currentPrice) {
        super(symbol, totalCost, currentPrice);
        this.totalShares = totalShares;
    }
    
    @Override
    public double getMarketValue() {
        return this.totalShares*this.currentPrice;
    }

    @Override
    public double getProfit() {
        return (this.totalShares*this.currentPrice)-this.totalCost;
    }
    
    @Override
    public void darInformacion(){
        System.out.println("STOCK: ");
        System.out.println("symbol: "+this.symbol);
        System.out.println("totalCost: "+this.totalCost);
        System.out.println("currentPrice: "+this.currentPrice);
        System.out.println("totalShares: "+this.totalShares);
    }
}
