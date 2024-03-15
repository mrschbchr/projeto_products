package teste.projeto.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.projeto.Control.Repository.OrderItensRepository;
import teste.projeto.Control.Repository.OrderRepository;
import teste.projeto.Control.Service.OrderItensService;
import teste.projeto.Control.Service.OrderService;
import teste.projeto.Model.Entities.Item;
import teste.projeto.Model.Entities.Order;
import teste.projeto.Model.Entities.OrderItens;
import teste.projeto.View.Utils.OrderItensTransactional;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/order_itens")
public class OrderItensController {
    @Autowired
    private OrderItensService service;

    @GetMapping(value = "/list")
    @ResponseBody
    List<OrderItens> list(){
        return service.findAll();
    }

    @GetMapping(value = "/read")
    @ResponseBody
    OrderItens read(@RequestParam("uuid") UUID uuid){
        return service.findById(uuid);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    OrderItens delete(@RequestParam("uuid") UUID uuid){
        return service.deleteById(uuid);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    OrderItens update(@RequestBody OrderItensTransactional itemUpdated){
        Order order = service.findOrderById(itemUpdated.getOrderUuid());
        Item item = service.findItemById(itemUpdated.getItemUuid());
        OrderItens orderItens = new OrderItens();
        orderItens.setOrder(order);
        orderItens.setItem(item);
        orderItens.setQuantity(itemUpdated.getQuantity());
        return service.update(orderItens);
    }

    @PostMapping("/create")
    @ResponseBody
    OrderItens save(@RequestBody OrderItensTransactional itemAdded){
        System.out.println("TRACE:");
        System.out.println(itemAdded.getOrderUuid());
        System.out.println(itemAdded.getItemUuid());
        Order order = service.findOrderById(itemAdded.getOrderUuid());
        Item item = service.findItemById(itemAdded.getItemUuid());
        OrderItens orderItens = new OrderItens();
        orderItens.setOrder(order);
        orderItens.setItem(item);
        orderItens.setQuantity(itemAdded.getQuantity());
        return service.save(orderItens);
    }
}
