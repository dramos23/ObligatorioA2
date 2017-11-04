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
		assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Mendoza Chico",-34.2417138,-56.2194872).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarCiudad("Mendoza Chico",-34.2417138,-56.2194872).resultado);
		
		//Registro 1 plantacion
		assertEquals(Retorno.Resultado.OK, s.registrarPlantacion("Plantacion_1",-34.211054,-56.2192116,"4.798.128-7",3000).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarPlantacion("Plantacion_1",-34.211054,-56.2192116,"4.798.128-7",0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarPlantacion("Plantacion_2",-34.211054,-56.2192116,"4.317.139-7",3000).resultado);
		
		//Registro 1 silo
		assertEquals(Retorno.Resultado.OK, s.registrarSilo("Silo_1",-34.235199,-56.2185438,300000).resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarSilo("Silo_1",-34.235199,-56.2185438,0).resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarSilo("Silo_2",-34.235199,-56.2185438,300000).resultado);
		
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.211054,-56.2192116,-34.235199,-56.2185438,100).resultado);
		assertEquals(Retorno.Resultado.OK, s.registrarTramo(-34.211054,-56.2192116,-34.2417138,-56.2194872,100).resultado);
		
		//assertEquals(Retorno.Resultado.OK, s.eliminarPunto(-34.211054,-56.2192116).resultado);
		
		//assertEquals(Retorno.Resultado.ERROR_1, s.eliminarTramo(-34.211054,-56.2192116,-34.235199,-56.2185438).resultado);
		
		//hay que arreglar el registrarProductor
		
		assertEquals(Retorno.Resultado.OK, s.mapaEstado());
		
		assertEquals(Retorno.Resultado.OK, s.listadoProductores().resultado);
		
		
	}

}
