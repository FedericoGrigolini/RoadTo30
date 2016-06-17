import java.util.Iterator;

public class StringTokenization implements Tokenization {
	
	private String core;
	private String limit;
	
	public StringTokenization(String s, String delimiters) throws NoDelimitersException {
		if(delimiters.isEmpty()){
			throw new NoDelimitersException();
		}
		this.core=s;
		this.limit=delimiters;
	}

	public Iterator<String> iterator() {
		
		return new Iterator<String>(){
			
			private String pointer=core;
			
			@Override
			public boolean hasNext() {
				if(pointer.isEmpty())
					return false;
				return true;
			}
			
			@Override
			public String next() {
				char temp;
				String result ="";
				
				do{
					temp=pointer.charAt(0);
					result+=temp;
					pointer=pointer.substring(1);
				}while(!pointer.isEmpty() && limit.indexOf(temp)==-1);
				
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();	
			}
			
		};
		
	}

}
