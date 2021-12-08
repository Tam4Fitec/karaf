/*
* This software is the confidential and proprietary information of LeGuide.com.
* ("Confidential Information").  You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms of the license
* agreement you entered into with LeGuide.com.
*
* LeGuide.com MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
* SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
* IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
* PURPOSE, OR NON-INFRINGEMENT. LeGuide.com SHALL NOT BE LIABLE FOR ANY DAMAGES
* SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
* THIS SOFTWARE OR ITS DERIVATIVES.
*
* Use is subject to license terms.
*
*
* Project : LGMobileService
* Copyright (c) 2009-2010 LeGuide.com. All Rights Reserved.
* Company : LeGuide.com
*
* $Id:  $
* $Revision: $
*/
package com.leguide.backoffice.karaf.webservices.client.engine;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.Response;
;

/**
 * XMLEngineResult is a base generic class for handling XMLEngine search query results
 * 
 * @author Eduardo Francos
 *
 */
public class EngineResponse {
	
	private Response response;

	public EngineResponse() {
		super();
	}

	public EngineResponse(Response response) {
		super();
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
