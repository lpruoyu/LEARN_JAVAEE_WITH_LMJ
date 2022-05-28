package programmer.lp.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;

import java.util.List;

public interface ExamPlaceMapper extends BaseMapper<ExamPlace> {
    List<ProvinceDto> selectRegionExamPlaces();
}
