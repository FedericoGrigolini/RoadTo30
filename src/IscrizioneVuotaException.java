
public class IscrizioneVuotaException extends Exception {
	public IscrizioneVuotaException(){
		super("Attenzione, la data di scadenza precede la data di inizio!");
	}
}
