package coder.lp.two_javaeestart;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Date;

public class Search {
    static {
        // 配置BeanUtils：String -> Date
        // 前端表单 -> 格式化字符串 -> Date
        DateConverter dateConverter = new DateConverter(null);
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd"}); // , "yyyy-MM-dd HH:mm:ss"
        ConvertUtils.register(dateConverter, Date.class);
    }

//    public Date beginDay;
    private String beginDay;
    public String keyWord;
    public Integer pageIndex;
    public Integer pageSize;

    public String getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(String beginDay) {
        this.beginDay = beginDay;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Search{" +
                "beginDay='" + beginDay + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}