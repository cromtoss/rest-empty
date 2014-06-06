/*	$Header: $
 *
 *	Copyright © 2014 Pearson VUE. All rights reserved.
 */

package com.devket.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *  A simple interface for an example REST service.
 *
 *  @author Tom Cross
 *  @version $Revision: #1 $ submitted $DateTime: 2014/04/22 15:17:00 $ by $Author: CROSTA $	
 */
@Path("example")
@Produces({"application/json"})
@Consumes({"application/json"})
public interface ExampleService {

	@GET
	String sendMessage(
		@QueryParam("enrollmentId") Integer enrollmentId,
		@QueryParam("eventName") String eventName
	);
}
