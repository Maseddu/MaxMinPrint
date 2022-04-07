import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		try {
			FileOutputStream newFile = new FileOutputStream("text.txt");
			OutputStreamWriter osr = new OutputStreamWriter(newFile);
			osr.write(Generatore());
			osr.flush();
			osr.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int content;
		 String contentb = null;
		FileInputStream fis = null;
		InputStreamReader sr = null;
		try {
			fis = new FileInputStream("text.txt");
			
            // reads a byte at a time, if it reached end of the file, returns -1
            while ((content = fis.read()) != -1) {}
         contentb = String.valueOf(content);
		} catch (IOException e) {
			System.out.println("File non trovato");
			e.printStackTrace();
		}
		
		String line = contentb;
		String[] numberStrs = line.split(",");
		int[] ingresso = new int[numberStrs.length];
		Max(ingresso);
		System.out.println(Max(ingresso));
		Min(ingresso);
		System.out.println(Min(ingresso));
		try {
			FileOutputStream result = new FileOutputStream("dati.txt");
			OutputStreamWriter osr = new OutputStreamWriter(result);
			osr.write("Valore massimo: " + Max(ingresso) + "\nValore minimo: " + Min(ingresso));
			osr.flush();
			osr.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Programma terminato");
		System.exit(0);
	}

	public static int Max(int[] ingresso) {
		int maxNum = 0;
		int x = 0;
		do {
			for (int i = 0; i < ingresso.length; i++) {
				int valorea = Integer.valueOf(ingresso[i]);
				int valoreb = Integer.valueOf(ingresso[x]);
				if (valoreb > valorea) {
					maxNum = valoreb;
					System.out.println(maxNum);
				} else {
					System.out.println("Non esiste un valore maggiore");
				}
			}
			x++;
		} while (x <= ingresso.length - 1);
		return maxNum;
	}

	public static int Min(int[] ingresso) {
		int minNum = 0;
		int x = 0;
		do {
			for (int i = 0; i < ingresso.length; i++) {
				int valorea = Integer.valueOf(ingresso[i]);
				int valoreb = Integer.valueOf(ingresso[x]);
				if (valoreb > valorea) {
					minNum = valoreb;
					System.out.println(minNum);
				} else {
					System.out.println("Non esiste un valore minore");
				}
			}
			x++;
		} while (x <= ingresso.length - 1);
		return minNum;
	}
	
	public static String Generatore() {
		String generato = "";
		int dim = 1;
		int[] randomNumber = new int[1];
		for (int j = 0; j < 1; j++) {
			randomNumber[j] = (int) (Math.random() * (1000 + 0) - 0);
			dim = randomNumber[j];
		}
		int[] randomNumbers = new int[dim];
		do{for (int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = (int) (Math.random() * (1000 + 0) - 0);
			
			generato += randomNumbers[i] + ",";}} while(randomNumbers.length>dim);
		
		return generato;
		}
}
