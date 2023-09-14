package com.viegasb.taskmanager.models;

import java.time.LocalDate;
import java.util.Objects;

import com.viegasb.taskmanager.models.pk.BaseEntity;

public class Task extends BaseEntity {
	private String description;
	private String category;
	private LocalDate createdAt;

	private UserProfile userProfile;

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

	public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

	public UserProfile getUserProfile() { return userProfile; }

	public void setUserProfile(UserProfile userProfile) { this.userProfile = userProfile; }
	
	public Integer getId() { return getId(); }

	@Override
	public int hashCode() { return Objects.hash(getId(), category, createdAt, description); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Task other = (Task) obj;
		return Objects.equals(category, other.category)
				&& Objects.equals(getId(), other.getId())
				&& Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(description, other.description);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Task ")
				.append("[")
				.append(String.format("Id: %s, ", getId()))
				.append(String.format("Description: %s, ", description))
				.append(String.format("Category: %s, ", category))
				.append(String.format("Created-At: %s", createdAt))
				.append("]\n")
				.toString();
	}
}