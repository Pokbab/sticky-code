package test.lib;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaCacheTest {

    private static final int NUMBER_OF_THREADS = 100;

    @Test
    public void testCacheLoader() throws InterruptedException {
        CacheLoader<String, String> loader = new CacheLoader<>() {
            @SneakyThrows
            @Override
            public String load(String key) {
                log.debug("캐시 생성시작");
                Thread.sleep(3000);
                log.debug("캐시 생성완료");
                return key.toUpperCase();
            }
        };

        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.HOURS)
            .build(loader);

        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);

        log.debug("시작");
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            service.execute(() -> {
                String value = cache.getUnchecked("hello");
                latch.countDown();
                log.debug(value);
            });
        }
        log.debug("완료");

        latch.await();
        assertEquals(1, cache.size());
        assertNotNull(cache.getIfPresent("hello"));
    }

}
