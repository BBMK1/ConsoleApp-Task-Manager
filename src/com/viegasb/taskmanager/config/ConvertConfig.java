package com.viegasb.taskmanager.config;

import com.viegasb.taskmanager.models.Task;

public class ConvertConfig {
	public static String convertToArray(Task[] tasks) {
		StringBuilder builder = new StringBuilder();

		System.out.println();
		for (Task task : tasks)
			builder.append(task);

		return builder
				.toString();
	}
}