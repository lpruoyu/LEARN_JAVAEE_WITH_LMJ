package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.DictTypeMapper;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.query.DictTypeQuery;
import programmer.lp.jk.service.DictTypeService;

@Transactional
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Override
    @Transactional(readOnly = true)
    public void list(DictTypeQuery query) {
        MPQueryWrapper<DictType> wrapper = new MPQueryWrapper<>();
        wrapper.like(query.getKeyword(), DictType::getName, DictType::getValue, DictType::getIntro);
        wrapper.orderByDesc(DictType::getId);
        baseMapper.selectPage(new MPPage<>(query), wrapper);
    }
}
