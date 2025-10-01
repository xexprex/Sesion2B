package EmpleadoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Sesion2B.Empleado;
import Sesion2B.Empleado.TipoEmpleado;

class EmpleadoTest {

	private final Empleado emp = new Empleado();
	
	//Test para Nomina Bruta
	//Lo hago parametizado para ahorrar lineas de codigo.
    @ParameterizedTest
    @CsvSource({
        // tipo, 	ventas, 	horas, 	esperado
        "Vendedor, 	0, 			0, 		2000",
        "Vendedor, 	999, 		0, 		2000",
        "Vendedor, 	1000, 		0, 		2100",
        "Vendedor, 	1499, 		0,		2100",
        "Vendedor, 	1500, 		0, 		2200",
        "Vendedor, 	1500, 		2, 		2260",
        "Encargado, 0, 			0, 		2500",
        "Encargado, 999, 		0, 		2500",
        "Encargado, 1000,		0, 		2600",
        "Encargado, 1499, 		0, 		2600",
        "Encargado, 1500, 		0, 		2700",
        "Encargado, 1500, 		1, 		2730",
        "Encargado, 2000, 		5, 		2850"
    })
    public void testCalculoNominaBruta(TipoEmpleado tipo, float ventas, float horas, float esperado) {
        assertEquals(esperado, emp.caculoNominaBruta(tipo, ventas, horas), 0.01);
    }
    
    //Test nomina neta
    @ParameterizedTest
    @CsvSource({
    	//NominaBruta , Esperado
        "2099.99, 		2099.99",
        "2100, 			1785",
        "2200, 			1870",
        "2499.99, 		2124.99",
        "2500, 		2050",
        "3000, 			2460",
        "4000, 			3280"
    })
    public void testCalculoNominaNeta(float bruto, float esperado) {
        assertEquals(esperado, emp.calculoNominaNeta(bruto), 0.01);
    }
}
