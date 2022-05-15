package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import programmer.lp.jk.mapper.DictTypeMapper;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.query.DictTypeQuery;
import programmer.lp.jk.service.DictTypeService;

@Transactional
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;

    @Override
    public IPage<DictType> list(DictTypeQuery query) {
        LambdaQueryWrapper<DictType> wrapper = null;
        final String keyword = query.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper = new LambdaQueryWrapper<>();
            wrapper.like(DictType::getName, keyword).or()
                    .like(DictType::getValue, keyword).or()
                    .like(DictType::getIntro, keyword);
        }
        Page<DictType> p = new Page<>(query.getPage(), query.getSize());
        mapper.selectPage(p, wrapper);
        return p;
    }
}

