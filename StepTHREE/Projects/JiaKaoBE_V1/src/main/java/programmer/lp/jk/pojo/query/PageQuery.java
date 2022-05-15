package programmer.lp.jk.pojo.query;

import lombok.Data;

import java.util.List;

@Data
public class PageQuery<T> {
    private static final int MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 10;
    private long size; // 一页展示多少条数据
    private long page; // 第几页
    private List<T> data; // 查询出来的数据集

    public long getSize() {
        return size < MIN_SIZE ? DEFAULT_SIZE : size;
    }

    public long getPage() {
        return page < MIN_SIZE ? MIN_SIZE : page;
    }
}
