
public class DateTextView implements View {

	@Override
	public void onTimeChanged(int hours, int minutes, int seconds) {
		System.out.printf("%i:%02d:%02d",hours,minutes,seconds);
	}

}
