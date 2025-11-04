package trabajo_practico_nr2.vehiculo;
import lombok.Data;

@Data
public class Coche extends Vehiculo  {
    private int puertas;

    public Coche(String marca, String modelo, double precio, int puertas) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }


    @Override
    public String toString(){
        
        String precioFinal = String.format("%,.2f", getPrecio());
        //Toma el numero y lo convierte a string con el formato %,.2f
       
        //Realiza tres reemplazos para intercambiar la coma y el punto de lugar
        return "Marca: " + getMarca() + 
               " // Modelo: " + getModelo() + 
               " // Puertas: " + this.puertas + 
               " // Precio:  $" + precioFinal;
    }
}
