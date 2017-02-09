package simulacion;

public class Jugador extends Thread{
	private int banckRoll;
	public static int fibonacci[] = {10,10,20,30,50,80,130,210,340,550,890,1440,2330,3770,6100,9870,15970};
	
	@Override
	public void run(){
		Jugada j = new Jugada(500, 1500, 0.2);
		int apuesta;
		do{
			apuesta = j.crearApuesta();
			j.apostar(apuesta);
		}while(!j.terminar());
		System.out.println(j.getBalance());
	}
	public static void main(String[] args) {
		new Jugador().start();
	}
}
