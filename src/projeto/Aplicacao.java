package projeto;
import java.io.*;

public class Aplicacao {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String comand = in.readLine();
		
		String[] comand_split = comand.split(" ");
		
		//Verifica como será a entrada
		if (comand_split.length == 3) {
			FileTranslate.processaTraducaoArquivo(comand_split[1], comand_split[2]);
		}else {
			System.out.println("Digite o comando em linguem de montagem Mips:");
			comand = in.readLine();
			String resultado = FileTranslate.processaTraducaoLinha(comand);
			System.out.println(resultado);
		}
		
	}

}
