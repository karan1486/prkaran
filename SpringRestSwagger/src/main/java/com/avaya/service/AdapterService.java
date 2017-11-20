package com.avaya.service;

import org.springframework.stereotype.Service;

import com.avaya.model.Adapter;
import com.avaya.model.ModelApiResponse;

@Service
public interface AdapterService {
	public Adapter getMockedAdapter();
	public ModelApiResponse agentLoginCommand();
	public ModelApiResponse agentLogoutCommand();
}
