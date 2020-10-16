package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class RiotURI {

	private UriComponentsBuilder RiotURL;

	public RiotURI() {}

	public RiotURI(String riotURL) {
		RiotURL = UriComponentsBuilder.fromHttpUrl(riotURL);
	}

	public RiotURI setStringQueryParam(String key, String value) {
		this.RiotURL.queryParam(key, value);
		return this;
	}

	public RiotURI setIterableQueryParam(String key, Iterable<?> value) {
		value.forEach(item -> {
			this.RiotURL.queryParam(key, item);
		});
		return this;
	}

	public UriComponentsBuilder getRiotURL() {
		return RiotURL;
	}

	public RiotURI setRiotURL(UriComponentsBuilder riotURL) {
		RiotURL = riotURL;
		return this;
	}
}
