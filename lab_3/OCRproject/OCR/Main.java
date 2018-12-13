package OCR;

public class Main {
	public static void main(String[] args){
		
		ImgClass Test_System = new ImgClass();
		Test_System.cleanup();
		System.out.println(Test_System.FindBestMatch());

	
	}
}
