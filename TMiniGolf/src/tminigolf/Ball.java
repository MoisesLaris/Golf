package tminigolf;
public class Ball { 
	int    diametro = 15;
	Posicion posicion;
	Posicion velocidad;	
	boolean movimiento = false;
	Ball(float x, float y) {
		posicion = new Posicion(x,y);
		velocidad = new Posicion(0,0);
	}	
}