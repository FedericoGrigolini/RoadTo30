import java.util.HashSet;
import java.util.Set;

public class Time implements Model {

	private final Set<View> views = new HashSet<>(); // tutte le view a cui e’ connesso
	private int hours,minutes,seconds;
	
	@Override
	public void set(int hours, int minutes, int seconds) throws IllegalArgumentException {
		if(hours>23||hours<0||minutes<0||minutes>59||seconds<0||seconds>59){
			throw new IllegalArgumentException("Illegal Time");
		}
		
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
		
		for (View view: views) // notifica tutte le view del nuovo orario
			view.onTimeChanged(hours, minutes, seconds);
	}
	
	@Override
	public void linkToView(View view) {
		views.add(view);
		view.onTimeChanged(hours, minutes, seconds);
	}
	@Override
	public int getHours() {
		// TODO Auto-generated method stub
		return this.hours;
	}
	@Override
	public int getMinutes() {
		// TODO Auto-generated method stub
		return this.minutes;
	}
	@Override
	public int getSeconds() {
		// TODO Auto-generated method stub
		return this.seconds;
	}
}