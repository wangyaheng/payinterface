package redisutil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redisutil.CacheUtils.CacheCallback;

import com.lefu.commons.cache.util.CacheUtils.Redis;

public class RedisUtilTest {

	public static void main(String[] args) {

//		CacheUtils.setEx("CACHE_KEY_INTERFACE_REQUEST_INTERFACE_REQUEST_ID" + "payinterface-test", "11111", 7200, false);
//		System.out.println(CacheUtils.get("CACHE_KEY_INTERFACE_REQUEST_INTERFACE_REQUEST_ID" + "payinterface-test",String.class));
//		Redis redis=new Redis(Jedis);
		Long i=CacheUtils.execute(null, new CacheCallback<Long>() {
			@Override
			public Long doCallback(redisutil.CacheUtils.Redis redis) {
				return redis.setnx("foo.lock", String.valueOf(System.currentTimeMillis()));

			}

		});

		System.out.println("---"+CacheUtils.get("REMIT_CMBC_361000_LOCKNAME",String.class));
		DistributedLock.isHaveLock("foo.lock");
	}


}
