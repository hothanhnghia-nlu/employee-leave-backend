package vn.edu.hcmuaf.fit.backend.service.impl;

import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.backend.dto.LeaveApplicationsDTO;
import vn.edu.hcmuaf.fit.backend.exception.ResourceNotFoundException;
import vn.edu.hcmuaf.fit.backend.model.Employee;
import vn.edu.hcmuaf.fit.backend.model.LeaveApplications;
import vn.edu.hcmuaf.fit.backend.repository.EmployeeRepository;
import vn.edu.hcmuaf.fit.backend.repository.LeaveAppsRepository;
import vn.edu.hcmuaf.fit.backend.service.LeaveAppsService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaveAppsServiceImpl implements LeaveAppsService {
    private LeaveAppsRepository leaveAppsRepository;

    public LeaveAppsServiceImpl(LeaveAppsRepository leaveAppsRepository) {
        this.leaveAppsRepository = leaveAppsRepository;
    }

    // Create a new leave application
    @Override
    public LeaveApplications saveLeaveApps(int employeeId, LeaveApplicationsDTO leaveAppsDTO) {
        LeaveApplications leaveApplications = new LeaveApplications();
        leaveApplications.setId(leaveAppsDTO.getId());
        leaveApplications.setEmployee(new Employee(employeeId));
        leaveApplications.setReason(leaveAppsDTO.getReason());
        leaveApplications.setFrom(leaveAppsDTO.getFrom());
        leaveApplications.setTo(leaveAppsDTO.getTo());
//        leaveApplications.setHandleBy();
        leaveApplications.setStatus(2);
        leaveApplications.setCreatedAt(LocalDateTime.now());

        return leaveAppsRepository.save(leaveApplications);
    }

    // Approve leave application from boss
    @Override
    public LeaveApplications approveLeaveAppsByID(int id, LeaveApplicationsDTO leaveApps) {
        LeaveApplications existingLeaveApp = leaveAppsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Leave Application", "Id", id));

        existingLeaveApp.setReasonReject(leaveApps.getReasonReject());
        existingLeaveApp.setStatus(leaveApps.getStatus());
//        existingLeaveApp.setHandleBy();
        existingLeaveApp.setUpdatedAt(LocalDateTime.now());

        return leaveAppsRepository.save(existingLeaveApp);
    }

}
