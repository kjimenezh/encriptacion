

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Estudiante
 */

public class Company {
    private String name;
    private HashMap<Integer,Client> clientes;
    private ArrayList<Asset> activos;
     
    public Company(String name){
        this.name=name;
        this.clientes = new HashMap<>();
        this.activos = new ArrayList<>();
    }
    
    //Para añadir cliente. "Retorna verdadero porque si el espacio de memoria estaba en null si se pudo insertar objeto"
    public boolean addClient(int id, String name, String lastName, String email, int edad){
        return this.clientes.put(id, new Client(id, name, lastName, email, edad)) == null;
    }
    
    //Métodos para añadir activos
    public boolean addAssetStock(int totalShares, String symbol, double totalCost, double currentPrice){
        return this.activos.add(new Stock(totalShares, symbol, totalCost, currentPrice));
    }
    
    public boolean addAssetMutualFund(double totalShares, String symbol, double totalCost, double currentPrice){
        return this.activos.add(new MutualFund(totalShares, symbol, totalCost, currentPrice));
    }
    
    public boolean addAssetDividendStock(double dividends, int totalShares, String symbol, double totalCost, double currentPrice){
        return this.activos.add(new DividendStock(dividends, totalShares, symbol, totalCost, currentPrice));
    }
    
    public boolean addAssetCash(double amount){
        return this.activos.add(new Cash(amount));
    }
    
    //Método para añadir activo a cliente
    public boolean addAssettoClient(int pos, int id){
        return this.clientes.get(id).addAsset(this.activos.get(pos));
    }
    
    //Valor total del mercado
    public double getAllMarketValue(){
        double marketvalue = 0;
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                marketvalue+=asset.getMarketValue();
            }
        }
        return marketvalue;
    }
    
    //Obtener valor del mercado y beneficio total obtenido para un tipo de activo
    public void getMarketValueandProfitofAsset(int pos){
        System.out.println("El valor del mercado del activo es: "+this.activos.get(pos).getMarketValue());
        System.out.println("El beneficio del activo es: "+this.activos.get(pos).getProfit());
    }
    
    //Beneficio total obtenido
    public double getAllProfit(){
        double profit = 0;
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                profit+=asset.getProfit();
            }
        }
        return profit;
    }
    
    //Hacer método rango de edades...
    public void Agerange(){
        
        int edad = 0;
        double marketvaluea = 0;
        double marketvalueb = 0;
        double marketvaluec = 0;
        double profita = 0;
        double profitb = 0;
        double profitc = 0;

        for(Client client : clientes.values()){
            edad = client.getEdad();
            if((0<edad)&&(edad<=20)){
                for(Asset asset : client.getAssets()){
                    marketvaluea+=asset.getMarketValue();
                    profita+=asset.getProfit();
                }
            }
            if((20<edad)&&(edad<=40)){
                for(Asset asset : client.getAssets()){
                marketvalueb+=asset.getMarketValue();
                profitb+=asset.getProfit();
                }
            }
            if(edad>40){
                for(Asset asset : client.getAssets()){
                    marketvaluec+=asset.getMarketValue();
                    profitc+=asset.getProfit();
                }
            }
        }
        
        System.out.println("Rango de edad: 0-20 años");
        System.out.println("/nValor en el mercado: "+marketvaluea);
        System.out.println("/nBeneficio total: "+profita);
        System.out.println("Rango de edad: 21-40 años");
        System.out.println("/nValor en el mercado: "+marketvalueb);
        System.out.println("/nBeneficio total: "+profitb);
        System.out.println("Rango de edad: 41 o más años");
        System.out.println("/nValor en el mercado: "+marketvaluec);
        System.out.println("/nBeneficio total: "+profitc);
    }
    //Hacer método para conocer cliente mayores beneficios...
    
    public void ClientMoreProfit(){
        ArrayList<Double> profits = new ArrayList();
        double profit = 0;
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                profit+=asset.getProfit();
            }
            profits.add(profit);
            profit = 0;
        }
        double 
        for(int i=0;i<profits.size();i++){
            if(profits.get(i)>profits.get(i+1)){
                
            }
        }
    }
    //Hacer método para listado de clientes con valor en el mercado de los activo...
    
    
    //Para acceder a un método particular de un hijo que desconoce el padre...
    public void Instanceof(){
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                if(asset instanceof DividendStock){
                   DividendStock d =(DividendStock)asset;
                   d.add();
                }
            }
        }
    }
}
