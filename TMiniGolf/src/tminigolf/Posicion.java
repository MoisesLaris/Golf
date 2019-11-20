package tminigolf;

public class Posicion {
	
	float x;
	float y;
	
	Posicion(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	Posicion plus(Posicion v) {
		return new Posicion(x + v.x, y + v.y);
	}
	
	Posicion minus(Posicion v) {
		return new Posicion(x - v.x, y - v.y);
	}
	
	Posicion times(float f) {
		return new Posicion(x * f, y * f);
	}
	
	Posicion dividedBy(float f) {
		return new Posicion(x / f, y / f);
	}
	
	float length() {
		return (float) Math.sqrt(x*x + y*y);
	}	
	
	float cross(Posicion v) {
		return x*v.y - y*v.x;
	}
	
	float dot(Posicion v) {
		return x*v.x + y*v.y;
	}
	
	double dot(Posicion v, Posicion w) {
		return v.x*w.x + v.y*w.y;
	}
	
	double smallAngle(Posicion v, Posicion w) {
		double input = dot(v,w) / (w.length()*v.length());
		if (input > 1.0 || input < -1.0)
			return Math.PI;
		return Math.acos(input);
	}
	
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}

}
