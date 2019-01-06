package demo.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

import demo.bean.Employee;
import demo.data.EmployeeData;

/**
 * 此类用于演示StreamAPI的使用步骤之二：中间操作
 * @author liyuting
 * 
 * 特点：
 * ① 中间操作可以多个连接，形成流水线
 * ②中间操作必须等待终止操作执行后，才能处理，否则不会进行任何处理，我们把这种操作，称为“惰性求值”
 * ③每一个Stream都只能消费一次
 * 
 * 常见的方法：
 * 
 * filter(Predicate):根据条件过滤
 * limit(long max):截取size<=max的元素
 * skip(long s):跳过前s个
 * distinct():返回去重后的元素集合，根据hashCode和equals方法判断重复项
 * map(Function):映射成新元素
 * flatMap(Function):映射成Stream类型的新元素
 * sorted():自然排序
 * sorted(Comparator):定制排序
 * 
 * 
 * 
 *
 */
public class TestStreamMiddle {
	//测试筛选与切片
	/*
	 * filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
		limit(n)——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素

	 * 
	 */
	
	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getEmployees();
		
		//步骤1.开始操作：获取Stream对象，指向数据源list
		Stream<Employee> stream = list.stream();
		
		//步骤2：中间操作：调用Stream的方法，返回新的Stream
		
		//---------------------方法1：filter-------------------
		//使用匿名内部类
//		Stream<Employee> streamFilter = stream.filter(new Predicate<Employee>() {
//
//			@Override
//			public boolean test(Employee t) {
//				return t.getAge()>20;
//			}
//		});
		//使用Lambda表达式
//		Stream<Employee> streamFilter = stream.filter(t->t.getAge()>20);
		//---------------------方法2：limit-------------------
		
//		 stream.limit(5).forEach(System.out::println);
		//---------------------方法3：skip-------------------
//		 stream.skip(2).forEach(System.out::println);
		//---------------------方法4：distinct-------------------
		stream.distinct().forEach(System.out::println);
		
		//步骤3：终止操作
//		streamFilter.forEach(System.out::println);
		
		
	}
	//测试 映射
	/*
	 * map(Function):将数据源的每一个元素，根据需要映射成一个新的元素
	 * flatMap(Function):将数据源的每一个元素，根据需要映射成一个新的Stream
	 */
	@Test
	public void test2() {
		List<Employee> list = EmployeeData.getEmployees();
		//获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//调用中间操作
		//----------------------方法5：map--------------
//		Stream<String> map = stream.map(Employee::getName);
//		
//		map.forEach(System.out::println);
		
//		stream.map(Employee::getSalary).forEach(System.out::println);
		
		//----------------------方法6：flatMap--------------
		stream.map(TestStreamMiddle::fromEmployeeToStream).forEach(System.out::println);;
		
		
		
	}
	//测试 排序
	/*
	 * sorted():实现自然排序。要求元素本身具备比较性。也就是实现了Comparable接口，并实现了compareTo方法
	 * sorted(Comparator):实现定制排序。元素本身可以没有比较性，但要求按Comparator的比较规则进行排序
	 */
	@Test
	public void test3() {
		List<Employee> list = EmployeeData.getEmployees();
		//获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//---------------------方法七：sorted-------------
		
//		stream.sorted().forEach(System.out::println);
		
		//---------------------方法八：sorted(Comparator)-------------
		
		stream.sorted((o1,o2)->Integer.compare(o2.getAge(), o1.getAge())).forEach(System.out::println);;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//功能：将e转换成Stream，保存员工的一组值
	public static Stream<Object> fromEmployeeToStream(Employee e){
		return Stream.of(e.getId(),e.getName(),e.getAge(),e.getSalary(),e.getGender());
	}
	
	//案例1：截取第3——6条记录
	@Test
	public void exec1() {
		List<Employee> list = EmployeeData.getEmployees();
		
		list.stream().skip(2).limit(4).forEach(System.out::println);
		
	}
	//练习：获取员工姓名长度大于2的员工的姓名。
	@Test
	public void exec2() {
		
		List<Employee> list = EmployeeData.getEmployees();
		
		list.stream().map(Employee::getName).filter(s->s.length()>2).forEach(System.out::println);
		
		
	}

}










