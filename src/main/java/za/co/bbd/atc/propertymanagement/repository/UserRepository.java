package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
