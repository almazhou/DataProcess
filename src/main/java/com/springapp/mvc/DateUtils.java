package com.springapp.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date createDateWithFormat(String dateStr, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
           date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            new RuntimeException("Time is not valid");
        }

        return date;
    }
}
