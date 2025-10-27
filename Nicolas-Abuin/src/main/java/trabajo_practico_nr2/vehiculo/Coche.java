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
        return "Marca: " + getMarca() + 
               " // Modelo: " + getModelo() + 
               " // Puertas: " + this.puertas + 
               " // Precio: " + Unidades.formatearPrecio(getPrecio());
    }
}
