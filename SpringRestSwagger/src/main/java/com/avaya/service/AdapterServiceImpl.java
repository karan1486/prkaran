package com.avaya.service;

import org.springframework.stereotype.Service;

import com.avaya.model.*;

/**
 * @author prabhakaranm
 *
 */
@Service("adapterSvc")
public class AdapterServiceImpl implements AdapterService{
	
	/* This service class is used to create Adapter mockup
	 * 
	 * (non-Javadoc)
	 * @see com.avaya.service.AdapterService#getMockedAdapter()
	 */
	public Adapter getMockedAdapter(){
		Adapter adapter=new Adapter();
		adapter.setId("Newtin1190");
		adapter.setEventsUrl("www.newtglobal.com");
		return adapter;
	}
	
	/* 
	 * This service class is used by agent to login
	 * (non-Javadoc)
	 * @see com.avaya.service.AdapterService#agentLoginCommand()
	 */
	public ModelApiResponse agentLoginCommand(){
		ModelApiResponse apiResp=new ModelApiResponse();
		apiResp.setCode(1);
		apiResp.setMessage("Login Successfull");
		apiResp.setType("LoginMessage");
		return apiResp;
	}
	
	/* This service class is used by agent to logout
	 * 
	 * (non-Javadoc)
	 * @see com.avaya.service.AdapterService#agentLogoutCommand()
	 */
	public ModelApiResponse agentLogoutCommand(){
		ModelApiResponse apiResp=new ModelApiResponse();
		apiResp.setCode(1);
		apiResp.setMessage("Logout Successfull");
		apiResp.setType("LogoutMessage");
		return apiResp;
	}
}
