package chapter1.part2.low;

/**
 * 1.2.11
 * 1.2.12
 * @author mulw
 *
 */
public class SmartDate {
    private final int year;
    private final int month;
    private final int day;
    
    private final static int weekInterval = 7;
    public SmartDate(int year,int month,int day) throws Exception {
        if (year < 0 || month < 0 || day < 0) {
            Exception exception = new Exception("年月日要大于0");
            throw exception;
        }
        if (month > 12) {
            Exception exception = new Exception("年份要小于等于12");
            throw exception;
        }
        switch (month) {
        //月大
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if(day > 31) {
                Exception exception = new Exception(month+"月应不大于31号");
                throw exception;
            }
            break;
            //2月特殊处理
        case 2:
            if (day > 29) {
                Exception exception = new Exception(month+"月应不大于29号");
                throw exception;
            }
            int leapYear = year % 4;
            if (leapYear != 0) {
                if (day > 28) {
                    Exception exception = new Exception(month + "月小于29号");
                    throw exception;
                }
            }
            break;
            //月小
        case 4:
        case 6:
        case 9:
        case 11:
            if(day > 30) {
                Exception exception = new Exception(month+"月应不大于30号");
                throw exception;
            }
        default:
            break;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    //1919.1.1 --> 星期三
    public String dayOfTheWeek() {
        int tempYear = this.year;
        int tempMonth = this.month;
        int tempDay = this.day;
        //int count = 0;
        int daysInterval = getIntervalDays(tempYear,tempMonth,tempDay);
        //调试用
        //System.out.println(count);
        System.out.println(daysInterval);
        
        int interval = daysInterval % weekInterval;
        String reWeek = getWeek(interval);
        return reWeek;
    }
    
    /**
     * 得到星期数，以1919.1.1 -->星期三为基准
     * @param interval 间隔天数
     * @return 星期数
     */
    public String getWeek(int interval) {
        String reWeek = "";
        switch (interval) {
        case 1:
            reWeek = "星期四";
            break;
        case 2:
            reWeek = "星期五";
            break;
        case 3:
            reWeek = "星期六";
            break;
        case 4:
            reWeek = "星期日";
            break;
        case 5:
            reWeek = "星期一";
            break;
        case 6:
            reWeek = "星期二";
            break;
        default:
            reWeek = "星期三";
            break;
        }
        return reWeek;
    }
    
    /**
     * 获得间隔天数 以1919.1.1为基准
     * @param tempYear
     * @param tempMonth
     * @param tempDay
     * @return 间隔天数
     */
    public int getIntervalDays(int tempYear,int tempMonth,int tempDay) {
        int daysInterval = 0;
        
        if (tempYear-1919 > 0) {
            for (int i = 1; (1919+i) < tempYear; i++) {
                int leapYear = (1919+i) % 4;
                if (leapYear == 0) {
                    //count++;
                    daysInterval +=366;
                }else {
                    daysInterval +=365;
                }
            }
        }
        for (int i = 1; i < tempMonth; i++) {
            switch (i) {
            //月大
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInterval += 31;
                break;
                //2月特殊处理
            case 2:
                int leapYear = tempYear % 4;
                if (leapYear == 0) {
                    daysInterval += 29;
                }else {
                    daysInterval += 28;
                }
                break;
                //月小
            case 4:
            case 6:
            case 9:
            case 11:
                daysInterval += 30;
                break;
            default:
                break;
            }
        }
        daysInterval += tempDay;
        return daysInterval;
    }
    
    @Override
    public String toString() {
        return "SmartDate [year=" + year + ", month=" + month + ", day=" + day + "]";
    }

    public static void main(String[] args) throws Exception {
        SmartDate smartDate = new SmartDate(2019, 8, 20);
        String weekString = smartDate.dayOfTheWeek();
        System.out.println( smartDate+" is "+weekString);
    }
}
