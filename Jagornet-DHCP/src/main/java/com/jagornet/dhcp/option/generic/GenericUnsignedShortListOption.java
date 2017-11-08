/*
 * Copyright 2009-2014 Jagornet Technologies, LLC.  All Rights Reserved.
 *
 * This software is the proprietary information of Jagornet Technologies, LLC. 
 * Use is subject to license terms.
 *
 */

/*
 *   This file GenericUnsignedShortListOption.java is part of Jagornet DHCP.
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
package com.jagornet.dhcp.option.generic;

import java.util.List;

import com.jagornet.dhcp.option.base.BaseUnsignedShortListOption;

/**
 * <p>Title: GenericUnsignedShortListOption </p>
 * <p>Description: </p>.
 * 
 * @author A. Gregory Rabil
 */
public class GenericUnsignedShortListOption extends BaseUnsignedShortListOption
{	
	/**
	 * Instantiates a new generic unsigned short list option.
	 * 
	 * @param code the option code
	 * @param name the option name
	 */
	public GenericUnsignedShortListOption(int code, String name)
	{
		this(code, name, null);
	}
	
	/**
	 * Instantiates a new generic unsigned short list option.
	 * 
	 * @param code the option code
	 * @param name the option name
	 * @param unsignedShortListOption the unsigned short list option
	 */
	public GenericUnsignedShortListOption(int code, String name, List<Integer> unsignedShorts)
	{
		super(unsignedShorts);
		setCode(code);
		setName(name);
	}
}
