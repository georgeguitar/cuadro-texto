package principal;

interface Componente {
	void dibujar();
}

class CuadroDeTexto implements Componente {
	 private int ancho, alto;
	
	 public CuadroDeTexto(int ancho, int alto) {
	     this.ancho = ancho;
	     this.alto = alto;
	 }
	 
	 public void dibujar() {
	     System.out.println("- Cuadro de Texto (ancho, alto): " + ancho + ", " + alto);
	 }
}

abstract class Decorador implements Componente {
	 private Componente Componente;
	
	 public Decorador(Componente Componente) {
	     this.Componente = Componente;
	 }
	
	 public void dibujar() {
	     Componente.dibujar();
	 }
}

class DecoradorDeBorde extends Decorador {
	 public DecoradorDeBorde(Componente Componente) {
	     super(Componente);
	 }
	 public void dibujar() {
	     super.dibujar();
	     System.out.println("  * Con bordes.");
	 }
}

class DecoradorBarraDesplazamientoVertical extends Decorador {
	public DecoradorBarraDesplazamientoVertical(Componente Componente) {
	   super(Componente);
	}
	public void dibujar() {
	   super.dibujar();
	   System.out.println("  * Con barra de desplazamiento vertical.");
	}
}

class DecoradorBarraDesplazamientoHorizontal extends Decorador {
	 public DecoradorBarraDesplazamientoHorizontal(Componente Componente) {
	     super(Componente);
	 }
	 public void dibujar() {
	     super.dibujar();
	     System.out.println("  * Con barra de desplazamiento horizontal");
	 }
}


public class Main {
	public static void main(String[] args) {
        Componente CuadroDeTextoSimple = new CuadroDeTexto(100, 35);
        CuadroDeTextoSimple.dibujar();
		
        Componente CuadroDeTextoNormal = new DecoradorDeBorde(new DecoradorBarraDesplazamientoHorizontal(new CuadroDeTexto(100, 35)));
        CuadroDeTextoNormal.dibujar();
        
        Componente CuadroDeTextoCompleto = new DecoradorDeBorde(new DecoradorBarraDesplazamientoVertical(new DecoradorBarraDesplazamientoHorizontal(new CuadroDeTexto(100, 35))));
        CuadroDeTextoCompleto.dibujar();
	}
}
