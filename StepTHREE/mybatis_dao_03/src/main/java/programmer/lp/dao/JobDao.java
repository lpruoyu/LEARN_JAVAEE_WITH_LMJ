package programmer.lp.dao;

import org.apache.ibatis.annotations.Select;
import programmer.lp.bean.Job;

import java.util.List;

public interface JobDao {
    @Select("SELECT id, name, duty FROM job " +
            "JOIN person_job " +
            "ON person_job.job_id = id AND person_job.person_id = #{personId}")
    List<Job> listByPersonId(Integer personId);
}
