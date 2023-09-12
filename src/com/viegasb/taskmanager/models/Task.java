package com.viegasb.taskmanager.models;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	private String description;
	private String category;
	private LocalDate createdAt;

	public Task(String description, String category) {
		this.description = description;
		this.category = category;
		this.createdAt = LocalDate.now();
	}

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getCategory() { return category; }

	public void setCategory(String category) { this.category = category; }

	public LocalDate getCreatedAt() { return createdAt; }

	@Override
	public int hashCode() { return Objects.hash(category, createdAt, description); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Task other = (Task) obj;
		return Objects.equals(category, other.category)
				&& Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(description, other.description);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("User-Profile ")
				.append("[")
				.append(String.format("Description: %s, ", description))
				.append(String.format("Category: %s, ", category))
				.append(String.format("Created-At: %s", createdAt))
				.append("]")
				.toString();
	}
}