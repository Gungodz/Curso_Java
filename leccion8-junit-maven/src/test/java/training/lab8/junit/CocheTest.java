package training.lab8.junit;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import training.lab8.junit.Coche;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CocheTest {

	static Coche instance;
	
	public CocheTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeAll
	public static void setUpClass() {
		
		instance = new Coche("Audi A3", 10000);
		Coche.impuesto = 20f;
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	public void setUp(){
		System.out.println("----Comienzo del test----");
	}

	@AfterEach
	public void tearDown(){
		System.out.println("Hora:"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
	}

	@Test
	public void PrecioFinal_1() throws Exception{
		System.out.println("precioFinal_coche con descuento");
		
		float descuento = 10.0F;
		float expResult = 10800;
		float result = instance.precioFinal(descuento);
		
		assertEquals(expResult, result, 0.000001);
		
	}
	
	@Test
	public void PrecioFinal_2 () throws Exception{
		System.out.println("precioFinal_coche barato sin descuento");
		
		float descuento = 10.0F;
		instance.precioBase = 1000f;
		float expResult = 1200;
		float result = instance.precioFinal(descuento);
		
		assertEquals(expResult, result, 0.000001);
		
	}
	
	@Test
	public void PrecioFinal_3() throws Exception{
		System.out.println("precioFinal_coche con descuento incorrecto");
		
		assertThrows(Exception.class, new Executable(){
			float descuento = 110.0F;
			
			@Override
			public void execute() throws Throwable{
				float result = instance.precioFinal(descuento);
			}
		});
	}

}
