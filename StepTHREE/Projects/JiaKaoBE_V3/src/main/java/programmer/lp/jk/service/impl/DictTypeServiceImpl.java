package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.common.enhance.MPPage;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.mapper.DictTypeMapper;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.vo.req.page.ReqPageDictType;
import programmer.lp.jk.pojo.vo.resp.RespDictType;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.DictTypeService;

@Transactional
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Override
    @Transactional(readOnly = true)
    public JSONPageResult<RespDictType> list(ReqPageDictType reqPage) {
        MPLambdaQueryWrapper<DictType> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.like(reqPage.getKeyword(), DictType::getName, DictType::getValue, DictType::getIntro);
        wrapper.orderByDesc(DictType::getId);
        return baseMapper
                .selectPage(new MPPage<>(reqPage), wrapper)
                .buildResult(MapStruct.INSTANCE::po2vo);
    }
}
