/*
 * Copyright 2009-2014 Jagornet Technologies, LLC.  All Rights Reserved.
 *
 * This software is the proprietary information of Jagornet Technologies, LLC. 
 * Use is subject to license terms.
 *
 */

/*
 *   This file BaseUnsignedShortOption.java is part of Jagornet DHCP.
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
package com.jagornet.dhcp.option.base;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.jagornet.dhcp.util.Util;

/**
 * Title: BaseUnsignedShortOption
 * Description: The abstract base class for unsigned short DHCP options.
 * 
 * @author A. Gregory Rabil
 */
public abstract class BaseUnsignedShortOption extends BaseDhcpOption
{ 
    protected int unsignedShort;
    
    public BaseUnsignedShortOption() {
		this((int)0);
	}
    
    public BaseUnsignedShortOption(int unsignedShort) {
    	super();
		this.unsignedShort = unsignedShort;
	}

    public int getUnsignedShort() {
		return unsignedShort;
	}

	public void setUnsignedShort(int unsignedShort) {
		this.unsignedShort = unsignedShort;
	}

	@Override
    public int getLength()
    {
        return 2;   // always two bytes (short)
    }

	@Override
    public ByteBuffer encode() throws IOException
    {
        ByteBuffer buf = super.encodeCodeAndLength();
        buf.putShort((short)unsignedShort);
        return (ByteBuffer) buf.flip();
    }

	@Override
    public void decode(ByteBuffer buf) throws IOException
    {
    	int len = super.decodeLength(buf);
    	if ((len > 0) && (len <= buf.remaining())) {
    		unsignedShort = Util.getUnsignedShort(buf);
        }
    }

	@Override
	public String toString()
    {
        StringBuilder sb = new StringBuilder(Util.LINE_SEPARATOR);
        sb.append(super.getName());
        sb.append(": unsignedShort=");
        sb.append(unsignedShort);
        return sb.toString();
    }
    
}
