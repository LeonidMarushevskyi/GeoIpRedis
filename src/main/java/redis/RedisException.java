package redis;


public class RedisException extends Exception {

    private String message;

    public RedisException(String message) {
        this.message = message;
    }

    public RedisException(Throwable throwable) {
        super(throwable);
    }

    public String getMessage() {
        return this.message;
    }

}