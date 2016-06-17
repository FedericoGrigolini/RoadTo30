import java.util.Iterator;

public class DoubleTokenization implements Tokenization {

	private Tokenization core;
	private String limit;
	
	public DoubleTokenization(Tokenization base, String delimiters) { 
		this.core=base;
		this.limit=delimiters;
	}
	
	@Override
	public Iterator<String> iterator() { 
		return new Iterator<String>(){
			
			private Iterator<String> base = core.iterator();
			private Iterator<String> aux;
			
			@Override
			public boolean hasNext() {
				if(base.hasNext()||(aux!=null && aux.hasNext()))
					return true;
				return false;
			}

			@Override
			public String next() {
				if(aux!=null && aux.hasNext()){
					return aux.next();
				}
				
				try {
					this.aux= new StringTokenization(base.next(), limit).iterator();
				} catch (NoDelimitersException e) {
					e.printStackTrace();
				}
				return aux.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) throws NoDelimitersException {
		Tokenization tok = new StringTokenization("Questa$e’&una&prova!", "$&");
		for (String s: tok)
			System.out.println(s);
		
		Tokenization tok2 = new DoubleTokenization(tok, "ou");
		for (String s: tok2)
			System.out.println(s);
	}
	
}