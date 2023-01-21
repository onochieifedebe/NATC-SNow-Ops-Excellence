package com.theifedebegroup.operationalexcellence.services;

import com.theifedebegroup.operationalexcellence.dao.IEmployeeRepository;
import com.theifedebegroup.operationalexcellence.dto.*;
import com.theifedebegroup.operationalexcellence.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository empRepo;

    public Employee save(Employee employee){
        return empRepo.save(employee);
    }

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<ResourceCertification> resourceCertifications(){
        return empRepo.resourceCertifications();
    }

    public List<EmployeeCertification> employeeCertifications(){
        return empRepo.employeeCertifications();
    }

    public List<ProjectEmployee> projectEmployees(){
        return empRepo.projectEmployees();
    }

    public List<EmployeeProject> employeeProjects(){
        return empRepo.employeeProjects();
    }

    public Employee findByEmployeeId(long id) {
        return empRepo.findByEmployeeId(id);
    }

    public void delete(Employee employee) {
        empRepo.delete(employee);
    }

    public List<EmpInOrder> empInOrder() {
        return empRepo.empInOrder();
    }

    public void deleteEmpOnComplete(){
        empRepo.deleteEmployees();
    }

    public List<MlEmpCount> getMlEmpCount(){
        return empRepo.getMlEmpCount();
    }

}
