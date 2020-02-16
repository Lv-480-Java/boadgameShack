package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.dao.PublishingHouseDao;
import com.softserve.boardgameShack.entity.PublishingHouse;

import java.util.List;

public class PublishingHouseServiceImpl implements PublishingHouseService {

    private final PublishingHouseDao dao = new PublishingHouseDao();

    @Override
    public PublishingHouse getByName(final String name) {
        final List<PublishingHouse> publishingHouseList = dao.getByName(name);
        if (publishingHouseList.size() == 0) {
            throw new IllegalArgumentException("No publishing house with such name length");
        }
        return publishingHouseList.get(0);
    }

    @Override
    public List<PublishingHouse> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(final PublishingHouse model) {
        dao.add(model);
    }
}
