package app;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {

    private List<Empleado> empleados;

    public Plantilla() {

    }

    public void agregarEmpleado(Empleado empleado) {
	empleados.add(empleado);
    }

    public List<Empleado> getEmpleadosPorNombre(String filtroNombre) {
	List<Empleado> filtrado = new ArrayList<Empleado>();

	if (filtroNombre.isEmpty()) {
	    return empleados;
	}

	for (Empleado empleado : filtrado) {
	    if (empleado.getNombre().equalsIgnoreCase(filtroNombre)
		    || empleado.getApellidos().equalsIgnoreCase(filtroNombre)) {
		filtrado.add(empleado);
	    }
	}
	return filtrado;
    }

}
