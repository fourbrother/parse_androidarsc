package com.wjdiankong.parseresource.type;

import com.wjdiankong.parseresource.Utils;

/**
struct ResTable_ref
{
    uint32_t ident;
};
 * @author i
 *
 */
public class ResTableRef {
	
	public int ident;
	
	public int getSize(){
		return 4;
	}
	
	@Override
	public String toString(){
		return "ident:0x"+Utils.bytesToHexString(Utils.int2Byte(ident));
	}

}
