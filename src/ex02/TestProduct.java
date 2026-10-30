package ex02;

import java.util.Scanner;

interface Ipo{
	void input();
	void process();
	void output();
}
//데이터 중심 클래스
class ProductDto{
	private int num;
	private String pcode;
	private int amount;
	private double price;
	
	private String pname;
	private double kum;
	
	public ProductDto() {
		
	}
	public ProductDto(int num, String pcode, int amount, double price) {
		this.num = num;
		this.pcode = pcode;
		this.amount = amount;
		this.price = price;
		
		this.pname = "";
		this.kum = 0.0;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getKum() {
		return kum;
	}
	public void setKum(double kum) {
		this.kum = kum;
	}
	@Override
	public String toString() {
		return "ProductDto [num=" + num + ", pcode=" + pcode + ", amount=" + amount + ", price=" + price + ", pname="
				+ pname + ", kum=" + kum + "]";
	}
	
}
//기능중심 클래스
class Product implements Ipo{
	private ProductDto p;
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력:번호,제품코드,수량,단가");
		String line = sc.nextLine();
		String[] li = line.trim().split(",");
		int num = Integer.parseInt(li[0].trim());
		String pcode = li[1].trim();
		int amount = Integer.parseInt(li[2].trim());
		double price = Double.parseDouble(li[3].trim());
		
		p = new ProductDto(num, pcode, amount, price);
		}

	@Override
	public void process() {
		//제품명
		String pname = "";
		if(p.getPcode().equals("P01")) {
			p.setPname("새우깡");
		}else if(p.getPcode().equals("P02")) {
			p.setPname("빅파이");
		}else if(p.getPcode().equals("P03")) {
			p.setPname("짱구");
		}else if(p.getPcode().equals("P04")) {
			p.setPname("초코파이");
		}else if(p.getPcode().equals("P05")) {
			p.setPname("수박맛초코파이");
		}else {
			System.out.println("잘못된 입력");
		}
		
		//금액
			double kum = p.getAmount() * p.getPrice();
			p.setKum(kum);
		}

	@Override
	public void output() {
		System.out.println("번호   제품명   수량     단가     금액");
		String fmt = "%05d  %s      %d   %.3f  %.3f";
		String msg = String.format(fmt,p.getNum(),p.getPname(),p.getAmount(),p.getPrice(),p.getKum());
		System.out.println(msg);
	}
	
}
	
public class TestProduct {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.input();
		p1.process();
		p1.output();
	}

}
