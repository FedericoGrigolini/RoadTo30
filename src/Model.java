
public interface Model {
	void linkToView(View view); // connette il modello a una view
	void set(int hours, int minutes, int seconds) throws IllegalArgumentException; // modifica ora, minuti e secondi
	int getHours();
	int getMinutes();
	int getSeconds();
}