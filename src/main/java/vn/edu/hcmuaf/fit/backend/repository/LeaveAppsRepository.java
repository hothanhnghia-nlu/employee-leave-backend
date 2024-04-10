package vn.edu.hcmuaf.fit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmuaf.fit.backend.model.Employee;
import vn.edu.hcmuaf.fit.backend.model.LeaveApplications;

@Repository
public interface LeaveAppsRepository extends JpaRepository<LeaveApplications, Integer> {

}
