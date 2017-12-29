package com.cobolconverter.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties") 
@ConfigurationProperties
public class ConfigProperties {
	
	public String getInputFile() {
		return inputFile;
	}
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	public String getRPVFPO0A() {
		return RPVFPO0A;
	}
	public void setRPVFPO0A(String rPVFPO0A) {
		RPVFPO0A = rPVFPO0A;
	}
	public String getRPVFPO0Z() {
		return RPVFPO0Z;
	}
	public void setRPVFPO0Z(String rPVFPO0Z) {
		RPVFPO0Z = rPVFPO0Z;
	}
	private String inputFile;
	private String RPVFPO0A;
	private String RPVFPO0Z;

}
