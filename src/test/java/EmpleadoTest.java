import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmpleadoTest {
	
	static double anual, mensual;
	static String nombre;
	private Empleado empleado;		
	
	public EmpleadoTest() {
		this.empleado = new Empleado("Juan", 2000);
	}
	
	@BeforeAll
	static void iniciar() {
		System.out.println("Antes de ejecutar el conjunto de unidades de pruebas");
		anual = 24000;
		mensual = 2000;
		nombre = "Ana";	
	}
	
	@AfterAll
	static void terminar() {
		System.out.println("Después de ejecutar el conjunto de unidades de prueba");
		anual = 0;
		mensual = 0;
		nombre = null;
	}
	
	@Test
    @DisplayName("Unidad de prueba: Get y set nombre")
    void testGetYSetNombre() {    	
    	this.empleado.setNombre(nombre);    	
    	assertEquals(nombre, this.empleado.getNombre());
    }
	
	@Test
    @DisplayName("Unidad de prueba: Get y set nombre")
    void testGetYSetSalarioMensual() {    	
    	this.empleado.setSalarioMensual(mensual);    	
    	assertEquals(mensual, this.empleado.getSalarioMensual());
    }
	
    @Test
    @DisplayName("Unidad de Prueba: calcular salario anual")
    void testCalcularSalarioAnual() {    	    	        
    	assertEquals(anual, this.empleado.calcularSalarioAnual());
    }

    @Test
    @DisplayName("Unidad de Prueba: aplicar bono")
    void testAplicarBono() {
    	double importeConBono = 25200; // 24000 + 5% = 25200
        assertEquals(importeConBono, empleado.aplicarBono(5)); 
    }

    @Test
    @DisplayName("Unidad de Prueba: aplicar bono negativo")
    void testAplicarBonoNegativo() {     
        assertThrows(IllegalArgumentException.class, () -> empleado.aplicarBono(-5));
    }
    
    @Test
    @DisplayName("Unidad de prueba: Agrupar aserciones")
    void testAgruparAserciones() {
    	assertAll(
    			() -> assertEquals(24000, this.empleado.calcularSalarioAnual()),
    			() -> assertEquals(25200, this.empleado.aplicarBono(5)),
    			() -> assertThrows(IllegalArgumentException.class, () -> empleado.aplicarBono(-5))
    		);
    }        
}
