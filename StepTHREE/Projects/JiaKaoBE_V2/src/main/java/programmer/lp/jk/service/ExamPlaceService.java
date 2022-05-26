package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.query.ExamPlaceQuery;

import java.util.List;

public interface ExamPlaceService extends IService<ExamPlace> {
    void list(ExamPlaceQuery query);
    List<ProvinceDto> listRegionExamPlaces();
}

