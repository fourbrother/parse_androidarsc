package com.wjdiankong.parseresource.type;

import com.wjdiankong.parseresource.ParseResourceUtils;

/**
struct Res_value
 {
     //Res_value头部大小
     uint16_t size;
     //保留,始终为0
     uint8_t res0;
 
     enum {
         TYPE_NULL = 0x00,
         TYPE_REFERENCE = 0x01,
         TYPE_ATTRIBUTE = 0x02,
         TYPE_STRING = 0x03,
         TYPE_FLOAT = 0x04,
         TYPE_DIMENSION = 0x05,
         TYPE_FRACTION = 0x06,
         TYPE_FIRST_INT = 0x10,
         TYPE_INT_DEC = 0x10,
         TYPE_INT_HEX = 0x11,
         TYPE_INT_BOOLEAN = 0x12,
         TYPE_FIRST_COLOR_INT = 0x1c,
         TYPE_INT_COLOR_ARGB8 = 0x1c,
         TYPE_INT_COLOR_ARGB8 = 0x1c,
         TYPE_INT_COLOR_RGB8 = 0x1d,
         TYPE_INT_COLOR_ARGB4 = 0x1e,
         TYPE_INT_COLOR_RGB4 = 0x1f,
         TYPE_LAST_COLOR_INT = 0x1f,
         TYPE_LAST_INT = 0x1f
     };
     //数据的类型,可以从上面的枚举类型中获取
     uint8_t dataType;
 
     //数据对应的索引
     uint32_t data;
 };
 * @author i
 *
 */
public class ResValue {
	
	//dataType字段使用的常量
	public final static int TYPE_NULL = 0x00;
	public final static int TYPE_REFERENCE = 0x01;
	public final static int TYPE_ATTRIBUTE = 0x02;
	public final static int TYPE_STRING = 0x03;
	public final static int TYPE_FLOAT = 0x04;
	public final static int TYPE_DIMENSION = 0x05;
	public final static int TYPE_FRACTION = 0x06;
	public final static int TYPE_FIRST_INT = 0x10;
	public final static int TYPE_INT_DEC = 0x10;
	public final static int TYPE_INT_HEX = 0x11;
	public final static int TYPE_INT_BOOLEAN = 0x12;
	public final static int TYPE_FIRST_COLOR_INT = 0x1c;
	public final static int TYPE_INT_COLOR_ARGB8 = 0x1c;
	public final static int TYPE_INT_COLOR_RGB8 = 0x1d;
	public final static int TYPE_INT_COLOR_ARGB4 = 0x1e;
	public final static int TYPE_INT_COLOR_RGB4 = 0x1f;
	public final static int TYPE_LAST_COLOR_INT = 0x1f;
	public final static int TYPE_LAST_INT = 0x1f;
	
	public static final int
    COMPLEX_UNIT_PX			=0,
    COMPLEX_UNIT_DIP		=1,
    COMPLEX_UNIT_SP			=2,
    COMPLEX_UNIT_PT			=3,
    COMPLEX_UNIT_IN			=4,
    COMPLEX_UNIT_MM			=5,
	COMPLEX_UNIT_SHIFT		=0,
    COMPLEX_UNIT_MASK		=15,
    COMPLEX_UNIT_FRACTION	=0,
    COMPLEX_UNIT_FRACTION_PARENT=1,
    COMPLEX_RADIX_23p0		=0,
    COMPLEX_RADIX_16p7		=1,
    COMPLEX_RADIX_8p15		=2,
    COMPLEX_RADIX_0p23		=3,
    COMPLEX_RADIX_SHIFT		=4,
    COMPLEX_RADIX_MASK		=3,
    COMPLEX_MANTISSA_SHIFT	=8,
    COMPLEX_MANTISSA_MASK	=0xFFFFFF;
	
	
	public short size;
	public byte res0;
	public byte dataType;
	public int data;
	
	public int getSize(){
		return 2 + 1 + 1 + 4;
	}
	
