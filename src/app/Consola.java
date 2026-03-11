package app;

import java.util.Scanner;

public class Consola implements IEntradaSalida {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void imprimir(String texto) {

	System.out.print(texto);
    }

    @Override
    public void imprimirLinea(String texto) {
	System.out.println(texto);

    }

    @Override
    public String leerTexto(String mensaje) {

	return sc.nextLine();
    }

    @Override
    public int leerEntero(String mensaje) {

	return sc.nextInt();

    }

    @Override
    public Double leerImporte(String mensaje) {

	return sc.nextDouble();
    }

    @Override
    public void mostrarMenu() {
	System.out.println("1 - Contratar empleado" + "\n2 - Listar todos los empleados"
		+ "\n3 - Listar empleados con filtro" + "\n4 - Salir");
    }

    @Override
    public void limpiarPantalla() {

    }

    @Override
    public void pausa() {

    }

}
