
public enum Mese {
	GENNAIO,
	FEBBRAIO,
	MARZO,
	APRILE,
	MAGGIO,
	GIUGNO,
	LUGLIO,
	AGOSTO,
	SETTEMBRE,
	OTTOBRE,
	NOVEMBRE,
	DICEMBRE;
	
	public final static int NUMERO_MESI = elementi().length;
	
	public static Mese[] elementi(){
		return values();
	}
	
	public int indice(){
		for (int pos = 0; pos < NUMERO_MESI; pos++)
			if (elementi()[pos] == this)
				return pos;
		throw new RuntimeException("impossibile");
	}
}
