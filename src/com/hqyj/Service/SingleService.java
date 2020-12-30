package com.hqyj.Service;

import com.hqyj.Dao.SingleDao;
import com.hqyj.entity.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleService {
    @Autowired
    SingleDao singleDao;
    public List<Single> queryTest() {
        return singleDao.queryTest();
    }
}
