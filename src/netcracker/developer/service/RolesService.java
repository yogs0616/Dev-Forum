package netcracker.developer.service;

import netcracker.developer.viewBean.RegBean;

public interface RolesService {

	public RegBean getUser(String emailId);



	public void updateProfile(RegBean regBean);

	public void changePassword(RegBean regBean, String newpassword);



	public void increaseLike(int queryId);

}
