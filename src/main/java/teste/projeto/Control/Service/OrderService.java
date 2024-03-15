package teste.projeto.Control.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teste.projeto.Control.Repository.OrderItensRepository;
import teste.projeto.Control.Repository.OrderRepository;
import teste.projeto.Model.Entities.Order;
import teste.projeto.Model.Entities.OrderItens;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository rep;

    @Autowired
    private OrderItensRepository rep_itens;

    @Transactional(readOnly = true)
    public Order findById(UUID uuid) {
        return rep.getReferenceById(uuid);
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return rep.findAll();
    }

    @Transactional
    public Order deleteById(UUID orderId) {
        Order order = findById(orderId);
        rep.deleteById(orderId);
        return order;
    }

    @Transactional
    public Order save(Order newOrder) {
        return rep.save(newOrder);
    }

    @Transactional
    public Order update(Order orderUpdated) {
        double orderValue = 0;
        for(OrderItens orderItem : rep_itens.findItensByOrder(orderUpdated.getUuid())){
            double itemTotalValue = 0;
            itemTotalValue = orderItem.getItem().getBaseValue();
            if(!orderItem.getItem().isService() && orderUpdated.getDiscountPercent()>0) {
                itemTotalValue = itemTotalValue * ((100-orderUpdated.getDiscountPercent()) / 100);
            }
            itemTotalValue = itemTotalValue * orderItem.getQuantity();
            orderValue += itemTotalValue;
            OrderItens orderItens = orderItem;
            orderItens.setTotalValue(itemTotalValue);
            rep_itens.save(orderItens);
        }
        orderUpdated.setTotalValue(orderValue);
        return rep.save(orderUpdated);
    }
}
