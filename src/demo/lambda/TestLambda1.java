package demo.lambda;

import org.junit.Test;

/**
 * 此类用于演示Lambda表达式的概念和好处
 * 一、理解：
 * Lambda表达式可以理解成一段可以传递的代码，相当于是对匿名内部类的代替和简化。可以作为接口的实例赋值给某接口，或传递给某方法
 * 
 * 示例1：
 * 
 * 		接口 a  = Lambda表达式;
 * 
 * 示例2：【居多】
 * 		method(Lambda表达式);
 *
 * 		public void method(接口 a){
 * 				
 * 		}
 * 
 * 
 * 二、好处
 * 
 * 1、语句更加简洁
 * 2、更加紧凑，使java语言的表达能力得到了提升！
 * 
 * 
 *
 */

public class TestLambda1 {
	
	@Test
	public void test1() {
//		method(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("跑 啊 跑");
//				
//			}
//			
//		});
		
		method(()->System.out.println("跑 啊 跑"));
		
		
	}
	public void method(Runnable r) {
		r.run();
	}

}
