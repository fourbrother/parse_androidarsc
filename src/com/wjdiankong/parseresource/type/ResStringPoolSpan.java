package com.wjdiankong.parseresource.type;

/**
 struct ResStringPool_span
 {
     enum {
         END = 0xFFFFFFFF
     };
     //指向样式字符串在字符串池中偏移,例如粗体样式<b>XXX</b>,则此处指向b
     ResStringPool_ref name;
     //指向应用样式的第一个字符
     uint32_t firstChar
     //指向应用样式的最后一个字符
     uin32_t  lastChar;
 };
 * @author i
 *
 */
public class ResStringPoolSpan {
	
	public final static int END = 0xFFFFFFFF;
	
	public ResStringPoolRef name;
	public int firstChar;
	public int lastChar;
	
	@Override
	public String toString(){
		return "name:"+name.toString()+",firstChar:"+firstChar+",lastChar:"+lastChar;
	}

}
