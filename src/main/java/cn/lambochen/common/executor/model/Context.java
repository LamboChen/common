package cn.lambochen.common.executor.model;

import java.io.Serializable;

/**
 * @author lambochen
 * @date 2022-04-10 23:05
 * <p>
 * executor context
 */
public interface Context<T extends Type>
        extends Serializable {

    /**
     * type for executor
     *
     * @return executor type
     */
    T type();

    /**
     * default context
     */
    Context<Type> NULLABLE = () -> Type.NULLABLE;
}
