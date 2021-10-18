package com.gcu.business;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

public interface SecurityBusinessServiceInterface {
	//Methods 
	void register(RegisterModel registerUser);
	boolean login(LoginModel loginModel);
	void init();
	void destroy();
}
