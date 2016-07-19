package task1;

public class AllWork {

	private Task[] tasks;
	public Task[] getTasks() {
		return tasks;
	}

	public int getFreePlacesForTasks() {
		return freePlacesForTasks;
	}

	public int getCurrentUnassignedTask() {
		return currentUnassignedTask;
	}

	private int freePlacesForTasks;
	private int currentUnassignedTask;

	AllWork() {
		freePlacesForTasks = 10;
		tasks = new Task[freePlacesForTasks];
		currentUnassignedTask = 0;

	}

	void addTask(Task task) {
		if (task != null) {
			for (int index = 0; index < tasks.length; index++) {
				if (tasks[index] == null) {
					tasks[index] = task;
					freePlacesForTasks--;
					return;
				}
			}
		}

	}

	Task getNextTask() {
		if (currentUnassignedTask < tasks.length) {
			Task unassignedTask = tasks[currentUnassignedTask];
			currentUnassignedTask++;
			return unassignedTask;
		}
		return null;
	}
	
	double hoursLeftOnAllTasks() {
		double hoursLeftOnAllTasks = 0;
		
		for (int i = 0; i < tasks.length; i++) {
			hoursLeftOnAllTasks += tasks[i].getWorkingHours();
		}
		
		return hoursLeftOnAllTasks;
	}
}
