package teste.projeto.Control.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teste.projeto.Control.Repository.ItemRepository;
import teste.projeto.Model.Entities.Item;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    @Autowired
    private ItemRepository rep;

    @Transactional(readOnly = true)
    public Item findById(UUID uuid) {
        return rep.getReferenceById(uuid);
    }
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return rep.findAll();
    }

    @Transactional
    public Item deleteById(UUID itemId) {
        Item item = findById(itemId);
        rep.deleteById(itemId);
        return item;
    }

    @Transactional
    public Item save(Item newItem) {
        return rep.save(newItem);
    }

    @Transactional
    public Item update(Item itemUpdated) {
        return rep.save(itemUpdated);
    }
}
