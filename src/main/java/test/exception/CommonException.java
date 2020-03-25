package test.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

	private static final long serialVersionUID = -823166844470942984L;

	private final int code;

	public CommonException(int code, String message, Exception ex) {
		super(message, ex);
		this.code = code;
	}

	public CommonException(int code, String message) {
		super(message);
		this.code = code;
	}

}