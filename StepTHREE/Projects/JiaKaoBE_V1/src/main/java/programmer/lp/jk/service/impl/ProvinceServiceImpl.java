package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import programmer.lp.jk.mapper.ProvinceMapper;
import programmer.lp.jk.pojo.po.Province;
import programmer.lp.jk.pojo.query.KeywordQuery;
import programmer.lp.jk.service.ProvinceService;

@Transactional
@Service("provinceService")
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
    @Autowired
    private ProvinceMapper mapper;

    @Override
    public IPage<Province> list(KeywordQuery<Province> query) {
        LambdaQueryWrapper<Province> wrapper = null;
        final String keyword = query.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper = new LambdaQueryWrapper<>();
            wrapper.like(Province::getName, keyword).or()
                    .like(Province::getPlate, keyword);
        }
        Page<Province> p = new Page<>(query.getPage(), query.getSize());
        mapper.selectPage(p, wrapper);
        return p;
    }
}

