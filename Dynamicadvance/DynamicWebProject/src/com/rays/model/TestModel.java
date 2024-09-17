package com.rays.model;

import com.rays.bean.UserBean;

public class TestModel {

public static void main(String[] args) throws Exception {
	
///testAuthenticate ();	
testFindByLoginId();
	
	
}
private static void testFindByLoginId() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.findByLoginId("samay@gmail.com");

		if (bean != null) {
			System.out.println("loginId already exists");
		} else {
			System.out.println("loginId is not available");
		}

	}
private static void testAuthenticate() throws Exception {

	UserModel model = new UserModel();

	UserBean bean = new UserBean();

	bean = model.authenticate("samay@gmail.com", "samay@123");

	if (bean != null) {

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getPhoneNo());
		System.out.println(bean.getGender());
		System.out.println(bean.getAddress());

	} else {
		System.out.println("invalid loginId or password");
	}

}
	
}
