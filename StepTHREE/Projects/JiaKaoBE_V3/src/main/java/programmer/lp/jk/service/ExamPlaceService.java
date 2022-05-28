package programmer.lp.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlace;
import programmer.lp.jk.pojo.vo.resp.RespExamPlace;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;

import java.util.List;

public interface ExamPlaceService extends IService<ExamPlace> {
    JSONPageResult<RespExamPlace> list(ReqPageExamPlace reqPage);
    JSONDataResult<List<ProvinceDto>> listRegionExamPlaces();
}

