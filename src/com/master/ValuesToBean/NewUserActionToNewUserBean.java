/*package com.aqua.ValuesToBean;

import com.aqua.action.NewUserAction;
import com.aqua.model.NewUserBean;

public class NewUserActionToNewUserBean {

	public NewUserBean setvalues(NewUserAction nua) {
		
		
		NewUserBean nub = new NewUserBean();
		nub.setAddress(nua.getAddress());
		nub.setContact_no(nua.getContact_no());
		nub.setDept_name(nua.getDept_name());
		nub.setEmail(nua.getEmail());
		nub.setOffice_name(nua.getOffice_name());
		nub.setPassword(nua.getPassword());
		nub.setRole_name(nua.getRole_name());
		nub.setUsername(nua.getUsername());
		nub.setZone_name(nua.getZone_name());
		nub.setCity_name(nua.getCity_name());
		return nub;
	}
}*/
package com.master.ValuesToBean;


import com.dao.NewUserAction;
import com.dao.NewUserDao;
import com.login.loginModel.NewUserBean;

public class NewUserActionToNewUserBean {

	public NewUserBean setvalues(NewUserAction nua) {
		NewUserBean nub = new NewUserBean();
		nub.setAddress(nua.getAddress());
		nub.setContact_no(nua.getContact_no());
		nub.setDept_name(nua.getDept_name());
		nub.setEmail(nua.getEmail());
		nub.setOffice_name(nua.getOffice_name());
		nub.setPassword(nua.getPassword());
		nub.setRole_name(nua.getRole_name());
		nub.setUsername(nua.getUsername());
		nub.setZone_name(nua.getZone_name());
		nub.setCity_name(nua.getCity_name());
		nub.setDealerCode(nua.getDealerCode());
		return nub;
	}
}

