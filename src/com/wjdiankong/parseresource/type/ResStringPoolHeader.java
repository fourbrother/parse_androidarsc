package com.wjdiankong.parseresource.type;

/**
struct ResStringPool_header
{
    struct ResChunk_header header;

    // Number of strings in this pool (number of uint32_t indices that follow
    // in the data).
    uint32_t stringCount;

    // Number of style span arrays in the pool (number of uint32_t indices
    // follow the string indices).
    uint32_t styleCount;

    // Flags.
    enum {
        // If set, the string index is sorted by the string values (based
        // on strcmp16()).
        SORTED_FLAG = 1<<0,

        // String pool is encoded in UTF-8
        UTF8_FLAG = 1<<8
    };
    uint32_t flags;

    // Index from header of the string data.
    uint32_t stringsStart;

    // Index from header of the style data.
    uint32_t stylesStart;
};
 * @author i
 *
 */
public class ResStringPoolHeader {
	
	public ResChunkHeader header;
	public int stringCount;
	public int styleCount;
	
	public final static int SORTED_FLAG = 1;
	public final static int UTF8_FLAG = (1<<8);
	
	public int flags;
	public int stringsStart;
	public int stylesStart;
	
	public ResStringPoolHeader(){
		header = new ResChunkHeader();
	}
	
	public int getHeaderSize(){
		return header.getHeaderSize() + 4 + 4 + 4 + 4 + 4;
	}
	
	@Override
	public String toString(){
		return "header:"+header.toString()+"\n" + "stringCount:"+stringCount+",styleCount:"+styleCount+",flags:"+flags+",stringStart:"+stringsStart+",stylesStart:"+stylesStart;
	}
	
}
