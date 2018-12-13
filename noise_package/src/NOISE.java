import java.io.File;
public class NOISE {
	Speak speech = newSpeak(2);
	SoundDevice device = new SoundDevice();
	
	public double[] sine (double freq, double duration) {
		// (int) converts things to int
		int n = (int) (duration * device.SAMPLING_RATE);
		double[] a = new double[n];
		double dx = 2 * Math.PI * freq / device.SAMPLING_RATE;
		for (int i = 0; i < n; i++){
			a[i] = Math.sin(i * dx);
		}
		return a;
	}
	
	public double[] makef0 (double freq, double duration){
		int n = (int) (duration * device.SAMPLING_RATE);
		double[] a = new double[n];
		double cycle = device.SAMPLING_RATE / freq;
		double dx = 2 * Math.PI * freq / device.SAMPLING_RATE;
		for (int i=0; i < n; i++){
			a[i] = Math.sin(i *dx);
		}
	}

}
