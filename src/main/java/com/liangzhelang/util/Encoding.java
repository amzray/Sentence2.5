package com.liangzhelang.util;

import java.io.UnsupportedEncodingException;

public class Encoding {  
    public static String encodeUTF8(String str) {  
            try {
				str =  new String(str.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}finally {
				return str;
			}
    }  
} 