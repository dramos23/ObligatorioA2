package PaqueteSistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test() {
		
		Sistema s = new Sistema();
		
		/*PRUEBAS*/
		//Inicializar Sistema
		assertEquals(Retorno.Resultado.OK, s.inicializarSistema(16).resultado);
		
		//Registrar Productor - OK
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.868.799-1", "Adri�n", "Lorenzo P�rez 3171", "gandeladri@gmail.com", "099553848").resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.317.139-7", "Lucia", "Florida M14 S2", "lucia@gmail.com", "099999999").resultado);			
		
		//Registrar Productor - Errores
		assertEquals(Retorno.Resultado.ERROR_1, s.registrarProductor("A.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "078369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_4, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		
		//Registrar Ciudad - OK
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Veinticinco de Mayo",-34.192082,-56.339053).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Mendoza Chico",-34.237845,-56.218210).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Berrondo",-34.145863,-56.277579).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Florida",-34.094821,-56.220934).resultado);
		
		
		//Registrar Ciudad - Errores
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarCiudad("Veinticinco de Mayo",-34.192082,-56.339053).resultado);
		
		//Registrar Plantaci�n - OK
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_1",-34.176316,-56.175714,"4.798.128-7",15000).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_2",-34.065572,-56.314966,"4.868.799-1",10000).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_3",-34.262350,-56.163138,"4.317.139-7",8000).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_4",-34.117518,-56.405298,"4.317.139-7",5700).resultado); 
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_5",-34.030568,-56.182196,"4.317.139-7",20000).resultado); 
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_6",-34.061509,-56.375655,"4.317.139-7",2000).resultado);
				
		//Registrar Plantaci�n - Errores
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarPlantacion("Plantacion_1",-34.176316,-56.175714,"4.798.128-7",0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarPlantacion("Plantacion_2",-34.176316,-56.175714,"4.317.139-7",3000).resultado);
		assertEquals(Retorno.Resultado.ERROR_4, s.registrarPlantacion("Plantacion_1",-34.176310,-56.175714,"1.322.361-1",3000).resultado);
																					 
		//Registrar Silo - OK
		assertEquals(Retorno.Resultado.OK, s.registrarSilo("Silo_1",-34.102376,-56.122201,30000).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarSilo("Silo_2",-34.177174,-56.217845,21000).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarSilo("Silo_3",-34.203299,-56.399141,26000).resultado);
		
		//Registrar Silo - Errores
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarSilo("Silo_1",-34.102376,-56.122201,0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarSilo("Silo_2",-34.102376,-56.122201,300000).resultado);
		
		//Registrar Tramo - OK
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.094821,-56.220934,-34.102376,-56.122201,9).resultado); //ciudad florida - silo
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.177174,-56.217845,-34.094821,-56.220934,12).resultado); //silo 2 - ciudad florida
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.145863,-56.277579,-34.094821,-56.220934,6).resultado); //ciudad berrondo - ciudad florida
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.192082,-56.339053,-34.094821,-56.220934,17).resultado); //ciudad veinticinco de mayo - ciudad florida
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.237845,-56.218210,-34.176316,-56.175714,8).resultado); //ciudad mendoza chico - plantacion 1
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.237845,-56.218210,-34.177174,-56.217845,8).resultado); //ciudad mendoza chico - silo 2
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.094821,-56.220934,-34.065572,-56.314966,14).resultado); //ciudad florida - plantacion 2
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.237845,-56.218210,-34.262350,-56.163138,4).resultado); //ciudad mendoza chico - plantacion 3
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.192082,-56.339053,-34.203299,-56.399141,4).resultado); //ciudad veinticinco de mayo - silo 3
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.192082,-56.339053,-34.117518,-56.405298,12).resultado); //ciudad veinticinco de mayo - plantacion 4
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.094821,-56.220934,-34.030568,-56.182196,9).resultado); //ciudad florida - plantacion 5
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.065572,-56.314966,-34.061509,-56.375655,13).resultado); //ciudad plantacion 2 - palntacion 6
		
		//Registrar Tramo - Errores
		assertEquals(Retorno.Resultado.ERROR_1, s.registrarTramo(-34.094821,-56.220934,-34.061509,-56.375655,-10).resultado); //ciudad florida - palntacion 6
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarTramo(-34.094821,-56.220930,-34.061509,-56.375655,10).resultado); //x - palntacion 6
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarTramo(-34.094821,-56.220934,-34.061509,-56.375650,10).resultado); //ciudad florida - x
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarTramo(-34.065572,-56.314966,-34.061509,-56.375655,13).resultado); //ciudad plantacion 2 - palntacion 6
		
		//Eliminar Tramo - OK
		assertEquals(Retorno.Resultado.OK, s.eliminarTramo(-34.145863,-56.277579,-34.094821,-56.220934).resultado);  //ciudad berrondo - ciudad florida

		//Eliminar Tramo - Errores	
		assertEquals(Retorno.Resultado.ERROR_1, s.eliminarTramo(-34.211054,-56.2192116,-34.235199,-56.2185438).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.eliminarTramo(-34.102376,-56.122201,-34.203299,-56.399141).resultado); //silo - silo 3
		
		//Eliminar Punto - OK
		assertEquals(Retorno.Resultado.OK, s.eliminarPunto(-34.145863,-56.277579).resultado);
		
		//Eliminar Punto - OK
		assertEquals(Retorno.Resultado.ERROR_1, s.eliminarPunto(-34.145863,-56.277579).resultado);

		//Ruta al silo m�s cercano - OK
		assertEquals(Retorno.Resultado.OK, s.rutaASiloMasCercano(-34.176316,-56.175714).resultado);
		
		assertEquals(Retorno.Resultado.OK, s.listadoDeSilos().resultado);
		
		assertEquals(Retorno.Resultado.OK, s.mapaEstado().resultado);
		
		assertEquals(Retorno.Resultado.OK, s.listadoProductores().resultado);

		//Listado de plantaciones en ciudad - OK
		assertEquals(Retorno.Resultado.OK, s.listadoDePlantacionesEnCiudad(-34.237845,-56.218210).resultado);
		
		assertEquals(Retorno.Resultado.OK, s.destruirSistema().resultado);
		
		//Pruebas sobre sistema destruido reinicializado
//		assertEquals(Retorno.Resultado.ERROR_2, s.registrarTramo(-34.094821,-56.220934,-34.102376,-56.122201,9).resultado); //ciudad florida - silo
//		assertEquals(Retorno.Resultado.ERROR_1, s.eliminarPunto(-34.145863,-56.277579).resultado);
//		assertEquals(Retorno.Resultado.ERROR_1, s.eliminarTramo(-34.192082,-56.339053,-34.117518,-56.405298).resultado);
//		assertEquals(Retorno.Resultado.OK, s.listadoDeSilos().resultado);
//		assertEquals(Retorno.Resultado.ERROR_1, s.rutaASiloMasCercano(-34.176316,-56.175714).resultado);
//		assertEquals(Retorno.Resultado.OK, s.listadoProductores().resultado);
//		assertEquals(Retorno.Resultado.ERROR_1, s.listadoDePlantacionesEnCiudad(-34.237845,-56.218210).resultado);
		
	}

}
