/*	$Header: $
 *
 *	Copyright © 2014 Pearson VUE. All rights reserved.
 */

package com.devket.service;

import com.devket.jms.JmsMessageProducer;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 *  Simple implementation hosting example REST service endpoints.
 *
 *  @author Tom Cross
 *  @version $Revision: #1 $ submitted $DateTime: 2014/04/22 15:21:00 $ by $Author: CROSTA $	
 */
@Service
public class ExampleServiceImpl implements ExampleService {

	@Resource
	private JmsMessageProducer messageProducer;


	public String sendMessage(final Integer enrollmentId, final String eventName) {

		if (enrollmentId == null || eventName == null) {
			return "REST endpoint triggered but nothing to do.";
		}

		messageProducer.sendMessage(enrollmentId, eventName);
		return "Sent message for enrollment " + enrollmentId + " and event " + eventName + ".";
	}
}
