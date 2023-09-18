package com.ioiox.dei.core.utils;

import com.ioiox.dei.core.exception.DeiServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 身份证处理工具类
 */
public class IdNoUtil {
    public static final Map<String, String> AREA_CODE_MAP = new HashMap<>();
    static {
        AREA_CODE_MAP.put("11", "北京");
        AREA_CODE_MAP.put("12", "天津");
        AREA_CODE_MAP.put("13", "河北");
        AREA_CODE_MAP.put("14", "山西");
        AREA_CODE_MAP.put("15", "内蒙古");
        AREA_CODE_MAP.put("21", "辽宁");
        AREA_CODE_MAP.put("22", "吉林");
        AREA_CODE_MAP.put("23", "黑龙江");
        AREA_CODE_MAP.put("31", "上海");
        AREA_CODE_MAP.put("32", "江苏");
        AREA_CODE_MAP.put("33", "浙江");
        AREA_CODE_MAP.put("34", "安徽");
        AREA_CODE_MAP.put("35", "福建");
        AREA_CODE_MAP.put("36", "江西");
        AREA_CODE_MAP.put("37", "山东");
        AREA_CODE_MAP.put("41", "河南");
        AREA_CODE_MAP.put("42", "湖北");
        AREA_CODE_MAP.put("43", "湖南");
        AREA_CODE_MAP.put("44", "广东");
        AREA_CODE_MAP.put("45", "广西");
        AREA_CODE_MAP.put("46", "海南");
        AREA_CODE_MAP.put("50", "重庆");
        AREA_CODE_MAP.put("51", "四川");
        AREA_CODE_MAP.put("52", "贵州");
        AREA_CODE_MAP.put("53", "云南");
        AREA_CODE_MAP.put("54", "西藏");
        AREA_CODE_MAP.put("61", "陕西");
        AREA_CODE_MAP.put("62", "甘肃");
        AREA_CODE_MAP.put("63", "青海");
        AREA_CODE_MAP.put("64", "宁夏");
        AREA_CODE_MAP.put("65", "新疆");
        AREA_CODE_MAP.put("71", "台湾");
        AREA_CODE_MAP.put("81", "香港");
        AREA_CODE_MAP.put("82", "澳门");
        AREA_CODE_MAP.put("91", "国外");
    }

    public static final int [] WEIGHT_FACTORS = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

    public static final String [] CHK_CODES = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };

    public static final Pattern ID_NO_PATTERN = Pattern.compile("^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");

    private static String calcChkCode(final String idNo) {
        int sum = 0;
        for (int i = 0 ; i < 17 ; i++) {
            final String digit = StringUtils.substring(idNo, i, i + 1);
            sum += Integer.parseInt(digit) * WEIGHT_FACTORS[i];
            System.out.printf("digit : %s%n", digit);
        }
        return CHK_CODES[sum % 11];
    }

    private static String getAreaCode(final String idNo) {
        return StringUtils.substring(idNo, 0, 2);
    }

    private static String getChkCode(final String idNo) {
        return StringUtils.substring(idNo, 17);
    }

    public static String getDateOfBirth(final String idNo) {
        return StringUtils.substring(idNo, 6, 14);
    }

    private static void checkDateOfBirth(final String idNo) {
        final String dateOfBirth = getDateOfBirth(idNo);
        final Date result = DateUtil.parse(dateOfBirth, DateUtil.PATTERN_YYYY_MM_DD_SLIM);
        if (Objects.isNull(result)) {
            throw new DeiServiceException("出生日期有误");
        }
        final String formattedResult = DateUtil.format(result, DateUtil.PATTERN_YYYY_MM_DD_SLIM);
        if (!StringUtils.equals(dateOfBirth, formattedResult)) {
            throw new DeiServiceException("出生日期有误");
        }
    }

    public static Date retrieveDateOfBirth(final String idNo) {
        final String dateOfBirth = getDateOfBirth(idNo);
        return DateUtil.parse(dateOfBirth, DateUtil.PATTERN_YYYY_MM_DD_SLIM);
    }

    public static boolean validIdNo(final String idNo) {
        try {
            checkIdNo(idNo);
        } catch (DeiServiceException e) {
            return false;
        }
        return true;
    }

    public static void checkIdNo(final String idNo) {
        if (StringUtils.isBlank(idNo)
                || 18 != idNo.length()) {
            throw new DeiServiceException("身份证格式有误");
        }

        if (ID_NO_PATTERN.matcher(idNo).matches()) {
            final String areaCode = getAreaCode(idNo);
            if (!AREA_CODE_MAP.containsKey(areaCode)) {
                throw new DeiServiceException("无效的地址码");
            }
            final String chkCode = calcChkCode(idNo);
            if (!StringUtils.equals(chkCode, getChkCode(idNo))) {
                throw new DeiServiceException("校验码错误");
            }
            checkDateOfBirth(idNo);
        } else {
            throw new DeiServiceException("身份证格式有误");
        }
    }
}
