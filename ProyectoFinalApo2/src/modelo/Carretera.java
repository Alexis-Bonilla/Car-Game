package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad Icesi (Cali - Colombia)    ~ 
 * Autores: Juan Sebastian Puerta Ordo�es ~ 
 * 			Jeiner Alexis Bonilla Chavez  ~ 
 * 			Sergio Andres Lozada Sanchez  ~      
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class Carretera implements Serializable {
	
	public static final String CARRETERA_TIPO_CAMPO = "imagenes/mapas/campo.png";
	public static final int LIMITE_DERECHA_CAMPO = 0;
	public static final int LIMITE_IZQUIERDA_CAMPO = 0;
	
	public static final String CARRETERA_TIPO_PUENTE = "imagenes/mapas/puente.png";
	public static final int LIMITE_DERECHA_PUENTE = 0;
	public static final int LIMITE_IZQUIERDA_PUENTE = 0;
	
	public static final String CARRETERA_TIPO_PLAYA = "imagenes/mapas/playa.png";
	public static final int LIMITE_DERECHA_PLAYA = 0;
	public static final int LIMITE_IZQUIERDA_PLAYA = 0;
	
	public static final String CARRETERA_TIPO_CANHON = "imagenes/mapas/ca�on.png";
	public static final int LIMITE_DERECHA_CANHON = 0;
	public static final int LIMITE_IZQUIERDA_CANHON = 0;
	
	public static final int AUTOMOVIL_ROJO = 1;
	public static final int AUTOMOVIL_AZUL = 2;
	public static final int AUTOMOVIL_AMARILLO = 3;
	
	public static final int POS_X_IMAGEN = 0;
	
	private String tipo;
	private boolean avanza;
	private int cantidadAutomovilesJugador;
	private int cantidadAutomovilesCarretera;
	private int numeroCarretera;
	private int posYImagen1;
	private int posYImagen2;
	private int limiteCarreteraDerecha;
	private int limiteCarreteraIzquierda;
	private AutomovilJugador automovilSeleccionado;
	private Carretera carreteraSiguiente;
	private Carretera carreteraAnterior;
	private Automovil[] automoviles;
	
	public Carretera(String pCarretera,int pNumeroCarretera){
		
		automoviles = new Automovil[2];
		automoviles[0] = new AutomovilJugador(AutomovilJugador.PLACA_AUTO_2,AutomovilJugador.AUTOMOVIL_2,0,0,0);
		automoviles[0].cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_3,AutomovilJugador.AUTOMOVIL_3,0,0,0));
		automoviles[0].darAutomovilSiguiente().cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_1,AutomovilJugador.AUTOMOVIL_1,0,0,0));
		
		automoviles[1] = new AutomovilCarretera(AutomovilCarretera.PLACA_CAMION_1,AutomovilCarretera.CAMION,0,0,0);
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AMARILLO_2,AutomovilCarretera.CARRO_AMARILLO,0,0,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AZUL_1,AutomovilCarretera.CARRO_AZUL,0,0,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_ROJO_2,AutomovilCarretera.CARRO_ROJO,0,0,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AMARILLO_1,AutomovilCarretera.CARRO_AMARILLO,0,0,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_ROJO_1,AutomovilCarretera.CARRO_ROJO,0,0,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AZUL_2,AutomovilCarretera.CARRO_AZUL,0,0,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CAMION_2,AutomovilCarretera.CAMION,0,0,0)) ;
		
		if(pCarretera.equals(CARRETERA_TIPO_CAMPO)) {
			tipo=CARRETERA_TIPO_CAMPO;
			
		}else if(pCarretera.equals(CARRETERA_TIPO_PUENTE)) {
			tipo=CARRETERA_TIPO_PUENTE;
			
		}else if(pCarretera.equals(CARRETERA_TIPO_PLAYA)) {
			tipo=CARRETERA_TIPO_PLAYA;
			
		}else if(pCarretera.equals(CARRETERA_TIPO_CANHON)) {
			tipo=CARRETERA_TIPO_CANHON;
			
		}
		
		cantidadAutomovilesJugador=3;
		cantidadAutomovilesCarretera=8;
		numeroCarretera=pNumeroCarretera;
		posYImagen1=0;
		posYImagen2=-2;
		avanza=false;
		
		
		
		
	}
	
	public String darTipo() {
		return tipo;
	}

	public void cambiarTipo(String pTipo) {
		tipo = pTipo;
	}
	
	
	public boolean Avanza() {
		return avanza;
	}

	public void cambiarAvanza(boolean pAvanza) {
		avanza = pAvanza;
	}

	public int darCantidadAutomovilesJugador() {
		return cantidadAutomovilesJugador;
	}

	public void cambiarCantidadAutomovilesJugador(int pCantidadAutomovilesJugador) {
		cantidadAutomovilesJugador = pCantidadAutomovilesJugador;
	}

	public int darCantidadAutomovilesCarretera() {
		return cantidadAutomovilesCarretera;
	}

	public void cambiarCantidadAutomovilesCarretera(int pCantidadAutomovilesCarretera) {
		cantidadAutomovilesCarretera = pCantidadAutomovilesCarretera;
	}

	public int darNumeroCarretera() {
		return numeroCarretera;
	}

	public void cambiarNumeroCarretera(int pNumeroCarretera) {
		numeroCarretera = pNumeroCarretera;
	}
	
	public void moverImagen1() {
		posYImagen1+=1;
	}

	public int darPosYImagen1() {
		return posYImagen1;
	}

	public void cambiarPosYImagen1(int pPosYImagen1) {
		posYImagen1 = pPosYImagen1;
	}
	
	public void moverImagen2() {
		posYImagen2+=1;
	}
	
	public int darPosYImagen2() {
		return posYImagen2;
	}

	public void cambiarPosYImagen2(int pPosYImagen2) {
		posYImagen2 = pPosYImagen2;
	}

	public int darLimiteCarreteraDerecha() {
		return limiteCarreteraDerecha;
	}

	public void cambiarLimiteCarreteraDerecha(int pLimiteCarreteraDerecha) {
		limiteCarreteraDerecha = pLimiteCarreteraDerecha;
	}

	public int darLimiteCarreteraIzquierda() {
		return limiteCarreteraIzquierda;
	}

	public void cambiarLimiteCarreteraIzquierda(int pLimiteCarreteraIzquierda) {
		limiteCarreteraIzquierda = pLimiteCarreteraIzquierda;
	}

	public AutomovilJugador darAutomovilSeleccionado() {
		return automovilSeleccionado;
	}

	public void cambiarAutomovilSeleccionado(AutomovilJugador pAutomovilSeleccionado) {
		automovilSeleccionado = pAutomovilSeleccionado;
	}

	public Carretera darCarreteraSiguiente() {
		return carreteraSiguiente;
	}

	public void cambiarCarreteraSiguiente(Carretera pCarreteraSiguiente) {
		carreteraSiguiente = pCarreteraSiguiente;
	}

	public Carretera darCarreteraAnterior() {
		return carreteraAnterior;
	}

	public void cambiarCarreteraAnterior(Carretera pCarreteraAnterior) {
		carreteraAnterior = pCarreteraAnterior;
	}

	public Automovil[] darAutomoviles() {
		return automoviles;
	}

	public void cambiarAutomoviles(Automovil[] pAutomoviles) {
		automoviles = pAutomoviles;
	}
	
	public void seleccionarAutomovil(int pPlaca) {
		automovilSeleccionado=buscarBinarioAutomovil(pPlaca);
	}

	
	public AutomovilCarretera darPrimerAutomovilListaCarretera() {
		AutomovilCarretera auto = null;
		for (int i = 0; i < automoviles.length; i++) {
			if(automoviles[i] instanceof ICarretera) {
				auto=(AutomovilCarretera) automoviles[i];
			}
		}
		return auto;
	}
	
	public AutomovilJugador darPrimerAutomovilListaJugador() {
		AutomovilJugador auto = null;
		for (int i = 0; i < automoviles.length; i++) {
			if(automoviles[i] instanceof IJugador) {
				auto=(AutomovilJugador) automoviles[i];
			}
		}
		return auto;
	}
	
	public void agregarAutomovilCarretera(AutomovilCarretera pAutomovilCarretera) {
		AutomovilCarretera actual = (AutomovilCarretera) automoviles[1];
		while(actual.darAutomovilSiguiente() != null) {
			actual=(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
		actual.cambiarAutomovilSiguiente(pAutomovilCarretera);
	}
	
	public AutomovilJugador buscarBinarioAutomovil(int pPlaca) {
		ArrayList<AutomovilJugador> lista = darAutoMovilesJugadorOrdenadosSeleccion();
		
		AutomovilJugador encontrado = null;
		int inicio = 0;
		int fin = lista.size()-1;
		while (inicio <= fin && encontrado == null ) {
			int medio = (inicio + fin ) / 2 ;
			if (lista.get(medio).darPlaca() == pPlaca ) {
				encontrado = lista.get(medio);
			} else if (lista.get(medio).darPlaca()  > pPlaca) {
				fin = medio -1 ;
			} else {
				inicio = medio + 1;
			}
		}
		return encontrado;
	}
	
	public  ArrayList<AutomovilJugador> darAutoMovilesJugador() {
		AutomovilJugador actual = darPrimerAutomovilListaJugador();
		ArrayList<AutomovilJugador> lista = new ArrayList<AutomovilJugador>();
		while(actual != null) {
			lista.add(actual);
			actual = (AutomovilJugador) actual.darAutomovilAnterior();
		}
		
		return lista;
	}
	
	public ArrayList<AutomovilJugador> darAutoMovilesJugadorOrdenadosSeleccion() {
		ArrayList<AutomovilJugador> lista = darAutoMovilesJugador();
		
		for (int i = 0; i > lista.size() -1; i++) {
			AutomovilJugador menor = lista.get(i); 
			int cual = i;
			for (int j = i + 1; j < lista.size(); j++  ) {
				if ( lista.get(j).darPlaca() < menor.darPlaca() ) {
					menor = lista.get(j);
					cual = j;
				}
			}
			AutomovilJugador temp = lista.get(cual);
			lista.set(i, menor);
			lista.set(cual,temp);
		}
		
		return lista;
	}
}
