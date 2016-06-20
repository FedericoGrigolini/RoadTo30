
public interface Controller {
	void onIncreaseHours(); // e’ stato richiesto l’incremento (circolare) dell’ora
	void onDecreaseHours(); // e’ stato richiesto il decremento (circolare) dell’ora
	void onIncreaseMinutes(); // e’ stato richiesto l’incremento (circolare) dei minuti
	void onDecreaseMinutes(); // e’ stato richiesto il decremento (circolare) dei minuti
	void onIncreaseSeconds(); // e’ stato richiesto l’incremento (circolare) dei secondi
	void onDecreaseSeconds(); // e’ stato richiesto il decremento (circolare) dei secondi
	void onResetTime(); // e’ stato richiesto di resettare l’orario al momento corrente
}
