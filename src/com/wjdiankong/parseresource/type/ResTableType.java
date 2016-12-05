package com.wjdiankong.parseresource.type;

/**
struct ResTable_type
{
    struct ResChunk_header header;

    enum {
        NO_ENTRY = 0xFFFFFFFF
    };
    
    // The type identifier this chunk is holding.  Type IDs start
    // at 1 (corresponding to the value of the type bits in a
    // resource identifier).  0 is invalid.
    uint8_t id;
    
    // Must be 0.
    uint8_t res0;
    // Must be 0.
    uint16_t res1;
    
    // Number of uint32_t entry indices that follow.
    uint32_t entryCount;

    // Offset from header where ResTable_entry data starts.
    uint32_t entriesStart;
    
    // Configuration this collection of entries is designed for.
    ResTable_config config;
};
 * @author i
 *
 */
public class ResTableType {
	
	public ResChunkHeader header;
	
	public final static int NO_ENTRY = 0xFFFFFFFF;
	
	public byte id;
	public byte res0;
	public short res1;
	public int entryCount;
	public int entriesStart;
	
	public ResTableConfig resConfig;
	
	public ResTableType(){
		header = new ResChunkHeader();
		resConfig = new ResTableConfig();
	}

	public int getSize(){
		return header.getHeaderSize() + 1 + 1 + 2 + 4 + 4;
	}
	
	@Override
	public String toString(){
		return "header:"+header.toString()+",id:"+id+",res0:"+res0+",res1:"+res1+",entryCount:"+entryCount+",entriesStart:"+entriesStart;
	}

}
