package programmer.lp.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programmer.lp.jk.controller.base.BaseController;
import programmer.lp.jk.pojo.dto.ProvinceDto;
import programmer.lp.jk.pojo.po.ExamPlace;
import programmer.lp.jk.pojo.query.ExamPlaceQuery;
import programmer.lp.jk.pojo.result.R;
import programmer.lp.jk.service.ExamPlaceService;
import programmer.lp.jk.util.Rs;

import java.util.List;

@RestController
@RequestMapping("/examPlaces")
public class ExamPlaceController extends BaseController<ExamPlace> {
    @Autowired
    private ExamPlaceService service;

    @GetMapping
    public R list(ExamPlaceQuery query) {
        service.list(query);
        return Rs.success(query).add(Rs.K_COUNT, query.getTotal());
    }

    @GetMapping("/regionExamPlaces")
    public R regionExamPlaces() {
        List<ProvinceDto> list = service.listRegionExamPlaces();
        return Rs.success(list).add(Rs.K_COUNT, list.size());
    }

    @Override
    protected IService<ExamPlace> service() {
        return service;
    }
}

