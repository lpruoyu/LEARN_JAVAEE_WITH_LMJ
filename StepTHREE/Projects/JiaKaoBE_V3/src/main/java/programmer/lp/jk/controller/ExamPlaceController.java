package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.mapstruct.MapStruct;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlace;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlace;
import programmer.lp.jk.pojo.vo.resp.RespExamPlace;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.service.ExamPlaceService;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/examPlaces")
@Api(tags = "考场", description = "ExamPlace")
public class ExamPlaceController extends BaseController<ExamPlace, ReqSaveExamPlace> {
    @Autowired
    private ExamPlaceService service;

    @GetMapping
    @ApiOperation("分页查询")
    public JSONPageResult<RespExamPlace> list(ReqPageExamPlace reqPage) {
        return service.list(reqPage);
    }

    @GetMapping("/regionExamPlaces")
    @ApiOperation("查询所有的考场信息")
    public JSONDataResult<List<ProvinceDto>> regionExamPlaces() {
        return service.listRegionExamPlaces();
    }

    @Override
    protected IService<ExamPlace> service() {
        return service;
    }

    @Override
    protected Function<ReqSaveExamPlace, ExamPlace> function() {
        return MapStruct.INSTANCE::vo2po;
    }
}

