package com.wjdiankong.parseresource.type;

import com.wjdiankong.parseresource.Utils;

/**
struct ResChunk_header
{
    // Type identifier for this chunk.  The meaning of this value depends
    // on the containing chunk.
    uint16_t type;

    // Size of the chunk header (in bytes).  Adding this value to
    // the address of the chunk allows you to find its associated data
    // (if any).
    uint16_t headerSize;

    // Total size of this chunk (in bytes).  This is the chunkSize plus
    // the size of any data associated with the chunk.  Adding this value
    // to the chunk allows you to completely skip its contents (including
    // any child chunks).  If this value is the same as chunkSize, there is
    // no data associated with the chunk.
    uint32_t size;
};
 * @author i
 *
 */
public class ResChunkHeader {
	
	public short type;
	public short headerSize;
	public int size;
	
	public int getHeaderSize(){
		return 2+2+4;
	}
	
	@Override
	public String toString(){
		return "type:"+Utils.bytesToHexString(Utils.int2Byte(type))+",headerSize:"+headerSize+",size:"+size;
	}

}
