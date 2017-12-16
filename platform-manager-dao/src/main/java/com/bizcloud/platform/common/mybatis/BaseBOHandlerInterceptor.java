package com.bizcloud.platform.common.mybatis;

import com.bizcloud.framework.util.DateUtil;
import com.bizcloud.platform.common.base.BaseBO;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * BaseBO子类拦截处理，在insert和update时自动处理createTime和modifiedTime
 *
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class BaseBOHandlerInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        if (args[1] instanceof BaseBO) {
            BaseBO baseBO = (BaseBO) args[1];
            if (SqlCommandType.INSERT.equals(sqlCommandType)) {
//				baseBO.setId(); // TODO auto gen ID
                if (baseBO.getCreatedTime() == null) {
                    baseBO.setCreatedTime(DateUtil.currDate());
                }
                if (baseBO.getModifiedTime() == null) {
                    baseBO.setModifiedTime(DateUtil.currDate());
                }
            } else if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
                if (baseBO.getModifiedTime() == null) {
                    baseBO.setModifiedTime(DateUtil.currDate());
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}