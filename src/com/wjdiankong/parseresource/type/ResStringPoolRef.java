package com.wjdiankong.parseresource.type;

/**
 struct ResStringPool_ref
 {
     uint32_t index;
 };
 
 * @author i
 *
 */
public class ResStringPoolRef {

	public int index;
	
	public int getSize(){
		return 4;
	}
	
	@Override
	public String toString(){
		return "index:"+index;
	}
	
}
