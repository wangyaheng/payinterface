package spring.aspect;


import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import spring.dao.FeeFrozenRecordMapper;


import javax.annotation.Resource;


@Aspect
@Component
public class FeeFrozenRecordStatusSendAspect {
	@Resource
	private FeeFrozenRecordMapper feeFrozenRecordMapper;

    @Pointcut("execution(* spring.dao.FeeFrozenRecordMapper.insert*(..)) || execution(* spring.dao.FeeFrozenRecordMapper.update*(..))")
    private void pointCut() {
    }// 请求method前打印内容
   /**
    * 拦截com.pay.promotionFee.core.dao.FeeFrozenRecordDao类所有的insert和update方法
    * 发送冻结记录的创建和状态变更的mq
    * @param pjp 切点
    */
   @Around(value="pointCut()")
    public void doAfter(ProceedingJoinPoint pjp) {
   	try{
   	    // 方法名称
        System.out.println(pjp.getSignature().getName());
        System.out.println(feeFrozenRecordMapper.selectById("BDF8BSVD2LFGUJGM00JG"));
        System.out.println("before===========");
        pjp.proceed();
        System.out.println("after===========");
        System.out.println(feeFrozenRecordMapper.selectById("BDF8BSVD2LFGUJGM00JG"));
    }  catch (Throwable e) {
           //记录本地异常日志
         e.printStackTrace();
       }
   }



}
