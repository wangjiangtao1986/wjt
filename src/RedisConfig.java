public class RedisConfig {

    private int maxActive;
    private int maxWait;
    private int maxidle;
    private boolean testOnBorrow;
    private boolean testOnReturn;  
    private int timeout;
    private int retryNum;
    
    
	public int getRetryNum() {
		return retryNum;
	}
	public void setRetryNum(int retryNum) {
		this.retryNum = retryNum;
	}
	public int getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getMaxidle() {
		return maxidle;
	}
	public void setMaxidle(int maxidle) {
		this.maxidle = maxidle;
	}
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}  
}