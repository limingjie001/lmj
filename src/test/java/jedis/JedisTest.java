package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassName JedisTest
 * @Date 2021/4/24 11:34
 * @Author 李明杰
 * @Description 测试连接redis
 */

public class JedisTest {
    public static void zset(Jedis jedis) {
        jedis.zadd("zsetTest", 99, "Mr1");
        jedis.zadd("zsetTest", 100, "Ms2");
        System.out.println(jedis.zrange("zsetTest", 0, -1));
        jedis.del("zsetTest");
    }

    public static void listAdd(Jedis jedis) {

        System.out.println();
    }

    @Test
    public void main() {
//        连接
        Jedis jedis = new Jedis("localhost", 6379);
//        操作
        this.zset(jedis);
//        关闭
        jedis.close();
    }
}
