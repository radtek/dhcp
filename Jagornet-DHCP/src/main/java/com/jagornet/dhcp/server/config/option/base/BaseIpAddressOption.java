/*
 * Copyright 2009-2014 Jagornet Technologies, LLC.  All Rights Reserved.
 *
 * This software is the proprietary information of Jagornet Technologies, LLC. 
 * Use is subject to license terms.
 *
 */

/*
 *   This file BaseIpAddressOption.java is part of Jagornet DHCP.
 *
 *   Jagornet DHCP is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Jagornet DHCP is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Jagornet DHCP.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.jagornet.dhcp.server.config.option.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jagornet.dhcp.server.config.option.DhcpComparableOption;
import com.jagornet.dhcp.xml.IpAddressOptionType;
import com.jagornet.dhcp.xml.Operator;
import com.jagornet.dhcp.xml.OptionExpression;

/**
 * Title: BaseIpAddressOption
 * Description: The abstract base class for ip address DHCP options.
 * 
 * @author A. Gregory Rabil
 */
public abstract class BaseIpAddressOption 
				extends com.jagornet.dhcp.option.base.BaseIpAddressOption
				implements DhcpComparableOption
{
	private static Logger log = LoggerFactory.getLogger(BaseIpAddressOption.class);
	
	public BaseIpAddressOption()
	{
		this(null);
	}
	
	public BaseIpAddressOption(IpAddressOptionType ipAddressOption)
	{
		super();
		if (ipAddressOption != null) {
			super.setIpAddress(ipAddressOption.getIpAddress());
		}
	}

	@Override
	public boolean matches(OptionExpression expression)
    {
        if (expression == null)
            return false;
        if (expression.getCode() != this.getCode())
            return false;
        if (ipAddress == null)
        	return false;
        
        IpAddressOptionType exprOption = expression.getIpAddressOption();
        if (exprOption != null) {
        	String exprIpAddress = exprOption.getIpAddress();
            Operator op = expression.getOperator();
            if (op.equals(Operator.EQUALS)) {
            	return ipAddress.equals(exprIpAddress);
            }
            else if (op.equals(Operator.STARTS_WITH)) {
            	return ipAddress.startsWith(exprIpAddress);
            }
            else if (op.equals(Operator.ENDS_WITH)) {
            	return ipAddress.endsWith(exprIpAddress);
            }
            else if (op.equals(Operator.CONTAINS)) {
            	return ipAddress.contains(exprIpAddress);
            }
            else if (op.equals(Operator.REG_EXP)) {
            	return ipAddress.matches(exprIpAddress);
            }
            else {
            	log.warn("Unsupported expression operator: " + op);
            }
        }
        
        return false;
    }
}
