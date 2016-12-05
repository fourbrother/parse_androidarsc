package com.wjdiankong.parseresource.type;

import com.wjdiankong.parseresource.ParseResourceUtils;

/**
struct ResTable_entry
{
    // Number of bytes in this structure.
    uint16_t size;

    enum {
        // If set, this is a complex entry, holding a set of name/value
        // mappings.  It is followed by an array of ResTable_map structures.
        FLAG_COMPLEX = 0x0001,
        // If set, this resource has been declared public, so libraries
        // are allowed to reference it.
        FLAG_PUBLIC = 0x0002
    };
    uint16_t flags;
    
    // Reference into ResTable_package::keyStrings identifying this entry.
    struct ResStringPool_ref key;
};
 * @author i
 *
 */
public class ResTableEntry {
	
	public final static int FLAG_COMPLEX = 0x0001;
	public final static int FLAG_PUBLIC = 0x0002;
	
	public short size;
	public short flags;
	
	public ResStringPoolRef key;
	
	public ResTableEntry(){
		key = new ResStringPoolRef();
	}
	
	public int getSize(){
		return 2+2+key.getSize();
	}
	
	@Override
	public String toString(){
		return "size:"+size+",flags:"+flags+",key:"+key.toString()+",str:"+ParseResourceUtils.getKeyString(key.index);
	}

}
