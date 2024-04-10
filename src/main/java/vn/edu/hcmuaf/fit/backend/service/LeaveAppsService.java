package vn.edu.hcmuaf.fit.backend.service;

import vn.edu.hcmuaf.fit.backend.dto.LeaveApplicationsDTO;
import vn.edu.hcmuaf.fit.backend.model.LeaveApplications;

import java.util.List;


public interface LeaveAppsService {
    LeaveApplications saveLeaveApps(int employeeId, LeaveApplicationsDTO leaveApps);
//    List<LeaveApplications> getAllLeaveApp();
//    LeaveApplications getLeaveAppsByID(int id);
    LeaveApplications approveLeaveAppsByID(int id, LeaveApplicationsDTO leaveApps);
//    void deleteLeaveAppsByID(int id);
}
