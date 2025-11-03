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

         String precioSinSigno = String.format("%,.2f", getPrecio());
        //Toma el numero y lo convierte a string con el formato %,.2f
        String precioFinal = precioSinSigno.replace(',', 'X').replace('.', ',').replace('X', '.');
        //Realiza tres reemplazos para intercambiar la coma y el punto de lugar

        return "Marca: " + getMarca() + 
               " // Modelo: " + getModelo() + 
               " // Cilindrada: " + this.cilindrada + "c" +
               " // Precio: $" + precioFinal;
    }
}
