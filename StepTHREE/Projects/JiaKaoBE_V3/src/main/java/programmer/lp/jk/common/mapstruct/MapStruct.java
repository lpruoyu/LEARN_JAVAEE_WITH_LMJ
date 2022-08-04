package programmer.lp.jk.common.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import programmer.lp.jk.pojo.po.*;
import programmer.lp.jk.pojo.vo.req.save.*;
import programmer.lp.jk.pojo.vo.resp.*;

//@Mapper
@Mapper(uses = {
        MapStructFormatter.class
})
public interface MapStruct {
    MapStruct INSTANCE = Mappers.getMapper(MapStruct.class);

    DictItem vo2po(ReqSaveDictItem reqSaveVo);
    DictType vo2po(ReqSaveDictType reqSaveVo);
    ExamPlace vo2po(ReqSaveExamPlace reqSaveVo);
    ExamPlaceCourse vo2po(ReqSaveExamPlaceCourse reqSaveVo);
    PlateRegion vo2po(ReqSavePlateRegion reqSaveVo);
    SysUser vo2po(ReqSaveSysUser reqSaveVo);
    SysRole vo2po(ReqSaveSysRole reqSaveVo);
    SysResource vo2po(ReqSaveSysResource reqSaveVo);

    RespDictItem po2vo(DictItem po);
    RespDictType po2vo(DictType po);
    RespExamPlace po2vo(ExamPlace po);
    RespExamPlaceCourse po2vo(ExamPlaceCourse po);
    RespPlateRegion po2vo(PlateRegion po);
    @Mapping(source = "loginTime",
            target = "loginTime",
            qualifiedBy = MapStructFormatter.Date2Millis.class)
    RespSysUser po2vo(SysUser po);
    RespSysRole po2vo(SysRole po);
    RespSysResource po2vo(SysResource po);

    RespLogin po2loginVo(SysUser po);
}
