package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.common.mapstruct.MapStruct;
import programmer.lp.jk.common.util.Constants;
import programmer.lp.jk.common.util.JSONResults;
import programmer.lp.jk.pojo.vo.resp.RespProvince;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.vo.req.page.ReqPageExamPlace;
import programmer.lp.jk.pojo.vo.req.save.ReqSaveExamPlace;
import programmer.lp.jk.pojo.vo.resp.RespExamPlace;
import programmer.lp.jk.pojo.vo.resp.json.JSONDataResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONPageResult;
import programmer.lp.jk.pojo.vo.resp.json.JSONResult;
import programmer.lp.jk.service.ExamPlaceService;

import javax.validation.Valid;
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
    @RequiresPermissions(Constants.Permisson.EXAM_PLACE_LIST)
    public JSONPageResult<RespExamPlace> list(@Valid ReqPageExamPlace reqPage) {
        return service.list(reqPage);
    }

    @GetMapping("/regionExamPlaces")
    @ApiOperation("查询所有的考场信息")
    @RequiresPermissions(Constants.Permisson.EXAM_PLACE_LIST)
    public JSONDataResult<List<RespProvince>> regionExamPlaces() {
        return JSONResults.ok(service.listRegionExamPlaces());
    }

    @Override
    @RequiresPermissions(value = {
            Constants.Permisson.EXAM_PLACE_ADD,
            Constants.Permisson.EXAM_PLACE_UPDATE
    }, logical = Logical.AND)
    public JSONResult save(ReqSaveExamPlace entity) {
        return super.save(entity);
    }

    @Override
    @RequiresPermissions(Constants.Permisson.EXAM_PLACE_REMOVE)
    public JSONResult remove(String id) {
        return super.remove(id);
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

