package com.wjdiankong.parseresource;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class ParseResourceMain {
	
	public static void main(String[] args){
		
		byte[] srcByte = null;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try{
			fis = new FileInputStream("resource/resources_gdt1.arsc");
			bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=fis.read(buffer)) != -1){
				bos.write(buffer, 0, len);
			}
			srcByte = bos.toByteArray();
		}catch(Exception e){
			System.out.println("read res file error:"+e.toString());
		}finally{
			try{
				fis.close();
				bos.close();
			}catch(Exception e){
				System.out.println("close file error:"+e.toString());
			}
		}
		
		if(srcByte == null){
			System.out.println("get src error...");
			return;
		}
		
		System.out.println("parse restable header...");
		ParseResourceUtils.parseResTableHeaderChunk(srcByte);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		System.out.println("parse resstring pool chunk...");
		ParseResourceUtils.parseResStringPoolChunk(srcByte);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		System.out.println("parse package chunk...");
		ParseResourceUtils.parsePackage(srcByte);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		System.out.println("parse typestring pool chunk...");
		ParseResourceUtils.parseTypeStringPoolChunk(srcByte);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		System.out.println("parse keystring pool chunk...");
		ParseResourceUtils.parseKeyStringPoolChunk(srcByte);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		int resCount = 0;
		while(!ParseResourceUtils.isEnd(srcByte.length)){
			resCount++;
			boolean isSpec = ParseResourceUtils.isTypeSpec(srcByte);
			if(isSpec){
				System.out.println("parse restype spec chunk...");
				ParseResourceUtils.parseResTypeSpec(srcByte);
				System.out.println("++++++++++++++++++++++++++++++++++++++");
				System.out.println();
			}else{
				System.out.println("parse restype info chunk...");
				ParseResourceUtils.parseResTypeInfo(srcByte);
				System.out.println("++++++++++++++++++++++++++++++++++++++");
				System.out.println();
			}
		}
		System.out.println("res count:"+resCount);
		
	}

}
