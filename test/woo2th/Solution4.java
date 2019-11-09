package test.woo2th;

import java.util.Arrays;
import java.util.Stack;

public class Solution4 {
	public static void main(String[] args) {

		String[] infos = {"kim password", "lee abc"};
		String[] actions = {"ADD 30", 
			    "LOGIN kim abc", 
			    "LOGIN lee password", 
			    "LOGIN kim password", 
			    "LOGIN kim password", 
			    "ADD 30", 
			    "ORDER",
			    "ORDER",
			    "ADD 40",
			    "ADD 50"};
		System.out.println(Arrays.toString(solution(infos, actions)));
	}
    public static boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        String[] id_info, act_info;
        String[] id = new String[infos.length], pw = new String[infos.length];
        String act, id_access, pw_access;
        Stack<String> basket = new Stack<String>();
        boolean check_login = false;
        // id, pw 배열 저장
        for(int i=0; i<infos.length;i++) {
        	id_info = infos[i].split(" ");
        	id[i] = id_info[0];
        	pw[i] = id_info[1];
        }
        // actions
        for(int c=0; c<actions.length;c++) {
        		act_info = actions[c].split(" ");
        		act = act_info[0];
        	
        	if(act.equals("ADD")){
        		if(check_login) {
        			basket.push(act_info[1]);
        			answer[c] = true;
        		}
        	}
        	if(act.equals("LOGIN")) {
        		id_access = act_info[1];
        		pw_access = act_info[2];
        		if(!check_login) {
        			for(int i=0; i<id.length;i++) {
        				if(id_access.equals(id[i]) && pw_access.equals(pw[i])) {
        					check_login = true;
        					answer[c] = true;
        					break;
        				}
        			}
        		}
        	}
        	if(act.equals("ORDER")){
        		if(!basket.isEmpty()) {
        			answer[c] = true;
        			basket.pop();
        		}
        	}
        }
        return answer;
    }
}
