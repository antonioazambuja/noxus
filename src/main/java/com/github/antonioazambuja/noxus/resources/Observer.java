package com.github.antonioazambuja.noxus.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Observer {
	@JsonProperty("encryptionKey")
	private String EncryptionKey;

	public Observer(String encryptionKey) {
		EncryptionKey = encryptionKey;
	}

	public Observer() {}

	public String getEncryptionKey() {
		return EncryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		EncryptionKey = encryptionKey;
	}
}
