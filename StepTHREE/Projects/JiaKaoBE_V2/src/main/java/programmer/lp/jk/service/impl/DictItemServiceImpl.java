package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.enhance.MPPage;
import programmer.lp.jk.enhance.MPQueryWrapper;
import programmer.lp.jk.mapper.DictItemMapper;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.query.DictItemQuery;
import programmer.lp.jk.service.DictItemService;

@Transactional
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Override
    @Transactional(readOnly = true)
    public void list(DictItemQuery query) {
        MPQueryWrapper<DictItem> wrapper = new MPQueryWrapper<>();
        wrapper.like(query.getKeyword(), DictItem::getName, DictItem::getValue);
        final Integer typeId = query.getTypeId();
        if (typeId != null && typeId > 0) {
            wrapper.eq(DictItem::getTypeId, typeId);
        }
        wrapper.orderByDesc(DictItem::getSn);
        baseMapper.selectPage(new MPPage<>(query), wrapper);
    }
}
