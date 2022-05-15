package programmer.lp.jk.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import programmer.lp.jk.pojo.query.PageQuery;

public class MPPage<T> extends Page<T> {
    private final PageQuery query;

    public MPPage(PageQuery query) {
        super(query.getPage(), query.getSize());
        this.query = query;
    }

    public void updateQuery() {
        query.setData(getRecords());
        query.setPages(getPages());
        query.setTotal(getTotal());
        // 如果客户端的查询条件有问题，MyBatis会自动识别并修正，因此可以修改一下query中的查询数据
        query.setSize(getSize());
        query.setPage(getCurrent());
    }
}
