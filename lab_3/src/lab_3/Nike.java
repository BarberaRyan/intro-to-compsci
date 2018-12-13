package lab_3;
import javax.swing.JOptionPane;

public class Nike {

	private double[] current_distance;
	private double[] current_speed;
	private double last_week_mileage;
	private double last_week_speed;
	private double[] zero_setter;
	
	public Nike(){
		current_distance = new double[7];
		last_week_mileage= 0.0;
		current_speed= new double[7];
		last_week_speed= 0.0;
		zero_setter = new double[7];
	}
	
	public void setDistance(double[] dis){
		current_distance = dis;
		last_week_mileage= 0;
		current_speed= zero_setter;
		last_week_speed= 0;
	}
	
	public void setSpeed(double[] dis, double[] speed){
		current_distance = dis;
		current_speed= speed;
		last_week_mileage= 0;
		last_week_speed= 0;
	}
	
	private double getPastDistance(){
		return last_week_mileage;
	}
	private double getPastSpeed(){
		return last_week_speed;
	}
	
	public void setPastDistance(){
		double sum = 0.0;
		for (int i = 0; i < current_distance.length; i++){
			sum += current_distance[i];
		}
		this.last_week_mileage = sum;
		current_distance = zero_setter;
	}
	
	public void setPastSpeed(){
		double sum = 0.0;
		for (int i = 0; i < current_speed.length; i++){
			sum += current_speed[i];
		}
		this.last_week_speed = sum;
		current_speed = zero_setter;
	}

	public String moreDistance(){
		double sum = 0.0;
		for (int i = 0; i < current_distance.length; i++){
			sum += current_distance[i];
		}
		if (sum > getPastDistance()){
			return("You ran further than last week");
		}
		else{
			return("You didn't run as far as last week");
		}
		
	}
	
	public String moreSpeed(){
		double sum = 0.0;
		for (int i = 0; i < current_speed.length; i++){
			sum += current_speed[i];
		}
		if (sum > getPastSpeed()){
			return("You ran faster than last week");
		}
		else{
			return("You didn't run as fast as last week");
		}
	}
	
	
	public void addSpeed(int day){
		String svar = JOptionPane.showInputDialog("Input today's speed");
		double xvar = Double.parseDouble(svar);
		current_speed[day] = xvar;
	}
	
	public void addDistance(int day){
		String svar = JOptionPane.showInputDialog("Input today's distance");
		double xvar = Double.parseDouble(svar);
		current_distance[day] = xvar;
	}

}
