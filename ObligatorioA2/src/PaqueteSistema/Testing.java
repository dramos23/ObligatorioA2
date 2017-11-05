package PaqueteSistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test() {
		
		Sistema s = new Sistema();
		
		//inicializo el sistema con 3 puntos
		assertEquals(Retorno.Resultado.OK, s.inicializarSistema(20).resultado);
		
		//Registro 2 productor
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.868.799-1", "Adrián", "Lorenzo Pérez 3171", "gandeladri@gmail.com", "099553848").resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.317.139-7", "Lucia", "Florida M14 S2", "lucia@gmail.com", "099999999").resultado);
		assertEquals(Retorno.Resultado.ERROR_1, s.registrarProductor("A.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "078369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_4, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);		
		
		//Registro 1 ciudad
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Veinticinco de Mayo",-34.192082,-56.339053).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarCiudad("Veinticinco de Mayo",-34.192082,-56.339053).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Berrondo",-34.145863,-56.277579).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Florida",-34.094821,-56.220934).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Mendoza",-34.281350,-56.213361).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Mendoza Chico",-34.237845,-56.218210).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Cardal",-34.290906,-56.394002).resultado);
		
		//Registro 1 plantacion
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_1",-34.176316,-56.175714,"4.798.128-7",3000).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarPlantacion("Plantacion_1",-34.176316,-56.175714,"4.798.128-7",0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarPlantacion("Plantacion_2",-34.176316,-56.175714,"4.317.139-7",3000).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_2",-34.065572,-56.314966,"4.868.799-1",3000).resultado);
		
		//Registro 1 silo
		assertEquals(Retorno.Resultado.OK, s.registrarSilo("Silo_1",-34.102376,-56.122201,300000).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarSilo("Silo_1",-34.102376,-56.122201,0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarSilo("Silo_2",-34.102376, -56.122201,300000).resultado);
		
		
		//Registro 2 tramo
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.094821,-56.220934,-34.102376,-56.122201,11).resultado); //ciudad florida - silo
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.176316,-56.175714,-34.094821,-56.220934,14).resultado); //plantacion - ciudad florida
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.145863,-56.277579,-34.094821,-56.220934,8).resultado); //ciudad berrondo - ciudad florida
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.192082,-56.339053,-34.145863,-56.277579,13).resultado); //ciudad veinticinco de mayo - ciudad berrondo
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.290906,-56.394002,-34.192082,-56.339053,16).resultado); //ciudad cardal - ciudad veinticinco de mayo
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.192082,-56.339053,-34.281350,-56.213361,20).resultado); //ciudad veinticinco de mayo - ciudad mendoza
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.281350,-56.213361,-34.237845,-56.218210,5).resultado); //ciudad mendoza - ciudad mendoza chico
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.237845,-56.218210,-34.176316,-56.175714,10).resultado); //ciudad mendoza chico - plantacion 1
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.094821,-56.220934,-34.065572,-56.314966,16).resultado); //ciudad florida - plantacion 2
		
		//assertEquals(Retorno.Resultado.OK, s.eliminarPunto(-34.211054,-56.2192116).resultado);
		
		//assertEquals(Retorno.Resultado.ERROR_1, s.eliminarTramo(-34.211054,-56.2192116,-34.235199,-56.2185438).resultado);
		
		assertEquals(Retorno.Resultado.OK, s.mapaEstado().resultado);
		
		assertEquals(Retorno.Resultado.OK, s.listadoProductores().resultado);
		
		
	}

}
