package com.wjdiankong.parseresource.type;

/**
 struct ResTable_map
 {
     //bag资源项ID
     ResTable_ref name;
     //bag资源项值
     Res_value value;
 };
 * @author i
 *
 */
public class ResTableMap {
	
	public ResTableRef name;
	public ResValue value;
	
	public ResTableMap(){
		name = new ResTableRef();
		value = new ResValue();
	}
	
	public int getSize(){
		return name.getSize() + value.getSize();
	}
	
	@Override
	public String toString(){
		return name.toString()+",value:"+value.toString();
	}

}
