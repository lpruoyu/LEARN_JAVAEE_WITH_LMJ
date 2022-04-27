package programmer.lp.domain;

//@Component
//@ConfigurationProperties("person")
//@Data
// @Data >= @Getter + @Setter + @ToString
public class Person3 {
    private Integer id;
    private Integer age;
    private String name;

    // List、Set、数组，yml的写法是一样的
    private String[] nickNames;
}
