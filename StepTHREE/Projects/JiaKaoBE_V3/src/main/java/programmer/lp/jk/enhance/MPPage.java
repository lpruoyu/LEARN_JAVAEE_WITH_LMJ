package programmer.lp.jk.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import programmer.lp.jk.pojo.vo.req.page.ReqPage;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

import java.util.function.Function;
import java.util.stream.Collectors;

public class MPPage<T, R> extends Page<T> {
    private final ReqPage reqPage;

    public MPPage(ReqPage reqPage) {
        super(reqPage.getPage(), reqPage.getSize());
        this.reqPage = reqPage;
    }

    public JSONPageResult<R> buildResult(Function<T, R> function) {
        final JSONPageResult<R> jsonPageResult = new JSONPageResult<>();
        jsonPageResult.setData(getRecords().stream().map(function).collect(Collectors.toList()));
        jsonPageResult.setPages(getPages());
        jsonPageResult.setCount(getTotal());
        reqPage.setSize(getSize());
        reqPage.setPage(getCurrent());
        return jsonPageResult;
    }
}
