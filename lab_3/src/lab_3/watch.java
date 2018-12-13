package lab_3;

public class watch {
	private int hour;
	private int minute;
	private int second;
	
	public watch() {
		hour = 12;
		minute = 0;
		second = 0;
	}
	
	public void setHour(int x) {
		hour = x;
		minute = 0;
		second = 0;
	}
	
	public void  setMinute(int x) {
		minute = x;
		second = 0;
	}
	
	public void setSecond (int x){
		second = x;
	
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
		if (10 > hour){
			second_result = "0" + second;
		}
		String time = hour_result +":"+ minute_result +":"+ second_result;
		return time;
	}
	public String toString(){
		return ("The current time is "+ getTime());
	}
	

		
}

	


