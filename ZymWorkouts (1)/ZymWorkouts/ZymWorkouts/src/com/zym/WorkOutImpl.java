package com.zym;

public class WorkOutImpl implements IWorkout {

	private WorkOut workouts[];
	
	public WorkOutImpl()
	{
		workouts = new WorkOut[2];
	}

	@Override
	public void addWorkOut(WorkOut workout, int index) {
		// TODO Auto-generated method stub
		workouts[index] = workout;
	}

	@Override
	public WorkOut[] displayWorkOuts() {
		// TODO Auto-generated method stub
		
		return workouts;
	}
}
