public class Utente {
	protected String nome;
	protected String cognome;
	
	public Utente(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}
	
	private String getName(){
		return this.nome;
	}
	private String getSurname(){
		return this.cognome;
	}
	
	public boolean equals(Object other) { 
		if(other instanceof Utente){
			Utente u = (Utente) other;
			return this.nome==u.getName()&&
					this.cognome==u.getSurname();
		}
		return false;
	}
	
	public int hashCode() { 
		return nome.hashCode() ^ cognome.hashCode();
	}
	
	public int compareTo(Utente other) {  
		if(this.getSurname().compareTo(other.getSurname())==0){
			return this.getSurname().compareTo(other.getSurname()); 
		}else{
			return this.getSurname().compareTo(other.getSurname());
		}
	}
	
	public String toString() { 
		return this.nome+" "+this.cognome;
	}
}
