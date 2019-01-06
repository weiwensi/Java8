package demo.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import demo.bean.Employee;

/*
 * 此类用于演示方法引用
 * 
 * 一、理解
 * 方法引用，本质上就是Lambda表达式，和Lambda表达式的应用场景完全一样，都是可以作为函数式接口的实例出现，要么当做实参，要么当做对象赋值
 * 
 * 但必须是满足一定要求的Lambda表达式，才能使用方法引用代替！！！
 * 
 * 二、要求
 * 
 * 1、Lambda体中仅仅只有一句话
 * 2、Lambda体中仅有的这一句话为方法调用
 * 3、调用的方法的参数列表和返回类型 ，与接口中抽象方法的参数列表和返回类型完全一致！  ★
 *   如果是类名::普通方法，则需要满足
 *   调用方法的调用者必须是抽象方法的第一个参数。调用方法的参数列表和抽象方法的其他参数一致。
 * 三、语法
 * 
 * 类名|对象名::方法名
 * 情况：
 * 对象::普通方法
 * 类名::静态方法
 * 类名::普通方法 
 * 
 */

public class TestMethodRef {
	//测试：对象::普通方法
	@Test
	public void test1() {
		//使用匿名内部类：
		Consumer<String> con = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
			
		}; 
		
		//使用Lambda
		Consumer<String> con2 = t->System.out.println(t);
		
		//使用方法引用
		Consumer<String> con3 = System.out::println;
		
		con3.accept("hello");
		
		
		
	}
	
	//类名::静态方法
	@Test
	public void test2() {
		//使用匿名内部类
		Comparator<Integer> com = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
			
		};
		//使用Lambda
		Comparator<Integer> com2 = (o1,o2)->Integer.compare(o1, o2);
		
		
		//使用方法引用
		Comparator<Integer> com3 = Integer::compare;
		
		System.out.println(com3.compare(100, 200));
		
		
		//测试：
		
		Comparator<Double> c1 = Double::compare;
		
		
		
	}
	//类名::普通方法 
	@Test
	public void test3() {
		//使用匿名内部类
		Function<Employee,String> fun1 = new Function<Employee,String>(){

			@Override
			public String apply(Employee t) {
				return t.getName();
			}
			
		};
		//使用Lambda
		Function<Employee,String> fun2 = t->t.getName();
		
		//使用方法引用
		Function<Employee,String> fun3 = Employee::getName;
		
		
		System.out.println(fun3.apply(new Employee(5, "john", 12, '男', 10000)));
	}
	//类名::普通方法 
	@Test
	public void test3_2() {
		//使用匿名内部类
		BiPredicate<String, String>  b1 = new BiPredicate<String, String>() {
			
			@Override
			public boolean test(String t, String u) {
				return t.equals(u);
			}
		};
		//使用Lambda
		BiPredicate<String, String>  b2 = (t,u)->t.equals(u);
		
		//使用方法引用
		BiPredicate<String, String>  b3 = String::equals;
		
	}
	
	//类名::普通方法 
	@Test
	public void test3_3() {
		//使用Lambda
		BiFunction<String, String, Boolean>  b2 = (s1,s2)->s1.contains(s2);
		
		//使用方法引用
		BiFunction<String,String,Boolean> b3 = String::contains;
		
	}
	

}
