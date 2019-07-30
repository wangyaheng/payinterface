package redisutil;

import com.lefu.commons.utils.io.JdkSerializeUtils;

import redisutil.CacheUtils.CacheCallback;

public  class DistributedLock {
		private static Long timeOutValue=5000L;
		public static boolean isHaveLock(final String lockKey){
			Long isLockFlag=setnx(lockKey);
			if(isLockFlag==1){//说明获取到了锁
				return true;
			}else{
				String timeValueStr=(String)JdkSerializeUtils.deserialize(CacheUtils.get(null,JdkSerializeUtils.serialize(lockKey)));
				if(timeValueStr==null){   //说明锁已经被释放
					if(setnx(lockKey)==1) return true;
				}
				//判断是否锁超时
				Long timeValue=Long.valueOf(		timeValueStr 	);
				if(System.currentTimeMillis()-timeValue>timeOutValue){  //加锁时间超过限制，开始重置锁,返回true说明已经获得锁
						return resetLockFlag(Long.valueOf(timeValue),lockKey);
				}

			}
			return false;
		}
		public static boolean resetLockFlag(final Long flagTime,final String lockKey ){
			String timeStampStr=String.valueOf(System.currentTimeMillis());

			String lockOldTime =getSet(lockKey,timeStampStr);
			if(lockOldTime==null) return true;  //为空说明获得锁标记
			else if(Long.valueOf(lockOldTime)==flagTime) return true;  //获取到的值不等于原有get的值，说明锁被别的线程重置
			else	return false;
		}
		public static void delLockFlag(final  String  lockKey ){
			CacheUtils.execute(null, new CacheCallback<Long>() {
				@Override
				public Long doCallback(redisutil.CacheUtils.Redis redis) {

							return redis.del(JdkSerializeUtils.serialize(lockKey));
				}
			});
		}
		public static String getSet(final String lockKey,final String timeStampStr) {
			String timeValueString=CacheUtils.execute(null, new CacheCallback<String>() {
				@Override
				public String doCallback(redisutil.CacheUtils.Redis redis) {
					byte[] result=redis.getSet(JdkSerializeUtils.serialize(lockKey)
										,JdkSerializeUtils.serialize(	timeStampStr)
									);
					if(JdkSerializeUtils.deserialize(result)==null)	   return null;
					else		return 	(String)JdkSerializeUtils.deserialize(result);
				}
			});
			return timeValueString;
		}
		public static Long setnx(final String lockKey){
			return CacheUtils.execute(null, new CacheCallback<Long>() {
				@Override
				public Long doCallback(redisutil.CacheUtils.Redis redis) {

					return redis.setnx(JdkSerializeUtils.serialize(lockKey)
							, JdkSerializeUtils.serialize(String.valueOf(System.currentTimeMillis()))
							);
				}
			});
		}
}
