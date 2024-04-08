package vn.edu.hcmuaf.fit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmuaf.fit.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
