package api.util;

public class ApiUtil {
	
	public static int   getByteLen(String str) {
		int    lenb    = str.getBytes().length;
		
		return lenb;
	}

	public static String cutString(String str, int start, int len) { 

		byte[] by = str.getBytes();
		int count = 0;
		try  {
			for(int i = 0; i < len; i++) {

				if((by[i] & 0x80) == 0x80) count++; // 핵심 코드

			}

			if((by[len - 1] & 0x80) == 0x80 && (count % 2) == 1) len--; // 핵심코드

			return new String(by, start, len);   

		}
		catch(java.lang.ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
			return "";
		}

	} 
	
	public static String substringByBytes(String str, int beginBytes, int endBytes) {
	    if (str == null || str.length() == 0) {
	        return "";
	    }
	 

	     if (beginBytes < 0) {
	        beginBytes = 0;
	    }

	    if (endBytes < 1) {
	        return "";
	    }

	    int len = str.length();

	    int beginIndex = -1;
	    int endIndex = 0;

	    int curBytes = 0;
	    String ch = null;
	    for (int i = 0; i < len; i++) {
	        ch = str.substring(i, i + 1);
	        curBytes += ch.getBytes().length;
	 

	        if (beginIndex == -1 && curBytes >= beginBytes) {
	            beginIndex = i;
	        }

	        if (curBytes > endBytes) {
	            break;
	        } else {
	            endIndex = i + 1;
	        }
	    }
	 

	    return str.substring(beginIndex, endIndex);
	}

}
