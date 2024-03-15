package teste.projeto.Control.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teste.projeto.Control.Repository.ItemRepository;
import teste.projeto.Control.Repository.OrderItensRepository;
import teste.projeto.Control.Repository.OrderRepository;
import teste.projeto.Model.Entities.Item;
import teste.projeto.Model.Entities.Order;
import teste.projeto.Model.Entities.OrderItens;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItensService {
    @Autowired
    private OrderItensRepository rep;

    @Autowired
    private OrderRepository rep_order;

    @Autowired
    private ItemRepository rep_item;

    @Transactional(readOnly = true)
    public OrderItens findById(UUID uuid) {
        return rep.getReferenceById(uuid);
    }

    @Transactional(readOnly = true)
    public List<OrderItens> findAll() {
        return rep.findAll();
    }

    @Transactional
    public OrderItens deleteById(UUID orderId) {
        OrderItens orderItens = findById(orderId);
        rep.deleteById(orderId);
        return orderItens;
    }

    @Transactional
    public OrderItens save(OrderItens addedItem) {
        double baseValue = addedItem.getItem().getBaseValue();
        if (!addedItem.getItem().isService() && addedItem.getOrder().getDiscountPercent() > 0){
            baseValue = ((100-addedItem.getOrder().getDiscountPercent()) / 100) * baseValue;
        }
        double totalValue = baseValue* addedItem.getQuantity();
        addedItem.setTotalValue(totalValue);
        OrderItens orderItens = rep.save(addedItem);
        double orderValue = 0;
        for(OrderItens orderItem : rep.findItensByOrder(orderItens.getOrder().getUuid())){
            orderValue += orderItem.getTotalValue();
        }
        Order order = orderItens.getOrder();
        order.setTotalValue(orderValue);
        rep_order.save(order);
        return orderItens;
    }

    @Transactional
    public OrderItens update(OrderItens updatedItem) {
        double baseValue = updatedItem.getItem().getBaseValue();
        if (!updatedItem.getItem().isService() && updatedItem.getOrder().getDiscountPercent() > 0){
            baseValue = ((100-updatedItem.getOrder().getDiscountPercent()) / 100) * baseValue;
        }
        double totalValue = baseValue * updatedItem.getQuantity();
        updatedItem.setTotalValue(totalValue);
        OrderItens orderItens = rep.save(updatedItem);
        double orderValue = 0;
        for(OrderItens orderItem : rep.findItensByOrder(orderItens.getOrder().getUuid())){
            orderValue += orderItem.getTotalValue();
        }
        Order order = orderItens.getOrder();
        order.setTotalValue(orderValue);
        rep_order.save(order);
        return orderItens;
    }
    @Transactional
    public Order findOrderById(UUID orderUuid){
        return rep_order.getReferenceById(orderUuid);
    }
    @Transactional
    public Item findItemById(UUID itemUuid){
        return rep_item.getReferenceById(itemUuid);
    }
}
