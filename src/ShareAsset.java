

/**
 *
 * @author Estudiante
 */
public abstract class ShareAsset implements Asset{
    protected String symbol;
    protected double totalCost;
    protected double currentPrice;
    
    public ShareAsset(String symbol, double totalCost, double currentPrice){
        this.symbol=symbol;
        this.totalCost=totalCost;
        this.currentPrice=currentPrice;
    }
    
    //No implemento getProfit porque no tengo los datos para hacerlo, por lo que los hijos tienen que implementarlo

    public String getSymbol() {
        return symbol;
    }
}
