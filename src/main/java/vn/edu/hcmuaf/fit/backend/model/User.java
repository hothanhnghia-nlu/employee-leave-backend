package vn.edu.hcmuaf.fit.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name", length = 1000)
    private String fullName;

    @Column(name = "email", length = 500)
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "day_offs_remain")
    private int dayOffsRemain;

    @OneToOne
    @JoinColumn(name = "boss_id")
    private User bossId;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<EmployeeLeave> employeeLeaves;

}
