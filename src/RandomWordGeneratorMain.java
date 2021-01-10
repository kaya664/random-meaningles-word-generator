import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RandomWordGeneratorMain {
	static Random random = new Random();

	public static void main(String[] args) {
		createFile();
	}

	public static String generateWord(int length) {
		if (length > 0) {
			return (char) (random.nextInt(26) + (random.nextInt(2) == 0 ? 65 : 97)) + generateWord(length - 1);
		}
		return "";
	}

	public static void createFile() {
		int index = 0;
		while (index < 100000) {
			String fileName = generateWord(random.nextInt(15));
			try {
				File myObj = new File("./words/" + fileName + ".txt");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			index++;
		}
	}
}
