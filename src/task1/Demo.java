package task1;

public class Demo {
	final static int EMPLOYEE_COUNT = 4;

	public static void main(String[] args) {
		AllWork allWork = new AllWork();
		Employee[] employees = new Employee[EMPLOYEE_COUNT];
		
		for (int i = 0; i < 10; i++) {
			Task task = new Task("Task " + i, (i % 2 == 0) ? 10 : 14);
			allWork.addTask(task);
		}
		
		Employee.setAllWork(allWork);

		for (int i = 0; i < EMPLOYEE_COUNT; i++) {
			Employee employee = new Employee("Employee " + i);
			employees[i] = employee;
		}
		
		while (allWork.hoursLeftOnAllTasks() > 0) {
			System.out.println("\nNew day\n----------------------\n");
			
			for (int i = 0; i < employees.length; i++) {
				Employee employee = employees[i];
				employee.startWorkingDay();
				employee.work();
				
				System.out.println();
			}
			
			System.out.println("End of the day \n" + allWork.hoursLeftOnAllTasks() + "\n----------------------");
			
		}
	}

}
