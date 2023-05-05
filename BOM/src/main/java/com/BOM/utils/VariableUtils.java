package com.BOM.utils;

import java.text.SimpleDateFormat;

public class VariableUtils {
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_OF_DATABASE = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_OF_DATABASE_AWS = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_OF_DATABASE2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_FOR_KG = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static final String DATE_FORMAT_FROM_ANGULAR = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
}
