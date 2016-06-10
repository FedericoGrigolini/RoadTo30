import java.util.SortedSet;
import java.util.TreeSet;
public class Registro {
	
		private final SortedSet<Iscrizione> iscrizioni = new TreeSet<Iscrizione>();
		
		//public Registro(){}
		
		public void aggiungi(Iscrizione iscrizione) throws IscrizioneSovrappostaException {
			Utente p = iscrizione.getUtente(); 
			for(Iscrizione altra: iscrizioni){
				if(altra.getUtente().equals(p)&&altra.sovrappostaCon(iscrizione)){
					throw new IscrizioneSovrappostaException();
				}	
			}
			iscrizioni.add(iscrizione);
		}
		
		public String toString() {
			String s="Registro Iscrizioni:\n";
			for(Iscrizione i:iscrizioni){
				s+=i.toString()+". Costo: "+i.costo()+"\n";
			}
			return s;
		}
		
		public Registro proiettaSu(int anno) {
			Registro nuovo=new Registro();
			for(Iscrizione i:iscrizioni){
				if(i.relativaAl(anno)){
					nuovo.iscrizioni.add(i);
				}
			}
			return nuovo;
		}
}