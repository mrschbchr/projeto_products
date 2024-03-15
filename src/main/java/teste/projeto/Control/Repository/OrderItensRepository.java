package teste.projeto.Control.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.projeto.Model.Entities.OrderItens;

import java.util.List;
import java.util.UUID;

public interface OrderItensRepository extends JpaRepository<OrderItens, UUID> {
    @Query(value="SELECT * FROM order_itens u where u.order_uuid = ?1", nativeQuery=true)
    List<OrderItens> findItensByOrder(UUID orderId);
}