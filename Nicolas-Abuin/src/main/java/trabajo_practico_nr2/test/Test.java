package trabajo_practico_nr2.test;

import java.util.List;

import trabajo_practico_nr2.interfaz.IConcecionaria;
import trabajo_practico_nr2.metodos.ConcesionariaServicio;
import trabajo_practico_nr2.vehiculo.Vehiculo;

public class Test {
    public static void main(String []args){

        // Instancia del servicio
        IConcecionaria service = new ConcesionariaServicio();
        // Carga la lista de vehículos (Método 6)
        List<Vehiculo> vehiculos = (List<Vehiculo>) service.cargarVehiculos();

        // 1. Listado inicial
        System.out.println();
        vehiculos.forEach(System.out::println); //foreach recorre la list entera
        System.out.println("=============================");

        // 2. Vehículo más caro y más barato
        Vehiculo masCaro = (Vehiculo) service.obtenerVehiculoMasCaro(vehiculos);
        Vehiculo masBarato = (Vehiculo) service.obtenerVehiculoMasBarato(vehiculos);
        
        if (masCaro != null) {
            System.out.println("Vehículo más caro: " + masCaro.getMarca() + " " + masCaro.getModelo());
        }
        if (masBarato != null) {
            System.out.println("Vehículo más barato: " + masBarato.getMarca() + " " + masBarato.getModelo());
        }

        // 3. Búsqueda por letra 'Y'
        Vehiculo encontradoY = (Vehiculo) service.buscarPorLetraEnModelo(vehiculos, "Y");
        if (encontradoY != null) {
            System.out.println("=="); 
            // Usa el toString() corregido para obtener el formato exacto del precio
            String precioFormateado = encontradoY.toString().substring(encontradoY.toString().lastIndexOf(':') + 2);
            System.out.println("Vehículo que contiene en el modelo la letra 'Y': " + 
                               encontradoY.getMarca() + " " + encontradoY.getModelo() + " " + 
                               precioFormateado); 
            System.out.println("=="); 
        }
        System.out.println("=============================");

        // 4. Ordenados por precio (mayor a menor)
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        List<Vehiculo> ordenadoPrecio = (List<Vehiculo>) service.ordenarPorPrecioMayorAMenor(vehiculos);
        ordenadoPrecio.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo()));
        System.out.println();

        // 5. Ordenados por orden natural (Marca, Modelo, Precio)
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
        List<Vehiculo> ordenadoNatural = (List<Vehiculo>) service.ordenarPorOrdenNatural(vehiculos);
        ordenadoNatural.forEach(System.out::println);
    }
}

/*
 * Actúa como un intermediario entre la capa de presentación y la capa de datos/modelos 
 */