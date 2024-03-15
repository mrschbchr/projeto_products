package teste.projeto.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private double totalValue;
    private double discountPercent;

    public Order() {
    }

    public Order(UUID uuid, double totalValue, double discountPercent) {
        this.uuid = uuid;
        this.totalValue = totalValue;
        this.discountPercent = discountPercent;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "Order{" +
                "uuid=" + uuid +
                ", totalValue=" + totalValue +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
