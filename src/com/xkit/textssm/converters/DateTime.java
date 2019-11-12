package com.xkit.textssm.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 请求参数类型转换器 日期转换器
 *
 * @author asus
 */
public class DateTime implements Converter<String, Date> {

    public Date convert(String param) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = df.parse(param);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }

}
