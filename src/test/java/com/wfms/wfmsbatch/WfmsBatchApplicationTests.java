package com.wfms.wfmsbatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(properties = {"spring.config.location=classpath:application.yml"})
@ExtendWith(SpringExtension.class)
class WfmsBatchApplicationTests {
//    @Autowired
//    private DbOne dbOne;
//
//    @Autowired
//    private DbTwo dbTwo;
//
//    @Autowired
//    private DbThree dbThree;
//
//    @Test
//    void testMain() {
//        dbOne.getTests();
//        dbTwo.getTestSecs();
//        dbThree.getTestThirs();
//    }

}
