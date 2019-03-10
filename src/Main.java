
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kevin Jiménez
 */

public class Main {
    private static ArrayList<Asset> assets;
    
    public static void getMarketTotalValueStockyDividendStock(){
        double markettotalvalue = 0;
        for(Asset asset : assets){
            if(asset instanceof Stock){
                Stock stock = (Stock) asset;
                if((stock.getSymbol().equals("GOOGLE"))||(stock.getSymbol().equals("SAMSUNG"))){
                    if(stock instanceof DividendStock){
                        DividendStock dividendStock = (DividendStock) asset;
                        markettotalvalue += dividendStock.getMarketValue();
                    }else{
                        markettotalvalue += stock.getMarketValue();
                    }
                }
            }
        }
        
        System.out.println("\nEl valor total del mercado para activos tipo Stock y DividendStock es: "+markettotalvalue);
    }
    
    public static double getAllMarketValue(){
        double marketvalue = 0;
        for(Asset asset : assets){
            marketvalue += asset.getMarketValue();
        }
        return marketvalue;
    }
    
    public static double getAllProfit(){
        double profit = 0;
        for(Asset asset : assets){
            profit += asset.getProfit();
        }
        return profit;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        GestionArchivo archivo = new GestionArchivo("datos.txt");
        
        assets = archivo.cargarAssets();

        for(Asset asset : assets){
            if(asset instanceof Cash){
                Cash cash = (Cash) asset;
                cash.darInformacion();
            }
            if(asset instanceof Stock){
                Stock stock = (Stock) asset;
                if(stock instanceof DividendStock){
                    DividendStock dividendStock = (DividendStock) asset;
                    dividendStock.darInformacion();
                }else{
                    stock.darInformacion();
                }
            }
        }
        
        getMarketTotalValueStockyDividendStock();
        
        System.out.println("\nEl valor total del mercado es : "+getAllMarketValue());
        System.out.println("\nEl beneficio total obtenido es : "+getAllProfit());
        
        /*
        Company GestionSAS = new Company("Gestora de Activos SAS");
        
        System.out.println("Gestora de Activos SAS");
        
        int i=0;
        Scanner lectura = new Scanner (System.in);
        
        do{
            System.out.println("\n1.Adicionar cliente");
            System.out.println("2.Adicionar activo a cliente");
            System.out.println("3.Conocer valor total en el mercado de todos los activos gestionados");
            System.out.println("4.Conocer por tipo de activo el valor en el mercado y el beneficio total");
            System.out.println("5.Conocer beneficio total obtenido");
            System.out.println("6.Conocer por rango de edades el valor en el mercado y el beneficio total");
            System.out.println("7.Conocer cliente que tiene mayores beneficios");
            System.out.println("8.Listar clientes con valor en el mercado de los activos ordenados de manera descendente");
            System.out.println("\nPor favor digite el número de la opción que desea elegir");
            
            i = lectura.nextInt();
            
            switch(i){
                case 1:
                    System.out.println("\nDigite la identificación del cliente: ");
                    int id = lectura.nextInt();
                    System.out.println("\nDigite el nombre del cliente: ");
                    String name = lectura.next();
                    System.out.println("\nDigite el apellido del cliente: ");
                    String lastname = lectura.next();
                    System.out.println("\nDigite el email del cliente: ");
                    String email = lectura.next();
                    System.out.println("\nDigite la edad del cliente: ");
                    int edad = lectura.nextInt();
                    
                    if(GestionSAS.addClient(id, name, lastname, email, edad)){
                        System.out.println("El cliente se adiciono exitosamente");
                    }else{
                        System.out.println("Ocurrio un error");
                    }
                    break;
                case 2:
                    System.out.println("\nTipos de activo");
                    System.out.println("1.Stock");
                    System.out.println("2.MutualFund");
                    System.out.println("3.DividendStock");
                    System.out.println("4.Cash");
                    System.out.println("\nSeleccione el tipo de activo va a adicionarle al cliente");
                    
                    int j = lectura.nextInt();
                    
                    switch(j){
                        case 1:
                            System.out.println("Digite total shares: ");
                            int totalshare = lectura.nextInt();
                            System.out.println("Digite symbol: ");
                            String symbol = lectura.next();
                            System.out.println("Digite total cost: ");
                            double totalcost = lectura.nextDouble();
                            System.out.println("Digite current price: ");
                            double currentprice = lectura.nextDouble();
                            
                            if(GestionSAS.addAssetStock(totalshare, symbol, totalcost, currentprice)){
                                System.out.println("El activo se adiciono al cliente exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            break;
                        case 2:
                            System.out.println("Digite total shares: ");
                            double totalshareM = lectura.nextDouble();
                            System.out.println("Digite symbol: ");
                            String symbolM = lectura.next();
                            System.out.println("Digite total cost: ");
                            double totalcostM = lectura.nextDouble();
                            System.out.println("Digite current price: ");
                            double currentpriceM = lectura.nextDouble();
                            
                            if(GestionSAS.addAssetMutualFund(totalshareM, symbolM, totalcostM, currentpriceM)){
                                System.out.println("El activo se adiciono al cliente exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            break;
                        case 3:
                            System.out.println("Digite dividends: ");
                            double dividends = lectura.nextDouble();
                            System.out.println("Digite total shares: ");
                            int totalshareD = lectura.nextInt();
                            System.out.println("Digite symbol: ");
                            String symbolD = lectura.next();
                            System.out.println("Digite total cost: ");
                            double totalcostD = lectura.nextDouble();
                            System.out.println("Digite current price: ");
                            double currentpriceD = lectura.nextDouble();
                            
                            if(GestionSAS.addAssetDividendStock(dividends,totalshareD, symbolD, totalcostD, currentpriceD)){
                                System.out.println("El activo se adiciono al cliente exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            break;
                        case 4:
                            System.out.println("Digite amount: ");
                            double amount = lectura.nextDouble();
                            
                            if(GestionSAS.addAssetCash(amount)){
                                System.out.println("El activo se adiciono al cliente exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            break;
                    }
                    break;
                case 3:
            }
             
            
        }while((i>0)&&(i<9));*/
    }
}
