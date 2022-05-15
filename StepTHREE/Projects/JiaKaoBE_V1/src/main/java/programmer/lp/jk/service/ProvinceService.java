package programmer.lp.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.po.Province;
import programmer.lp.jk.pojo.query.KeywordQuery;

public interface ProvinceService extends IService<Province> {
    IPage<Province> list(KeywordQuery<Province> query);
}

