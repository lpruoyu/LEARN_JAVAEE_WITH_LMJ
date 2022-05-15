package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;

    @Override
    public void list(DictTypeQuery query) {
        final String keyword = query.getKeyword();
        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
        // 按照关键字查询
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(DictType::getName, keyword).or()
                    .like(DictType::getIntro, keyword).or()
                    .like(DictType::getValue, keyword);
        }
        // 分页查询
        Page<DictType> page = new Page<>(query.getNo(), query.getSize());
        mapper.selectPage(page, wrapper);
        query.setData(page.getRecords());
        query.setPages(page.getPages());
        query.setTotal(page.getTotal());
    }
}
