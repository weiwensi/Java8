package demo.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 此类用于演示类型推断的特点
 * @author liyuting
 *
 */
public class TestTypeAnn {
	@Test
	public void test1() {
		
		Comparable<String> com = new Comparable<String>() {

			@Override
			public int compareTo(String o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			
		};
		Comparable<String> com2 = o->0;//使用了类型推断思想，将参数类型省略
		
		
	}

	@Test
	public void test2() {
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<>();//jdk7:类型推断
	}
	@Test
	public void test3() {
		
		method(new HashMap<>());//类型推断
	}
	
	@Test
	public void test4() {
		
		//jdk9之前:匿名内部类的泛型不可以省略
		
		Comparable<String> com = new Comparable<String>() {

			@Override
			public int compareTo(String o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		//jdk9以及之后:匿名内部类的泛型可以省略
//		Comparable<String> com2 = new Comparable<>() {
//
//			@Override
//			public int compareTo(String o) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		};
		
	}
	
	@Test
	public void test5() {
		//jdk10 的新特性
//		var list = new ArrayList<String>();//类型推断思想
		
		
//		Iterator<Map.Entry<String,List<String,Integer>>>
	}
	
	
	public void method(Map<String,Integer> map) {
		
	}
}
