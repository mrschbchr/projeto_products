package teste.projeto.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "itens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", updatable = false, unique = true, nullable = false)
    private UUID uuid;
    private boolean isService;
    private double baseValue;
    private String productName;

    public Item() {
    }

    public Item(UUID uuid, boolean isService, double baseValue, String productName) {
        this.uuid = uuid;
        this.isService = isService;
        this.baseValue = baseValue;
        this.productName = productName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isService() {
        return isService;
    }

    public void setService(boolean service) {
        isService = service;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "uuid=" + uuid +
                ", isService=" + isService +
                ", baseValue=" + baseValue +
                ", productName='" + productName + '\'' +
                '}';
    }
}
