package spring.controller;

import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import spring.utils.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
      /*  try {
            SphU.entry("HelloWorld");
        } catch (BlockException e) {
            e.printStackTrace();
        }*/
        System.out.println("test"+name);
        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        TestController testController = (TestController)applicationContext.getBean("testController");
        System.out.println(testController);
        return "hello world";
    }
}
