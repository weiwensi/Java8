package exec.lambda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import demo.bean.Employee;
import demo.data.EmployeeData;

/*
 * 
 * 问题：针对员工的集合数据，有如下的一些需求，我们考虑如何完成？

需求1：获取当前公司中员工年龄大于30的员工信息
需求2：获取公司中工资大于 5000 的员工信息
....

 */
public class TestEmployee {
	
	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getEmployees();
		//完成需求1
		List<Employee> filterByAge = filterByAge(list);
		for (Employee employee : filterByAge) {
			System.out.println(employee);
		}
		System.out.println("---------------");
		//完成需求2
		List<Employee> filterBySalary = filterBySalary(list);
		for (Employee employee : filterBySalary) {
			System.out.println(employee);
		}
		
	}
	//需求1：获取当前公司中员工年龄大于30的员工信息
	public List<Employee> filterByAge(List<Employee> list){
		List<Employee> datas = new ArrayList<>();//新集合用于保存过滤后的员工信息
		
		for (Employee employee : list) {
			if(employee.getAge()>30) {
				datas.add(employee);
			}
		}
		return datas;
	}
	
	//需求2：获取公司中工资大于 5000 的员工信息
	public List<Employee> filterBySalary(List<Employee> list){
		List<Employee> datas = new ArrayList<>();//新集合用于保存过滤后的员工信息
		
		for (Employee employee : list) {
			if(employee.getSalary()>15000) {
				datas.add(employee);
			}
		}
		return datas;
	}

}
