package co.jp.pcm.exception;

/**
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException {

	private static final long serialVersionUID = -1028519863112591187L;

	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}