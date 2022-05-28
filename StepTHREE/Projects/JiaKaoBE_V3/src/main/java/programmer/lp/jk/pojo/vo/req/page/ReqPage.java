package programmer.lp.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqPage {
    private static final int MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 10;
    @ApiModelProperty("一页展示多少条数据")
    private long size;
    @ApiModelProperty("第几页")
    private long page;
    public long getSize() {
        return size < MIN_SIZE ? DEFAULT_SIZE : size;
    }
    public long getPage() {
        return page < MIN_SIZE ? MIN_SIZE : page;
    }
}
