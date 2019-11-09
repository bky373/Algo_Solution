package study.test.woo2th;

import java.util.Arrays;

public class Soluton6 {
	public static void main(String[] args) {

		String[][] input = { { "jm@email.com", "¡¶¿Ãø•" }, { "jason@email.com", "¡¶¿ÃΩº" }, { "woniee@email.com", "øˆ¥œ" }, { "mj@email.com", "ø•¡¶¿Ã" }, { "nowm@email.com", "¿Ã¡¶ø•" } };
		solution(input);
//		System.out.println(solution(input));
	}

	public static String[] solution(String[][] forms) {
		String[] answer = {};
		String[] dup = {};

		String[] email = new String[forms.length];
		String[] nickname = new String[forms.length];
		for (int i = 0; i < email.length; i++) {
			email[i] = forms[i][0];
			nickname[i] = forms[i][1];
		}
//			for(int k=0; k<nickname[i].length();k++) {
//				for(int j=1; j<nickname.length; j++) {
// 
//						if(nickname[i].charAt(k) == nickname[j].charAt(c)) {
//							if(nickname[i].charAt(k+1) == nickname[j].charAt(c+1)) {
//								System.out.println(true);
//							}
//						}
//					}
//				}
//			}

		String[][] part = {};
		for (int c = 0; c < forms.length; c++) {
			part = new String[nickname.length][nickname[c].length()];
		}
		for (int i = 0; i < nickname.length; i++) {
			for (int j = 0; j < nickname[i].length() - 1; j++) {
				part[i][j] = nickname[i].substring(j, j + 2);
				System.out.print(part[i][j] + " ");
			}
			System.out.println();
		}

		for (int c = 0; c < part.length; c++) {
			for (int k = 0; k < part[c].length; k++) {
				for(int i = 0 ; i< nickname.length;i++) {
					if (nickname[i].contains(part[c][k])) {
						System.out.println(true);
					}
				}
			}
		}
		return answer;
	}
}

//		for (int c = 0; c < part.length; c++) {
//			for (int k = 0; k < part[c].length; k++) {
//				for (int i = c + 1; i < part.length; i++) {
//					for (int j = 0; j < part[i].length; j++) {
//						if (part[c][k].equals(part[i][j])) {
//							System.out.println(true);
//						}
//					}
//				}
//			}
//		}

//		for(int c=0; c<forms.length; c++) {
//			for(int i=0; i<nickname[c].length()-1;i++) {
//				part[c][i] = nickname[c].substring(i,i+2);
//				System.out.print(part[c][i]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		String[] dup = new String[10];
//		for(int c=0; c<forms.length; c++) {
//			for(int i=0; i<part[c].length;i++) {
//				System.out.print(part[c][i] +" ");
//				for(int j=i+1; j<part[j].length; j++) {
//					if(part[c][i].equals(part[i+1][j])) {
//						dup[c] = email[c];
//						System.out.println(dup[c]);
//					}
//				}
//			}
//		}

//		for (int c = 0; c < forms.length; c++) {
//			char[] c_name = nickname[i].toCharArray();
//
//			for (int i = 0; i < part[i].length - 1; i++) {
//				for (int j = 0; j < c_name.length - 1; j++) {
//					part[i][j] = nickname.copyValueOf(c_name, j, 2);
//					System.out.print(part[i][j] + " ");
//				}
//				System.out.println();
//			}
//			String[] dup = new String[3];
//			for (int i = 0; i < part.length-1; i++) {
//				for (int j = 0; j < part[i].length; j++) {
//					if(part[i][j].equals(part[i+1][j])){
//						dup[i] = email[i];
//						System.out.println(dup[i]);
//					}
//				}
//			}
//		}
