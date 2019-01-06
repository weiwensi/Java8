package demo.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 此类用于演示数组引用
 * @author liyuting
 * 
 * 一、理解
 * 数组引用本质上就是Lambda表达式的，相当于满足一定要求的Lambda表达式的简化，和Lambda表达式一样，可以作为函数式接口的实例出现
 * 
 * 二、要求
 * 1、Lambda体中仅仅只有一句话
 * 2、仅有的一句话为创建一个新数组
 * 3、抽象方法的参数列表和新数组的长度一致，并且抽象方法 的返回正好为该新数组
 * 三、语法
 * 数组类型[]::new
 */
public class TestArrayRef {
	//案例1:创建一个String类型的数组对象
	/*
	 * new String[长度];
	 */
	@Test
	public void test1() {
		//进阶1：
		Function<Integer,String[]> fun = new Function<Integer,String[]>(){

			@Override
			public String[] apply(Integer t) {
				return new String[t];
			}
			
		};
		
		//进阶2:
		Function<Integer,String[]> fun2 = t->new String[t];
		//进阶3：
		Function<Integer,String[]> fun3 = String[]::new;
			
		
	}
	
}
