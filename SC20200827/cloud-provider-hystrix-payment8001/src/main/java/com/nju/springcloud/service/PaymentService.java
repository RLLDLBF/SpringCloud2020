package com.nju.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池： "+ Thread.currentThread().getName()+" payment_OK, id: "+id+"\t"+"bingo";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_Timeout(Integer id){
        //超时
//        int timeNumber = 5;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        return "线程池： "+ Thread.currentThread().getName()+" payment_Timeout, id: "+id+"\t"+"耗时: "+timeNumber+"s";


        //计算异常
        int age = 10/0;
        return "线程池： "+ Thread.currentThread().getName()+" payment_Timeout, id: "+id+"\t";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池： "+ Thread.currentThread().getName()+" paymentInfo_TimeoutHandler, id: "+id+"\t"+"Shit!";
    }
}


