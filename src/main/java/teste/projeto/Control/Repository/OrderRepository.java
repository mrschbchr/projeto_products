package teste.projeto.Control.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.projeto.Model.Entities.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
