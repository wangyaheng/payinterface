package redisutil;

import redisutil.CacheUtils.CacheCallback;

import com.lefu.commons.utils.io.JdkSerializeUtils;

public class JRTest {

	public static void main(String[] args) {
		System.out.println((String)JdkSerializeUtils.deserialize(CacheUtils.get(null,JdkSerializeUtils.serialize("foo.lock"))));
		CacheUtils.del("REMIT_CMBC_361000_COUNT_TIME");

//		DistributedLock.delLockFlag("REMIT_CMBC_361000_LOCKNAME_COUNT");
//		final String lockKey="";
//		final String timeStampStr=String.valueOf(System.currentTimeMillis());
//		String timeValueString=CacheUtils.execute(null, new CacheCallback<String>() {
//			@Override
//			public String doCallback(redisutil.CacheUtils.Redis redis) {
//				byte[] result=redis.getSet(JdkSerializeUtils.serialize(lockKey)
//									,JdkSerializeUtils.serialize(	timeStampStr)
//								);
//				return null;
//			}
//		});

//		if(DistributedLock.getSet("foo.lock")==null) System.out.println(2);

//		System.out.println(CacheUtils.get("foo.lock", String.class));
//		if((String)JdkSerializeUtils.deserialize(CacheUtils.get(null,JdkSerializeUtils.serialize("foo.lock")))==null)
//		System.out.println(			1);
	}

}
