package PaqueteSistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ISistemaTest {

	private ISistema sis;
	private Retorno r;
	
	@Before
	public void setUp() throws Exception {
		sis = new Sistema();
	}

	@Test
	public void testInicializarSistema() {
		assertEquals(Retorno.Resultado.ERROR_1, sis.inicializarSistema(-10).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.inicializarSistema(-1).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.inicializarSistema(0).resultado);
		assertEquals(Retorno.Resultado.OK, sis.inicializarSistema(1).resultado);
		assertEquals(Retorno.Resultado.OK, sis.inicializarSistema(10).resultado);
	}

	@Test
	public void testDestruirSistema() {
		sis.inicializarSistema(10);
		 
		assertEquals(Retorno.Resultado.OK, sis.destruirSistema().resultado);
	}

	@Test
	public void testRegistrarProductor() {
		sis.inicializarSistema(10);
		 
		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarProductor("asdadsasd", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456").resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarProductor("87654321", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456").resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarProductor("1.234.567-1", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099-123-456").resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarProductor("1.234.567-2", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099.123.456").resultado);
		assertEquals(Retorno.Resultado.ERROR_3, sis.registrarProductor("1.234.567-3", "Rigoberta Menchú", "Esteban Quito 1234", "rigobertamenchu.com", "099123456").resultado);
		assertEquals(Retorno.Resultado.ERROR_3, sis.registrarProductor("1.234.567-3", "Rigoberta Menchú", "Esteban Quito 1234", "rigobertamenchu@.com", "099123456").resultado);
		assertEquals(Retorno.Resultado.ERROR_3, sis.registrarProductor("1.234.567-3", "Rigoberta Menchú", "Esteban Quito 1234", "rigobertamenchu@algo", "099123456").resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456").resultado);
		assertEquals(Retorno.Resultado.ERROR_4, sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456").resultado);
	}

	@Test
	public void testRegistrarCiudad_TopeCiudades() {
		sis.inicializarSistema(3);

		assertEquals(Retorno.Resultado.OK, sis.registrarCiudad("Montevideo", 20.00, 20.00).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarCiudad("Melo", 21.00, 21.00).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarCiudad("Trinidad", 22.00, 22.00).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarCiudad("Paso de los Toros", 23.00, 23.00).resultado);
	}
	
	@Test
	public void testRegistrarCiudad_CiudadExistente() {
		sis.inicializarSistema(3);

		assertEquals(Retorno.Resultado.OK, sis.registrarCiudad("Montevideo", 20.00, 20.00).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarCiudad("Tarariras", 20.00, 20.00).resultado);
		
	}

	@Test
	public void testRegistrarPlantacion() {
		
		sis.inicializarSistema(4);
		sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456");
		sis.registrarCiudad("Montevideo", 20.00, 20.00);
		
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",-1).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, sis.registrarPlantacion("Plan1", 20.00, 20.00,"1.234.567-0",1).resultado);
		assertEquals(Retorno.Resultado.ERROR_4, sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-5",1).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",1).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarPlantacion("Plan2", 22.00, 23.00,"1.234.567-0",1).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarPlantacion("Plan3", 23.00, 24.00,"1.234.567-0",1).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarPlantacion("Plan4", 24.00, 25.00,"1.234.567-0",1).resultado);
		
	}

	@Test
	public void testRegistrarSilo() {
		sis.inicializarSistema(4);
		sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456");
		sis.registrarCiudad("Montevideo", 20.00, 20.00);
		sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",1);
		
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarSilo("Silo1", 21.00, 22.00,-1).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarSilo("Silo1", 21.00, 22.00,0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, sis.registrarSilo("Silo1", 20.00, 20.00,1).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarSilo("Silo1", 22.00, 23.00,1).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarSilo("Silo2", 23.00, 24.00,1).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarSilo("Silo3", 24.00, 25.00,1).resultado);
	}

	@Test
	public void testRegistrarTramo() {
		sis.inicializarSistema(4);
		sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456");
		sis.registrarCiudad("Montevideo", 20.00, 20.00);
		sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",1);
		sis.registrarSilo("Silo1", 22.00, 23.00,1);

		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarTramo(20.00, 20.00, 21.00, 22.00,-1).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.registrarTramo(20.00, 20.00, 21.00, 22.00,0).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarTramo(0.00, 0.00, 20.00, 20.00, 100).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.registrarTramo(20.00, 20.00, 0.00, 0.00, 100).resultado);
		assertEquals(Retorno.Resultado.OK, sis.registrarTramo(20.00, 20.00, 21.00, 22.00,100).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, sis.registrarTramo(20.00, 20.00, 21.00, 22.00,100).resultado);
		
	}

	@Test
	public void testEliminarTramo() {
		
		sis.inicializarSistema(4);
		sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456");
		sis.registrarCiudad("Montevideo", 20.00, 20.00);
		sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",1);
		sis.registrarSilo("Silo1", 22.00, 23.00,1);

		assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarTramo(20.00, 20.00, 0.00, 0.00).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarTramo(0.00, 0.00, 21.00, 22.0).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.eliminarTramo(20.00, 20.00, 21.00, 22.00).resultado);
		sis.registrarTramo(20.00, 20.00, 21.00, 22.00, 100);
		assertEquals(Retorno.Resultado.OK, sis.eliminarTramo(20.00, 20.00, 21.00, 22.00).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, sis.eliminarTramo(20.00, 20.00, 21.00, 22.00).resultado);
		
	}

	@Test
	public void testEliminarPunto() {
		
		sis.inicializarSistema(4);
		sis.registrarProductor("1.234.567-0", "Rigoberta Menchú", "Esteban Quito 1234", "rigoberta@menchu.com", "099123456");
		sis.registrarCiudad("Montevideo", 20.00, 20.00);
		sis.registrarPlantacion("Plan1", 21.00, 22.00,"1.234.567-0",1);
		sis.registrarSilo("Silo1", 22.00, 23.00,1);

		assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarPunto(0.00, 0.00).resultado);
		assertEquals(Retorno.Resultado.OK, sis.eliminarPunto(20.00, 20.00).resultado);
		assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarPunto(0.00, 0.00).resultado);
		
	}

	@Test
	public void testMapaEstado() {
		sis.inicializarSistema(14);

		sis.registrarCiudad("MELO", -32.364862,-54.166551);
		sis.registrarSilo("TRINIDAD", -33.520142,-56.904220,150);
		sis.registrarCiudad("MONTEVIDEO", -34.901113,-56.164531);
		sis.registrarSilo("COLONIA", -34.460719,-57.833910,100);
		sis.registrarPlantacion("YOUNG", -32.702193,-57.638238,"1.111.111-0",150);
		sis.registrarSilo("CONCHILLAS", -34.164144,-58.034204,200);
		sis.registrarSilo("SARANDI GRANDE", -33.725648,-56.329281,250);
		
		assertEquals(Retorno.Resultado.OK, sis.mapaEstado().resultado);
	}

	@Test
	public void testRutaASiloMasCercano() {
		sis.inicializarSistema(20);
		
		assertEquals(Retorno.Resultado.ERROR_1, sis.rutaASiloMasCercano(0.0, 0.0).resultado);	

		sis.registrarProductor("1.111.111-0", "Lucia", "Esteban Quito 1234", "rigoberta@menchu.com", "099111111");
		sis.registrarPlantacion("CONCORDIA", -31.391392,-58.017434,"1.111.111-0",1);
		
		assertEquals(Retorno.Resultado.ERROR_2, sis.rutaASiloMasCercano(-31.391392,-58.017434).resultado);
		
		registrarPuntos();
		
		r = sis.rutaASiloMasCercano(-32.702193,-57.638238);
		assertEquals(Retorno.Resultado.OK, r.resultado);
		assertEquals("-32.702193;-57.638238|-32.364862;-54.166551|-34.901113;-56.164531|-34.460719;-57.83391|-33.725648;-56.329281", r.valorString);
		
	}

	@Test
	public void testListadoDePlantacionesEnCiudad() {

		sis.inicializarSistema(20);
		sis.registrarProductor("1.111.111-0", "Lucia", "Esteban Quito 1234", "rigoberta@menchu.com", "099111111");
		
		assertEquals(Retorno.Resultado.ERROR_1, sis.listadoDePlantacionesEnCiudad(0.0, 0.0).resultado);	
		
		registrarPuntos();
		
		r = sis.listadoDePlantacionesEnCiudad(-32.364862,-54.166551);
		assertEquals(Retorno.Resultado.OK, r.resultado);
		assertTrue(r.valorString.contains("-34.901113;-56.164531"));
		assertTrue(r.valorString.contains("-32.702193;-57.638238"));
		assertTrue(r.valorString.contains("-34.336668;-53.793882"));
		assertTrue(r.valorString.length()==65); // Solo tengo 3 plantaciones -> 21 * 3 + 2 pipes
	}

	@Test
	public void testListadoDeSilos() {
		
		sis.inicializarSistema(10);
		sis.registrarSilo("Silo1", 12.11, 13.11,200);
		sis.registrarSilo("Silo2", 22.11, 23.11,300);
		sis.registrarSilo("Silo3", 32.11, 33.11,400);
		sis.registrarSilo("Silo4", 42.11, 43.11,500);
		sis.registrarSilo("Silo5", 52.11, 53.11,600);
		
		r = sis.listadoDeSilos();
		assertEquals(Retorno.Resultado.OK, r.resultado);
		assertTrue(r.valorString.length()==99); //5 silos * 19 + 4 pipes = 99
	}

	@Test
	public void testListadoProductores() {
		sis.inicializarSistema(4);
		sis.registrarProductor("4.444.444-0", "Ilan", "Esteban Quito 1234", "rigoberta@menchu.com", "099444444");
		sis.registrarProductor("2.222.222-0", "Bruno", "Esteban Quito 1234", "rigoberta@menchu.com", "099222222");
		sis.registrarProductor("3.333.333-0", "Nicolas", "Esteban Quito 1234", "rigoberta@menchu.com", "099333333");
		sis.registrarProductor("5.555.555-0", "Fabian", "Esteban Quito 1234", "rigoberta@menchu.com", "099555555");
		sis.registrarProductor("1.111.111-0", "Lucia", "Esteban Quito 1234", "rigoberta@menchu.com", "099111111");
		sis.registrarProductor("6.666.666-0", "Gabriel", "Esteban Quito 1234", "rigoberta@menchu.com", "099666666");
		
		r = sis.listadoProductores();
		assertEquals(Retorno.Resultado.OK, r.resultado);
		assertEquals("11111110;Lucia;099111111|22222220;Bruno;099222222|33333330;Nicolas;099333333|44444440;Ilan;099444444|55555550;Fabian;099555555|66666660;Gabriel;099666666", r.valorString);
	}
	

	public void registrarPuntos() {
		
		sis.registrarCiudad("MELO", -32.364862,-54.166551);
		sis.registrarSilo("TRINIDAD", -33.520142,-56.904220,200);
		sis.registrarPlantacion("MONTEVIDEO", -34.901113,-56.164531,"1.111.111-0",1);
		sis.registrarSilo("COLONIA", -34.460719,-57.833910,1);
		sis.registrarPlantacion("YOUNG", -32.702193,-57.638238,"1.111.111-0",300);
		sis.registrarSilo("CONCHILLAS", -34.164144,-58.034204,400);
		sis.registrarSilo("SARANDI GRANDE", -33.725648,-56.329281,350);
		sis.registrarPlantacion("CASTILLOS", -34.197913,-53.861754,"1.111.111-0",1);
		sis.registrarCiudad("PUNTA DEL DIABLO", -34.042339,-53.547332);
		sis.registrarPlantacion("VALIZAS", -34.336668,-53.793882,"1.111.111-0",1);

		sis.registrarTramo(-32.364862,-54.166551	, -34.901113,-56.164531,  6); // 1-3
		sis.registrarTramo(-32.364862,-54.166551	, -32.702193,-57.638238,  5); // 1-5
		sis.registrarTramo(-32.364862,-54.166551	, -33.725648,-56.329281,  10); // 1-7
		sis.registrarTramo(-32.364862,-54.166551	, -34.197913,-53.861754,  21); // 1-8
		sis.registrarTramo(-32.364862,-54.166551	, -34.042339,-53.547332,  10); // 1-9
		sis.registrarTramo(-33.520142,-56.904220	, -32.702193,-57.638238,  10); // 2-5
		sis.registrarTramo(-33.520142,-56.904220	, -33.725648,-56.329281,  1891); // 2-7
		sis.registrarTramo(-34.901113,-56.164531	, -34.460719,-57.833910,  2); // 3-4
		sis.registrarTramo(-34.901113,-56.164531	, -33.725648,-56.329281,  3); // 3-7
		sis.registrarTramo(-34.901113,-56.164531	, -34.197913,-53.861754,  1901); // 3-8
		sis.registrarTramo(-34.460719,-57.833910	, -34.164144,-58.034204,  13); // 4-6
		sis.registrarTramo(-34.460719,-57.833910	, -33.725648,-56.329281,  11); // 4-7
		sis.registrarTramo(-32.702193,-57.638238	, -34.164144,-58.034204,  25); // 5-6
		sis.registrarTramo(-34.164144,-58.034204	, -33.725648,-56.329281,  11); // 6-7
		sis.registrarTramo(-34.042339,-53.547332	, -34.336668,-53.793882,  10); // 9-10
	}

}
