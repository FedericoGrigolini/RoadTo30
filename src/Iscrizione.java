public class Iscrizione implements Comparable<Iscrizione> {
	private Utente user;
	private Mese mStart,mFinish;
	private int aStart,aFinish;
	
	public Iscrizione(Utente utente, Mese meseInizio, int annoInizio, Mese meseFine, int annoFine)throws IscrizioneTroppoLungaException, IscrizioneVuotaException {
		this.user=utente;
		this.mStart=meseInizio;
		this.mFinish=meseFine;
		this.aStart=annoInizio;
		this.aFinish=annoFine;
		if(mStart.indice()>mFinish.indice()){
			throw new IscrizioneVuotaException();
		}
		if(aFinish>aStart+1){
			throw new IscrizioneTroppoLungaException();
		}else{
			if(aFinish==aStart+1){
				if(mStart.indice()>mFinish.indice()){
					throw new IscrizioneTroppoLungaException();
				}
			}
		}
	}
	
	public Utente getUtente() { return this.user; }
	
	public boolean equals(Object other) { 
		if(other instanceof Iscrizione){
			Iscrizione temp= (Iscrizione) other;
			return temp.getUtente()==this.getUtente()&&
					temp.aFinish==this.aFinish &&
					temp.aStart==this.aStart &&
					temp.mFinish==this.mFinish &&
					temp.mStart==this.mStart;
		}
		return false;
	}
	
	public int hashCode() { 
		return (int)Math.sqrt(this.user.hashCode()*this.mStart.indice()+this.aStart);
	}
	
	public int compareTo(Iscrizione other) {
		if(this.mStart==other.mStart && this.aStart==other.aStart){
			if(this.getUtente().equals(other.getUtente())){
				if(this.mFinish==other.mFinish&&this.aFinish==other.aFinish){
					return 0;
				}else{
					if(this.aFinish==other.aFinish){
						if(this.mFinish.indice()<other.mFinish.indice()){
							return 1;
						}else{
							return -1;
						}
					}else{
						if(this.aFinish<other.aFinish){
							return 1;
						}else{
							return -1;
						}
					}
				}
			}else{
				if(this.getUtente().cognome.compareTo(other.getUtente().cognome)==0){
					if(this.getUtente().nome.compareTo(other.getUtente().nome)==0){
						return 0;
					}else{
						return(this.getUtente().nome.compareTo(other.getUtente().nome)); 
					}
				}else{
					return this.getUtente().cognome.compareTo(other.getUtente().cognome);
				}
			}	
		}else{
			if(this.aStart==other.aStart){
				if(this.mStart.indice()<other.mStart.indice()){
					return 1;
				}else{
					return -1;
				}
			}else{
				if(this.aStart<other.aStart){
					return 1;
				}else{
					return -1;
				}
			}
		}
	}
	
	public String toString() {
		return this.getUtente().toString() +" : iscritto dall'inizio di "+this.mStart+" "+this.aStart+" fino alla fine di "+this.mFinish+" "+this.aFinish;
	}
	
	private int getDurata(){
		if(this.aStart==this.aFinish){
			return this.mFinish.indice()-this.mStart.indice();
		}else{
			return(this.mFinish.indice()+(Mese.NUMERO_MESI-this.mStart.indice()));
		}
		
	}
	
	public boolean sovrappostaCon(Iscrizione other) {
		if(this.aStart==other.aFinish){			
			if(this.mStart.indice()>other.mFinish.indice()){
				return false;
			}
		}else{
			if(this.aStart>other.aFinish){
				return false;
			}
		}
		if(other.aStart==this.aFinish){
			if(other.mStart.indice()>this.mFinish.indice()){
				return false;
			}
		}else{
			if(other.aStart>this.aFinish){
				return false;
			}
		}
		return true;
	}
	
	public int costo() {
		int d=this.getDurata();
		if(d<=2){
			return 50*d;
		}
		if(d<=5){
			return 40*d;
		}
		if(d<=11){
			return 35*d;
		}else{
			return 30*d;
		}
	}
	
	public boolean relativaAl(int anno) {
		return this.aFinish==anno||this.aStart==anno;
	}
}