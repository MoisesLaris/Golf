package tminigolf;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JuegoLogica extends JPanelBackground implements ActionListener, KeyListener, MouseListener {
	private Niveles niveles;
	private Ball ball;
	private Club club;			
	private boolean pelotah,inicio,fin;
	private Timer timer;
        int nivel = 0,turno,contiros,jugadores;
        Jugadores []jugador;
	public JuegoLogica() {
                jugadores = 0;
                contiros = 1;
                turno = 1;
                inicio = false;
		addKeyListener(this);	
		addMouseListener(this);
		setBackground(Color.gray);
		setPreferredSize(new Dimension(1020, 600));
                setOpaque(false);               
                setBackground("pasto1.jpeg");
		setFocusable(true);
		iniciarNivel();			
        }
	private void iniciarNivel() {	
		niveles = new Niveles(nivel);		
		ball = new Ball(niveles.ballStartPos.x, niveles.ballStartPos.y);
		club = new Club(ball);
		pelotah = false;
                
		timer = new Timer(15, this);
		timer.start();
                 
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
			timer.stop();
			iniciarNivel();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP && !ball.movimiento && inicio) {	
				club.powerPlus();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && !ball.movimiento && inicio ) {	
				club.powerMinus();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER && inicio) {
			if(!ball.movimiento && inicio) {				
				ball.velocidad = club.ballCenterToClickUnit.times(-1.0f).times(club.power);
				club.power = 4;
				ball.movimiento = true;
				club.isMouseClicked = false;
                                contiros++;
                                jugador[turno-1].tiros++;
			}
		}
                if(e.getKeyCode() == KeyEvent.VK_1 && !inicio){
                    inicio = true;
                    jugador = new Jugadores[1];
                    jugador[0] = new Jugadores();
                    jugadores = 1;
                }
                 /*if(e.getKeyCode() == KeyEvent.VK_2 && !inicio){
                    inicio = true;
                    jugador = new Jugadores[2];
                    jugador[0] = new Jugadores();
                    jugador[1] = new Jugadores();
                    jugadores = 2;
                }*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!ball.movimiento && inicio) 
			club.mouseClicked(new Posicion(e.getX(), e.getY()));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);        
                if(inicio && !fin){
                    g.setColor(Color.white);  
                    for(Lineas l : niveles.lineas) {
                        for(int i=0;i<10;i++){
                            g.drawLine(Math.round(l.x1+i), Math.round(l.y1+i), Math.round(l.x2+i), Math.round(l.y2+i));
                            g.drawLine(Math.round(l.x1+i), Math.round(l.y1+i), Math.round(l.x2+i), Math.round(l.y2+i));
                            g.drawLine(Math.round(l.x1+i), Math.round(l.y1+i), Math.round(l.x2+i), Math.round(l.y2+i));
                        }  
                        
                    }
                    g.setColor(Color.black);
                    g.fillOval(Math.round(niveles.goalPos.x), Math.round(niveles.goalPos.y), Math.round(ball.diametro + 6), Math.round(ball.diametro + 6));
                    g.setColor(Color.white);
                    g.fillOval(Math.round(ball.posicion.x), Math.round(ball.posicion.y), Math.round(ball.diametro), Math.round(ball.diametro));
                    g.setColor(Color.cyan);
                    if(!ball.movimiento && club.isMouseClicked) {
                            for(int i=0;i<3;i++)
                            g.drawLine(Math.round(club.startClub.x+i), Math.round(club.startClub.y+i), Math.round(club.endClub.x+i), Math.round(club.endClub.y+i));
                           // g.drawLine(Math.round(club.startClub.x), Math.round(club.startClub.y), Math.round(club.clubArrowLeft.x), Math.round(club.clubArrowLeft.y));
                           //g.drawLine(Math.round(club.startClub.x), Math.round(club.startClub.y), Math.round(club.clubArrowRight.x), Math.round(club.clubArrowRight.y));			
                    }
                    g.setColor(Color.yellow);
                    g.setFont( new Font("Arial",Font.BOLD,15)); //LETRA Y TAMAÑO
                    g.drawString("NIVEL: "+(nivel+1), 13,13);
                }else if(!fin && !inicio){
                    Inicio(g);
                }else 
                    Fin(g);
		Toolkit.getDefaultToolkit().sync();
	}
        public void Inicio(Graphics g){
             BufferedImage mini = null;
            try {
                mini = ImageIO.read(new File("Mini.png") );
            } catch (IOException ex) {
                Logger.getLogger(JuegoLogica.class.getName()).log(Level.SEVERE, null, ex);
            }
            //INSTRUCCIONES CON g.drawString("MENSAJE",X,Y);
            g.drawImage(mini, 300, 100, null); 
            g.setColor(Color.WHITE);
            g.setFont( new Font("Arial",Font.BOLD,50)); //LETRA Y TAMAÑO
            g.drawString("START  ¡PUCHELE 1!",243,400);
            //g.drawString("Presione 2 -> Para dos jugadores(Inicia el juego)",100,320);
           // g.drawString("Con el mouse se dirige la pelota",100,370);
            //g.drawString("Con las teclas arriba y abajo crece o decrece el tamaño de fuerza(para la velocidad)",100,410);
            //g.drawString("Con Enter se dispara la pelota",100,390);
            g.setFont( new Font("Arial",Font.BOLD,14)); //LETRA Y TAMAÑO
            g.drawString("BY: VONICE & MOISY", 40, 580);
            
        }
        public void Fin(Graphics g){
            int Gano = 0,mayor=0;
            for(int i = 0; i < jugadores; i++){
                g.drawString("Jugador: "+(i+1)+" Puntos: "+jugador[i].score,200,280+(i*20));
                if(jugador[i].score>mayor){
                    mayor = jugador[i].score;
                    Gano = i+1;
                }
                   
            }
            g.drawString("Ganó el jugador "+Gano,200,350);
        }
	@Override
	public void actionPerformed(ActionEvent e) {
             if(pelotah) { //Si está en el hoyo
                        for(int i = 0; i < jugadores; i++){
                            jugador[i].Calcular();
                            jugador[i].Regresar();
                        }
                        jugador[turno-1].score+=1000;
                        nivel++;
                        contiros--;
                        iniciarNivel();
                        if(nivel>17)
                            fin = true;
		}
		if(!pelotah) { // SI no está
			Posicion oP = ball.posicion;
			Posicion op = oP.plus(new Posicion(ball.diametro/ 2, ball.diametro / 2)); // Origo To Old Pos Center
			Posicion o_newPos = ball.posicion.plus(ball.velocidad);
			Posicion o_npc = o_newPos.plus(new Posicion(ball.diametro / 2, ball.diametro / 2)); // Origo To New Pos Center
			boolean collision = false;
			boolean cornerHit = false;
			boolean straightHit = false;			
			Lineas hitLS = null;
			Posicion o_hitCorner = null;
			for(Lineas ls : niveles.lineas) {
				if(!straightHit) {
					Posicion o_ls1 = new Posicion(ls.x1, ls.y1);
					Posicion o_ls2 = new Posicion(ls.x2, ls.y2);

					Posicion ls1_npc = o_npc.minus(o_ls1);
					Posicion ls1_ls2 = o_ls2.minus(o_ls1);
					Posicion ls1_ls2_ORT = new Posicion(-ls1_ls2.y,ls1_ls2.x);
					float s1 = ls1_npc.cross(ls1_ls2_ORT);
					float s2 = ls1_ls2.cross(ls1_ls2_ORT);
					if(s1 * s2 <= 0) {
						if(!cornerHit) {
							if(ls1_npc.length() < ball.diametro/ 2) {
								collision = true;
								cornerHit = true;
								o_hitCorner = new Posicion(ls.x1, ls.y1);
							}
						}
					} else {
						Posicion ls2_npc = o_npc.minus(o_ls2);
						Posicion ls2_Ls1 = o_ls1.minus(o_ls2);
						Posicion ls2_ls1_ORT = new Posicion(-ls2_Ls1.y, ls2_Ls1.x);
						float s3 = ls2_npc.cross(ls2_ls1_ORT);
						float s4 = ls2_Ls1.cross(ls2_ls1_ORT);
						if(s3 *s4 <= 0) {
							if(!cornerHit) {
								if(ls2_npc.length() < ball.diametro / 2) {
									collision = true;
									cornerHit = true;
									o_hitCorner = new Posicion(ls.x2, ls.y2);
								}
							}
						} else {
							Posicion ls1_ls2_UNIT = ls1_ls2.dividedBy(ls1_ls2.length());
							float s5 = ls1_npc.dot(ls1_ls2_UNIT);
							Posicion ls1ToPointClosestToBallOnLine = ls1_ls2_UNIT.times(s5);
							Posicion pointClosestToBallOnLine = o_ls1.plus(ls1ToPointClosestToBallOnLine);
							Posicion ballToPointClosestToBallOnLine = o_npc.minus(pointClosestToBallOnLine);
							if(ballToPointClosestToBallOnLine.length() < ball.diametro / 2) {
								collision = true;
								straightHit = true;
								hitLS = ls;
							}						
						}
					}
				}				
			}

			if(collision) {
				if(straightHit) {
					LineSegmentBallCollision(hitLS, op, o_npc);									} 
				if(cornerHit) {					
					Posicion o_opc_MOVED = new Posicion(op.x - o_hitCorner.x, op.y - o_hitCorner.y);
					Posicion o_npc_MOVED = new Posicion(o_npc.x - o_hitCorner.x, o_npc.y - o_hitCorner.y);
					Posicion v1 = o_opc_MOVED;
					Posicion v2 = o_npc_MOVED;
					double d_x = v2.x - v1.x;
					double d_y = v2.y - v1.y;
					double d_r = Math.sqrt(d_x*d_x + d_y*d_y);
					double D = v1.x*v2.y - v2.x*v1.y;
					double r = ball.diametro / 2;
					double xPlus = (D*d_y + Math.signum(d_y) * d_x * Math.sqrt(r*r*d_r*d_r - D*D)) / (d_r*d_r);
					double xMinus = (D*d_y - Math.signum(d_y) * d_x * Math.sqrt(r*r*d_r*d_r - D*D)) / (d_r*d_r);
					double yPlus = (-D*d_x + Math.abs(d_y) * Math.sqrt(r*r*d_r*d_r - D*D)) / (d_r*d_r);
					double yMinus = (-D*d_x - Math.abs(d_y) * Math.sqrt(r*r*d_r*d_r - D*D)) / (d_r*d_r);					
					Posicion vPlus = new Posicion((float)xPlus, (float)yPlus);
					Posicion vMinus = new Posicion((float)xMinus, (float)yMinus);
					Posicion o_opc_MOVED_vPlus = vPlus.minus(o_opc_MOVED);
					float o_opc_MOVED_vPlus_LENGTH = o_opc_MOVED_vPlus.length();
					Posicion o_opc_MOVED_vMinus = vMinus.minus(o_opc_MOVED);
					float o_opc_MOVED_vMinus_LENGTH = o_opc_MOVED_vMinus.length();
					Posicion o_ip_MOVED = null;
					if(o_opc_MOVED_vPlus_LENGTH < o_opc_MOVED_vMinus_LENGTH) {
						o_ip_MOVED = vPlus;
					} else {
						o_ip_MOVED = vMinus;
					}
					Posicion av1_MOVED = new Posicion(-o_ip_MOVED.y, o_ip_MOVED.x);
					Posicion av2_MOVED = new Posicion(o_ip_MOVED.y, -o_ip_MOVED.x);
					Posicion av1 = new Posicion(av1_MOVED.x + o_hitCorner.x, av1_MOVED.y + o_hitCorner.y);
					Posicion av2 = new Posicion(av2_MOVED.x + o_hitCorner.x, av2_MOVED.y + o_hitCorner.y);
        				Lineas absL = new Lineas(av1.x, av1.y, av2.x, av2.y);
					LineSegmentBallCollision(absL, op, o_npc);					
				}
			} else {
				ball.posicion = o_newPos;
			}
			Posicion o_centerGoal = new Posicion(niveles.goalPos.x + ball.diametro/ 2 + 3, niveles.goalPos.y + ball.diametro / 2 + 3); 
			if(o_npc.minus(o_centerGoal).length() < ball.diametro / 2 + 3) {
				ball.posicion = niveles.goalPos.plus(new Posicion(3, 3));
				pelotah = true;
			} 
			if(ball.velocidad.length() > 0.1f) {
				ball.velocidad = ball.velocidad.times(0.985f);
			} else {
				ball.velocidad = new Posicion(0,0);
				ball.movimiento= false; 
                                if(jugadores == 2){
                                    if(contiros%2 == 0){
                                        turno = 2;
                                    } else
                                        turno = 1;
                                }
			}
			repaint();
		}		
	}

	void LineSegmentBallCollision(Lineas ls, Posicion o_opc, Posicion o_npc) {
		Posicion o_v1 = new Posicion(ls.x1, ls.y1);
		Posicion o_v2 = new Posicion(ls.x2, ls.y2);
		Posicion v1_v2 = o_v2.minus(o_v1);						
		Posicion v1_v2_UNIT = v1_v2.dividedBy(v1_v2.length());	
		Posicion v1_npc = o_npc.minus(o_v1);						
		float f = v1_v2_UNIT.dot(v1_npc);						
		Posicion v1_projNpcOnv1v2 = v1_v2_UNIT.times(f);			
		Posicion o_projNpcOnv1v2 = o_v1.plus(v1_projNpcOnv1v2);
		Posicion projNpcOnv1v2_npc = o_npc.minus(o_projNpcOnv1v2);	
		Posicion projNpcOnv1v2_npc_UNIT = projNpcOnv1v2_npc.dividedBy(projNpcOnv1v2_npc.length());
		float distNpcTov1v2Moved = ball.diametro / 2 - projNpcOnv1v2_npc.length();
		Posicion npc_npcAfterCollision = projNpcOnv1v2_npc_UNIT.times(distNpcTov1v2Moved * 2);
		Posicion o_npcAfterCollision = o_npc.plus(npc_npcAfterCollision);
		Posicion cnpc = o_npcAfterCollision; 	// Correct new position center
		ball.posicion = new Posicion(cnpc.x - ball.diametro / 2, cnpc.y - ball.diametro / 2);
		Posicion moveLineSegmentBy = projNpcOnv1v2_npc_UNIT.times(ball.diametro / 2);
		Posicion hitLS1Moved = o_v1.plus(moveLineSegmentBy);
		Posicion hitLS2Moved = o_v2.plus(moveLineSegmentBy);
		float x1 = o_opc.x;
		float y1 = o_opc.y;
		float x2 = o_npc.x;
		float y2 = o_npc.y;
		float a = 0;
		float b = 0;
		String ballDir = "skew";
		if(x1 != x2 && y1 != y2) { 
			a = (y2 - y1) / (x2 - x1);
			b = y1 - a*x1;
		} 
		if(x1 != x2 && y1 == y2) {	
			ballDir = "hori";
		}
		if(x1 == x2 && y1 != y2){	
			ballDir = "vert";
		}
		float x = 0;
		float y = 0;					
		if(hitLS1Moved.x == hitLS2Moved.x) {
			if(ballDir.equals("skew")) {
				x = hitLS1Moved.x;
				y = a*x + b;	
			}
			if(ballDir.equals("hori")) {
				x = hitLS1Moved.x;
				y = y1;
			}
		} else if(hitLS1Moved.y == hitLS2Moved.y) {
			if(ballDir.equals("skew")) {
				y = hitLS1Moved.y;
				x = (y - b) / a;
			}
			if(ballDir.equals("vert")) {
				x = x1;
				y = hitLS1Moved.y;
			}
		} else {
			float x1l = hitLS1Moved.x;
			float y1l = hitLS1Moved.y;
			float x2l = hitLS2Moved.x;
			float y2l = hitLS2Moved.y;
			float al = (y2l - y1l) / (x2l - x1l);
			float bl = y1l - al*x1l;
			if(ballDir.equals("skew")) {							
				x = (bl - b) / (a - al);
				y = a*x + b;
			}
			if(ballDir.equals("vert")) {
				x = x1;
				y = al*x + bl;
			}
			if(ballDir.equals("hori")) {
				y = y1;
				x = (y - bl) / al;
			}
		}
		Posicion o_ip = new Posicion(x, y);
		Posicion ip_cnpc = cnpc.minus(o_ip);
		Posicion ip_cnpc_UNIT = ip_cnpc.dividedBy(ip_cnpc.length());
		Posicion newSpeedVector = ip_cnpc_UNIT.times(ball.velocidad.length());
		ball.velocidad = newSpeedVector;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }

}
