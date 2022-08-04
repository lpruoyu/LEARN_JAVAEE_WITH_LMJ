package programmer.lp.jk.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import programmer.lp.jk.pojo.vo.req.page.ReqPage;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MPPage<T> extends Page<T> {
    private final ReqPage reqPage;

    public MPPage(ReqPage reqPage) {
        super(reqPage.getPage(), reqPage.getSize());
        this.reqPage = reqPage;
    }

    public <R> JSONPageResult<R> buildResult(Function<T, R> function) {
        return buildResult(getRecords().stream().map(function).collect(Collectors.toList()));
    }

    public JSONPageResult<T> buildResult() {
        return buildResult(getRecords());
    }

    private <E> JSONPageResult<E> buildResult(List<E> data) {
        final JSONPageResult<E> jsonPageResult = new JSONPageResult<>();
        jsonPageResult.setData(data);
        jsonPageResult.setPages(getPages());
        jsonPageResult.setCount(getTotal());
        reqPage.setSize(getSize());
        reqPage.setPage(getCurrent());
        return jsonPageResult;
    }
}
