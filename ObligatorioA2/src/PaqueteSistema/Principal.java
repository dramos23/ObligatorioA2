package PaqueteSistema;

public class Principal {
	
	//hay que ver como setear para que corra con esto

	public static void main(String[] args) {
		Sistema s = new Sistema();
		System.out.println(s.inicializarSistema(3));
		System.out.println(s.registrarProductor("4.798.128-7", "Daniel", "Copacabana M31 S12", "daniel.r.23@gmail.com", "098369129"));
	}

}
