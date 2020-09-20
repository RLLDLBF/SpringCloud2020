package com.nju.springcloud.service;

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
        return "线程池： "+ Thread.currentThread().getName()+" payment_OK, id: "+"\t"+"bingo";
    }

    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池： "+ Thread.currentThread().getName()+" payment_Timeout, id: "+"\t"+"耗时: "+timeNumber+"s";
    }
}


