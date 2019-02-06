

/**
 * @author Estudiante
 */

public class Client {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private Asset[] assets;
    private int edad;

    public Client(int id, String name, String lastName, String email, int edad) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.assets = new Asset[10];
        this.edad = edad;
    }
    
    //Método para anadir activo a cliente
    public boolean addAsset(Asset asset){
        for(int i=0;i<this.assets.length;i++){
            if(this.assets[i]==null){
                this.assets[i]=asset;
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Asset[] getAssets() {
        return assets;
    }

    public int getEdad() {
        return edad;
    }
 
}
