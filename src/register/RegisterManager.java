package register;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterManager {
	private static String fileName = "register.out";
	private static ArrayList<Register> registerList;
		
	public static void createRegisterFile() {
		registerList = new ArrayList<Register>();
		Register register;
        for(int i = 0; i< 29; i++) {
        	String registerName = RegisterUtils.getRegistersName(i);
        	String content = "00000000";
        	
        	register = new Register(registerName, content);
        	registerList.add(register);
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
	      FileWriter myWriter = new FileWriter("register.out", true);
	      BufferedWriter conexao = new BufferedWriter(myWriter);
	      for(int i = 0; i< registerList.size(); i++) {
	    	  Register register = registerList.get(i);
	    	  String resultado = register.getRegisterName() + " 0x" +register.getValue();
	    	  conexao.write(resultado);
	    	  conexao.newLine();
	      }
	      conexao.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}

	public static void updateRegister(String registerName, int newValue) {
		for (Register register : registerList) {
			if(register.getRegisterName().equals(registerName)) {
				register.setValue(Integer.toBinaryString(newValue));
			}
		}
	}
	
	public static Register getRegisterByName(String registerName) {
		for (Register register : registerList) {
			if(register.getRegisterName().equals(registerName)) {
				return register;
			}
		}
		return null;
	}
}
