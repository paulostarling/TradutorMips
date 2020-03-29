package projeto;

public class DoTranslation {
	public static String doTranslation(String data) {
		String resultado = "";
		
		//Retira as vírgulas
		data = data.replace(",", "");
		String[] vetor_linha =  data.split(" ");
		
		
		resultado = traduz(vetor_linha);
		
		
		return resultado;
	}
	
	public static String traduz(String[] vetor_linha) {
		
		String array_aux[];
		String aux;
		String binario;
		String resultado = "";
		vetor_linha[0] = vetor_linha[0].toLowerCase();		
		switch(vetor_linha[0]) {
		
		case "nop":
			resultado = "0000000000000000000000000000000";
			break;
		//Tipo R
			case "add":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "100000";
				break;
				
			case "xor":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "100110";
				break;	
				
			case "sub":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "100010";
				break;
				
			case "mult":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += "0000000000";
				resultado += "011000";
				break;	
				
			case "div":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += "0000000000";
				resultado += "011010";
				break;	
				
			case "and":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "100100";
				break;
			
			case "or":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "100101";
				break;
				
			case "nor":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "100111";
				break;	
				
			case "slt":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[3]);
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "00000";
				resultado += "101010";
				break;	
				
			case "jr":
				resultado = "000000";
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += "000000000000000";
				resultado += "001000";
				break;	
				
			case "sll":
				resultado = "00000000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[1]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 5) {
					binario = "0" + binario;
				}
				resultado += binario;
				resultado += "000000";
				break;	
			
			case "srl":
				resultado = "00000000000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[1]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 5) {
					binario = "0" + binario;
				}
				resultado += binario;
				resultado += "000010";
				break;				
			
		//Tipo I
			case "addi":
				resultado = "001000";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[1]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;
				
			case "andi":
				resultado = "001100";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[1]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;
				
			case "ori":
				resultado = "001101";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[1]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;	
				
			case "slti":
				resultado = "001010";
				resultado += traduzRegistradores(vetor_linha[2]);
				resultado += traduzRegistradores(vetor_linha[1]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;	
				
			case "lw":
				resultado = "100011";
				
				array_aux = vetor_linha[2].split("\\(");
				
				aux = array_aux[1].replace(")", "");
				aux = traduzRegistradores(aux);
				
				resultado += aux;
				resultado += traduzRegistradores(vetor_linha[1]);
								  
				binario = transformaEmBinario(array_aux[0]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;
				
			case "sw":
				resultado = "101011";
				
				array_aux = vetor_linha[2].split("\\(");
				
				aux = array_aux[1].replace(")", "");
				aux = traduzRegistradores(aux);
				
				resultado += aux;
				resultado += traduzRegistradores(vetor_linha[1]);
								  
				binario = transformaEmBinario(array_aux[0]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;	
				
			case "beq":
				resultado = "000100";
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += traduzRegistradores(vetor_linha[2]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;
				
			case "bne":
				resultado = "000101";
				resultado += traduzRegistradores(vetor_linha[1]);
				resultado += traduzRegistradores(vetor_linha[2]);
				binario = transformaEmBinario(vetor_linha[3]);
				while(binario.length() < 16) {
					binario = "0" + binario;
				}
				resultado += binario;
				break;	
				
			//Tipo J
			case "j":
				resultado = "000010";
				resultado += "000000000";
				binario = transformaEmBinario(vetor_linha[1]);
				while(binario.length() < 16) {
					binario = "0" + binario;	
				}
				resultado += binario;
				break;
			
			case "jal":
				resultado = "000011";
				resultado += "000000000";
				binario = transformaEmBinario(vetor_linha[1]);
				while(binario.length() < 16) {
					binario = "0" + binario;	
				}
				resultado += binario;
				break;
		}
				
		return resultado;
	}
	
	
	public static String transformaEmBinario (String numero) {
		
		String resultado = "";
		int i = 0;
		
		//Transforma str em inteiro
		try{
	      i = Integer.parseInt(numero.trim());
	    }
	    catch (NumberFormatException nfe){
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }
		
		//Calcula binario
		int d = i;
        int resto;
        while ( d >= 1){
        	resto = d % 2;
        	if(d == 1) {
            	resultado = "1"+resultado;
            	d = 0;
            }else {
             resultado = Integer.toString(resto)+resultado;	
            }           
            d -= d / 2 ;
            
        }
		return resultado;
	}
}
