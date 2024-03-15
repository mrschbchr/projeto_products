package teste.projeto.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.projeto.Control.Repository.ItemRepository;
import teste.projeto.Control.Service.ItemService;
import teste.projeto.Model.Entities.Item;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping(value = "/list")
    @ResponseBody
    List<Item> list(){
        return service.findAll();
    }

    @GetMapping(value = "/read")
    @ResponseBody
    Item read(@RequestParam("uuid") UUID uuid){
        return service.findById(uuid);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    Item delete(@RequestParam("uuid") UUID uuid){
        return service.deleteById(uuid);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    Item update(@RequestBody Item itemUpdated){
        return service.update(itemUpdated);
    }

    @PostMapping("/create")
    @ResponseBody
    Item save (@RequestBody Item newItem){
        return service.save(newItem);
    }
}
