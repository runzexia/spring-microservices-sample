package io.kubesphere.services.employee.service;

import io.kubesphere.services.Employee;
import io.kubesphere.services.EmployeeService;
import io.kubesphere.services.employee.repository.EmployeeRepository;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(protocol = "dubbo", version = "1.0.0")
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeRepository repository;


    @Override
    public List<Employee> findByDepartment(Long departmentId){
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }
}
