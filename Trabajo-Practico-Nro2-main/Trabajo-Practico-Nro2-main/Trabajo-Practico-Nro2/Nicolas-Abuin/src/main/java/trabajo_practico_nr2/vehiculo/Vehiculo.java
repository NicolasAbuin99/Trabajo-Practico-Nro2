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
    public int compareTo(Vehiculo otro){
        int resultadoMarca = this.marca.compareTo(otro.marca);
    
        //  Compara la marca de cada auto, si no son iguales retorna el resultado.
        if (resultadoMarca != 0) {
            return resultadoMarca;
        }
    
        // Si las Marcas son iguales  pasa al siguiente criterio: Modelo.
        int resultadoModelo = this.modelo.compareTo(otro.modelo);

        
        if (resultadoModelo != 0) {
            return resultadoModelo;
        }
    
        // Si Marca y Modelo son iguales, pasa al último criterio: Precio.
        return Double.compare(this.precio, otro.precio);
    }
}
