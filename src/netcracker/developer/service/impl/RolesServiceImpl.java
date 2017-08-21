package netcracker.developer.service.impl;

import netcracker.developer.dao.RolesDao;
import netcracker.developer.service.RolesService;
import netcracker.developer.viewBean.RegBean;

public class RolesServiceImpl implements RolesService {
	
		RolesDao rolesDao;
	
	
	
	public RolesDao getRolesDao() {
			return rolesDao;
		}


		public void setRolesDao(RolesDao rolesDao) {
			this.rolesDao = rolesDao;
		}


	public RegBean getUser(String emailId) {
		return rolesDao.getUser(emailId);
		}

		
		
		
		@Override
		public void updateProfile(RegBean regBean) {
			rolesDao.updateProfile(regBean);
		}

		@Override
		public void changePassword(RegBean regBean, String password) {
		 rolesDao.changePassword(regBean, password);
			
		}


		@Override
		public void increaseLike(int queryId) {
		rolesDao.increaseLike(queryId);
			
		}




}
