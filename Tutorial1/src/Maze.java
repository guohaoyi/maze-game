import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Maze {
	
	private String map;
	
	public Maze(String fileName) {
		try
		{
			FileReader fin = new FileReader(fileName);
			Scanner scan = new Scanner(fin);
			while (scan.hasNext())
			{
				map = map + scan.next();
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
	}
	
	public String toString() {
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maze maz = new Maze("map01.txt");
		System.out.println(maz);

	}

}
