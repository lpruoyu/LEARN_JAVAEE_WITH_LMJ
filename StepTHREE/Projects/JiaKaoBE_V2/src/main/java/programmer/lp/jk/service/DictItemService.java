package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.query.DictItemQuery;

public interface DictItemService extends IService<DictItem> {
    void list(DictItemQuery query);
}

