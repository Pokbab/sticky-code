package test.exception;

import lombok.Getter;

import java.util.concurrent.Callable;

@Getter
public enum CommonExceptionCode {

	ASSERT(0, "ASSERT"),

	REST_API_CALL(70000, "REST_API_CALL"),
	REST_API_CALL_ERROR(REST_API_CALL.getCode() + 1, "%s %s"),

	HTTP_STATUS(80000, "HTTP"),
	HTTP_STATUS_400(HTTP_STATUS.getCode() + 400, "400 Bad Parameter. %s"),
	HTTP_STATUS_401(HTTP_STATUS.getCode() + 401, "401 Unauthorized. (%s)"),
	HTTP_STATUS_403(HTTP_STATUS.getCode() + 403, "403 Forbidden. (%s)"),
	HTTP_STATUS_404(HTTP_STATUS.getCode() + 404, "404 Not Found. (%s)"),
	HTTP_STATUS_500(HTTP_STATUS.getCode() + 500, "500 Internal Server Error"),
	HTTP_STATUS_500_INVALID_CHARACTER(HTTP_STATUS.getCode() + 500, "500 Internal Server Error: Invalid Character"),
	HTTP_STATUS_NOT_OK(HTTP_STATUS.getCode() + 1000, "%d Http Status is not 200 OK");

	private int code;
	private String message;

	CommonExceptionCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public CommonException getInstance() {
		return new CommonException(code, message);
	}

	public CommonException getInstance(Exception ex) {
		return new CommonException(code, message, ex);
	}

	public CommonException getInstance(Object... args) {
		return new CommonException(code, String.format(message, args));
	}

	public CommonException getInstance(Exception ex, Object... args) {
		return new CommonException(code, String.format(message, args), ex);
	}

	public Callable<CommonException> getSupplier() {
		return () -> new CommonException(code, message);
	}

	public Callable<CommonException> getSupplier(Exception ex) {
		return () -> new CommonException(code, message, ex);
	}

	public Callable<CommonException> getSupplier(Object... args) {
		return () -> new CommonException(code, String.format(message, args));
	}

	public Callable<CommonException> getSupplier(Exception ex, Object... args) {
		return () -> new CommonException(code, String.format(message, args), ex);
	}

}
