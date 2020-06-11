package memory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MemoryManager {
	private static String fileName = "memory.out";
	private static ArrayList<Memory> memoryList;
		
	public static void createMemoryFile() {
		memoryList = new ArrayList<Memory>();
		Memory memory;
        for(int i = 0; i< 4096; i+=16) {
        	String address = Integer.toHexString(i);
        	String content = "00000000";
        	
        	memory = new Memory(address, content);
        	memoryList.add(memory);
        }
        
        FileWriter arquivo;		
		try {
			arquivo = new FileWriter(new File(fileName));
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFile() {
		try {
	      FileWriter myWriter = new FileWriter("memory.out", true);
	      BufferedWriter conexao = new BufferedWriter(myWriter);
	      for(int i = 0; i< memoryList.size(); i++) {
	    	  Memory memory = memoryList.get(i);
	    	  String resultado = "0x" + memory.getAddress() + " 0x" +memory.getValue();
	    	  conexao.write(resultado);
	    	  conexao.newLine();
	      }
	      conexao.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	    
		  
	
}
