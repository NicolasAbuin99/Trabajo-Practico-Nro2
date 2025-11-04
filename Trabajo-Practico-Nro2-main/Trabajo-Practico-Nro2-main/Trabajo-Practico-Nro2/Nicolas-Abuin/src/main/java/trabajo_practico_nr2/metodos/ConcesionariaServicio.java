package trabajo_practico_nr2.metodos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import trabajo_practico_nr2.interfaz.IConcecionaria;
import trabajo_practico_nr2.vehiculo.Coche;
import trabajo_practico_nr2.vehiculo.Moto;
import trabajo_practico_nr2.vehiculo.Vehiculo;

public class ConcesionariaServicio implements IConcecionaria {

    @Override
    public List<Vehiculo> cargarVehiculos(){
        List<Vehiculo> lista = new ArrayList<>();
        // Carga de datos exacta requerida en la salida
        lista.add(new Coche("Peugeot", "206", 200000.00, 4));
        lista.add(new Moto("Honda", "Titan", 60000.00, 125));
        lista.add(new Coche("Peugeot", "208", 250000.00, 5));
        lista.add(new Moto("Yamaha", "YBR", 80500.50, 160));
        return lista;
    }

    @Override
    public Vehiculo obtenerVehiculoMasCaro(List<Vehiculo> vehiculos) {
        //ordena la lista del mas caro hacia el mas barato
        return vehiculos.stream()//Convierte la lista de vehículos en un flujo de datos
                .max(Comparator.comparingDouble(Vehiculo::getPrecio)) //busca el maximo
                .orElse(null);//si la lista esta vacia devuelve un null
    }

    @Override
    public Vehiculo obtenerVehiculoMasBarato(List<Vehiculo> vehiculos) {
        //al reves
        return vehiculos.stream() //Convierte la lista de vehículos en un flujo de datos
                .min(Comparator.comparingDouble(Vehiculo::getPrecio)) //busca el minimo
                .orElse(null); //si la lista esta vacia devuelve un null
    }

    @Override
    public Vehiculo buscarPorLetraEnModelo(List<Vehiculo> vehiculos,String letra) {
        //lo que hace es buscar con vehiculo y el filtro de busqueda es que inicie con la letra Y
        return vehiculos.stream()
                .filter(v -> v.getModelo().toUpperCase().contains(letra.toUpperCase()))
                //es como un filtro solo deja pasar los vehículos (v) cuyo modelo 
                //(getModelo()) contenga la letra de búsqueda. 
                //Convierte ambos a mayúsculas (toUpperCase()) para que la búsqueda no distinga entre mayúsculas y minúsculas
                //va dentro del contains para que convierta a mayuscula la letra
                .findFirst() //Una vez que encuentra el primer modelo que empieza con la letra
                .orElse(null);
    }

    @Override
    public List<Vehiculo> ordenarPorPrecioMayorAMenor(List<Vehiculo> vehiculos) {
        //ordena la lista del mas caro al mas barato
        return vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio)//Me permite ordenar cada vehiculo con su precio
                .reversed()) //comparamos los precios y devuelve del mas barato al mas caro
                .toList(); //Devuelve una nueva lista que tiene todos los vehiculos ordenados por su precio
                
    }

    @Override
    public List<Vehiculo> ordenarPorOrdenNatural(List<Vehiculo> vehiculos) {
        //ordena de forma natural
        return vehiculos.stream()
                .sorted() //me permite ordenar los vehiculos y como no le paso ningun argumetno busca automaticamente el compareTo de mi clase Vehiculo
                .toList(); //Devuelve una nueva lista que tiene todos los vehiculos ordenados en orden natural
                
    }

}
