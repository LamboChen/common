package cn.lambochen.common.executor;

import cn.lambochen.common.executor.model.Context;
import cn.lambochen.common.executor.model.Result;
import cn.lambochen.common.executor.model.Type;

/**
 * @author lambochen
 * @date 2022-04-10 23:23
 */
public class NullableExecutor<R extends Result, C extends Context<T>, T extends Type>
        implements Executor<R, C, T> {

    @Override
    public R execute(C context) {
        return (R) Result.NULLABLE;
    }

    @Override
    public T type() {
        return (T) Type.NULLABLE;
    }

}
