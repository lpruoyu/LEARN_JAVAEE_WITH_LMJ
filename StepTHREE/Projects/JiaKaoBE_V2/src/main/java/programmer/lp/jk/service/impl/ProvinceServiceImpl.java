package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.ProvinceMapper;
import programmer.lp.jk.pojo.po.Province;
import programmer.lp.jk.pojo.query.ProvinceQuery;
import programmer.lp.jk.service.ProvinceService;

@Transactional
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
    @Override
    public void list(ProvinceQuery query) {
//        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
//        final String keyword = query.getKeyword();
//        if (!StringUtils.isEmpty(keyword)) {
//            wrapper.like(Province::getName, keyword).or()
//                    .like(Province::getPlate, keyword);
//        }
        MPQueryWrapper<Province> wrapper = new MPQueryWrapper<>();
        wrapper.like(query.getKeyword(), Province::getName, Province::getPlate);
        baseMapper.selectPage(new MPPage<>(query), wrapper);
    }
}

