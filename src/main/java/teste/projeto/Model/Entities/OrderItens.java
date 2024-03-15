package teste.projeto.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="order_itens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderItens {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "item_uuid")
    private Item item;

    private double quantity;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    private double totalValue;

    public OrderItens() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public OrderItens(UUID uuid, Order order, Item item) {
        this.uuid = uuid;
        this.order = order;
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
