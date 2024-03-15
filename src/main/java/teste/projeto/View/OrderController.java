package teste.projeto.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.projeto.Control.Repository.OrderRepository;
import teste.projeto.Control.Service.ItemService;
import teste.projeto.Control.Service.OrderService;
import teste.projeto.Model.Entities.Item;
import teste.projeto.Model.Entities.Order;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping(value = "/list")
    @ResponseBody
    List<Order> list(){
        return service.findAll();
    }

    @GetMapping(value = "/read")
    @ResponseBody
    Order read(@RequestParam("uuid") UUID uuid){
        return service.findById(uuid);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    Order delete(@RequestParam("uuid") UUID uuid){
        return service.deleteById(uuid);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    Order update(@RequestBody Order orderUpdated){
        return service.update(orderUpdated);
    }

    @PostMapping("/create")
    @ResponseBody
    Order save(@RequestBody Order newOrder){
        return service.save(newOrder);
    }
}
