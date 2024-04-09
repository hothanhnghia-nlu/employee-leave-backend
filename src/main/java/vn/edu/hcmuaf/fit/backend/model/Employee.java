package vn.edu.hcmuaf.fit.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Employee boss;

    @Column(name = "potision")
    private String position;

    @Column(name = "dayOffRemaining")
    private int dayOffRemaining;

    @Column(name = "firstDayOfWork")
    private Date firstDayOfWork;

    @OneToMany(mappedBy = "employee")
    List<LeaveApplications> applicationsList;

    public String getFormattedId() {
        return String.format("%06d", this.id);
    }
}
