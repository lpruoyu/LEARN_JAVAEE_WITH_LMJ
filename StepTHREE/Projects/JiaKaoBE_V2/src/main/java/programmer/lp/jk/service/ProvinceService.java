package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.Province;
import programmer.lp.jk.pojo.query.ProvinceQuery;

public interface ProvinceService extends IService<Province> {
    void list(ProvinceQuery query);
}

