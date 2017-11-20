package com.avaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avaya.model.Adapter;
import com.avaya.model.AgentHandleLoginState;
import com.avaya.model.AgentLogoutReason;
import com.avaya.model.ModelApiResponse;
import com.avaya.service.AdapterService;
import com.avaya.util.AvayaDataMocker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api")
@Api(value="Employee Service")
public class CrmController
{
	@Autowired
	AdapterService adapterSvc;

	@Autowired
	AvayaDataMocker adapterdtmocker;

//	static Logger log = Logger.getLogger("com.avaya");

	/**
	 * This method will create an Adapter session and return a adapter id
	 * 
	 * @author prabhakaranm
	 * @return String
	 * 
	 * @throws JsonProcessingException
	 */

	@ApiOperation(value = "Create adapters", notes = "Returns Response Of adapters Creation. SLA:500", response = String.class)
	 @ApiResponses(value = {
	   @ApiResponse(code = 200, message = "Successfully Created adapters", response = String.class),
	   @ApiResponse(code = 404, message = "Creation Of adapters Failed"),
	   @ApiResponse(code = 400, message = "Invalid Input Provided") })
	@RequestMapping(value = "/adapters", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String createAdapterSession() throws JsonProcessingException {
		//log.info("Inside create Adapter Session");
		ObjectMapper mapper = new ObjectMapper();
		Adapter adapter = adapterSvc.getMockedAdapter();
		String jsonInString = mapper.writeValueAsString(adapter);
		return jsonInString;
	}

	/**
	 * This method is used by an agent to login
	 * 
	 * @param loginState
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "agents/{agentId}/loginCommand", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String loginCommand(@PathVariable("agentId") String agentId,@RequestBody AgentHandleLoginState loginStateParam)
			throws JsonProcessingException {
		//log.info("Inside login command" +agentId);
		//log.info(loginStateParam.getLoginState());
		ObjectMapper mapper = new ObjectMapper();
		ModelApiResponse modApiResp = adapterSvc.agentLoginCommand();
		String responseJson = convertObjtoJson(modApiResp);
		//log.info("Exit login command");
		return responseJson;
	}

	/**
	 * This method is used by an agent to logout
	 * 
	 * @param myParams
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "agents/{agentId}/logoutCommand", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String logoutCommand(@PathVariable("agentId") String agentId,@ModelAttribute AgentLogoutReason myParams)
			throws JsonProcessingException {
		//log.info("Inside logout command");
		//log.info(myParams.getLogoutReason());
		//log.info(agentId);
		ModelApiResponse modApiResp = adapterSvc.agentLogoutCommand();
		String responseJson = convertObjtoJson(modApiResp);
		//log.info("Exit logout command");
		return responseJson;
	}

	/**
	 * This method is used to convert Object to JSON\
	 * 
	 * @param Object
	 * @return String
	 * @throws JsonProcessingException
	 */
	private String convertObjtoJson(Object modelObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(modelObj);
		return jsonInString;

	}
}
