package com.epam.transporter.dao;

import com.epam.transporter.entity.Goods;

public interface GoodsDao {
    Goods findById(long id);

    Goods findByName(String name);

    Goods insert(Goods goods);

    boolean removeById(long id);
}
