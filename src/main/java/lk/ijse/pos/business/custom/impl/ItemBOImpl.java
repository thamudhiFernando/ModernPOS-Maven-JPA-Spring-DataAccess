package lk.ijse.pos.business.custom.impl;

import lk.ijse.pos.business.custom.ItemBO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemBOImpl implements ItemBO {
    @Autowired
    private ItemDAO itemDAO ;

    public List<ItemDTO> getAllItems() throws Exception {
        List<ItemDTO> items = itemDAO.findAll().stream().map(item -> new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand())).collect(Collectors.toList());
        return items;
    }

    public void saveItem(ItemDTO item) throws Exception {
        itemDAO.save(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
    }

    public void updateItem(ItemDTO item) throws Exception {
        itemDAO.update(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
    }

    public void deleteItem(String code) throws Exception {
        itemDAO.delete(code);
    }

}
