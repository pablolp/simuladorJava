package simulacion;

public class Jugada {
	private int balance;
	private int balanceApuesta;
	private int fibonacciIt;
	private int ganadas;
	private int jugadas;
	private double limite;
	private int max;
	private int maxFibonacciIt;
	private int min;
	private int objetivo;
	private int totalApuesta;
	public Jugada(int inicio, int objetivo, double limite) {
		this.balance = inicio;
		this.balanceApuesta = 0;
		this.fibonacciIt = 0;
		this.ganadas = 0;
		this.jugadas = 0;
		this.limite = limite;
		this.max = inicio;
		this.maxFibonacciIt = 0;
		this.min = inicio;
		this.objetivo = objetivo;
		this.totalApuesta = 0;
	}
	
	public int crearApuesta(){
		int apuesta = 0;
		apuesta = Jugador.fibonacci[this.fibonacciIt++];
		if(apuesta >= balance*limite){
			this.fibonacciIt = 0;
			apuesta = Jugador.fibonacci[this.fibonacciIt];
		}		
		return apuesta;
	}
	
	public void apostar(int apuesta){
		int premio;
		balance -= apuesta;
		totalApuesta += apuesta;
		premio = Ruleta.hacerApuesta(apuesta);
		jugadas++;
		if(premio > 0){
			ganadas++;
			balance += premio;
			balanceApuesta += premio;
			if(balanceApuesta >=0){
				balanceApuesta = 0;
				fibonacciIt = 0;
			}
			else {
				balanceApuesta -= 2;
			}
		}
		else {
			fibonacciIt++;
			if(fibonacciIt > maxFibonacciIt) {
				maxFibonacciIt = fibonacciIt;
			}
		}
		if(balance<min){
			min = balance;
		}
		else if (balance > max){
			max = balance;
		}		
	}

	public boolean terminar() {
		boolean terminar = false;
		if (balance >= objetivo || balance <= 0) {
			terminar = true;
		}
		return terminar;
	}
	public int getBalance() {
		return balance;
	}
}
