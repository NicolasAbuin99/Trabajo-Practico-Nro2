package trabajo_practico_nr2.vehiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String marca;
    private String modelo;
    private double precio;

    @Override
    public int compareTo(Vehiculo otro){ //Define el orden natural
        //se usa en los metodo de maximo, minimo y en el  sorted
        // Uso Double.compare para manejar la comparación de double
        return Double.compare(this.precio, otro.precio);
    } //Establece que el orden natural de los vehículos es 
    //de menor a mayor basado en el atributo precio
    //HACER EL compareTo
}
