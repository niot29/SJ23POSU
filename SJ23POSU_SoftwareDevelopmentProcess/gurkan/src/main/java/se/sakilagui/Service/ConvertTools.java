package se.sakilagui.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertTools {

    public Date ConvertStrToSqlDate(String patten,String str){
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
}
