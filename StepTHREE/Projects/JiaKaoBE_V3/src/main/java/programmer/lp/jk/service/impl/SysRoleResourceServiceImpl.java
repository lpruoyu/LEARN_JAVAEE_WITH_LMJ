package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.mapper.SysRoleResourceMapper;
import programmer.lp.jk.pojo.po.SysRoleResource;
import programmer.lp.jk.service.SysRoleResourceService;

@Service
@Transactional
public class SysRoleResourceServiceImpl
        extends ServiceImpl<SysRoleResourceMapper, SysRoleResource>
        implements SysRoleResourceService {
    @Override
    public boolean removeByRoleId(Short roleId) {
        if (roleId == null || roleId <= 0) return false;
        MPLambdaQueryWrapper<SysRoleResource> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.eq(SysRoleResource::getRoleId, roleId);
        return baseMapper.delete(wrapper) > 0;
    }
}
