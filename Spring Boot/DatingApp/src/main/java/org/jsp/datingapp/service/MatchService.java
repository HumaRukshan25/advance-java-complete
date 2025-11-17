package org.jsp.datingapp.service;


import org.jsp.datingapp.dao.UserDao;
import org.jsp.datingapp.dto.MatchResponse;
import org.jsp.datingapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class MatchService {

	@Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public User getUserById(int id) {
        return userDao.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

    public List<MatchResponse> findMatches(int userId, int topN) {
        User user = userDao.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));

        return userDao.findAll().stream()
                .filter(u -> u.getId() != user.getId())  // ✅ FIXED
                .map(match -> new AbstractMap.SimpleEntry<>(match, calculateScore(user, match)))
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(topN)
                .map(entry -> {
                    User matched = entry.getKey();
                    return new MatchResponse(matched.getId(), matched.getName(), matched.getAge());
                })
                .collect(Collectors.toList());

    }

    private int calculateScore(User source, User candidate) {
        int score = 0;

        if (candidate.getGender() == source.getInterestedIn()) {
            score += 1000;
        }

        score += 100 - Math.abs(source.getAge() - candidate.getAge());

        long common = source.getInterests().stream()
                .filter(candidate.getInterests()::contains)
                .count();
        score += common * 10;

        return score;
    }
}