	public String getTypeStr(){
		switch(dataType){
			case TYPE_NULL:
				return "TYPE_NULL";
			case TYPE_REFERENCE:
				return "TYPE_REFERENCE";
			case TYPE_ATTRIBUTE:
				return "TYPE_ATTRIBUTE";
			case TYPE_STRING:
				return "TYPE_STRING";
			case TYPE_FLOAT:
				return "TYPE_FLOAT";
			case TYPE_DIMENSION:
				return "TYPE_DIMENSION";
			case TYPE_FRACTION:
				return "TYPE_FRACTION";
			case TYPE_FIRST_INT:
				return "TYPE_FIRST_INT";
			case TYPE_INT_HEX:
				return "TYPE_INT_HEX";
			case TYPE_INT_BOOLEAN:
				return "TYPE_INT_BOOLEAN";
			case TYPE_FIRST_COLOR_INT:
				return "TYPE_FIRST_COLOR_INT";
			case TYPE_INT_COLOR_RGB8:
				return "TYPE_INT_COLOR_RGB8";
			case TYPE_INT_COLOR_ARGB4:
				return "TYPE_INT_COLOR_ARGB4";
			case TYPE_INT_COLOR_RGB4:
				return "TYPE_INT_COLOR_RGB4";
		}
		return "";
	}
	
	/*public String getDataStr(){
		if(dataType == TYPE_STRING){
			return ParseResourceUtils.getResString(data);
		}else if(dataType == TYPE_FIRST_COLOR_INT){
			return Utils.bytesToHexString(Utils.int2Byte(data));
		}else if(dataType == TYPE_INT_BOOLEAN){
			return data==0 ? "false" : "true";
		}
		return data+"";
	}*/
	
	public String getDataStr() {
		if (dataType == TYPE_STRING) {
			return ParseResourceUtils.getResString(data);
		}
		if (dataType == TYPE_ATTRIBUTE) {
			return String.format("?%s%08X",getPackage(data),data);
		}
		if (dataType == TYPE_REFERENCE) {
			return String.format("@%s%08X",getPackage(data),data);
		}
		if (dataType == TYPE_FLOAT) {
			return String.valueOf(Float.intBitsToFloat(data));
		}
		if (dataType == TYPE_INT_HEX) {
			return String.format("0x%08X",data);
		}
		if (dataType == TYPE_INT_BOOLEAN) {
			return data!=0?"true":"false";
		}
		if (dataType == TYPE_DIMENSION) {
			return Float.toString(complexToFloat(data))+
				DIMENSION_UNITS[data & COMPLEX_UNIT_MASK];
		}
		if (dataType == TYPE_FRACTION) {
			return Float.toString(complexToFloat(data))+
				FRACTION_UNITS[data & COMPLEX_UNIT_MASK];
		}
		if (dataType >= TYPE_FIRST_COLOR_INT && dataType <= TYPE_LAST_COLOR_INT) {
			return String.format("#%08X",data);
		}
		if (dataType >= TYPE_FIRST_INT && dataType <= TYPE_LAST_INT) {
			return String.valueOf(data);
		}
		return String.format("<0x%X, type 0x%02X>",data, dataType);
	}
	
	private static String getPackage(int id) {
		if (id>>>24==1) {
			return "android:";
		}
		return "";
	}
	
	public static float complexToFloat(int complex) {
		return (float)(complex & 0xFFFFFF00)*RADIX_MULTS[(complex>>4) & 3];
	}
	
	private static final float RADIX_MULTS[]={
		0.00390625F,3.051758E-005F,1.192093E-007F,4.656613E-010F
	};
	
	private static final String DIMENSION_UNITS[]={
		"px","dip","sp","pt","in","mm","",""
	};
	
	private static final String FRACTION_UNITS[]={
		"%","%p","","","","","",""
	};
	
	@Override
	public String toString(){
		return "size:"+size+",res0:"+res0+",dataType:"+getTypeStr()+",data:"+getDataStr();
	}

}
