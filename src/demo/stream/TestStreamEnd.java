package demo.stream;


import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import demo.bean.Employee;
import demo.data.EmployeeData;

/**
 * 此类用于演示StreamAPI的使用步骤之三：终止操作
 * @author liyuting
 * 
 * 
 * 常见方法：
 * allMatch：测试是否全部匹配
 * anyMatch:测试是否至少有一个匹配
 * noneMatch:测试是否所有的都不匹配
 * findFirst：返回第一个
 * findAny:返回并行流中的任意一个
 * count:统计个数
 * max(comparator):返回最大值
 * min(comparator):返回最小值
 * forEach(Consumer):内部迭代（遍历）
 * reduce(BinaryOperator):归约，往往和map搭配使用
 * 
 * 
 *
 */
public class TestStreamEnd {
	private List<Employee> list;

	@Before
	public void before() {
		list = EmployeeData.getEmployees();
		
		
	}
	//测试匹配与查找
	/*
	 * allMatch(Predicate p)——检查是否匹配所有元素
		anyMatch(Predicate p)——检查是否至少匹配一个元素
		noneMatch(Predicate p)——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素

	 */
	@Test
	public void test1() {
		//1.获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//2.中间操作（略）
		//3.终止操作
		//---------------方法1：allMatch/anyMatch/noneMathc------------------
		
//		boolean allMatch = stream.noneMatch(e->e.getAge()>18);
//		System.out.println(allMatch);
		
		//---------------方法2：findFirst--------------
		
		System.out.println(stream.findFirst());
	}
	//测试求最值和遍历
	/*
	 * count统计个数
	 * max
	 * min
	 * forEach
	 * 
	 */
	@Test
	public void test2() {
		//1.获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//2.中间操作（略）
		//3.终止操作
		//---------------方法3：count--------------
//		System.out.println(stream.count());
		//---------------方法4：max/min--------------
		Optional<Employee> max = stream.max((e1,e2)->Integer.compare(e1.getAge(), e2.getAge()));
		System.out.println(max);
		
		//--------------方法5：forEach---------------
		
		stream.forEach(System.out::println);
		
	}
	
	//测试归约
	/*
	 * reduce(BinaryOperator bo)
	 */
	@Test
	public void test3() {
		//1.获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//2.中间操作（略）
		//3.终止操作
		//---------------方法6：reduce--------------
		//使用匿名内部类
//		stream.map(Employee::getSalary).reduce(new BinaryOperator<Double>() {
//
//			@Override
//			public Double apply(Double t, Double u) {
//				return t+u;
//			}
//			
//		});
		//使用Lambda
//		Optional<Double> reduce = stream.map(Employee::getSalary).reduce((t,u)->t+u);
//		System.out.println(reduce);
		
		
//		System.out.println(stream.map(Employee::getSalary).reduce(10000.0, (t,u)->(t+u)));;
		
		System.out.println(stream.map(Employee::getName).reduce("hello", (t,u)->(t+" "+u)));
	}
	
	//统计男员工，并且去重后的个数
	@Test
	public void exec1() {
		System.out.println(list.stream().distinct().filter(e->e.getGender()=='男').count()
		);
		
	}
	
	//将年龄>20岁的员工的姓名进行拼接，中间使用空格隔开
	@Test
	public void exec3() {
		
		Optional<String> reduce = list.stream().filter(e->e.getAge()>20).map(Employee::getName).reduce((t,u)->(t+" "+u));
		System.out.println(reduce);
		
	}
//	练习2：员工姓名中包含“阿”的员工个数
	@Test
	public void exec4() {
		//不用reduce
//		long count = list.stream().filter(e->e.getName().contains("阿")).count();
//		System.out.println(count);
		
		//使用reduce
		Optional<Integer> reduce = list.stream().filter(e->e.getName().contains("阿")).map(e->1).reduce((t,u)->t+u);
		System.out.println(reduce);
		
	}
	
}
