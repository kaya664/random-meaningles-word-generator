import java.util.Random;

public class RandomWordGeneratorMain {
	static Random random = new Random();
	public static void main(String[] args) {
		int index = 0;
		while(index < 1000) {
			System.out.println(generateWord(random.nextInt(15)));
			index++;
		}
	}
	
	public static String generateWord(int length) {
		if(length > 0) {
			return (char) (random.nextInt(26) + (random.nextInt(2) == 0 ? 65 : 97)) + generateWord(length-1);
		}
		return "";
	}
}
