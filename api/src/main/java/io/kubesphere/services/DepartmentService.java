package io.kubesphere.services;

import java.util.List;

public interface DepartmentService {
    List<Department> findByOrganization(Long organizationId);

    List<Department> findByOrganizationWithEmployees(Long organizationId);
}
