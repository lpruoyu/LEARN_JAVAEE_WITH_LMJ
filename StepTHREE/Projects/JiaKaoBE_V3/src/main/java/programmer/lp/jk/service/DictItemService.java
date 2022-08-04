package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictItem;
import programmer.lp.jk.pojo.vo.resp.RespDictItem;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

public interface DictItemService extends IService<DictItem> {
    JSONPageResult<RespDictItem> list(ReqPageDictItem reqPage);
}