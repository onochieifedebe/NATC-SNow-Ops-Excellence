package com.theifedebegroup.operationalexcellence.services;

import com.theifedebegroup.operationalexcellence.dao.IProjectRepository;
import com.theifedebegroup.operationalexcellence.dto.ProjectCountData;
import com.theifedebegroup.operationalexcellence.dto.StatusChartData;
import com.theifedebegroup.operationalexcellence.dto.TimeChartData;
import com.theifedebegroup.operationalexcellence.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    IProjectRepository proRepo;

    public Project save(Project project){
        return proRepo.save(project);
    }

    public List<Project> getAll(){
        return proRepo.findAll();
    }

    public List<StatusChartData> getProjectStatus(){
        return proRepo.getProjectStatus();
    }

    public Project findByProjectId(long id) {
        return proRepo.findByProjectId(id);
    }

    public void delete(Project project) {
        proRepo.delete(project);
    }

    public List<TimeChartData> getTimeData(){
        return proRepo.getTimeData();
    }

    public List<ProjectCountData> getProjectCount(){
        return proRepo.getProjectCount();
    }

}
