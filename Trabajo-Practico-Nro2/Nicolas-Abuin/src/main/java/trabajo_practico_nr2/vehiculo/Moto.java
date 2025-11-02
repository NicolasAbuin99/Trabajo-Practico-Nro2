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
        return "Marca: " + getMarca() + 
               " // Modelo: " + getModelo() + 
               " // Cilindrada: " + this.cilindrada + "c" +
               " // Precio: " + getPrecio();
    }
}
