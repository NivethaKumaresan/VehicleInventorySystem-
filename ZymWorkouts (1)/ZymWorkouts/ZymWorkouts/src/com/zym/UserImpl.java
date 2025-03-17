package com.zym;

public class UserImpl implements IUser {

	private User users[];
	
	UserImpl()
	{
		users = new User[5];
	}

	@Override
	public boolean register(User user, int index) {
		// TODO Auto-generated method stub
		System.out.println("user info is:"+user);
		users[index] = user;
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("user username and password is:"+username+" "+password);
		for(User user:users)
		{
			if(user!=null)
			{
				if(user.getUserName().equals(username) && user.getPassWord().equals(password))
				{
					return true;
				}
			}
		}
		return false;
	}
	
}
