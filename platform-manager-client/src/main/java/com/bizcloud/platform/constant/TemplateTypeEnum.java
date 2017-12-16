package com.bizcloud.platform.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by leon on 2017/3/13.
 */
public enum TemplateTypeEnum {
    DISTTRIBUTION_ORDER_PAYED_SUCCESS_NOTICE_TEMPLATE_ID("pay_success","分销订单支付成功通知"),
    DISTTRIBUTION_MEMBER_REGISTER_SUCCESS_NOTICE_TEMPLATE_ID("register_success","分销商有会员注册成功通知"),
    DISTTRIBUTION_ORDER_CHECKOUT_SUCCESS_NOTICE_TEMPLATE_ID("checkout_success","分销订单结算成功通知"),

    ORDER_SEND_GOODS_NOTICE_TEMPLATE_ID("order_send_goods","订单发货通知"),
    ORDER_PAYED_SUCCESS_NOTICE_TEMPLATE_ID("order_send_goods","订单支付成功通知"),

    APPLY_FOR_CASH_TEMPLATE_ID("cash_apply","提现申请通知"),
    RESULT_FOR_CASH_TEMPLATE_ID("cash_result","提现结果通知"),
    FAILED_FOR_CASH_TEMPLATE_ID("cash_failed","提现失败通知"),
    RESULT_FOR_REFUND_TEMPLATE_ID("refund_failed","退款结果通知"),
    REJECTED_FOR_REFUND_TEMPLATE_ID("refund_rejected","退款驳回通知");

    private String value;
    private String desc;

    private TemplateTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static TemplateTypeEnum getByValue(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (TemplateTypeEnum templateTypeEnum : TemplateTypeEnum.values()) {
            if (templateTypeEnum.getValue().equals(value)) {
                return templateTypeEnum;
            }
        }
        return null;
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

    public static String getDescByValue(String value) {
        if(null==value){
            return null;
        }
        TemplateTypeEnum[] values = values();
        TemplateTypeEnum v = null;
        for (int i = 0; i < values.length; i++) {
            if (value.equalsIgnoreCase(values[i].getValue())) {
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
        System.out.println(TemplateTypeEnum.DISTTRIBUTION_ORDER_PAYED_SUCCESS_NOTICE_TEMPLATE_ID.getValue());
    }
}
