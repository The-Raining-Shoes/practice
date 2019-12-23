package com.example.item.tools.checkPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * 参数检查工具类
 * 
 * @author MaoHao
 * @date 2019年8月1日
 * 
 */

public class CheckUtil {

	/**
	 * 判断是否为空
	 * 
	 * @param String,Object
	 * @return boolean
	 */
	public static boolean isBlank(String str) {
		int strSize;
		if (str == "" || (strSize = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strSize; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return false;

		return true;
	}

	public static boolean isBlank(Object str) {
		int strLen;
		if (str == null || (strLen = str.toString().length()) == 0)
			return true;
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.toString().charAt(i)))
				return false;

		return true;
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	public static boolean isNotBlank(Object obj) {
		return !isBlank(obj);
	}

	/**
	 * 判断是否为手机号
	 * 
	 * @param value
	 * @return boolean
	 */
	public static boolean isPhone(Object value) {
		if (value == null)
			return false;
		return PHONE_PATTERN.matcher(value.toString()).matches();
	}

	private static final Pattern PHONE_PATTERN = Pattern.compile("^[1][3-9][0-9]{9}$"); // 验证手机号
	
	/**
	 * 去除字符串空格
	 * 
	 * @param str
	 * @return boolean
	 */
	public static String realStringValue(String str) {
		if (isBlank(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 根据指定符号进行分割(传入参数,分割符)
	 * 
	 * @param str,separator
	 * @return ArrayList<String>
	 */
	public static List<String> StringSplitToArrayList(String str, String separator) {
		//不传分割符号
		if(null == separator) {
			char[] arr = str.toCharArray();
			List<String> stringList= new ArrayList<>();
			for(int i = 0;i < arr.length;i++) {
				stringList.add(String.valueOf(arr[i]));
			}
			return stringList;
		}
		//空格分割
		if(""==separator) {
	        /*把字符串转化为数组形式，并用正则表达式进行分割*/
	        String [] c = str.split("\\s+");
	        ArrayList<String> arr = new ArrayList<String>();
	        for (String ss : c){
	        	arr.add(ss);
	        }
	        return arr;
		}
		ArrayList<String> arr = new ArrayList<String>();
		if ((str == null)) {
			return arr;
		}
		StringTokenizer st = new StringTokenizer(str, separator);
		while (st.hasMoreTokens()) {
			arr.add(st.nextToken());
		}
		return arr;
	}

	/**
	 * 检测传入参数是否相等(排除空指针情况)
	 * 
	 * @param str1,str2
	 * @return boolean
	 */
	public static boolean checkEquals(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		} else if (str1 != null && str2 != null) {
			if (str1.equals(str2)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 将传入字符串进行顺序排序
	 * 
	 * @param str1,str2
	 * @return boolean
	 */
	public static String StringAscSort(String str) {
		char[] arr = str.toCharArray();
		for(int i=0;i<arr.length-1;i++)
        {
            for (int x=0;x<arr.length-1-i;x++)
            {
                if(arr[x]>arr[x+1])
                {
                    char a=arr[x+1];
                    arr[x+1]=arr[x];
                    arr[x]=a;
                }
            }
        }
		return String.valueOf(arr);
	}
	
	/**
	 * 将传入字符串进行倒序排序
	 * 
	 * @param str1,str2
	 * @return boolean
	 */
	public static String StringDescSort(String str) {
		char[] arr = str.toCharArray();
		for(int i=0;i<arr.length-1;i++)
        {
            for (int x=0;x<arr.length-1-i;x++)
            {
                if(arr[x]<arr[x+1])
                {
                    char a=arr[x+1];
                    arr[x+1]=arr[x];
                    arr[x]=a;
                }
            }
        }
		return String.valueOf(arr);
	}

}
