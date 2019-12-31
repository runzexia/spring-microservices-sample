package io.kubesphere.services.department.services;

import io.kubesphere.services.Department;
import io.kubesphere.services.DepartmentService;
import io.kubesphere.services.EmployeeService;
import io.kubesphere.services.department.repository.DepartmentRepository;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author runzexia
 */

@Service(version = "1.0.0" , protocol = "dubbo")
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    DepartmentRepository repository;

    @Reference(version = "1.0.0" , protocol = "dubbo")
    EmployeeService employeeService;

    @Override
    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId")  Long organizationId){
        LOGGER.info("Department find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

    @Override
    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId){
        LOGGER.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repository.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmployees(employeeService.findByDepartment(d.getId())));
        return departments;
    }

}
