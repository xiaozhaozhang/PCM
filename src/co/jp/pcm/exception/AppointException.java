package co.jp.pcm.exception;


/**
 * 预约未知错误异常
 */
public class AppointException extends RuntimeException {

	private static final long serialVersionUID = -3661773697952437987L;

	public AppointException(String message) {
		super(message);
	}

	public AppointException(String message, Throwable cause) {
		super(message, cause);
	}

}