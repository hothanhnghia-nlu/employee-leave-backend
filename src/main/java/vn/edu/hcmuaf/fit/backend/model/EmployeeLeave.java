package vn.edu.hcmuaf.fit.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employee_leave")
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reason")
    private String reason;

    @Column(name = "from_day")
    private LocalDate fromDay;

    @Column(name = "to_day")
    private LocalDate toDay;

    @Column(name = "status", length = 2)
    private int status;

    @Column(name = "reason_reject")
    private String reasonReject;

    @OneToOne
    @JoinColumn(name = "received_to")
    private User receivedTo;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
