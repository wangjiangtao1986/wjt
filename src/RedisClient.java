
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClient {

	private static Jedis jedis;// 非切片额客户端连接
	private static JedisPool jedisPool;// 非切片连接池
	private static ShardedJedis shardedJedis;// 切片额客户端连接
	private static ShardedJedisPool shardedJedisPool;// 切片连接池

	public RedisClient() {
		initialPool();
		initialShardedPool();
		shardedJedis = shardedJedisPool.getResource();
		jedis = jedisPool.getResource();

	}

	/**
	 * 初始化非切片池
	 */
	private void initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(20);
		config.setMaxIdle(5);
		config.setMaxWait(1000l);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	}

	/**
	 * 初始化切片池
	 */
	private void initialShardedPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(20);
		config.setMaxIdle(5);
		config.setMaxWait(1000l);
		config.setTestOnBorrow(false);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));

		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}

	public void show() {
		KeyOperate();
		StringOperate();
		ListOperate();
		SetOperate();
		SortedSetOperate();
		HashOperate();
		jedisPool.returnResource(jedis);
		shardedJedisPool.returnResource(shardedJedis);
	}

	private void KeyOperate() {
		// 。。。
	}

	private void StringOperate() {
		// 。。。
	}

	private void ListOperate() {
		// 。。。
	}

	private void SetOperate() {
		// 。。。
	}

	private void SortedSetOperate() {
		// 。。。
	}

	private void HashOperate() {
		// 。。。
	}

	public static void main(String[] args) {
		
		new RedisClient();

		try {
			
			// 向key-->name中放入了value-->minxr
			jedis.set("name", "minxr");
			String ss = jedis.get("name");
			System.out.println(ss);

			// 很直观，类似map 将jintao append到已经有的value之后
			jedis.append("name", "jintao");
			ss = jedis.get("name");
			System.out.println(ss);

			// 2、直接覆盖原来的数据
			jedis.set("name", "jintao");
			System.out.println(jedis.get("name"));

			// 删除key对应的记录
			jedis.del("name");
			System.out.println(jedis.get("name"));// 执行结果：null

			jedis.mset("name", "minxr", "jarorwar", "aaa");
			System.out.println(jedis.mget("name", "jarorwar"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}

	}
	
//	
//
//import redis.clients.jedis.Jedis;
// 
//public class RedisStringJava {
//    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //设置 redis 字符串数据
//        jedis.set("runoobkey", "www.runoob.com");
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
//    }
//}


//import java.util.List;
//import redis.clients.jedis.Jedis;
// 
//public class RedisListJava {
//    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //存储数据到列表中
//        jedis.lpush("site-list", "Runoob");
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Taobao");
//        // 获取存储的数据并输出
//        List<String> list = jedis.lrange("site-list", 0 ,2);
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("列表项为: "+list.get(i));
//        }
//    }
//}


//import java.util.Iterator;
//import java.util.Set;
//import redis.clients.jedis.Jedis;
// 
//public class RedisKeyJava {
//    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
// 
//        // 获取数据并输出
//        Set<String> keys = jedis.keys("*"); 
//        Iterator<String> it=keys.iterator() ;   
//        while(it.hasNext()){   
//            String key = it.next();   
//            System.out.println(key);   
//        }
//    }
//}


}