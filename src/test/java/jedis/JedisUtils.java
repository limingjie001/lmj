package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @ClassName JedisUtils
 * @Date 2021/4/24 13:04
 * @Author 李明杰
 * @Description jedis连接池
 */

public class JedisUtils {
    private static JedisPool jp;
    private static String host;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(maxTotal);
        jpc.setMaxIdle(maxIdle);
        jp = new JedisPool(jpc, host, port);
    }

    public static Jedis getJedis() {
        return jp.getResource();
    }

    public static void main(String[] args) {
        JedisTest test = new JedisTest();
        test.zset(getJedis());

    }
}
