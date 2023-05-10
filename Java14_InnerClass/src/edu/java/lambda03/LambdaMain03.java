package edu.java.lambda03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList(
				new Employee(100, "이찬희", "개발 1팀", "대리", 400.0),
				new Employee(101, "김대한", "개발 2팀", "사원", 350.0),
				new Employee(200, "김다훈", "개발 2팀", "과장", 380.0),
				new Employee(201, "유다한", "개발 1팀", "부장", 500.0),
				new Employee(300, "강효남", "인사팀", "사원", 300.0),
				new Employee(301, "위태욱", "인사팀", "과장", 1000.0)
			);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		for(Employee x : employees) {
			System.out.println(x);
		}
		
		System.out.println("==============================================================================");
		
		// 2. 개발1,2팀에서 일하는 직원들의 급여의 합계를 출력.
		List<Employee> s = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.toList();
		Double sum = 0.0;
		for (Employee x : s) {
			sum += x.getSalary();
		}
		System.out.println("개발 팀 직원 급여 합계 : " + sum);
		
		System.out.println("==============================================================================");

		// 3. 개발1,2팀에서 일하는 직원들의 급여의 평균을 출력.
		System.out.println("개발 팀 직원 급여 평균 : " + (sum/s.size()));
		
		System.out.println("==============================================================================");
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력.
		
		Double s2 = employees.stream()
				.filter(x -> x.getEmpTitle().contains("사원"))
				.mapToDouble(x -> x.getSalary())
				.sum();
		System.out.println("직급이 사원인 직원들 급여 합계 : " + s2);
		
		System.out.println("==============================================================================");
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력.
		Double s3 = employees.stream()
				.filter(x -> x.getEmpTitle().contains("사원"))
				.mapToDouble(x -> x.getSalary())
				.average()
				.orElseThrow();
		System.out.println("직급이 사원인 직원들 급여 합계 : " + s3);
		
		System.out.println("==============================================================================");
		
		// 6. 급여가 400이상인 직원들의 정보를 출력. -> 한 줄에 한 명씩
		List<Employee> s4 = employees.stream()
				.filter(x -> x.getSalary() >= 400.0)
				.toList();
		for(Employee x : s4) {
			System.out.println(x);
		}
		
//		forEach(System.out::println) // -> x -> System.out.println(x)
		
		System.out.println("==============================================================================");
		
		// 7. 개발 1팀 직원들의 급여를 10%인상하고, 그 직원들의 급여 평균을 계산하고 출력.
		Double s5 = employees.stream()
				.filter(x -> x.getDept().contains("개발 1팀"))
				.mapToDouble(x -> x.getSalary()+(x.getSalary()*0.1))
				.average()
				.orElseThrow();
		System.out.println("개발 1팀 급여 10%인상 후 급여 평균 : " + s5);
				
		System.out.println("==============================================================================");
		
		// 8. 직원 리스트에서 "사원"은 몇 명일까요?
		long s6 = employees.stream()
				.filter(x -> x.getEmpTitle().contains("사원"))
				.count();
		System.out.println("직원 사원 인원 수 : " + s6);
	}

}
