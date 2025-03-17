package com.zym;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IUser userobj = new UserImpl();
		IWorkout workoutobj = new WorkOutImpl();
		
		User user = new User("Hari","Narayana","Harin","hari123");
		userobj.register(user, 0);
		System.out.println("is user is valid:"+userobj.login("Harin", "hari123"));
		System.out.println("is user is valid:"+userobj.login("Naman", "naman"));
        
		//workoutinfo
		WorkOut workout1 = new WorkOut("Cardio","Tredmill",0,10,"Fitness");
		WorkOut workout2 = new WorkOut("muscle","dumbel",10,15,"strength");
		
		workoutobj.addWorkOut(workout1, 0);
		workoutobj.addWorkOut(workout2, 1);
		
		WorkOut workouts[] = workoutobj.displayWorkOuts();
		for(WorkOut w:workouts)
		{
			System.out.println(w);
		}
	}

}
