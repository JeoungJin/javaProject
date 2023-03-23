package aproject.controller;

import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import aproject.model.EmpService;
import aproject.view.EmpView;
import aproject.vo.EmpVO;


 
//Servlet으로 대치될예정 
public class EmpController {

	static String login = "";
	static EmpVO emp;
	
	public static void main(String[] args) {
		/*
		 * AController aa = CController.ACONTROLLER; BController bb =
		 * CController.BCONTROLLER; aa.f1(); aa.f1(); aa.f1(); aa.f1(); bb.f1();
		 */
		 // default locale
        //Locale defaultLocale = Locale.getDefault();
        //System.out.println(defaultLocale);

        // set default locale to Locale.KOREA
        Locale.setDefault(Locale.ENGLISH);
        String fileEncoding=System.getProperty("file.encoding");
       
        System.out.println(fileEncoding);
        // default locale
        //defaultLocale = Locale.getDefault();
        //System.out.println(defaultLocale);
        
		startApp(args);
	}
	
	
	public static void startApp(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpService eService = new EmpService();
		
		while(true) {
			menuSelect();
			//nextLine(1줄 enter포함)  | 공백분리한 단어 - nextInt(),next()
			String job = sc.next();
			if(job.equals("exit")) break;
			switch (job) {
			case "1":{
				 
				EmpView.print(eService.selectAll());break;
			}
			case "2":{
				System.out.print("조회할 직원번호>>");
				int empid = sc.nextInt();
				EmpVO emp = eService.selectById(empid);
				
				EmpView.print(emp);break;}
			case "3":{
				if(emp == null) {
					System.out.println("부서조회불가");
					break;
				}
				System.out.print("조회할 부서번호>>");
				int deptid = sc.nextInt();
				EmpView.print(eService.selectByDept(deptid));break;
			}
			case "4":{
				System.out.print("조회할 부서번호,job,salary>>");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				double salary = sc.nextDouble();
				EmpView.print(eService.selectByCondition(deptid, jobid, salary));break;
			}
			case "5":
				List<EmpVO> empList = eService.selectLAB();
				System.out.println("[Controller] 5번작업:" + empList.size());
				EmpView.print(empList);
				break; 
			case "6":{
				EmpVO emp = makeEmp(sc);
				EmpView.print(eService.empInsert(emp));
				break;}
			case "7":{
				System.out.print("==수정할 직원ID>>"); 
				int empid = sc.nextInt();	
				EmpVO selectEmp = eService.selectById(empid);
				if (selectEmp==null) {
					EmpView.print("존재하지않는 직원");
				}else {
					EmpView.print(selectEmp);
					EmpVO emp = makeEmp2(sc, empid);
					EmpView.print(eService.empUpdate(emp));
				}
				
				break;}
			case "8":{
				System.out.print("==삭제할 직원ID>>"); 
				int empid = sc.nextInt();	
				EmpView.print(eService.selectById(empid));
				System.out.print("삭제를 계속진행(Y/N)?");
				String yn = sc.next();
				if(yn.equals("Y"))
				      EmpView.print(eService.empDelete(empid));
				}
			case "9":{
				System.out.print("조회할 직원번호>>");
				int empid = sc.nextInt();
				EmpVO emp = eService.getSalary(empid);
				
				EmpView.print("이름과 급여는 " + emp.getSalary() + "---" + emp.getFirst_name());
				break;}
			default:
				break;
			}
		}
		System.out.println("수고하셨습니다.....");
	}

	private static void menuSelect() {
		System.out.println("1.모든직원");
		System.out.println("2.직원상세");
		System.out.println("3.부서의직원");
		System.out.println("4.부서,직책, 급여로 조회");
		System.out.println("5.부서의평균급여이하를 받는 직원조회");
		
		System.out.println("6.신규직원등록");
		System.out.println("7.직원정보수정");
		System.out.println("8.직원정보삭제");
		System.out.println("9.직원의 급여조회(SP)");
		System.out.println("exit 종료");
		System.out.print("====작업선택>>");
		
	}

	private static EmpVO makeEmp(Scanner sc) {
		System.out.print("1.신규직원의 first_NAME>>");
		String fName = sc.next();
		System.out.print("2.신규직원의 LAST_NAME>>");
		String lastName = sc.next();
		System.out.print("3.신규직원의 email>>");
		String email = sc.next();
		System.out.print("4.신규직원의 jobid>>");
		String jobid = sc.next();
		System.out.print("5.신규직원의 phone>>");
		String phone = sc.next();		
		System.out.print("6.신규직원의 manager>>");
		int mid = sc.nextInt();
		System.out.print("7.신규직원의 dept>>");
		int deptid = sc.nextInt();
		System.out.print("8.신규직원의 commission>>");
		double comm = sc.nextDouble();
		System.out.print("9.신규직원의 salary>>");
		double sal = sc.nextDouble();		
		System.out.print("10.신규직원의 입사일 yyyy/mm/dd>>");
		String sdate = sc.next();
		//String->Date
		Date hiredata = DateUtil.convertToDate(sdate);		
		EmpVO emp = new EmpVO();
		emp.setLast_name(lastName);
		emp.setEmail(email);
		emp.setJob_id(jobid);	
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setFirst_name(fName);
		emp.setHire_date(hiredata);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(sal);
		return emp;
	}
	private static EmpVO makeEmp2(Scanner sc, int empid) {
		System.out.print("1.직원의 email>>");
		String email = sc.next();
		System.out.print("2.직원의 jobid>>");
		String jobid = sc.next();
		System.out.print("3.직원의 dept>>");
		int deptid = sc.nextInt();
		System.out.print("4.직원의 salary>>");
		double sal = sc.nextDouble();		
		System.out.print("5.직원의 입사일 yyyy/mm/dd>>");
		String sdate = sc.next();
		Date hiredata = DateUtil.convertToDate(sdate);		
		System.out.print("6.직원의 manager>>");
		int mid = sc.nextInt();
		
		EmpVO emp = new EmpVO();
		emp.setEmployee_id(empid);
		emp.setEmail(email);
		emp.setJob_id(jobid);	
		emp.setDepartment_id(deptid);
		emp.setSalary(sal);
		emp.setHire_date(hiredata);
		emp.setManager_id(mid);
		return emp;
	}
}














