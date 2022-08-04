package programmer.lp.jk.common.mapstruct;

import javax.annotation.Generated;
import programmer.lp.jk.pojo.po.DictItem;
import programmer.lp.jk.pojo.po.DictType;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.po.ExamPlaceCourse;
import programmer.lp.jk.pojo.po.PlateRegion;
import programmer.lp.jk.pojo.po.SysResource;
import programmer.lp.jk.pojo.po.SysRole;
import programmer.lp.jk.pojo.po.SysUser;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveDictItem;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveDictType;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlace;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlaceCourse;
import programmer.lp.jk.pojo.vo.req.save.ReqSavePlateRegion;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysResource;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysRole;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveSysUser;
import programmer.lp.jk.pojo.vo.resp.RespDictItem;
import programmer.lp.jk.pojo.vo.resp.RespDictType;
import programmer.lp.jk.pojo.vo.resp.RespExamPlace;
import programmer.lp.jk.pojo.vo.resp.RespExamPlaceCourse;
import programmer.lp.jk.pojo.vo.resp.RespLogin;
import programmer.lp.jk.pojo.vo.resp.RespPlateRegion;
import programmer.lp.jk.pojo.vo.resp.RespSysResource;
import programmer.lp.jk.pojo.vo.resp.RespSysRole;
import programmer.lp.jk.pojo.vo.resp.RespSysUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T14:14:11+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class MapStructImpl implements MapStruct {

    @Override
    public DictItem vo2po(ReqSaveDictItem reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        DictItem dictItem = new DictItem();

        dictItem.setId( reqSaveVo.getId() );
        dictItem.setName( reqSaveVo.getName() );
        dictItem.setValue( reqSaveVo.getValue() );
        dictItem.setTypeId( reqSaveVo.getTypeId() );
        dictItem.setSn( reqSaveVo.getSn() );
        dictItem.setDisabled( reqSaveVo.getDisabled() );

        return dictItem;
    }

    @Override
    public DictType vo2po(ReqSaveDictType reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        DictType dictType = new DictType();

        dictType.setId( reqSaveVo.getId() );
        dictType.setName( reqSaveVo.getName() );
        dictType.setValue( reqSaveVo.getValue() );
        dictType.setIntro( reqSaveVo.getIntro() );

        return dictType;
    }

    @Override
    public ExamPlace vo2po(ReqSaveExamPlace reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        ExamPlace examPlace = new ExamPlace();

        examPlace.setId( reqSaveVo.getId() );
        examPlace.setName( reqSaveVo.getName() );
        examPlace.setProvinceId( reqSaveVo.getProvinceId() );
        examPlace.setCityId( reqSaveVo.getCityId() );
        examPlace.setAddress( reqSaveVo.getAddress() );
        examPlace.setLatitude( reqSaveVo.getLatitude() );
        examPlace.setLongitude( reqSaveVo.getLongitude() );

        return examPlace;
    }

    @Override
    public ExamPlaceCourse vo2po(ReqSaveExamPlaceCourse reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        ExamPlaceCourse examPlaceCourse = new ExamPlaceCourse();

        examPlaceCourse.setId( reqSaveVo.getId() );
        examPlaceCourse.setName( reqSaveVo.getName() );
        examPlaceCourse.setPrice( reqSaveVo.getPrice() );
        examPlaceCourse.setType( reqSaveVo.getType() );
        examPlaceCourse.setIntro( reqSaveVo.getIntro() );
        examPlaceCourse.setVideo( reqSaveVo.getVideo() );
        examPlaceCourse.setCover( reqSaveVo.getCover() );
        examPlaceCourse.setPlaceId( reqSaveVo.getPlaceId() );

        return examPlaceCourse;
    }

    @Override
    public PlateRegion vo2po(ReqSavePlateRegion reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        PlateRegion plateRegion = new PlateRegion();

        plateRegion.setId( reqSaveVo.getId() );
        plateRegion.setName( reqSaveVo.getName() );
        plateRegion.setPlate( reqSaveVo.getPlate() );
        plateRegion.setParentId( reqSaveVo.getParentId() );

        return plateRegion;
    }

    @Override
    public SysUser vo2po(ReqSaveSysUser reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        SysUser sysUser = new SysUser();

        sysUser.setId( reqSaveVo.getId() );
        sysUser.setNickname( reqSaveVo.getNickname() );
        sysUser.setUsername( reqSaveVo.getUsername() );
        sysUser.setPassword( reqSaveVo.getPassword() );
        sysUser.setStatus( reqSaveVo.getStatus() );

        return sysUser;
    }

    @Override
    public SysRole vo2po(ReqSaveSysRole reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        SysRole sysRole = new SysRole();

        sysRole.setId( reqSaveVo.getId() );
        sysRole.setName( reqSaveVo.getName() );

        return sysRole;
    }

    @Override
    public SysResource vo2po(ReqSaveSysResource reqSaveVo) {
        if ( reqSaveVo == null ) {
            return null;
        }

        SysResource sysResource = new SysResource();

        sysResource.setId( reqSaveVo.getId() );
        sysResource.setName( reqSaveVo.getName() );
        sysResource.setUri( reqSaveVo.getUri() );
        sysResource.setPermission( reqSaveVo.getPermission() );
        sysResource.setType( reqSaveVo.getType() );
        sysResource.setIcon( reqSaveVo.getIcon() );
        sysResource.setSn( reqSaveVo.getSn() );
        sysResource.setParentId( reqSaveVo.getParentId() );

        return sysResource;
    }

    @Override
    public RespDictItem po2vo(DictItem po) {
        if ( po == null ) {
            return null;
        }

        RespDictItem respDictItem = new RespDictItem();

        respDictItem.setId( po.getId() );
        respDictItem.setName( po.getName() );
        respDictItem.setValue( po.getValue() );
        respDictItem.setTypeId( po.getTypeId() );
        respDictItem.setSn( po.getSn() );
        respDictItem.setDisabled( po.getDisabled() );

        return respDictItem;
    }

    @Override
    public RespDictType po2vo(DictType po) {
        if ( po == null ) {
            return null;
        }

        RespDictType respDictType = new RespDictType();

        respDictType.setId( po.getId() );
        respDictType.setName( po.getName() );
        respDictType.setValue( po.getValue() );
        respDictType.setIntro( po.getIntro() );

        return respDictType;
    }

    @Override
    public RespExamPlace po2vo(ExamPlace po) {
        if ( po == null ) {
            return null;
        }

        RespExamPlace respExamPlace = new RespExamPlace();

        respExamPlace.setId( po.getId() );
        respExamPlace.setName( po.getName() );
        respExamPlace.setProvinceId( po.getProvinceId() );
        respExamPlace.setCityId( po.getCityId() );
        respExamPlace.setAddress( po.getAddress() );
        respExamPlace.setLatitude( po.getLatitude() );
        respExamPlace.setLongitude( po.getLongitude() );

        return respExamPlace;
    }

    @Override
    public RespExamPlaceCourse po2vo(ExamPlaceCourse po) {
        if ( po == null ) {
            return null;
        }

        RespExamPlaceCourse respExamPlaceCourse = new RespExamPlaceCourse();

        respExamPlaceCourse.setId( po.getId() );
        respExamPlaceCourse.setCreateTime( po.getCreateTime() );
        respExamPlaceCourse.setName( po.getName() );
        respExamPlaceCourse.setPrice( po.getPrice() );
        respExamPlaceCourse.setPlaceId( po.getPlaceId() );
        respExamPlaceCourse.setType( po.getType() );
        respExamPlaceCourse.setIntro( po.getIntro() );
        respExamPlaceCourse.setVideo( po.getVideo() );
        respExamPlaceCourse.setCover( po.getCover() );

        return respExamPlaceCourse;
    }

    @Override
    public RespPlateRegion po2vo(PlateRegion po) {
        if ( po == null ) {
            return null;
        }

        RespPlateRegion respPlateRegion = new RespPlateRegion();

        respPlateRegion.setId( po.getId() );
        respPlateRegion.setName( po.getName() );
        respPlateRegion.setPlate( po.getPlate() );
        respPlateRegion.setParentId( po.getParentId() );

        return respPlateRegion;
    }

    @Override
    public RespSysUser po2vo(SysUser po) {
        if ( po == null ) {
            return null;
        }

        RespSysUser respSysUser = new RespSysUser();

        respSysUser.setLoginTime( MapStructFormatter.date2millis( po.getLoginTime() ) );
        respSysUser.setId( po.getId() );
        respSysUser.setNickname( po.getNickname() );
        respSysUser.setUsername( po.getUsername() );
        respSysUser.setStatus( po.getStatus() );

        return respSysUser;
    }

    @Override
    public RespSysRole po2vo(SysRole po) {
        if ( po == null ) {
            return null;
        }

        RespSysRole respSysRole = new RespSysRole();

        respSysRole.setId( po.getId() );
        respSysRole.setName( po.getName() );

        return respSysRole;
    }

    @Override
    public RespSysResource po2vo(SysResource po) {
        if ( po == null ) {
            return null;
        }

        RespSysResource respSysResource = new RespSysResource();

        respSysResource.setId( po.getId() );
        respSysResource.setName( po.getName() );
        respSysResource.setUri( po.getUri() );
        respSysResource.setPermission( po.getPermission() );
        respSysResource.setType( po.getType() );
        respSysResource.setIcon( po.getIcon() );
        respSysResource.setSn( po.getSn() );
        respSysResource.setParentId( po.getParentId() );

        return respSysResource;
    }

    @Override
    public RespLogin po2loginVo(SysUser po) {
        if ( po == null ) {
            return null;
        }

        RespLogin respLogin = new RespLogin();

        respLogin.setId( po.getId() );
        respLogin.setNickname( po.getNickname() );
        respLogin.setUsername( po.getUsername() );

        return respLogin;
    }
}
