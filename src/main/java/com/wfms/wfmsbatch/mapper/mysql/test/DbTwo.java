package com.wfms.wfmsbatch.mapper.mysql.test;

import com.wfms.wfmsbatch.biz.test.domain.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbTwo {
    List<TestDTO> getTestSecs();
}
