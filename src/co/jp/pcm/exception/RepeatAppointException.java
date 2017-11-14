package co.jp.pcm.exception;

/**
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

	private static final long serialVersionUID = 7181366156720854020L;

	public RepeatAppointException(String message) {
		super(message);
	}

	public RepeatAppointException(String message, Throwable cause) {
		super(message, cause);
	}

}