package cn.lambochen.common.executor;

import cn.lambochen.common.executor.model.Context;
import cn.lambochen.common.executor.model.Result;
import cn.lambochen.common.executor.model.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author lambochen
 * @date 2022-04-10 23:22
 */
public abstract class ExecutorHolder<R extends Result, C extends Context<T>, T extends Type> {

    protected Map<T, Executor<R, C, T>> executorContainer = new HashMap<>();
    protected NullableExecutor<R, C, T> nullableExecutor = new NullableExecutor<>();

    public R handle(C context) {
        return Optional.ofNullable(executorContainer.get(context.type()))
                .orElse(nullableExecutor)
                .handle(context);
    }

    protected void register(Executor<R, C, T> executor) {
        if (null == executor) {
            return;
        }

        if (executor instanceof NullableExecutor) {
            this.nullableExecutor = (NullableExecutor<R, C, T>) executor;
            return;
        }

        executorContainer.put(executor.type(), executor);
    }

}
