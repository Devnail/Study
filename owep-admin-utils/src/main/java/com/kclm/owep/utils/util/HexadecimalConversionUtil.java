package com.kclm.owep.utils.util;

/**
 * @ClassName HexadecimalConversionUtil
 * @Description: 进制转换工具类
 * @author: huangfei
 * @since: 2016年12月15日 上午11:37:39
 */
public class HexadecimalConversionUtil {

	/**
	 * @Description： 10进制转16进制
	 * @author: QIJJ
	 * @since: 2016年12月15日 上午11:38:41
	 */
	public static String intToHex(int n) {
		char[] ch = new char[20];
		int nIndex = 0;
		while (true) {
			int m = n / 16;
			int k = n % 16;
			if (k == 15)
				ch[nIndex] = 'F';
			else if (k == 14)
				ch[nIndex] = 'E';
			else if (k == 13)
				ch[nIndex] = 'D';
			else if (k == 12)
				ch[nIndex] = 'C';
			else if (k == 11)
				ch[nIndex] = 'B';
			else if (k == 10)
				ch[nIndex] = 'A';
			else
				ch[nIndex] = (char) ('0' + k);
			nIndex++;
			if (m == 0)
				break;
			n = m;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(ch, 0, nIndex);
		sb.reverse();
		String strHex = new String("0x");
		strHex += sb.toString();
		return strHex;
	}

	/**
	 * @Description： 16进制转10进制
	 * @author: QIJJ
	 * @since: 2016年12月15日 上午11:38:53
	 */
	public static int hexToInt(String strHex) {
		int nResult = 0;
		if (!isHex(strHex))
			return nResult;
		String str = strHex.toUpperCase();
		if (str.length() > 2) {
			if (str.charAt(0) == '0' && str.charAt(1) == 'X') {
				str = str.substring(2);
			}
		}
		int nLen = str.length();
		for (int i = 0; i < nLen; ++i) {
			char ch = str.charAt(nLen - i - 1);
			try {
				nResult += (getHex(ch) * getPower(16, i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nResult;
	}

	/**
	 * @Description： 计算16进制对应的数值
	 * @author: QIJJ
	 * @since: 2016年12月15日 上午11:39:02
	 */
	public static int getHex(char ch) throws Exception {
		if (ch >= '0' && ch <= '9')
			return (int) (ch - '0');
		if (ch >= 'a' && ch <= 'f')
			return (int) (ch - 'a' + 10);
		if (ch >= 'A' && ch <= 'F')
			return (int) (ch - 'A' + 10);
		throw new Exception("error param");
	}

	/**
	 * @Description： 计算幂
	 * @author: QIJJ
	 * @since: 2016年12月15日 上午11:39:09
	 */
	public static int getPower(int nValue, int nCount) throws Exception {
		if (nCount < 0)
			throw new Exception("nCount can't small than 1!");
		if (nCount == 0)
			return 1;
		int nSum = 1;
		for (int i = 0; i < nCount; ++i) {
			nSum = nSum * nValue;
		}
		return nSum;
	}

	/**
	 * @Description： 判断是否是16进制数
	 * @author: QIJJ
	 * @since: 2016年12月15日 上午11:39:15
	 */
	public static boolean isHex(String strHex) {
		int i = 0;
		if (strHex.length() > 2) {
			if (strHex.charAt(0) == '0' && (strHex.charAt(1) == 'X' || strHex.charAt(1) == 'x')) {
				i = 2;
			}
		}
		for (; i < strHex.length(); ++i) {
			char ch = strHex.charAt(i);
			if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f'))
				continue;
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(intToHex(8));
		System.out.println(hexToInt("0x8"));

	}

}
