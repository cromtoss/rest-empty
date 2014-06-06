/*	$Header: $
 *
 *	Copyright © 2014 Pearson VUE. All rights reserved.
 */

package com.devket.jms;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 *  Code example for producing a JMS message.
 *
 *  The connection information is represented in the Spring configuration XML that
 *  is used to instantiate the JmsTemplate bean below.
 *
 *  @author Tom Cross
 *  @version $Revision: #1 $ submitted $DateTime: 2014/04/24 15:00:00 $ by $Author: CROSTA $	
 */
@Component
public class JmsMessageProducer {

	@Resource
	private JmsTemplate jmsTemplate;

	// It might be convenient to get the JMS destination bean from the Spring container right
	// when it's needed, because setting the "defaultDestination" property on the JmsTemplate
	// will probably necessitate that the JMS queue exists on startup, which might not
	// be what you want.
	public String sendMessage(final Integer enrollmentId, final String eventName) {

		if (enrollmentId == null || eventName == null) {
			return "REST endpoint triggered but nothing to do.";
		}

		final MessageCreator messageCreator = new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				final Message message = session.createMessage();
				message.setIntProperty("EnrollmentID", enrollmentId);
				message.setStringProperty("RequirementName", eventName);
				return message;
			}
		};

		try {
			jmsTemplate.send(messageCreator);
		} catch (RuntimeException ex) {
			// put your "try to send message later" logic here.
		}

		return "Sent message for enrollment " + enrollmentId + " and event " + eventName + ".";
	}
}
