package teste.projeto.Control.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.projeto.Model.Entities.Item;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
