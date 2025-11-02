package trabajo_practico_nr2.interfaz;

import java.util.List;

import trabajo_practico_nr2.vehiculo.Vehiculo;

//las interfaces son como contratos, si las vinculo a una clase x todos los metodods
//de esa interfaz se deben implementar si o si
public interface IConcecionaria {
    // Búsqueda del vehículo más caro
    Vehiculo obtenerVehiculoMasCaro(List<Vehiculo> vehiculos);

    // Búsqueda del vehículo más barato
    Vehiculo obtenerVehiculoMasBarato(List<Vehiculo> vehiculos);

    //  Búsqueda por patrón en el modelo
    Vehiculo buscarPorLetraEnModelo(List<Vehiculo> vehiculos,String letra);

    // Ordenamiento por precio (mayor a menor)
    List<Vehiculo> ordenarPorPrecioMayorAMenor(List<Vehiculo> vehiculos);
    
    //  Carga de la lista (Requisito: se debe cargar en un único método)
    List<Vehiculo> cargarVehiculos();
}
