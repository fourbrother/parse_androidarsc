package com.wjdiankong.parseresource.type;

/**
struct ResTable_header
{
    struct ResChunk_header header;

    // The number of ResTable_package structures.
    uint32_t packageCount;
};
 * @author i
 *
 */
public class ResTableHeader {

	public ResChunkHeader header;
	public int packageCount;
	
	public ResTableHeader(){
		header = new ResChunkHeader();
	}
	
	public int getHeaderSize(){
		return header.getHeaderSize() + 4;
	}
	
	@Override
	public String toString(){
		return "header:"+header.toString()+"\n" + "packageCount:"+packageCount;
	}
	
}
