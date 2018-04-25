import java.awt.Color;

public class TestKochOV {

	public static void main(String[] args) {
		Koch myKoch = new Koch("Mueller", "Jens", Color.RED);
		System.out.println(myKoch.getNachname());
		System.out.println(myKoch.getVorname());
		System.out.println(myKoch.getFarbeSchuerze());
	}
}