package tminigolf;

public class Club {	
	
	Ball ball;
	Posicion mouseClick;
	
	int power = 6;
	
	Posicion startClub;
	Posicion endClub;
	Posicion clubArrowLeft;
	Posicion clubArrowRight;

	Posicion ballCenterToClickUnit;
	
	boolean isMouseClicked;
	
	Club(Ball ball) {
		this.ball = ball;
		mouseClick = new Posicion(ball.posicion.x + ball.diametro / 2, ball.posicion.y + ball.diametro * 2);
		calcParams();
		isMouseClicked = true;
	}
	
	void mouseClicked(Posicion clickPos) {
		mouseClick = clickPos;
		calcParams();
		isMouseClicked = true;
	}
	
	void powerPlus() {
		if(power < 15) {
			power++;
			calcParams();
		}
	}
	
	void powerMinus() {
		if(power > 1) {
			power--;
			calcParams();
		}
	}
	
	void calcParams() {
		Posicion ballCenter = new Posicion(ball.posicion.x + ball.diametro/2, ball.posicion.y + ball.diametro/2);
		Posicion ballCenterToClick = mouseClick.minus(ballCenter);
		ballCenterToClickUnit = ballCenterToClick.dividedBy(ballCenterToClick.length());

		startClub = ballCenter.plus(ballCenterToClickUnit.times(ball.diametro));
		endClub = ballCenter.plus(ballCenterToClickUnit.times(ball.diametro + 10 * power));

		Posicion aUnitLeftFromStartClub = new Posicion(-ballCenterToClickUnit.y, ballCenterToClickUnit.x);
		Posicion aUnitRightFromStartClub = new Posicion(ballCenterToClickUnit.y, -ballCenterToClickUnit.x);

		clubArrowLeft = startClub.plus(aUnitLeftFromStartClub.times(10)).plus(ballCenterToClickUnit.times(10));
		clubArrowRight = startClub.plus(aUnitRightFromStartClub.times(10)).plus(ballCenterToClickUnit.times(10));		
	}
	
	
	
}
