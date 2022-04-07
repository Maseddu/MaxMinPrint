import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		try {
			FileOutputStream newFile = new FileOutputStream("text.txt");
			OutputStreamWriter osr1 = new OutputStreamWriter(newFile);
			osr1.write(Generatore());
			osr1.flush();
			osr1.close();

			FileInputStream file = new FileInputStream("text.txt");
			InputStreamReader isr = new InputStreamReader(file);
			int i = isr.read();
			String dati = "";
			int[] elementi = null;
			int numeri = 0;
			while (i != -1) {
				dati = dati + String.valueOf((char) i);
				i = isr.read();
				String[] list = dati.split(",");
				int n = list.length;
				elementi = new int[n];
				for (int c = 0; c < list.length; c++) {
					elementi[c] = Integer.parseInt(list[c]);
					numeri = elementi[c];
				}
			}
			isr.close();
			try {
				FileOutputStream result = new FileOutputStream("dati.txt");
				OutputStreamWriter osr2 = new OutputStreamWriter(result);
				osr2.write(MinMax(elementi));
				osr2.flush();
				osr2.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Programma Eseguito");
			System.exit(0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static String MinMax(int[] ingresso) {
		int maxNum = 0;
		int minNum = 0;
		int x = 0;
		do {
			for (int i = 0; i < ingresso.length; i++) {
				
				int valoreb = Integer.valueOf(ingresso[x]);
				int valorea = Integer.valueOf(ingresso[i]);
				
				if (valorea > valoreb) {
					maxNum = valorea;
				} 
				if (valorea < valoreb) {
					minNum = valorea;
				}
			}
			x++;
		} 
		while (x < ingresso.length - 1);
		return "Valore massimo: " + maxNum + "\nValore minimo: " + minNum;
	}

	public static String Generatore() {
		String generato = "";
		int dim = 1;
		int[] randomNumber = new int[1];
		for (int j = 0; j < 1; j++) {
			randomNumber[j] = (int) (Math.random() * (50 + 0) - 0);
			dim = randomNumber[j];
		}
		int[] randomNumbers = new int[dim];
		do {
			for (int i = 0; i < randomNumbers.length; i++) {
				randomNumbers[i] = (int) (Math.random() * (50 + 0) - 0);

				generato += randomNumbers[i] + ",";
			}
		} while (randomNumbers.length > dim);

		return generato;
	}
}
