package task1;

public class Employee {
	final static double WORK_HOURS = 8;

	private String name;
	Task currentTask;
	private double hoursLeft;
	private static AllWork allWork;

	public static AllWork getAllWork() {
		return allWork;
	}

	public static void setAllWork(AllWork allWork) {
		if (allWork != null) {
			Employee.allWork = allWork;
		}
	}

	Employee(String name) {
		this.name = name;

	}

	String getName() {
		return name;
	}

	void setName(String name) {
		if (name.length() > 0) {
			this.name = name;
		}
	}

	double getHoursLeft() {
		return hoursLeft;
	}

	void setHoursLeft(double hoursLeft) {
		if (hoursLeft >= 0) {
			this.hoursLeft = hoursLeft;
		}
	}

	void work() {
		if (currentTask != null) {
			if (hoursLeft < currentTask.getWorkingHours()) {
				currentTask.setWorkingHours(currentTask.getWorkingHours() - hoursLeft);
				hoursLeft = 0;

				showReport();
			} else {
				hoursLeft -= currentTask.getWorkingHours();
				currentTask.setWorkingHours(0);
				currentTask = allWork.getNextTask();
									
				if (hoursLeft > 0 && currentTask != null) {
					work();
				} else {
					showReport();
				}
			}
		} else {
			currentTask = allWork.getNextTask();
			
			if (currentTask == null) {
				System.out.println(name + ": No tasks left.");
			} else {
				work();
			}
		}
	}

	void showReport() {
		System.out.println("Name of Employee: " + this.name);
		System.out.println("Employee hour left: " + this.hoursLeft);

		if (this.currentTask != null) {
			System.out.println("Task of Employee: " + this.currentTask.getName());
			System.out.println("Current task hour left: " + this.currentTask.getWorkingHours());
		}
	}

	void startWorkingDay() {
		hoursLeft = WORK_HOURS;
	}
}
