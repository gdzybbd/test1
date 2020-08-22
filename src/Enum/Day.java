package Enum;

public enum Day {
    /**
     * 周一~周日
     */
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    //需要用 ； 结束 在枚举实例之前不能有任何方法！


    //中文描述
    private String str;

    private Day(String str) {
        this.str = str;
    }

    //可以复写toString来实现
    public String getStr(){
        return str;
    }




}
