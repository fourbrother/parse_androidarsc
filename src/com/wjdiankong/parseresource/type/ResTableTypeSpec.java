package com.wjdiankong.parseresource.type;

/**
struct ResTable_typeSpec
{
    struct ResChunk_header header;

    // The type identifier this chunk is holding.  Type IDs start
    // at 1 (corresponding to the value of the type bits in a
    // resource identifier).  0 is invalid.
    uint8_t id;
    
    // Must be 0.
    uint8_t res0;
    // Must be 0.
    uint16_t res1;
    
    // Number of uint32_t entry configuration masks that follow.
    uint32_t entryCount;

    enum {
        // Additional flag indicating an entry is public.
        SPEC_PUBLIC = 0x40000000
    };
};
 * @author i
 *
 */
public class ResTableTypeSpec {
	
	public final static int SPEC_PUBLIC = 0x40000000;
	
	public ResChunkHeader header;
	public byte id;
	public byte res0;
	public short res1;
	public int entryCount;
	
	public ResTableTypeSpec(){
		header = new ResChunkHeader();
	}
	
	@Override
	public String toString(){
		return "header:"+header.toString()+",id:"+id+",res0:"+res0+",res1:"+res1+",entryCount:"+entryCount;
	}
	
}
