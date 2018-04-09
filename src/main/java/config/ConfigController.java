package config;

import Constants.StudyConstant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hejun on 2018/2/2.
 */
@RequestMapping("config")
@RestController
public class ConfigController {
    @RequestMapping("/volatile/visibility/{flag}")
    public String configVisibility(@PathVariable("flag") String flag){
        if("1".equals(flag)){
            StudyConstant.visibility = false;
        }
        return "success";
    }
}
