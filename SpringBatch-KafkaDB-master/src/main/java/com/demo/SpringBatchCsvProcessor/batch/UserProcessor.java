package com.demo.SpringBatchCsvProcessor.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.demo.SpringBatchCsvProcessor.model.User;

import java.util.Date;

@Component
public class UserProcessor implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
		user.setId(1L);
		user.setDate(new Date());
		return user;
	}
}
