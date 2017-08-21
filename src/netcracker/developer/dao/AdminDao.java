package netcracker.developer.dao;

import java.util.List;

import netcracker.developer.viewBean.RegBean;

public interface AdminDao extends RolesDao {

	

	public void insertData(RegBean regBean);

	public List<RegBean> getUserList();

	public void deleteData(String emailId);

	void updateData(RegBean regBean);

	public void deleteQue(int queryId);

	public void deleteAns(int solutionId,int queryId);

	
	

}
