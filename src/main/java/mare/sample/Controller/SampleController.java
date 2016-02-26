package mare.sample.Controller;

import mare.sample.executor.HogeTaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Autowired
    HogeTaskExecutor executor;

    @RequestMapping("/")
    @ResponseBody
    String home() {

        for (int i = 0; i < 50; i++) {
            final int n = Integer.valueOf(i);
            Runnable runnable = () -> {
                System.out.printf("task%d Start.........\n", n);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("task%d end.........\n", n);
            };
            executor.execute(runnable);
        }

        return "Hello World!";
    }
}
