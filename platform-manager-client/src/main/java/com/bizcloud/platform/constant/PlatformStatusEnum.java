package com.bizcloud.platform.constant;

/**
 * Created by leon on 2017/3/13.
 */
public enum PlatformStatusEnum {
    ENABLE("0","可用"),
    DISABLED("1","不可用");

    private String value;
    private String desc;

    private PlatformStatusEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByCode(String code) {
        if(null==code){
            return null;
        }
        PlatformStatusEnum[] values = values();
        PlatformStatusEnum v = null;
        for (int i = 0; i < values.length; i++) {
            if (code.equalsIgnoreCase(values[i].getValue())) {
                v = values[i];
                break;
            }
        }
        if (v == null) {
            return null;
        }
        return v.getDesc();
    }

    @Override
    public String toString() {
        return "["+name() + "]"+value+":" + desc;
    }

    public static void main(String[] args) {
        System.out.println(PlatformStatusEnum.DISABLED.getValue());
    }
}
