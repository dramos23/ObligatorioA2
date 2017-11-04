package PaqueteSistema;

import java.util.List;

import PaqueteArbolBB.ArbolBB;
import PaqueteDominio.Ciudad;
import PaqueteDominio.Plantacion;
import PaqueteDominio.Punto;
import PaqueteDominio.Silo;
import PaqueteGrafo.GrafoLista;
import PaqueteLista.Lista;
import PaqueteSistema.Retorno.Resultado;

public class Sistema implements ISistema {
	
	public enum TipoPunto {CIUDAD,PLANTACIÓN,SILO};
	
	private ArbolBB productores;
	private GrafoLista mapa;

	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		Retorno ret = new Retorno();
		
		if(cantPuntos <= 0)
			ret.resultado = Resultado.ERROR_1;
		else {
			mapa = new GrafoLista(cantPuntos);
			productores = new ArbolBB();
			ret.resultado = Resultado.OK;
		}
		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno();
		//vaciar arbol productores y grafo mapa, siempre retorna OK.
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarProductor(String cedula, String nombre, String direccion, String email, String celular) {
		Retorno ret = new Retorno();
		
		switch(productores.insertarProductor(cedula, nombre, direccion, email, celular)){
		case 0:
			ret.resultado = Resultado.OK;
			break;
		case 1:
			ret.resultado = Resultado.ERROR_1;
			break;
		case 2:
			ret.resultado = Resultado.ERROR_2;
			break;
		case 3:
			ret.resultado = Resultado.ERROR_3;
			break;
		case 4:
			ret.resultado = Resultado.ERROR_4;
			break;
		}
		
		return ret;
	}

	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		Ciudad c = new Ciudad(nombre,coordX,coordY);
		
		switch(mapa.agregarVertice(c)){
		case 0:
			ret.resultado = Resultado.OK;
			break;
		case 1:
			ret.resultado = Resultado.ERROR_1;
			break;
		case 2:
			ret.resultado = Resultado.ERROR_2;
			break;
		}
						
		return ret;
	}

	@Override
	public Retorno registrarPlantacion(String nombre, Double coordX, Double coordY, String cedula_productor,
			int capacidad) {
		
		Retorno ret = new Retorno();
		
		if(!mapa.sePuedeInsertarPunto()){
			ret.resultado = Resultado.ERROR_1;
		} else if(capacidad <= 0)
			ret.resultado = Resultado.ERROR_2;
		else {
			Plantacion p = new Plantacion(nombre,coordX,coordY,cedula_productor,capacidad);
			int indice = mapa.existeVertice(p);
			if(indice != -1){
				ret.resultado = Resultado.ERROR_3;
			} else if(!productores.existeProductor(cedula_productor)){
				ret.resultado = Resultado.ERROR_4;
			} else {
				//No debería caer si llega acá
				switch(mapa.agregarVertice(p)){
				case 0:
					ret.resultado = Resultado.OK; 
					break;
				case 1:
					ret.resultado = Resultado.ERROR_1; 
					break;
				case 2:
					ret.resultado = Resultado.ERROR_3;
					break;
				}
			}
		}
		return ret;
	}

	@Override
	public Retorno registrarSilo(String nombre, Double coordX, Double coordY, int capacidad) {
		Retorno ret = new Retorno();
		
		if(!mapa.sePuedeInsertarPunto()){
			ret.resultado = Resultado.ERROR_1;
		} else if(capacidad <= 0)
			ret.resultado = Resultado.ERROR_2;
		else {
			Silo s = new Silo(nombre, coordX, coordY, capacidad);
			switch(mapa.agregarVertice(s)){
			case 0:
				ret.resultado = Resultado.OK;
				break;
			case 1:
				ret.resultado = Resultado.ERROR_1; //No debería entrar acá
				break;
			case 2:
				ret.resultado = Resultado.ERROR_3;
				break;
			}
		}	
		return ret;
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		Retorno ret = new Retorno();
		
		if(peso <= 0)
			ret.resultado = Resultado.ERROR_1;
		else {
			switch(mapa.agregarArista(coordXi, coordYi, coordXf, coordYf, peso)){
			case 0:
				ret.resultado = Resultado.OK;
				break;
			case 1:
				ret.resultado = Resultado.ERROR_2;
				break;
			case 2:
				ret.resultado = Resultado.ERROR_3;
				break;
			}
		}	
		return ret;
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		Retorno ret = new Retorno();
		
		switch(mapa.eliminarArista(coordXi, coordYi, coordXf, coordYf)){
		case 0:
			ret.resultado = Resultado.OK;
			break;
		case 1:
			ret.resultado = Resultado.ERROR_1;
			break;
		case 2:
			ret.resultado = Resultado.ERROR_2;
			break;
		}		
		return ret;
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		if(mapa.eliminarVertice(coordX, coordY)){
			ret.resultado = Resultado.OK;
		} else {
			ret.resultado = Resultado.ERROR_1;
		}		
		return ret;
	}

	@Override
	public Retorno mapaEstado() {
		Lista p = mapa.ObtenerPuntoMasAdyacentes();
		
		Retorno ret = new Retorno();
		String url = "www.google.com.uy";
		Navegador.openURL(url);
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno rutaASiloMasCercano(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno listadoDePlantacionesEnCiudad(Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
//		ArrayList<Plantacion> plantacionesEnCiudad = mapa.obtenerPlantacionesEnCiudad(coordX,coordY);
//		
//		if(plantacionesEnCiudad == null){
//			ret.resultado = Resultado.ERROR_1;
//		} else {
//			ret.valorString = "Listado de plantaciones en Ciudad "+ coordX + ", "+ coordY;
//			for(Plantacion p: plantacionesEnCiudad){
//				ret.valorString += p;
//			}
//			ret.resultado = Resultado.OK;
//		}		
//		return ret;
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		return ret;
	}

	//Preguntar como se calcula o de donde se obtiene la "capacidad remanente"
	@Override
	public Retorno listadoDeSilos() {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno listadoProductores() {
		Retorno ret = new Retorno();
		
		ret.valorString = productores.obtenerObjetosInOrder();
		ret.resultado = Resultado.OK;
		
		return ret;
	}

}
