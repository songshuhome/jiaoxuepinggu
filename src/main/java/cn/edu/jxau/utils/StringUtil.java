package cn.edu.jxau.utils;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串工具类,参考commons-lang
 * StringUtil
 *
 * @author zclong 2017年8月4日
 */
public class StringUtil {
    public static final String EMPTY = "";

    public static String getdateConfoundAndUUDI() {
        return dateConfound() + "/" + getUUID();
    }

    /**
     * base64字符串转化成图片
     * * @Author Mangodai
     * @Date 9/18/2017 6:10 PM
     * @param imgStr
     * @param imgFile
     * @return
     */
    public static boolean GenerateImage(String imgStr, File imgFile) {
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
/*            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }*/
            OutputStream out = new FileOutputStream(imgFile);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 得到一个uuid
     ** @Author Mangodai
     * @Date 9/18/2017 6:10 PM
     * @return
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.replace("-", "");
    }

    /**
     * 从文件路径中，重新重构这个文件名称
     ** @Author Mangodai
     * @Date 9/18/2017 6:10 PM
     * @param filePath 文件的路径，包括了文件名
     * @return 新的文件名称
     */
    public static String reConfoundFileName(String filePath) {
        File file = new File(filePath);
        return file.getParent() + UUID.randomUUID();
    }

    /**
     * 返回一个日期加密
     ** @Author Mangodai
     * @Date 9/18/2017 7:58 PM
     * @return /2017/8/23
     */
    public static String dateConfound() {
        Calendar calendar = Calendar.getInstance();
        return "/" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
                + calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @param css
     * @return
     */
    public static boolean arrayIsEmpty(CharSequence[] css) {
        return css == null || css.length == 0;
    }

    /**
     * <p>Checks if a CharSequence is empty ("") or null.</p>
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * <p>Checks if any one of the CharSequences are empty ("") or null.</p>
     * <pre>
     * StringUtils.isAnyEmpty(null)             = true
     * StringUtils.isAnyEmpty(null, "foo")      = true
     * StringUtils.isAnyEmpty("", "bar")        = true
     * StringUtils.isAnyEmpty("bob", "")        = true
     * StringUtils.isAnyEmpty("  bob  ", null)  = true
     * StringUtils.isAnyEmpty(" ", "bar")       = false
     * StringUtils.isAnyEmpty("foo", "bar")     = false
     * </pre>
     */
    public static boolean isAnyEmpty(final CharSequence... css) {
        if (arrayIsEmpty(css)) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>Checks if a CharSequence is whitespace, empty ("") or null.</p>
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Checks if any one of the CharSequences are blank ("") or null and not whitespace only..</p>
     * <pre>
     * StringUtils.isAnyBlank(null)             = true
     * StringUtils.isAnyBlank(null, "foo")      = true
     * StringUtils.isAnyBlank(null, null)       = true
     * StringUtils.isAnyBlank("", "bar")        = true
     * StringUtils.isAnyBlank("bob", "")        = true
     * StringUtils.isAnyBlank("  bob  ", null)  = true
     * StringUtils.isAnyBlank(" ", "bar")       = true
     * StringUtils.isAnyBlank("foo", "bar")     = false
     * </pre>
     */
    public static boolean isAnyBlank(final CharSequence... css) {
        if (arrayIsEmpty(css)) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isBlank(cs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <pre>
     * StringUtils.trim(null)          = null
     * StringUtils.trim("")            = ""
     * StringUtils.trim("     ")       = ""
     * StringUtils.trim("abc")         = "abc"
     * StringUtils.trim("    abc    ") = "abc"
     * </pre>
     */
    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }

    /**
     * <pre>
     * StringUtils.trimToNull(null)          = null
     * StringUtils.trimToNull("")            = null
     * StringUtils.trimToNull("     ")       = null
     * StringUtils.trimToNull("abc")         = "abc"
     * StringUtils.trimToNull("    abc    ") = "abc"
     * </pre>
     */
    public static String trimToNull(final String str) {
        final String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    /**
     * <pre>
     * StringUtils.trimToEmpty(null)          = ""
     * StringUtils.trimToEmpty("")            = ""
     * StringUtils.trimToEmpty("     ")       = ""
     * StringUtils.trimToEmpty("abc")         = "abc"
     * StringUtils.trimToEmpty("    abc    ") = "abc"
     * </pre>
     */
    public static String trimToEmpty(final String str) {
        return str == null ? EMPTY : str.trim();
    }

    /**
     * @param str
     * @param prefix
     * @return
     */
    public static boolean startsWith(final String str, final String prefix) {
        if (str == null || prefix == null) {
            return str == null && prefix == null;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.startsWith(prefix);
    }

    /**
     * @param string
     * @param searchStrings
     * @return
     */
    public static boolean startsWithAny(final String string, final String... searchStrings) {
        if (isEmpty(string) || arrayIsEmpty(searchStrings)) {
            return false;
        }
        for (final String searchString : searchStrings) {
            if (startsWith(string, searchString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param str
     * @param suffix
     * @return
     */
    public static boolean endsWith(final String str, final String suffix) {
        if (str == null || suffix == null) {
            return str == null && suffix == null;
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        return str.endsWith(suffix);
    }

    /**
     * @param string
     * @param searchStrings
     * @return
     */
    public static boolean endsWithAny(final String string, final String... searchStrings) {
        if (isEmpty(string) || arrayIsEmpty(searchStrings)) {
            return false;
        }
        for (final String searchString : searchStrings) {
            if (endsWith(string, searchString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回是否匹配指定的字符串，如果匹配则为true,否则为false;
     *
     * @param string
     * @param regex
     * @return
     * @zclong
     * @2017年8月4日
     * @ReturnType: boolean
     */
    public static boolean matches(final String string, String regex) {
        if (isEmpty(string)) {
            return false;
        }
        return Pattern.matches(regex, string);
    }
}
