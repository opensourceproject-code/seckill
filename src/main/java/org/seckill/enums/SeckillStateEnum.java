package org.seckill.enums;

/*
* 使用枚举表述常量数据字典
* */
public enum SeckillStateEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;

    private String stateInfo;

    SeckillStateEnum(int state, String stareInfo) {
        this.state = state;
        this.stateInfo = stareInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStateEnum stateOf(int index){
        for(SeckillStateEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
