package programmer.lp.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import programmer.lp.filter.MyTypeFilter;

@Component
@ComponentScan(basePackages = "programmer.lp", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {Person.class, Dog.class}),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*demo.*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "programmer.lp.service..*")
})
public class MyCat {
    // ...
}