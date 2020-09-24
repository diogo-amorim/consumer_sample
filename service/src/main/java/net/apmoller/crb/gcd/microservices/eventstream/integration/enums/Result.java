package net.apmoller.crb.gcd.microservices.eventstream.integration.enums;

public enum Result {
	
	PROCESSED(1), FAILED(2);
	
	private int num;
	
	Result(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}
}
