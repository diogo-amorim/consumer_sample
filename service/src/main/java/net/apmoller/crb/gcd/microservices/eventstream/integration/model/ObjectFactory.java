package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import javax.xml.bind.annotation.XmlRegistry;

/*
 *
 * Copyright (c) Maersk  All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Maersk. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with Maersk.
 * 
 * Module Name 	: ObjectFactory.java
 * Author		: TCS
 * Date			: 01-Mar-2014
 * Description	: it is an Integration controller class
 *  
 */
/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.hermes.form package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.hermes.form
	 */
	public ObjectFactory() {
	}

	/**
	 * createResponseMessage Method Create an instance of
	 * {@link ResponseMessage }.
	 * 
	 * @return the response message
	 * @Input Parameters:
	 * @Return Parameters: ResponseMessage
	 */
	public ResponseMessage createResponseMessage() {
		return new ResponseMessage();
	}

	/**
	 * createResponseMessage Method Create an instance of
	 * {@link ResponseMessage.CustResponse }
	 * 
	 * @return the cust response
	 * @Input Parameters:
	 * @Return Parameters: ResponseMessage.CustResponse
	 */

	public ResponseMessage.CustResponse createResponseMessageCustResponse() {
		return new ResponseMessage.CustResponse();
	}

	/**
	 * createResponseMessageCustResponseResponseDetail Method Create an instance
	 * of {@link ResponseMessage.CustResponse.ResponseDetail }
	 * 
	 * @return the response detail
	 * @Input Parameters:
	 * @Return Parameters: ResponseMessage.CustResponse.ResponseDetail
	 */

	public ResponseMessage.CustResponse.ResponseDetail createResponseMessageCustResponseResponseDetail() {
		return new ResponseMessage.CustResponse.ResponseDetail();
	}

	/**
	 * createResponseMessageCustResponseRemarks Method Create an instance of
	 * {@link ResponseMessage.CustResponse.Remarks }
	 * 
	 * @return the remarks
	 * @Input Parameters:
	 * @Return Parameters: ResponseMessage.CustResponse.Remarks
	 */
	public ResponseMessage.CustResponse.Remarks createResponseMessageCustResponseRemarks() {
		return new ResponseMessage.CustResponse.Remarks();
	}

	/**
	 * createResponseMessageCustResponseResponseDetailRemarks Method Create an
	 * instance of {@link ResponseMessage.CustResponse.ResponseDetail.Remarks }
	 * 
	 * @return the remarks
	 * @Input Parameters:
	 * @Return Parameters:ResponseMessage.CustResponse.ResponseDetail.Remark
	 */
	public ResponseMessage.CustResponse.ResponseDetail.Remarks createResponseMessageCustResponseResponseDetailRemarks() {
		return new ResponseMessage.CustResponse.ResponseDetail.Remarks();
	}

}
