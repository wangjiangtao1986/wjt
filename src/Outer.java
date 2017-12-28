import java.util.Date;

public class Outer { 
	
	private String ss="1111111";
	public String ssss="2222222";
	private static String sss="33333333333";
	
	
    public static void main(String[] args) {
//        Outer outer = new Outer(); 
//        Outer.Inner inner = outer.new Inner(); 
//        inner.print("Outer.new"); 
// 
//        inner = outer.getInner(); 
//        inner.print("Outer.get"); 

//	      Outer outer = new Outer(); 
//	      Inner inner = outer.getInner();
////      	Outer.getInner2();
//
//	      inner.print("111111111111");
	      
//    	int a=10;
//
//        System.out.println(a+10>15?a+5/3:a%7);
    	
//    	int x=0;
//    	while(1==x){
//    		
//    	}
    } 

    public static Inner getInner2() {
        System.out.println("111111111111111111111111"); 
		return null; 
    } 
 
    // 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 
    public Inner getInner() { 
        return new Inner(); 
    } 
 
    public class Inner { 
		String s;
		double d;
		Date date;
		boolean b;
		
        public void print(String str) {
        	
        	Outer outer2 = new Outer(); 
        	
        	
            System.out.println(outer2.ssss); 
            System.out.println(outer2.ss);
            System.out.println(outer2.sss); 
        	
        	
            System.out.println(s + "_" + d + "_" + date + "_" + b); 
        } 
    } 
} 

class Inner2 { 
	String s;
	double d;
	Date date;
	boolean b;
	
    public void print(String str) { 
        System.out.println(s + "_" + d + "_" + date + "_" + b); 
    } 
} 