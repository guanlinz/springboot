package com.hp.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/***
 * 将当前日期转换为17位时间戳字符串
 */
public class TimeFormatHelper {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");

    public static String getCurrentTimeStamp() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return sdf.format(ts);
    }
}
