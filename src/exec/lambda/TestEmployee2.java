package exec.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import demo.bean.Employee;
import demo.data.EmployeeData;

/*
 * 
 * 问题：针对员工的集合数据，有如下的一些需求，我们考虑如何完成？

需求1：获取当前公司中员工年龄大于30的员工信息
需求2：获取公司中工资大于 5000 的员工信息
....
进阶2：升级版
 */
public class TestEmployee2 {
	
	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getEmployees();
		//完成需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> filterByAge = filter(list,e->e.getAge()>30);
		for (Employee employee : filterByAge) {
			System.out.println(employee);
		}
		System.out.println("---------------");
		//完成需求2
		List<Employee> filterBySalary = filter(list,e->e.getSalary()>15000);
		for (Employee employee : filterBySalary) {
			System.out.println(employee);
		}
		
	}
	//按条件进行过滤员工
	public List<Employee> filter(List<Employee> list,Predicate<Employee> filter){
		List<Employee> datas = new ArrayList<>();//新集合用于保存过滤后的员工信息
		
		for (Employee employee : list) {
			if(filter.test(employee)) {//如果满足条件，则添加到新集合
				datas.add(employee);
			}
		}
		return datas;
	}
	
	

}

//interface MyFilter{
//	boolean test(Employee employee);
//}
