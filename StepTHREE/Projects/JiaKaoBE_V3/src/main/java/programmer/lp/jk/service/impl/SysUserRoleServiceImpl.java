package programmer.lp.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programmer.lp.jk.common.enhance.MPLambdaQueryWrapper;
import programmer.lp.jk.mapper.SysUserRoleMapper;
import programmer.lp.jk.pojo.po.SysUserRole;
import programmer.lp.jk.service.SysUserRoleService;

@Service
@Transactional
public class SysUserRoleServiceImpl
        extends ServiceImpl<SysUserRoleMapper, SysUserRole>
        implements SysUserRoleService {
    @Override
    public boolean removeByUserId(Integer userId) {
        if (userId == null || userId <= 0) return false;
        MPLambdaQueryWrapper<SysUserRole> wrapper = new MPLambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId, userId);
        return baseMapper.delete(wrapper) > 0;
    }
}
