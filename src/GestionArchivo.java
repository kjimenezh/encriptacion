
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kevin Jiménez
 */

public class GestionArchivo {
    private String ruta;

    public GestionArchivo(String ruta) {
        this.ruta = ruta;
    }
    
    public Asset cargarAsset(Scanner sc){
        Asset asset = null;
        
        String a = GestionArchivo.desencriptar(sc.next().trim());
        
        switch(a){
            case "CASH":
                Double amount = Double.parseDouble(sc.next().trim());
                asset = new Cash(amount);
                break;
            case "DIVSTOCK":
                String symbol = GestionArchivo.desencriptar(sc.next().trim());
                double totalCost = Double.parseDouble(sc.next().trim());
                double currentPrice = Double.parseDouble(sc.next().trim());
                int totalShares = Integer.parseInt(sc.next().trim());
                double dividends = Double.parseDouble(sc.next().trim());
                asset = new DividendStock(dividends,totalShares,symbol,totalCost,currentPrice);
                break;
            case "STOCK":
                String symbolS = GestionArchivo.desencriptar(sc.next().trim());
                double totalCostS = Double.parseDouble(sc.next().trim());
                double currentPriceS = Double.parseDouble(sc.next().trim());
                int totalSharesS = Integer.parseInt(sc.next().trim());
                asset = new Stock(totalSharesS,symbolS,totalCostS,currentPriceS);
                break;
        }
        return asset;
    }
    
    public ArrayList<Asset> cargarAssets() throws FileNotFoundException{
        ArrayList<Asset> data = new ArrayList<>();
        Scanner lectura = null;
        
        try{
            lectura = new Scanner(new File(this.ruta));
            lectura.useDelimiter(",");
            while(lectura.hasNext()){
                data.add(cargarAsset(lectura));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        lectura.close();
        return data;
    }
    
    public static String desencriptar(String cadena){
        String desencriptacion = "";
        int nd = 0;
        for(int i = 0; i<cadena.length(); i++){
            char c = cadena.charAt(i);
            int n = GestionArchivo.numLetra(c);
            if((n-7)>=0){
                nd = (n-7)%26;
            }else{
                nd = 26+((n-7)%26);
            }
            char cd = GestionArchivo.letraNum(nd);
            desencriptacion = desencriptacion + cd;
        }
        return desencriptacion;
    }
    
    public static int numLetra(char c){
        switch(c){
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            case 'K':
                return 10;
            case 'L':
                return 11;
            case 'M':
                return 12;
            case 'N':
                return 13;
            case 'O':
                return 14;
            case 'P':
                return 15;
            case 'Q':
                return 16;
            case 'R':
                return 17;
            case 'S':
                return 18;
            case 'T':
                return 19;
            case 'U':
                return 20;
            case 'V': 
                return 21;
            case 'W':
                return 22;
            case 'X':
                return 23;
            case 'Y':
                return 24;
            case 'Z':
                return 25;
        }
        return 0;
    }
    
    public static char letraNum(int a){
        switch(a){
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            case 9:
                return 'J';
            case 10:
                return 'K';
            case 11:
                return 'L';
            case 12:
                return 'M';
            case 13:
                return 'N';
            case 14:
                return 'O';
            case 15:
                return 'P';
            case 16:
                return 'Q';
            case 17:
                return 'R';
            case 18:
                return 'S';
            case 19:
                return 'T';
            case 20:
                return 'U';
            case 21: 
                return 'V';
            case 22:
                return 'W';
            case 23:
                return 'X';
            case 24:
                return 'Y';
            case 25:
                return 'Z';
        }
        return ' ';
    }
}
