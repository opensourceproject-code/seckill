package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/*
* 业务接口：站在"使用者"角度设计接口
* 三个方面：方法定义粒度，参数，返回类型(return 类型/异常)
*
* */
public interface SeckillService {

    /*
    * 查询所有秒杀记录
    * */
    List<Seckill> getSeckillList();

    /*
    * 查询单个秒杀记录
    * */
    Seckill getById(long seckillId);

    /*
    * 输出开启时秒杀接口的地址，
    * 否则输出系统时间和秒杀时间
    * 秒杀未开始之前不暴露秒杀地址，防止用户提前进行秒杀
    * */
    Exposer exportSeckillUrl(long seckillId);

    /*
    * 执行秒杀操作,抛出秒杀异常
    * */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    throws SeckillException, RepeatKillException, SeckillCloseException;

    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
