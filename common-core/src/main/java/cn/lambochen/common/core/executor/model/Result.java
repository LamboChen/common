package cn.lambochen.common.core.executor.model;

import java.io.Serializable;

/**
 * @author lambochen
 * @date 2022-04-10 23:10
 */
public interface Result extends Serializable {

    /**
     * default result
     */
    Result NULLABLE = new Result() {
    };

}
