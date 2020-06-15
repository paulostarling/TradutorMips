package projeto;

import java.io.*;
import java.util.Scanner;

import memory.MemoryManager;
import register.RegisterManager;

public class Process {
	
	public static void processaTraducaoArquivo(String file_name, String out_file_name) {
		createFile(out_file_name);

		MemoryManager.createMemoryFile();
		RegisterManager.createRegisterFile();
		
		
		String data = Process.readFile(file_name, out_file_name);
		
		if (data.equals("1")) {
			System.out.println("Arquivo nao encontrado.");
			return;
		}		
	}
	
	public static String processaTraducaoLinha(String comand) {
		String resultado = DoTranslation.doTranslation(comand);
		return resultado;		
	}
	
	public static String readFile(String file_name, String out_file_name) {
		String data = "";
		String resultado = "";
		try {
		      File myObj = new File(file_name);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        data = myReader.nextLine();
		        resultado = DoTranslation.doTranslation(data);
		        writeInFile(out_file_name, resultado);
		        MemoryManager.addMemoryIndex();
		      }
		      myReader.close();	
		      MemoryManager.writeToFile();
		      RegisterManager.writeToFile();
		      return resultado;
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		      return "1";
		    }
	}
	
	public static void createFile(String out_file_name) {
		
		FileWriter arquivo;
		
		try {
			arquivo = new FileWriter(new File(out_file_name));
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeInFile(String out_file_name, String resultado) {
			try {
				FileWriter fw = new FileWriter(out_file_name, true);
				BufferedWriter conexao = new BufferedWriter(fw);
				conexao.write(resultado);
				conexao.newLine();
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
