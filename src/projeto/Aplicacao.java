package projeto;
import java.io.*;

public class Aplicacao {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String comand = in.readLine();
		
		String[] comand_split = comand.split(" ");
		
		//Verifica como será a entrada
		if (comand_split.length == 2) {
			Process.processaTraducaoArquivo(comand_split[1], "output");
		}
		
	}

}
