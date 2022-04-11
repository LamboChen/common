package cn.lambochen.common.core.exception;

import lombok.Getter;

/**
 * @author lambochen
 * @date 2022-04-10 22:56
 * <p>
 * business exception
 */
@Getter
public class BizException extends RuntimeException {

    private final String code;

    public BizException(String message) {
        super(message);
        code = null;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        code = null;
    }

    public BizException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BizException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
