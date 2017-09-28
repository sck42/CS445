//Sai Konduru
import java.util.*;
import java.io.*; 
public class CharacterFrequency
{
	public static void main(String args[])throws IOException
	{
		FrequencyBag<Character> fb = new FrequencyBag<Character>();
		File f = new File("letter1.txt"); 
		Scanner sc = new Scanner(f); 
		BufferedReader fr = new BufferedReader(new FileReader(f)); 
		int c; 
		while((c = fr.read()) != -1)
		{
			fb.add(Character.toLowerCase((char) c)); 
		}
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		System.out.println("Character: Frequency");
		System.out.println("====================");
		for(int i = 0; i < 26; i++)
		{
			System.out.println(alphabet[i] + ": " + fb.getFrequencyOf(new Character(alphabet[i]))); 
		}		
	}
}