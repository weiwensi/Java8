package exec.lambda;

public class TestMethodRef {
	
	public static void main(String[] args) {
		
		//--------------------A-------------
		//使用Lambda
		A a = ()->new MyClass().run();
		
		//使用方法引用
		A a2 = new MyClass()::run;
		
		//-------------------B-------------
		B<Integer> b = (t1,t2)->MyClass.cale(t1,t2);
		B<Integer> b2 = MyClass::cale;
		
		//-------------------C-------------
		C<Double,Double> c = (d1,d2,d3)->MyClass.sum(d1, d2, d3);
		C<Double,Double> c2 = MyClass::sum;
		
		//-------------------D-------------
		D<Integer,String> d = i1->new MyClass().max(i1);
		D<Integer,String> d2 = new MyClass()::max;
		//------------------E-------------
		E<MyClass,String,Integer,Character> e = new E<MyClass,String,Integer,Character>() {

			@Override
			public Character method5(MyClass t, String r, Integer u) {
				return t.getCharacter(r, u);
			}

		};
		E<MyClass,String,Integer,Character> e1 =(t,r,u)->t.getCharacter(r, u);
		
		E<MyClass,String,Integer,Character> e2 = MyClass::getCharacter;
		
	}

}


class MyClass{
	public void run(){
		System.out.println("跑啊跑啊");
	}
	public static void cale(int a,int b){
		System.out.println(a+b);
	}
	
	public static double sum(double d1,double d2,double d3){
		return d1+d2+d3;
	}
	public  String concat(double d1,double d2,double d3){
		return "hi:"+d1+d2+d3;
	}
	public String max(Integer...is){
		int max=is[0];
		for (int i = 0; i < is.length; i++) {
			if(max<is[i])
				max=is[i];
		}
		return "最大值："+max;
	}

	public char getCharacter(String str,int index){
		return str.charAt(index);
	}
}
interface A{
	void method1();
}
interface B<T>{
	void method2(T t1,T t2);
}
interface C<T,R>{
	R method3(T t1,T t2,T t3);
}
interface D<T,R>{
	R method4(T...ts);
}
interface E<T,R,U,M>{
	M method5(T t,R r,U u);
}