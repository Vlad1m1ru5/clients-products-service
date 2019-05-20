package repository;

import entity.ValidClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MainRepository extends JpaRepository<ValidClient, UUID> {
}
