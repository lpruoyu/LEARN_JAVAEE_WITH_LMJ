package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import programmer.lp.jk.mapper.DictItemMapper;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.query.DictItemQuery;
import programmer.lp.jk.service.DictItemService;

@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Autowired
    private DictItemMapper mapper;

    @Override
    public void list(DictItemQuery query) {
        final String keyword = query.getKeyword();
        LambdaQueryWrapper<DictItem> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(DictItem::getName, keyword).or()
                    .like(DictItem::getValue, keyword);
        }
        Page<DictItem> page = new Page<>(query.getNo(), query.getSize());
        mapper.selectPage(page, wrapper);
        query.setData(page.getRecords());
        query.setPages(page.getPages());
        query.setTotal(page.getTotal());
    }
}
