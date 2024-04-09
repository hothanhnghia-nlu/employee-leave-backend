package vn.edu.hcmuaf.fit.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@EntityScan
@Table(name = "leave_application")
public class LeaveApplications {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "reason")
    private String reason;

    @Column(name = "start_date")
    private Date from;

    @Column(name = "end_date")
    private Date to;

    @Column(name = "status")
    private int status;

    @Column(name = "reason_reject")
    private String reasonReject;

    @ManyToOne
    @JoinColumn(name = "handle_by")
    private Employee handleBy;
}
