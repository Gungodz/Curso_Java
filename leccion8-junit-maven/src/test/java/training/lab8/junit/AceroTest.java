package training.lab8.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import training.lab8.ej1.Acero;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AceroTest {
	
	static Acero instance;
	
	public AceroTest() {
		// TODO Auto-generated constructor stub
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		instance = new Acero("Acero 1", 10, 90);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("*Test Metodo Acero Fin*");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("*Test Metodo Acero Inicio*");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Hora:"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
	}

	@Test
	public void test1() {
		System.out.println("Test 1 sin modificaciones");
		String expected = "Acero Duro";
		String result = instance.clasificacionAcero();
		System.out.println(result);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void test2(){
		System.out.println("Test 2 con modificaciones");
		String expected = "Acero Dulce";
		instance.setKGCarbono(195.46);
		instance.setKgHierro(451.35);
		String result = instance.clasificacionAcero();
		System.out.println(result);
		
		assertEquals(expected, result);
	}

}
