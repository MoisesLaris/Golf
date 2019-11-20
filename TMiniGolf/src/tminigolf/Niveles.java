package tminigolf;

import java.util.ArrayList;

public class Niveles {
	ArrayList<Lineas> lineas = new ArrayList<Lineas>();
        int [] vxo,vyo;
	Posicion ballStartPos;
	Posicion goalPos;
	int nivel;
	Niveles(int nivel) {
                this.nivel = nivel;
		// Walls
                        ballStartPos = new Posicion(950,540);
                    	goalPos = new Posicion(100,100);
                switch(nivel){
                    case 0:
                        lineas.add(new Lineas(250,20,250,250));
                        lineas.add(new Lineas(250,400,250,250));
                        lineas.add(new Lineas(500,200,900,580));
                        lineas.add(new Lineas(500,580,900,200));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 1:
                        lineas.add(new Lineas(20,400,900,400));
                        lineas.add(new Lineas(1000,500,100,500));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 2:
                        lineas.add(new Lineas(450,20,450,200));
                        lineas.add(new Lineas(20,300,800,300));
                        lineas.add(new Lineas(1000,600,300,600));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 3:
                        lineas.add(new Lineas(150,20,150,540));
                        lineas.add(new Lineas(300,580,300,100));
                        lineas.add(new Lineas(450,20,450,540));
                        lineas.add(new Lineas(600,580,600,100));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(750,20,750,540));
                        //lineas.add(new Lineas(650,580,650,100));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 4:

                        //--------------------------------------
                        lineas.add(new Lineas(550,580,550,450));
                        lineas.add(new Lineas(600,430,630,430));
                        lineas.add(new Lineas(1000,100,450,450));
                        lineas.add(new Lineas(20,500,500,100));
                        lineas.add(new Lineas(150,20,150,310));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 5:
                        lineas.add(new Lineas(350,580,350,500));
                        lineas.add(new Lineas(1000,520,540,520));
                        lineas.add(new Lineas(20,250,200,250));
                        lineas.add(new Lineas(350,20,350,250));
                        lineas.add(new Lineas(200,200,540,540));
                        lineas.add(new Lineas(200,540,540,200));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 6:
                        lineas.add(new Lineas(50,150,500,150));
                        lineas.add(new Lineas(550,20,550,550));
                        lineas.add(new Lineas(300,200,550,550));
                        lineas.add(new Lineas(100,200,350,550));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 7:
                        lineas.add(new Lineas(400,580,400,100));
                        lineas.add(new Lineas(20,580,400,500));
                        lineas.add(new Lineas(400,380,800,100));
                        lineas.add(new Lineas(200,200,550,530));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 8:
                        lineas.add(new Lineas(800,400,800,150));
                        lineas.add(new Lineas(400,20,400,300));
                        lineas.add(new Lineas(20,400,920,400));
                        lineas.add(new Lineas(300,450,1000,450));
                        lineas.add(new Lineas(20,500,600,500));
                        lineas.add(new Lineas(400,525,1000,525));
                        lineas.add(new Lineas(20,550,900,550));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 9:
                        lineas.add(new Lineas(20,350,200,350));
                        //lineas.add(new Lineas(100,400,400,100));
                        lineas.add(new Lineas(350,350,120,70));
                        lineas.add(new Lineas(350,350,100,200));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(450,20,450,250));
                        //lineas.add(new Lineas(20,300,800,300));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 10:

                        //-------------------------------------
                        lineas.add(new Lineas(250,30,100,150));
                        lineas.add(new Lineas(250,30,700,30));
                        lineas.add(new Lineas(700,30,700,500));
                        lineas.add(new Lineas(550,200,550,550));
                        lineas.add(new Lineas(550,550,830,550));
                        lineas.add(new Lineas(250,200,550,200));
                        lineas.add(new Lineas(700,500,830,500));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 11:
                        lineas.add(new Lineas(400,20,400,350));
                        lineas.add(new Lineas(400,580,400,400));
                        lineas.add(new Lineas(600,20,600,350));
                        lineas.add(new Lineas(600,580,600,400));
                        lineas.add(new Lineas(550,100,550,520));
                        lineas.add(new Lineas(550,100,550,520));
                        lineas.add(new Lineas(600,350,830,350));
                        lineas.add(new Lineas(600,400,830,400));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,680));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 12:
                        lineas.add(new Lineas(100,100,140,100));
                        lineas.add(new Lineas(100,100,100,140));
                        lineas.add(new Lineas(140,100,600,400));
                        lineas.add(new Lineas(100,140,600,450));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,680));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 13:
                        lineas.add(new Lineas(550,300,550,400));
                        lineas.add(new Lineas(550,20,550,250));
                        lineas.add(new Lineas(20,300,800,300));
                        lineas.add(new Lineas(1000,450,300,450));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 14:
                        lineas.add(new Lineas(435,20,435,450));
                        lineas.add(new Lineas(20,500,700,500));
                        lineas.add(new Lineas(750,580,750,250));
                        lineas.add(new Lineas(500,195,1000,195));
                        lineas.add(new Lineas(550,250,550,450));
                        lineas.add(new Lineas(550,250,600,250));
                        lineas.add(new Lineas(550,450,600,450));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 15:

                        //----------------
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 16:
                        lineas.add(new Lineas(20,180,150,180));
                        lineas.add(new Lineas(180,20,180,150));
                        lineas.add(new Lineas(1000,520,550,520));
                        lineas.add(new Lineas(520,580,520,550));
                        lineas.add(new Lineas(100,500,600,100));
                        //lineas.add(new Lineas(200,200,500,500));        
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    case 17:
                        lineas.add(new Lineas(350,467,1000,467));
                        lineas.add(new Lineas(20,233,600,233));
                        lineas.add(new Lineas(550,117,1000,117));
                        lineas.add(new Lineas(550,350,1000,350));
                        lineas.add(new Lineas(350,233,350,350));
                        lineas.add(new Lineas(450,467,450,350));
                        lineas.add(new Lineas(20,20,1000,20));
                        lineas.add(new Lineas(20,20,20,580));
                        lineas.add(new Lineas(20,580,1000,580));
                        lineas.add(new Lineas(1000,580,1000,20));
                        break;
                    default:
                        new Main().setVisible(true);
                        break;
                }
		
		
	}
}
