package demo.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 此类用于演示构造器引用
 * @author liyuting
 * 
 * 一、理解
 * 构造器引用本质上就是Lambda表达式的，相当于满足一定要求的Lambda表达式的简化，和Lambda表达式一样，可以作为函数式接口的实例出现
 * 
 * 二、要求
 * 1、Lambda体中仅仅只有一句话
 * 2、仅有的一句话为调用构造器
 * 3、抽象方法的参数列表和调用的构造器的参数列表完全一致，并且抽象方法 的返回正好为通过构造器创建的对象
 * 三、语法
 * 类型::new
 */
public class TestConstructorRef {
	//案例1:创建一个String类型对象
	/*
	 * String s = new String();
	 */
	@Test
	public void test1() {
		//进阶1
		Supplier<String> sup = new Supplier<String>() {

			@Override
			public String get() {
				return new String();
			}
			
		};
		//进阶2
		Supplier<String> sup2 = ()->new String();
		//进阶3：
		Supplier<String> sup3 = String::new;
		
		System.out.println(sup3.get());
			
		
	}
	//案例2:创建一个String类型对象
	/*
	 * String s = new String("hello");
	 */
	@Test
	public void test2() {
		//进阶1：
		Function<String,String> fun1 = new Function<String,String>(){

			@Override
			public String apply(String t) {
				return new String(t);
			}
			
		};
		
		//进阶2：
		Function<String,String> fun2 = t->new String(t);
		//进阶3：
		Function<String,String> fun3 = String::new;
		
		System.out.println(fun3.apply("hello"));
		
		
	}
	//练习:创建一个StringBuffer类型对象
	/*
	 * StringBuffer s = new StringBuffer(20);
	 */
	@Test
	public void test3() {
		Function<Integer,StringBuffer> fun = StringBuffer::new;
		
	}
}
