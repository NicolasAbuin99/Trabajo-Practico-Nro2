package trabajo_practico_nr2.test;

import java.util.List;

import trabajo_practico_nr2.interfaz.IConcecionaria;
import trabajo_practico_nr2.metodos.ConcesionariaServicio;
import trabajo_practico_nr2.vehiculo.Vehiculo;

public class Test {
    public static void main(String []args){

        // Instancia del servicio
        ConcesionariaServicio service = new ConcesionariaServicio();
        // Carga la lista de vehículos
        List<Vehiculo> vehiculos = service.cargarVehiculos();

        // Listado inicial
        System.out.println();
        vehiculos.forEach(System.out::println); //foreach recorre la list entera
        System.out.println("=============================");

        // Vehículo más caro y más barato
        Vehiculo masCaro = service.obtenerVehiculoMasCaro(List<Vehiculo> vehiculos);
        Vehiculo masBarato = service.obtenerVehiculoMasBarato(List<Vehiculo> vehiculos);
        
        if (masCaro != null) {
            System.out.println("Vehículo más caro: " + masCaro.getMarca() + " " + masCaro.getModelo());
        }
        if (masBarato != null) {
            System.out.println("Vehículo más barato: " + masBarato.getMarca() + " " + masBarato.getModelo());
        }

        // Búsqueda por letra 'Y'
        Vehiculo encontradoY = service.buscarPorLetraEnModelo(List<Vehiculo> vehiculos,"Y");
        if (encontradoY != null) {
            System.out.println("Vehículo que contiene en el modelo la letra 'Y': " + 
                               encontradoY.getMarca() + " " + encontradoY.getModelo() + " $" + 
                               String.format("%,.2f",encontradoY.getPrecio())); 
             
        }
        System.out.println("=============================");

        // Ordenados por precio (mayor a menor)
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        List<Vehiculo> ordenadoPrecio = service.ordenarPorPrecioMayorAMenor(List<Vehiculo> vehiculos);
        ordenadoPrecio.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo()));
        System.out.println();
    }
}