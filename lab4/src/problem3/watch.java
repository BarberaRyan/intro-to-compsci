package problem3;

public class watch {
	private int hour;
	private int minute;
	private int second;
	
	public watch() {
		this.hour = 12;
		this.minute = 0;
		this.second = 0;
	}
	
	public void setHour(int x) {
		this.hour = x;
		this.minute = 0;
		this.second = 0;
	}
	
	public void  setMinute(int x) {
		this.minute = x;
		this.second = 0;
	}
	
	public void setSecond (int x){
		this.second = x;
	
	}
	private String getTime(){
		String hour_result = Integer.toString(hour);
		String minute_result = Integer.toString(minute);
		String second_result = Integer.toString(second);
		if (10 > hour){
			hour_result = "0" + hour;
		}
		if (10 > minute){
			minute_result = "0" + minute;
		}
		if (10 > second){
			second_result = "0" + second;
		}
		String time = hour_result +":"+ minute_result +":"+ second_result;
		return time;
	}
	public String toString(){
		return ("The current time is "+ getTime());
	}
	

		
}