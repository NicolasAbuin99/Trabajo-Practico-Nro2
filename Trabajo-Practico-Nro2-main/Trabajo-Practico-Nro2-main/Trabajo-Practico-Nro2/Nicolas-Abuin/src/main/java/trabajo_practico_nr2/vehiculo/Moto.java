package trabajo_practico_nr2.vehiculo;
import lombok.Data;


@Data
public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, double  precio, int cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    

    @Override
    public String toString(){

         String precioFinal = String.format("%,.2f", getPrecio());
        //Toma el numero y lo convierte a string con el formato %,.2f
        
        return "Marca: " + getMarca() + 
               " // Modelo: " + getModelo() + 
               " // Cilindrada: " + this.cilindrada + "c" +
               " // Precio: $" + precioFinal;
    }
}
