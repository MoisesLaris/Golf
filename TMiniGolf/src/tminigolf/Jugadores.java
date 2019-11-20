package tminigolf;

public class Jugadores {
    int puntos,tiros,score;
    Jugadores(){
        puntos = 1000;
        tiros = 0;
        score = 0;
    }
    void Calcular(){
        if(tiros>0)
            this.score += puntos/tiros;  
    }
    void Regresar(){
        tiros = 0;
    }
}
