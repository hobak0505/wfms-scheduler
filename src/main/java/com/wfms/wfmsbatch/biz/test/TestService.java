package com.wfms.wfmsbatch.biz.test;

import com.wfms.wfmsbatch.mapper.maria.test.DbThree;
import com.wfms.wfmsbatch.mapper.mysql.test.DbTwo;
import com.wfms.wfmsbatch.mapper.oracle.test.DbOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private DbOne dbOne;
    @Autowired
    private DbTwo dbTwo;
    @Autowired
    private DbThree dbThree;

    @Scheduled(cron = "${scheduling.cron.test}") // 초 분 시 일 월 요일 년도
    public void testSchedule() {
        dbOne.getTests().forEach(o -> {
            System.out.println("db첫번째 : " + o.getTest());
        });
        dbTwo.getTestSecs().forEach(o -> {
            System.out.println("db두번째 : " + o.getTest());
        });
        dbThree.getTestThirs().forEach(o -> {
            System.out.println("db세번째 : " + o.getTest());
        });
    }
}
