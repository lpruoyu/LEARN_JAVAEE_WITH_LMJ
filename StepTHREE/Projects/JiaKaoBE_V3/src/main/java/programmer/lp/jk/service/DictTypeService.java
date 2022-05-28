package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictType;
import programmer.lp.jk.pojo.vo.resp.RespDictType;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

public interface DictTypeService extends IService<DictType> {
    JSONPageResult<RespDictType> list(ReqPageDictType reqPage);
}

