package se.sakilagui.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertTools {
    public Date ConvertStrToSqlDate(String patten,String str){
        System.out.println(patten);
        System.out.println(str);
        java.util.Date year = null;
        DateFormat df = new SimpleDateFormat(patten);
        java.sql.Date sqlDate;

        try {
            year = (java.util.Date) df.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        sqlDate = new java.sql.Date(year.getTime());
        return sqlDate;
    }

    public String getlastUpdate(){
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       return df.format(timestamp);
    }
}
