package com.demo.SpringBatchCsvProcessor.model;


import java.io.IOException;

import org.apache.kafka.common.errors.SerializationException;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class UserJsonSerializer  extends JsonSerializer<User>{
	
	@Override
	public byte[] serialize(String topic, User data) {
		if (data == null) {
			return null;
		}
		try {
			byte[] result = null;
			if (data != null) {
				result = this.objectMapper.writeValueAsBytes(data);
			}
			return result;
		}
		catch (IOException ex) {
			throw new SerializationException("Can't serialize data [" + data + "] for topic [" + topic + "]", ex);
		}
	}
}
