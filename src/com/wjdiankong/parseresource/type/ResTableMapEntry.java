package com.wjdiankong.parseresource.type;

/**
 struct ResTable_map_entry : public ResTable_entry
 {
     //指向父ResTable_map_entry的资源ID，如果没有父ResTable_map_entry，则等于0。
     ResTable_ref parent;
     //等于后面ResTable_map的数量
     uint32_t count;
 };
 * @author i
 *
 */
public class ResTableMapEntry extends ResTableEntry{
	
	public ResTableRef parent;
	public int count;
	
	public ResTableMapEntry(){
		parent = new ResTableRef();
	}
	
	@Override
	public int getSize(){
		return super.getSize() + parent.getSize() + 4;
	}
	
	@Override
	public String toString(){
		return super.toString() + ",parent:"+parent.toString()+",count:"+count;
	}

}
