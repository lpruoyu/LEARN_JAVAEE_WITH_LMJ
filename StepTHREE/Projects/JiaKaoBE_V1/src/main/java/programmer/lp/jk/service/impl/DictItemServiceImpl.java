package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.mapper.DictItemMapper;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.service.DictItemService;

@Transactional
@Service("dictItemService")
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Autowired
    private DictItemMapper mapper;
    
}

