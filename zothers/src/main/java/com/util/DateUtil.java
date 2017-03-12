package com.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MiaoMU on 2017/2/25.
 */

/*
交易日管理
        背景描述：
        在金融业务中，经常涉及到交易日期的计算，交易日和自然日是有区别的，比如法定节假日，周末，都是不能交易的，我们叫非交易日，允许交易的日我们称之为交易日。
        交易日每天也不是24小时，比如中国股市的股票交易时间在每个交易日的[AM9:30-11:30) 和 [PM13:00-15:00)
        为了满足7*24小时服务，我们对用户提供的服务在非交易日或是非交易时段也是有支持的，所以将非交易时段产生的业务，它的交易日会算到下一个最近交易时段的交易日中，
        为了表述方便，我们用T+0表示当前交易日，T+1表示下一个交易日。D+0表示当天自然日，D+1表示下一个自然日，以此类推可能会有：D+n，D-n T+n，T-n等这样的日期表述方式。
        举例说明：20160701 20160704 20160705 是交易日，交易日的交易时间是[AM9:30-11:30) 和 [PM13:00-15:00),20160702和20160703是非交易日，
        则 20160701上午8点的交易日是20160701 ，20160701下午5点的交易日则是 20160704 ，用T+0标示某个时间的当前交易日，如20160701下午5点的T+0为20160704，T+1为20160705。

        编程要求：
        写一个交易日期的计算工具类：
        1、根据交易日历初始化交易日工具
        2、给定任意时间，返回给定时间的T+n交易日。
*/

public class DateUtil {
    Map<Date, String> dateStringMap = new HashMap<Date, String>();


    //: TODO 可自行定义需要的变量

    /**
     * 工具初始化，初始化的目的是让工具具备更加合适各的数据结构，方便计算提高效率

     * @param tradeDayList 包含一年内所有的交易日起，格式如：20160701 20160704 20160705，非交易日20160702 20160703不在其中.
     */
    public void init (List<String> tradeDayList){
    }

    /**
     *
     * 给定任意时间，返回给定时间的T+n交易日
     *
     * @param time 给定要计算的时间。
     * @param offsetDays 交易日偏移量，offsetDays可以为负数，表示T-n的计算。
     */
    public String getTradeDay(Date time, int offsetDays){
        //: TODO 完成此处的代码


        return null;
    }

    private String dateToStr(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }




}
