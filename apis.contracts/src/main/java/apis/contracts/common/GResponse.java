package apis.contracts.common;


public class GResponse<T> {

    private boolean success;
    private String message;
    private T data;

    // Constructors
    public GResponse() {}

    public GResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Static factory methods
    public static <T> GResponse<T> ok(T data) {
        return new GResponse<>(true, "Success", data);
    }

    public static <T> GResponse<T> fail(String message) {
        return new GResponse<>(false, message, null);
    }

    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}