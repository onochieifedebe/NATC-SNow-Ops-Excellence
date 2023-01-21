package com.theifedebegroup.operationalexcellence.dao;

import java.util.List;

import com.theifedebegroup.operationalexcellence.dto.ProjectCountData;
import com.theifedebegroup.operationalexcellence.dto.StatusChartData;
import com.theifedebegroup.operationalexcellence.dto.TimeChartData;
import com.theifedebegroup.operationalexcellence.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface IProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT STATUS as label, COUNT(STATUS) AS value FROM PROJECT GROUP BY STATUS")
    List<StatusChartData> getProjectStatus();

    Project findByProjectId(long id);

    @Query(nativeQuery = true, value="SELECT name as projectName, start_date as startDate, end_date as endDate FROM project")
    List<TimeChartData> getTimeData();

    @Query(nativeQuery = true, value="select count(DISTINCT e.employee_id) as label, count( distinct ee.employee_id)-count(DISTINCT e.employee_id) as value " +
            "from employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "right join employee ee on pe.employee_id = ee.employee_id")
    List<ProjectCountData> getProjectCount();


}
