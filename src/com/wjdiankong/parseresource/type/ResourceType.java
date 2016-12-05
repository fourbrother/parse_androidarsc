package com.wjdiankong.parseresource.type;

/**
 * 	   RES_NULL_TYPE               = 0x0000,
 3     RES_STRING_POOL_TYPE        = 0x0001,
 4     RES_TABLE_TYPE              = 0x0002,
 5     RES_XML_TYPE                = 0x0003,
 6 
 7     // Chunk types in RES_XML_TYPE
 8     RES_XML_FIRST_CHUNK_TYPE    = 0x0100,
 9     RES_XML_START_NAMESPACE_TYPE= 0x0100,
10     RES_XML_END_NAMESPACE_TYPE  = 0x0101,
11     RES_XML_START_ELEMENT_TYPE  = 0x0102,
12     RES_XML_END_ELEMENT_TYPE    = 0x0103,
13     RES_XML_CDATA_TYPE          = 0x0104,
14     RES_XML_LAST_CHUNK_TYPE     = 0x017f,
15     // This contains a uint32_t array mapping strings in the string
16     // pool back to resource identifiers.  It is optional.
17     RES_XML_RESOURCE_MAP_TYPE   = 0x0180,
18 
19     // Chunk types in RES_TABLE_TYPE
20     RES_TABLE_PACKAGE_TYPE      = 0x0200,
21     RES_TABLE_TYPE_TYPE         = 0x0201,
22     RES_TABLE_TYPE_SPEC_TYPE    = 0x0202
 * @author i
 *
 */
public class ResourceType {
	
	public final static int RES_NULL_TYPE = 0x0000;
	public final static int RES_STRING_POOL_TYPE = 0x0001;
	public final static int RES_TABLE_TYPE = 0x0002;
	public final static int RES_XML_TYPE = 0x0003;
	public final static int RES_XML_FIRST_CHUNK_TYPE = 0x0100;
	public final static int RES_XML_START_NAMESPACE_TYPE = 0x0100;
	public final static int RES_XML_END_NAMESPACE_TYPE = 0x0101;
	public final static int RES_XML_START_ELEMENT_TYPE = 0x0102;
	public final static int RES_XML_END_ELEMENT_TYPE = 0x0103;
	public final static int RES_XML_CDATA_TYPE = 0x0104;
	public final static int RES_XML_LAST_CHUNK_TYPE = 0x017f;
	public final static int RES_XML_RESOURCE_MAP_TYPE = 0x0180;
	public final static int RES_TABLE_PACKAGE_TYPE = 0x0200;
	public final static int RES_TABLE_TYPE_TYPE = 0x0201;
	public final static int RES_TABLE_TYPE_SPEC_TYPE = 0x0202;
	
}
