package vn.edu.hcmuaf.fit.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.backend.dto.LeaveApplicationsDTO;
import vn.edu.hcmuaf.fit.backend.model.LeaveApplications;
import vn.edu.hcmuaf.fit.backend.service.LeaveAppsService;

@RestController
@RequestMapping("api/leave-applications")
public class LeaveAppsController {
    private LeaveAppsService leaveAppsService;

    public LeaveAppsController(LeaveAppsService leaveAppsService) {
        this.leaveAppsService = leaveAppsService;
    }

    // Create a new Leave Application
    @PostMapping("/save")
    public ResponseEntity<LeaveApplications> createLeaveApps(@RequestParam int employeeId,
                                                             @RequestBody LeaveApplicationsDTO leaveApps) {
        return new ResponseEntity<>(leaveAppsService.saveLeaveApps(employeeId, leaveApps), HttpStatus.CREATED);
    }

    // Approve Leave Application
    @PutMapping("/approve/{id}")
    public ResponseEntity<LeaveApplications> approveLeaveApps(@PathVariable("id") int id,
                                                              @RequestBody LeaveApplicationsDTO leaveAppsDTO) {
        return new ResponseEntity<>(leaveAppsService.approveLeaveAppsByID(id, leaveAppsDTO), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<LeaveApplications> getEmployeeById(@PathVariable("id") int id) {
        return new ResponseEntity<>(leaveAppsService.getLeaveAppsByID(id), HttpStatus.OK);
    }
}