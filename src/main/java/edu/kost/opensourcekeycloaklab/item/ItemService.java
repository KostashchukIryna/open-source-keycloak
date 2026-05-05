package edu.kost.opensourcekeycloaklab.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Optional<Item> getById(String id) {
        return repository.findById(id);
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Optional<Item> update(Item item) {
        return repository.existsById(item.getId())
                ? Optional.of(repository.save(item))
                : Optional.empty();
    }

    public boolean deleteById(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
