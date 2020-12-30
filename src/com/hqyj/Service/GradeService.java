package com.hqyj.Service;

import com.hqyj.Dao.GradeDao;
import com.hqyj.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeDao gradeDao;

    public List<Grade> query() {

        return gradeDao.query();
    }


    public void addGrade(Grade grade) {
        gradeDao.addGrade(grade);
    }
}
