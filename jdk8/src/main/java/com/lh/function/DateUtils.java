package com.lh.function;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lh on 2017/6/8.
 */
public class DateUtils {

    public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEFORMAT_T = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATEFORMATY_M_D = "yyyy-MM-dd";
    public static final String DATEFORMATYMD = "yyyyMMdd";
    public static final String DATEFORMATYMDHH = "yyyyMMdd HH:mm:ss";
    public static final String DATEFORMATYMDHHT = "yyyyMMdd'T'HH:mm:ss";

    /**
     * 时间戳
     *
     * @return
     */
    public static long secondTime() {
        return Instant.now().toEpochMilli();
    }


    /**
     * 日期格式转换
     *
     * @param date
     * @param formate yyyy-MM-dd'T'HH:mm:ss   "yyyy-MM-dd HH:mm:ss"  "yyyy-MM-dd"
     * @return
     */
    public static String fromatString(String date, String formate) {

        if (isNotNull(formate)) {
            if (DATEFORMATY_M_D.equals(formate) || DATEFORMATYMD.equals(formate)) {
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(formate));
                return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            LocalDateTime localDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(formate));
            return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return "";
    }


    public static boolean isNotNull(String str) {

        if (null != str && str.length() > 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = fromatString("20170909T09:12:22", DateUtils.DATEFORMATYMDHHT);
        System.out.println(s);
    }

}
