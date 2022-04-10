package cn.lambochen.common.executor;

import cn.lambochen.common.exception.BizException;
import cn.lambochen.common.executor.model.Context;
import cn.lambochen.common.executor.model.Result;
import cn.lambochen.common.executor.model.Type;

/**
 * @author lambochen
 * @date 2022-04-10 23:05
 */
public interface Executor<R extends Result, C extends Context<T>, T extends Type> {

    default R handle(C context) {
        try {
            preExecute(context);
            R res = execute(context);
            postExecute(context, res);
            return res;
        } catch (Exception cause) {
            return exceptionalHandle(context, cause);
        }
    }

    R execute(C context);

    T type();

    default R exceptionalHandle(C context, Exception cause) {
        if (cause instanceof BizException) {
            throw (BizException) cause;
        }

        throw new BizException(cause.getMessage(), cause);
    }

    default void postExecute(C context, R res) {
    }

    default void preExecute(C context) {
    }

}
