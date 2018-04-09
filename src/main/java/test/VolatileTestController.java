package test;

import Constants.StudyConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.ThreadUtils;

/**
 * Created by hejun on 2018/2/2.
 */
@RestController
@RequestMapping("/volatile")
public class VolatileTestController {
    @RequestMapping("/test/visibility")
    public String testVisibility() throws InterruptedException {
        while(StudyConstant.visibility){
            System.out.println("visibility is true");
            Thread.sleep(1000);
        }
        System.out.println("out");
        return "over";
    }
}
