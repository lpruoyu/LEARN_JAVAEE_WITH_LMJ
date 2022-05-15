package programmer.lp.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.query.DictTypeQuery;

public interface DictTypeService extends IService<DictType> {

    IPage<DictType> list(DictTypeQuery query);

}

