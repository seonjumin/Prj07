package ex03;

import java.time.LocalDate;
import java.util.Scanner;

interface Ipo{
	void input();
	void process();
	void output();
}
class EmpDto{
	private int num;
	private String name;
	private String date;
	private double sal;
	private int depno;
	
	private double bon;
	private double pay;
	private String depna;
	
	public EmpDto() {
		
	}
	public EmpDto(int num, String name, String date, double sal, int depno) {
		this.num = num;
		this.name = name;
		this.date = date;
		this.sal = sal;
		this.depno = depno;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDepno() {
		return depno;
	}
	public void setDepno(int depno) {
		this.depno = depno;
	}
	public double getBon() {
		return bon;
	}
	public void setBon(double bon) {
		this.bon = bon;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public String getDepna() {
		return depna;
	}
	public void setDepna(String depna) {
		this.depna = depna;
	}
}
class Emp implements Ipo{
	 private EmpDto e;
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : 사번,이름,입사일,월급,부서번호");
		String line = sc.nextLine();
		String[] li = line.trim().split(",");
		int num = Integer.parseInt(li[0].trim());
		String name = li[1].trim();
		String date = li[2].trim();
		double sal = Double.parseDouble(li[3].trim());
		int depno = Integer.parseInt(li[4].trim());
		
		e = new EmpDto(num,name,date,sal,depno);
	}

	//금액은 소수이하 두자리로 반올림
	@Override
	public void process() {
		//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
		int thisYear = LocalDate.now().getYear();
		String hiredate = e.getDate();
		int hireYear = Integer.parseInt(hiredate.substring(0, 4));
		int hireYears =  thisYear - hireYear;
		double bonus = hireYears * e.getSal() *0.005;
		//수령액   =  월급 + 보너스 
		double pay = e.getSal() + bonus;
		//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스
		String deptname ="";
		int deptno = e.getDepno();
		switch(deptno) {
		case 10:
			deptname ="인사";
			break;
		case 20:
			deptname ="자재";
			break;
		case 30:
			deptname ="총무";
			break;
		case 40:
			deptname ="연구개발";
			break;
		case 50:
			deptname ="생산";
			break;
		case 60:
			deptname ="서비스";
			break;
		default:
			System.out.println("잘못된 번호입니다.");
		}
		e.setBon(bonus);
		e.setPay(pay);
		e.setDepna(deptname);
		
	}

	@Override
	public void output() {
		System.out.println("사번  이름  입사일   월급  보너스  수령액  부서명");
		System.out.printf("%d  %s  %s  %.2f  %.2f  %.2f  %s",e.getNum(),e.getName(),
				e.getDate(),e.getSal(),e.getBon(),e.getPay(),e.getDepna());
		
	}
	
}

public class TestEmp {

	public static void main(String[] args) {
	
		Emp emp1 = new Emp();
		emp1.input();
		emp1.process();
		emp1.output();
		

	}

}
