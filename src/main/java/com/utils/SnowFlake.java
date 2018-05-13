package com.utils;


/**
 * SnowFlake算法生成全局唯一ID
 */
public class SnowFlake {
    //初始时间值(2017-01-01)
    public static final long INITIAL_TIME_STAMP = 1483200000000L;
    //机器ID所占的位数
    public static final long WORKER_ID_BITS = 5L;
    //数据标识ID所占的位数
    public static final long DATACENTER_ID_BITS = 5L;
    //支持最大机器ID,结果31
    public static final long MAX_WORKER_ID = ~(-1L<<WORKER_ID_BITS);
    //支持最大数据表示ID,结果31
    public static final long MAX_DATACENTER_ID = ~(-1L<<DATACENTER_ID_BITS);
    //序列在ID中的占位
    public static final long SEQUENSE_BITS = 12L;
    //机器ID的偏移量(12)
    public static final long WORKERID_OFFSET = SEQUENSE_BITS;
    //数据中心ID偏移量(12+5)
    public static final long DATACENTERID_OFFSET = SEQUENSE_BITS+SEQUENSE_BITS;
    //时间偏移量(5+5+12)
    public static final long TIMESTAMP_OFFSET = SEQUENSE_BITS+WORKER_ID_BITS+DATACENTER_ID_BITS;
    //生成序列的掩码,这里为4095(0b111111111111=0xfff=4095)
    public static final long  SEQUENCE_MASK = ~(-1L<<SEQUENSE_BITS);
    //工作节点ID(0~31)
    public long workerId;
    //数据中心ID(0~31)
    public long datacenterId;
    //毫秒内序列(0~4095)
    public long sequence = 0L;
    //上次生成ID的时间戳
    public long lastTimestamp = -1L;

    /**
     *
     * @param workerId
     * @param datacenterId
     */
    public SnowFlake(long workerId,long datacenterId){
        if(workerId > MAX_WORKER_ID || workerId < 0){
            throw new IllegalArgumentException(String.format("WorkerId 不能大于%d 或小于0",MAX_WORKER_ID));

        }
        if(datacenterId > MAX_DATACENTER_ID || datacenterId < 0){
            throw new IllegalArgumentException(String.format("DataCenterID 不能大于%d或小于0",MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId(){
        long timestamp = System.currentTimeMillis();
        if(timestamp < lastTimestamp){
            throw new RuntimeException("当前时间小于上一次记录的时间戳");
        }
        if(lastTimestamp == timestamp){
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if(sequence == 0){
                //获取新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        //时间戳改变,毫秒内序列重置
        }else {
           sequence = 0L;
        }
        lastTimestamp = timestamp;
        return ((timestamp - INITIAL_TIME_STAMP) << TIMESTAMP_OFFSET)
                | (datacenterId << DATACENTERID_OFFSET)
                | (workerId << WORKERID_OFFSET)
                | sequence;
    }

    /**
     * 获取新的时间戳
     * @param lastTimestamp
     * @return timestamp
     */

    protected long tilNextMillis(long lastTimestamp){
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp){
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }


}

