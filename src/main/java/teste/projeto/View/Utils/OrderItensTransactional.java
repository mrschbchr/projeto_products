package teste.projeto.View.Utils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderItensTransactional {
    private UUID uuid;
    private UUID orderUuid;
    private UUID itemUuid;
    private double quantity;

    public OrderItensTransactional() {
    }

    public OrderItensTransactional(UUID orderUuid, UUID itemUuid, double quantity) {
        this.orderUuid = orderUuid;
        this.itemUuid = itemUuid;
        this.quantity = quantity;
    }

    public UUID getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(UUID orderUuid) {
        this.orderUuid = orderUuid;
    }

    public UUID getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(UUID itemUuid) {
        this.itemUuid = itemUuid;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
