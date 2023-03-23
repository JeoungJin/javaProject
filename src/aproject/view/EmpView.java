package aproject.view;

import java.io.UnsupportedEncodingException;
import java.util.List;

import aproject.vo.EmpVO;

//JSP로 대치될예정 
public class EmpView {
	private static void printIt(String string) {
        System.out.println(string);
        for (int i = 0; i < string.length(); i++) {
            System.out.print(String.format("U+%04X ", string.codePointAt(i)));
        }
        System.out.println();
    }

	public static void print(List<EmpVO> emplist)   {
		System.out.println("===================직원들정보=============");
		for(EmpVO emp:emplist) {
		 
			try {
				System.out.printf("%-10s%-10s%f\n",
					new String(emp.getFirst_name().getBytes(),"utf-8"),
					emp.getLast_name(), emp.getSalary());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					 
		}
	}
	public static void print(EmpVO emp) {
		System.out.println("===================직원상세보기=============");
		if(emp==null) {
			print("직원이 존재하지않습니다.");
		}else {
			System.out.println(emp);
		}
		
		 
	}
	public static void print(String message) {
		System.out.println("[알림]" + message);	 
	}
}

















