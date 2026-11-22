package ro.uvt.info.designpatternslab2026.commands;

public record AsyncRequestStatus<T>(
        String requestId,
        String status,
        T result,
        String error
) {
    public static <T> AsyncRequestStatus<T> pending(String requestId) {
        return new AsyncRequestStatus<>(requestId, "PENDING", null, null);
    }

    public static <T> AsyncRequestStatus<T> completed(String requestId, T result) {
        return new AsyncRequestStatus<>(requestId, "COMPLETED", result, null);
    }

    public static <T> AsyncRequestStatus<T> failed(String requestId, String error) {
        return new AsyncRequestStatus<>(requestId, "FAILED", null, error);
    }
}
