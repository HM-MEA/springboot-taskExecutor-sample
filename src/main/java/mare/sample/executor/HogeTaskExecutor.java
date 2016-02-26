package mare.sample.executor;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class HogeTaskExecutor {

    private final SimpleAsyncTaskExecutor executor;

    public HogeTaskExecutor() {
        executor = new SimpleAsyncTaskExecutor();
        executor.setConcurrencyLimit(10);
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }
}
