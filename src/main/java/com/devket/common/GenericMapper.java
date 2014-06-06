/*	$Header: $
 *
 *	Copyright © 2014 Pearson VUE. All rights reserved.
 */

package com.devket.common;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *  Generic mapper for translation between domain objects and DTOs.
 *
 *  @author Tom Cross
 *  @version $Revision: #1 $ submitted $DateTime: 2014/04/22 14:29:00 $ by $Author: CROSTA $	
 */
@Component
public class GenericMapper<U, V> {

	public U copy(U toObject, V fromObject) {
		return copy(toObject, fromObject, null);
	}


	public U copy(U toObject, V fromObject, List<String> fields) {
		try {
			if (fields == null || fields.isEmpty()) {
				BeanUtils.copyProperties(fromObject, toObject);
			} else {
				for (String field : fields) {
					PropertyUtils.setProperty(toObject, field, PropertyUtils.getProperty(fromObject, field));
				}
			}
			return toObject;
		} catch (Exception ex) {
			//TODO: Review exception handling
			throw new IllegalArgumentException(ex);
		}
	}
}
