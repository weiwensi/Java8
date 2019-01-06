package demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

import demo.bean.Employee;
import demo.data.EmployeeData;

/**
 * 此类用于演示StreamAPI使用步骤之一：开始操作（获取Stream对象）
 *
 * @author liyuting
 * 
 * 方式：
 * 一、通过集合来获取Stream对象  ★
 * Stream<XX> stream = list.stream();
 * 
 * 二、通过数组来获取Stream对象
 * Stream<XX> stream = Arrays.stream(数组);
 * 
 * 三、通过一组指定的值来获取Stream对象
 * Stream<XX> stream = Stream.of(T...ts);
 * 
 * 四、生成无限流
 * 
 * Stream<XX> stream= Stream.generate(Supplier sup);
 *
 */
public class TestStreamBegin {
	
	//一、通过集合来获取Stream对象
	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getEmployees();
		
		Stream<Employee> stream = list.stream();
		
		Stream<Employee> parallelStream = list.parallelStream();
//		
//		
//		
//		//终止操作
		stream.forEach(System.out::println);
		
		
//		list.stream().forEach(System.out::println);
	}
	// 二、通过数组来获取Stream对象
	@Test
	public void test2() {
		String[] arr = new String[] {"尹好学","颜才富","贾道宇"};
		
		Stream<String> stream = Arrays.stream(arr);
		
		//终止操作
		
		stream.forEach(System.out::println);
		
		
	}
	// 三、通过一组指定的值来获取Stream对象
	@Test
	public void test3() {
		
		Stream<Integer> of = Stream.of(1,3,5,7,9);
		
		of.forEach(System.out::println);
		
	}
	//四、生成无限流
	@Test
	public void test4() {
		
//		Stream.generate(new Supplier<Double>() {
//
//			@Override
//			public Double get() {
//				return Math.random();
//			}
//			
//		});
		
		Stream<Double> generate = Stream.generate(Math::random);
		generate.forEach(System.out::println);
		
		
		
	}

}
