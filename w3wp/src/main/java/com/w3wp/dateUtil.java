package com.w3wp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dateUtil {

 
public static Date parseDate(String date) {
    try {
        final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
        return new Date(DATE_FORMAT.parse(date).getTime());
    } catch (ParseException e) {
        throw new IllegalArgumentException(e);
    }
}
}
