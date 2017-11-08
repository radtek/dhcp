/*
 * Copyright 2009-2014 Jagornet Technologies, LLC.  All Rights Reserved.
 *
 * This software is the proprietary information of Jagornet Technologies, LLC. 
 * Use is subject to license terms.
 *
 */

/*
 *   This file DhcpV4NetbiosNameServersOption.java is part of Jagornet DHCP.
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
package com.jagornet.dhcp.option.v4;

import java.util.List;

import com.jagornet.dhcp.option.base.BaseIpAddressListOption;
import com.jagornet.dhcp.util.DhcpConstants;

/**
 * <p>Title: DhcpV4NetbiosNameServersOption </p>
 * <p>Description: </p>.
 * 
 * @author A. Gregory Rabil
 */
public class DhcpV4NetbiosNameServersOption extends BaseIpAddressListOption
{
	/**
	 * Instantiates a new dhcp v4 netbiosName servers option.
	 */
	public DhcpV4NetbiosNameServersOption()
	{
		this(null);
	}
	
	/**
	 * Instantiates a new dhcp v4 netbios name servers option.
	 * 
	 * @param v4NetbiosNameServersOption the v4 netbios name servers option
	 */
	public DhcpV4NetbiosNameServersOption(List<String> v4NetbiosNameServers)
	{
		super(v4NetbiosNameServers);
		setCode(DhcpConstants.V4OPTION_NETBIOS_NAME_SERVERS);
		setV4(true);
	}
}
