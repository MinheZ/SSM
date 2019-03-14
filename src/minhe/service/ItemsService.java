package minhe.service;

import minhe.pojo.Items;

import java.util.List;

public interface ItemsService {

    List<Items> list();

    Items findItemById(Integer id);

    void updateItem(Items items);
}
