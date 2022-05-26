package programmer.lp.jk.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageQuery {
    private static final int MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 10;
    @ApiModelProperty("一页展示多少条数据")
    private long size; // 一页展示多少条数据
    @ApiModelProperty("第几页")
    private long page; // 第几页
    /**
     * 查询出来的数据集
     * 由于将来查出来的类型不确定（VO、BO、PO），因此泛型使用类型通配符
     */
    @ApiModelProperty(hidden = true)
    private List<?> data;
    @ApiModelProperty("总条数")
    private long total; // 总条数
    @ApiModelProperty("总页数")
    private long pages; // 总页数

    public long getSize() {
        return size < MIN_SIZE ? DEFAULT_SIZE : size;
    }

    public long getPage() {
        return page < MIN_SIZE ? MIN_SIZE : page;
    }
}
