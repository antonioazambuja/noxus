package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
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
