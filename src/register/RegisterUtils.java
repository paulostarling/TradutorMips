package register;

public class RegisterUtils {
	public  static String getRegistersName(int i) {
		switch (i) {
		case 0:
			return "v0";
		case 1:
			return "v1";
		case 2:
			return "a0";
		case 3:
			return "a1";
		case 4:
			return "a2";
		case 5:
			return "a3";
		case 6:
			return "t0";
		case 7:
			return "t1";
		case 8:
			return "t2";
		case 9:
			return "t3";
		case 10:
			return "t4";
		case 11:
			return "t5";
		case 12:
			return "t6";
		case 13:
			return "t7";	
		case 14:
			return "t8";
		case 15:
			return "t9";
		case 16:
			return "s0";
		case 17:
			return "s1";
		case 18:
			return "s2";
		case 19:
			return "s3";
		case 20:
			return "s4";			
		case 21:
			return "s5";
		case 22:
			return "s6";
		case 23:
			return "s7";
		case 24:
			return "s8";
		case 25:
			return "gp";
		case 26:
			return "fp";
		case 27:
			return "sp";
		case 28:
			return "ra";
		case 29:
			return "at";
		case 30:
			return "k1";
		case 31:
			return "k2";
		default:
			return null;
		}
	}
}
