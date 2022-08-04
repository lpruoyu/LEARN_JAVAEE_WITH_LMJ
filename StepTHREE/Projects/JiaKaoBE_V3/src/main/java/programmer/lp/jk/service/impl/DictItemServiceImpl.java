package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.mapper.DictItemMapper;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictItem;
import programmer.lp.jk.pojo.vo.resp.RespDictItem;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.DictItemService;

@Transactional
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespDictItem> list(ReqPageDictItem reqPage) {
        MPLambdaQueryWrapper<DictItem> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), DictItem::getName, DictItem::getValue);
        final Integer typeId = reqPage.getTypeId();
        if (typeId != null && typeId > 0) {
            wrapper.eq(DictItem::getTypeId, typeId);
        }
        wrapper.orderByDesc(DictItem::getSn);
        return baseMapper.selectPage(new MPPage<>(reqPage), wrapper)
                .buildResult(MapStruct.INSTANCE::po2vo);
    }
}
