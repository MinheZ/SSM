package minhe.service;

import minhe.dao.ItemsMapper;
import minhe.pojo.Items;
import minhe.pojo.ItemsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "itemsService")
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> list() {

        ItemsExample itemsExample = new ItemsExample();
        List<Items> items = itemsMapper.selectByExampleWithBLOBs(itemsExample);
        return items;
    }

    @Override
    public Items findItemById(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItem(Items items) {
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
