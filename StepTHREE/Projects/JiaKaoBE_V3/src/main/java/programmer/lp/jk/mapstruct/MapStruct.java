package programmer.lp.jk.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import programmer.lp.jk.pojo.po.*;
import programmer.lp.jk.pojo.vo.req.save.*;
import programmer.lp.jk.pojo.vo.resp.*;

@Mapper
public interface MapStruct {
    MapStruct INSTANCE = Mappers.getMapper(MapStruct.class);

    DictItem vo2po(ReqSaveDictItem reqSaveVo);
    DictType vo2po(ReqSaveDictType reqSaveVo);
    ExamPlace vo2po(ReqSaveExamPlace reqSaveVo);
    ExamPlaceCourse vo2po(ReqSaveExamPlaceCourse reqSaveVo);
    PlateRegion vo2po(ReqSavePlateRegion reqSaveVo);

    RespDictItem po2vo(DictItem po);
    RespDictType po2vo(DictType po);
    RespExamPlace po2vo(ExamPlace po);
    RespExamPlaceCourse po2vo(ExamPlaceCourse po);
    RespPlateRegion po2vo(PlateRegion po);
}
