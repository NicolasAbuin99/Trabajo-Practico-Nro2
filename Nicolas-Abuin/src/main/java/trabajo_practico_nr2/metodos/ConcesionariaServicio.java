package trabajo_practico_nr2.metodos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import trabajo_practico_nr2.interfaz.IConcecionaria;
import trabajo_practico_nr2.vehiculo.Coche;
import trabajo_practico_nr2.vehiculo.Moto;
import trabajo_practico_nr2.vehiculo.Vehiculo;

public class ConcesionariaServicio implements IConcecionaria {

    @Override
    public List<Vehiculo> cargarVehiculos(){
        List<Vehiculo> lista = new ArrayList<>(); // Uso del framework Collections
        // Carga de datos exacta requerida en la salida
        lista.add(new Coche("Peugeot", "206", 200000.00, 4));
        lista.add(new Moto("Honda", "Titan", 60000.00, 125));
        lista.add(new Coche("Peugeot", "208", 250000.00, 5));
        lista.add(new Moto("Yamaha", "YBR", 80500.50, 160));
        return lista;
    }

    @Override
    public Vehiculo obtenerVehiculoMasCaro(List<Vehiculo> vehiculos) {
        // Usa Comparable<Vehiculo> implementado en Vehiculo
        //ordena la lista del mas caro hacia el mas barato
        return vehiculos.stream()//Convierte la lista de vehículos en un flujo de datos
                .max(Comparator.naturalOrder()) //busca el maximo
                .orElse(null);//si la lista esta vacia devuelve un null
    }

    @Override
    public Vehiculo obtenerVehiculoMasBarato(List<Vehiculo> vehiculos) {
        //al reves
        return vehiculos.stream() //Convierte la lista de vehículos en un flujo de datos
                .min(Comparator.naturalOrder()) //busca el minimo
                .orElse(null); //si la lista esta vacia devuelve un null
    }

    @Override
    public Vehiculo buscarPorLetraEnModelo(List<Vehiculo> vehiculos, String letra) {
        //lo que hace es buscar con vehiculo y el filtro de busqueda es que inicie con la letra Y
        return vehiculos.stream()
                .filter(v -> v.getModelo().toUpperCase().contains(letra.toUpperCase())) 
                //es como un filtro solo deja pasar los vehículos (v) cuyo modelo 
                //(getModelo()) contenga la letra de búsqueda. 
                //Convierte ambos a mayúsculas (toUpperCase()) para que la búsqueda no distinga entre mayúsculas y minúsculas
                .findFirst() 
                .orElse(null);
    }

    @Override
    public List<Vehiculo> ordenarPorPrecioMayorAMenor(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                // Inversión del orden natural (Comparable) para mayor a menor precio
                .sorted(Comparator.reverseOrder()) //invierte el orden natural
                .collect(Collectors.toList());
    }

    public List<Vehiculo> ordenarPorOrdenNatural(List<Vehiculo> vehiculos) {
        // Ordena por los 3 campos tal como se muestra en la salida final
        return vehiculos.stream()
                .sorted(Comparator //ordena por 3 campos
                    .comparing(Vehiculo::getMarca) //primero por marca
                    .thenComparing(Vehiculo::getModelo) //si la marca son iguales lo hace por modelo
                    .thenComparing(Vehiculo::getPrecio) //si marca y modelo son iguales lo hace por $
                )
                .collect(Collectors.toList()); //devuelve la lista
    }


}

/*
 * Es una secuencia de elementos que te permite realizar operaciones funcionales
 *  sobre colecciones (como tus listas de vehículos) 
 * de una manera declarativa, más legible y a menudo más eficiente que usar los bucles tradicionales
 */
