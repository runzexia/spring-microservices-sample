package io.kubesphere.services;

import java.util.List;

public interface EmployeeService {
    List<Employee> findByDepartment(Long departmentId);
}
