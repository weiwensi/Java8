package demo.lambda;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 此类用于演示Lambda表达式的语法
 * 特点：Lambda表达式只能代替实现的接口中只有一个抽象方法的匿名内部类！
 * 语法：
 * 
 * (参数类型 参数名,参数类型 参数名)->{方法体的实现/Lambda体}
 * 示例：
    (String o1, String o2)->{return o1.compareTo(o2);}
 * 
 * 特点：
 * ①左侧参数列表中的参数类型可以省略！
 * ②如果左侧参数列表中，只有一个参数，则小括号也可以省略
 * ③右侧的Lambda体中如果仅有一句话，则大括号可以省略
 * ④右侧的Lambda体中仅有的一句话为return语句，则return要求省略
 * 
 * 案例：Comparator<Integer>
 *
 */
public class TestLambda2 {
	
	@Test
	public void test1() {
		TreeSet<String> set = new TreeSet<>(
				new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						System.out.println("ooo");
						return o1.compareTo(o2);
					}
					
					
				}
		);
		
		
		TreeSet<String> set2 = new TreeSet<>( ( o1,  o2)->{
			System.out.println();
			return o1.compareTo(o2);}
		
				);
		
	}
	
	@Test
	public void test2() {
		//使用匿名内部类
		Comparable<String> com= new Comparable<String>() {

			@Override
			public int compareTo(String o) {
				return 100;
			}
			
			
		};
		
		//使用Lambda表达式
		Comparable<String> com2 = o-> 100;
		
	}
	@Test
	public void test3() {
		Runnable run = new Runnable() {

			@Override
			public void run() {
				System.out.println("哈哈");
			}
			
			
		};
		//使用Lambda表达式
		Runnable run2 = ()->System.out.println("哈哈");
		
		
		
	}
	@Test
	public void test4() {
		
		//使用匿名内部类
		Comparator<Integer> com1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		
		//使用Lambda
		Comparator<Integer> com2 = ( o1,  o2)->  Integer.compare(o1, o2);
		
		
	}
	
}
