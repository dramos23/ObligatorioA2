package PaqueteSistema;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Sistema s = new Sistema();
		
		//inicializo el sistema con 3 puntos
		assertEquals(Retorno.Resultado.OK, s.inicializarSistema(3).resultado);
		
		//Registro 2 productor
		assertEquals(Retorno.Resultado.OK, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_1, s.registrarProductor("A.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_2, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "078369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_3, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23gmail.com", "098369129").resultado);
		assertEquals(Retorno.Resultado.ERROR_4, s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129").resultado);
		//Registro 1 ciudad
		//Registro 1 plantacion
		//Registro 1 silo
	}

}
