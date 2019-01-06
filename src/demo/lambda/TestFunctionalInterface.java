package demo.lambda;

import java.util.function.*;

import org.junit.Test;

import demo.bean.Employee;

/**
 * 此类用于演示内置的四大核心函数式接口
 * @author liyuting
 * 案例：
 * BiFunction<T, U, R>
   BiConsumer<T, U>

 */
public class TestFunctionalInterface {
	//测试：BiConsumer<T, U>
	@Test
	public void exec2() {
		BiConsumer<String,Integer> bc = (s,i)->System.out.println(s+i);
		bc.accept("hello", 100);
		
	}
	
	//测试：BiFunction<T, U, R>
	@Test
	public void exec1() {
		
		//使用匿名内部类
		BiFunction<String, String, Boolean>  bf1 = new BiFunction<String, String, Boolean>() {
			
			@Override
			public Boolean apply(String t, String u) {
				return t.equals(u);
			}
		}; 
		
		//使用Lambda
		BiFunction<String, String, Boolean>  bf2 = (t,u) ->t.equals(u);
	}
	
	
	//测试消费型接口Consumer<T>
	@Test
	public void test1() {
		Consumer<Double> con1 = new Consumer<Double>() {

			@Override
			public void accept(Double t) {
				if(t>1000) {
					System.out.println("去看大海");
				}else if(t>500) {
					System.out.println("去看小河");
				}else {
					System.out.println("来北京看雨");
				}
				
			}
			
		};
		
		
		//使用Lambda表达式
		Consumer<Double> con2 =t-> {
			if(t>1000) {
				System.out.println("去看大海");
			}else if(t>500) {
				System.out.println("去看小河");
			}else {
				System.out.println("来北京看雨");
			}
		};
		
		con2.accept(1500.0);
		
		
	}
	//测试供给型接口Supplier<T>
	/*
	 * T get();
	 */
	@Test
	public void test2() {
		Supplier<String> sup = ()->"hello";
		
		System.out.println(sup.get());
		
	}
	//测试函数型接口Function<T,R>
	/*
	 * R apply(T t);
	 */
	@Test
	public void test3() {
		Function<String,Character> fun = s->s.charAt(0);
		
		System.out.println(fun.apply("john"));
	}
	//测试断定接口Predicate<T>
	/*
	 * boolean test(T t);
	 */
	@Test
	public void test4() {
		Predicate<Employee> pre = e->e.getGender()=='男';
		
		System.out.println(pre.test(new Employee(1, "john", 12, '女', 1234)));
		
	}
	

}
