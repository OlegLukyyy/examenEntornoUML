package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorEmpleados {
    private Plantilla plantilla;
    private IEntradaSalida consola;

    public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {

	this.plantilla = plantilla;
	this.consola = consola;

    }

    public void ejecutar() {
	boolean running = true;

	while (running) {

	    consola.mostrarMenu();
	    int opcion = consola.leerEntero("Seleccione una opción:");
	    switch (opcion) {
	    case 1 -> contratarEmpleado();
	    case 2 -> listarTodos();
	    case 3 -> listarPorFiltro();
	    case 4 -> {
		consola.imprimir("Deteniendo...");
		running = false;
	    }
	    default -> consola.imprimirLinea("Opcion no valida");
	    }
	}
    }

    private void contratarEmpleado() {

	int tipo = consola.leerEntero("1 - Técnico\n2 - Comercial");

	String dni = consola.leerTexto("Introduce los DNI");
	String nombre = consola.leerTexto("Introduce el nombre");
	String apellidos = consola.leerTexto("Introduce los apellidos");
	double sueldoBase = consola.leerImporte("Introduce el sueldoBase (separando la parte decimal con \",\")");

	switch (tipo) {
	case 1 -> {
	    int categoria = consola.leerEntero("Introduce categoria");
	    plantilla.agregarEmpleado(new Tecnico(dni, nombre, apellidos, sueldoBase, categoria));
	}
	case 2 -> plantilla.agregarEmpleado(new Comercial(dni, nombre, apellidos, sueldoBase));
	default -> consola.imprimirLinea("Opcion no valida");
	}
    }

    private void listarTodos() {
	listarEmpleados(plantilla.getEmpleadosPorNombre(""));
    }

    private void listarPorFiltro() {
	String filtro = consola.leerTexto("Introduce el nombre o apellidos del empleado");
	listarEmpleados(plantilla.getEmpleadosPorNombre(filtro));
    }

    private void listarEmpleados(List<Empleado> empleados) {
	ordenarPorNombre(empleados);
	for (Empleado empleado : empleados) {
	    consola.imprimirLinea("N " + empleado.getNombre() + " Apellidos: " + empleado.getApellidos() + " Sueldo "
		    + empleado.getSueldo() + "€");
	}
    }

    private void ordenarPorNombre(List<Empleado> empleados) {
	Collections.sort(empleados, Comparator.comparing(Empleado::getNombre));
    }

}
