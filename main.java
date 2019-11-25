
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class main {
	static void solution(String text)
	{
		String input = text;
	    String word = Arrays.stream(input.split(" "))
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	            .entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .map(Map.Entry::getKey)
	            .orElse(null);
	    System.out.println("Most popular word is " + word);
	}
	
	public static void main(String[] args) throws IOException
	{
		FileInputStream inFile = new FileInputStream("D:\\filename.txt");
		byte[] str = new byte[inFile.available()];
		inFile.read(str);
		String text = new String(str);
		
		solution(text);
	}
}

