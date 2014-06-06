/*	$Header: $
 *
 *	Copyright © 2014 Pearson VUE. All rights reserved.
 */

package com.devket.common;

import org.apache.commons.lang3.StringUtils;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

/**
 *  A Hibernate naming strategy.
 *
 *  @author Tom Cross
 *  @version $Revision: #1 $ submitted $DateTime: 2014/04/22 14:33:00 $ by $Author: CROSTA $	
 */
public final class NamingStrategy extends ImprovedNamingStrategy {

	private static final long serialVersionUID = 0L;


	@Override
	public String classToTableName(String className) {
		final String unqualified = StringHelper.unqualify(className);
		return StringUtils.removeEnd(unqualified, "PO");
	}


	@Override
	public String propertyToColumnName(String propertyName) {
		final String unqualified = StringHelper.unqualify(propertyName);
		return StringUtils.capitalize(unqualified);
	}


	@Override
	public String tableName(String tableName) {
		return tableName;
	}


	@Override
	public String columnName(String columnName) {
		return columnName;
	}

}
