package TestDate;

/**
 * Time      2017/11/12 下午8:25
 * Author    JoanneGeng
 * File      WeekEnum.java
 * Software  IntelliJ IDEA
 */
public interface WeekEnum {

    enum Week{

        MON("Mon", "周一"),
        SUN("Sun","周日")



        ;

        private String code;

        private String message;

        Week(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }
    }
}
