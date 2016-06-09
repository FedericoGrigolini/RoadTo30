
public class Data {
	private int giorno,mese,anno;
	
	public Data(int g, int m, int a){
		this.giorno = g;
		this.mese = m;
		this.anno = a;
		dataControl(a, m, g);
	}
	
	public Data(int g, int m){
		this.giorno = g;
		this.mese = m;
		this.anno = 2008;
		dataControl(2008, m, g);
		
	}
	
	public Data(int g){
		this.giorno = g;
		this.mese = 1;
		this.anno = 2008;
		dataControl(2008, 1, g);
	}
	
	public Data(){
		this.giorno = 13;
		this.mese = 1;
		this.anno = 1973;
	}
	
	private static boolean bisestile(int a){
		if(a%4==0){
			if(a%100==0 && a%400!=0){
				return false;
			}
			return true;
		}
		return false;
	}
	
	private static void dataControl(int a, int m, int g){
		if(a<1900 || m>12 || m<1 || a<1 || a>31 ){
			System.out.println("Errore, data inserita non valida");
		}
		
		
		
		
	}
	
	public String toString(){
		String temp = ""+this.giorno;
		switch(this.mese){
			case 1:{
				temp+=" Gennaio ";
				break;
			}
			case 2:{
				temp+=" Aprile ";
				break;
			}
			case 3:{
				temp+=" Marzo ";
				break;
			}
			case 4:{
				temp+=" Aprile ";
				break;
			}
			case 5:{
				temp+=" Maggio ";
				break;
			}
			case 6:{
				temp+=" Giugno ";
				break;
			}
			case 7:{
				temp+=" Luglio ";
				break;
			}
			case 8:{
				temp+=" Agosto ";
				break;
			}
			case 9:{
				temp+=" Settembre ";
				break;
			}
			case 10:{
				temp+=" Ottobre ";
				break;
			}
			case 11:{
				temp+=" Novembre ";
				break;
			}
			case 12:{
				temp+=" Dicembre ";
				break;
			}
			default:{
				System.out.print("Errore, mese non valido");
			}
		}
		temp+=this.anno;
		return temp;
	}
	
	public int passatiDal1900(){
		int temp=this.giorno;
		//calcolo anni passati
		for(int i=1900; i<this.anno; i++){
			if(bisestile(this.anno)){
				temp += 366;
			}
			temp += 365;
		}
		//calcolo giorni dei mesi di quest'anno.
		int m=this.mese-1;
		for(int i=m; i>0; i--){
			switch(this.mese){
				case 1:{
					temp+=31;
					break;
				}
				case 2:{
					if(bisestile(this.anno)){
						temp += 29;
					}
					temp+= 28;
					break;
				}
				case 3:{
					temp+= 31;
					break;
				}
				case 4:{
					temp+= 30;
					break;
				}
				case 5:{
					temp+=31;
					break;
				}
				case 6:{
					temp+=30;
					break;
				}
				case 7:{
					temp+=31;
					break;
				}
				case 8:{
					temp+=31;
					break;
				}
				case 9:{
					temp+=30;
					break;
				}
				case 10:{
					temp+=31;
					break;
				}
				case 11:{
					temp+=30;
					break;
				}
				default:{
					System.out.print("Errore, mese non valido");
				}
			}
		}	
		return temp;
	}

	public int passatiDallInizioDellAnno(){
		int temp= this.giorno;
		int m=this.mese-1;
		for(int i=m; i>0; i--){
			switch(this.mese){
				case 1:{
					temp+=31;
					break;
				}
				case 2:{
					if(bisestile(this.anno)){
						temp += 29;
					}
					temp+= 28;
					break;
				}
				case 3:{
					temp+= 31;
					break;
				}
				case 4:{
					temp+= 30;
					break;
				}
				case 5:{
					temp+=31;
					break;
				}
				case 6:{
					temp+=30;
					break;
				}
				case 7:{
					temp+=31;
					break;
				}
				case 8:{
					temp+=31;
					break;
				}
				case 9:{
					temp+=30;
					break;
				}
				case 10:{
					temp+=31;
					break;
				}
				case 11:{
					temp+=30;
					break;
				}
				default:{
					System.out.print("Errore, mese non valido");
				}
			}
		}
		return temp;
	}

	public boolean precede(Data other){
		if(other.anno>this.anno){
			return true;
		}
		return false;
	}
	
	public static void main(){
			
	}
}


