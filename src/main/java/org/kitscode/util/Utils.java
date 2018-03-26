package org.kitscode.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	//返回第一个匹配记录
    public static String regex(String regex,String str){
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if (matcher.find()){
            return matcher.group(1);
        }
        return "";
    }
    
    //返回所有匹配的记录
    public static String regexAll(String regex,String str){
        Matcher matcher = Pattern.compile(regex).matcher(str);
        String match_all="";
        while(matcher.find()){
            match_all+=matcher.group();
        }
        return match_all;
    }
    
    //获得00.00形式数据
    public static String regexFloat(String str){
    	String regex="\\d+\\.\\d+";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if (matcher.find()){
            return matcher.group();
        }
        return "";
    }
    
    public static Long getDateTaskId(){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        String dateFormat=dateFormater.format(date);
        return new Long(dateFormat.trim());
    }

}
