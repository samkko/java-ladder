package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderUsers {
    private static final String INVALID_RESULT_USER = "참여자에 포함되어 있지 않은 유저입니다.";

    private final List<User> users;

    public LadderUsers(List<User> users) {
        this.users = users;
    }

    public int getUserNumber() {
        return users.size();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public boolean isEqualSize(int size) {
        return users.size() == size;
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    public void validateResultUser(String resultUserName) {
        if (!users.contains(new User(resultUserName))) {
            throw new IllegalArgumentException(INVALID_RESULT_USER);
        }
    }

    public User getUserByIndex(int index) {
        return users.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderUsers)) return false;
        LadderUsers that = (LadderUsers) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
