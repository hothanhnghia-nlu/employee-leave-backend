package vn.edu.hcmuaf.fit.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class LeaveApplicationsDTO {
    private int id;
    private int employeeId;
    private String reason;
    private LocalDateTime from;
    private LocalDateTime to;
    private int status;
    private String reasonReject;
    private int handleById;

    public LeaveApplicationsDTO() {
    }
}
