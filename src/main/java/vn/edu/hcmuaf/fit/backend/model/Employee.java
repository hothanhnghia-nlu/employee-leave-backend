package vn.edu.hcmuaf.fit.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Employee bossId;

    @Column(name = "position")
    private String position;

    @Column(name = "dayOffRemaining")
    private int dayOffRemaining;

    @Column(name = "firstDayOfWork")
    private LocalDateTime firstDayOfWork;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LeaveApplications> applicationsList;

    public Employee(int id) {
        this.userId = id;
    }

    public String getFormattedId() {
        return String.format("%06d", this.userId);
    }
}
