package com.viegasb.taskmanager.config;

import java.util.Collection;

import com.viegasb.taskmanager.models.Task;

public class ConvertConfig {
	public static String convertToCollections(Collection<Task> tasks) {
		StringBuilder builder = new StringBuilder();

		tasks.stream()
			.forEach(items -> {
				builder.append(items);
			});

		return builder
				.toString();
	}
}