package com.viegasb.taskmanager.models;

import java.time.LocalDate;
import java.util.Objects;

public class Account {
	private String email;
	private String password;
	private LocalDate createdAt;

	private UserProfile userProfile;

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
		this.createdAt = LocalDate.now();
	}

	public String getEmail() { return email; }

	public String getPassword() { return password; }

	public LocalDate getCreatedAt() { return createdAt; }

	public void setEmail(String email) { this.email = email; }

	public void setPassword(String password) { this.password = password; }

	public UserProfile getUserProfile() { return userProfile; }

	public void setUserProfile(UserProfile userProfile) { this.userProfile = userProfile; }

	@Override
	public int hashCode() { return Objects.hash(createdAt, email, password); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Account other = (Account) obj;
		return Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(email, other.email)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Account ")
				.append("[")
				.append(String.format("Email: %s, ", email))
				.append(String.format("Password: %s, ", password))
				.append(String.format("Created-At: %s, ", createdAt))
				.append(userProfile)
				.append("]")
				.toString();
	}

}