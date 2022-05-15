package programmer.lp.jk.pojo.query;

import lombok.Data;

import java.util.List;

@Data
public class PageQuery {
    private static final int MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 10;
    private long size; // 一页展示多少条数据
    private long page; // 第几页
    /**
     * 查询出来的数据集
     * 由于将来查出来的类型不确定（VO、BO、PO），因此泛型使用类型通配符
     */
    private List<?> data;
    private long total; // 总条数
    private long pages; // 总页数

    public long getSize() {
        return size < MIN_SIZE ? DEFAULT_SIZE : size;
    }

    public long getPage() {
        return page < MIN_SIZE ? MIN_SIZE : page;
    }
}
