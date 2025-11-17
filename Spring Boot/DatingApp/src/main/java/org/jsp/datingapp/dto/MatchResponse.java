package org.jsp.datingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchResponse {
    private int userId;
    private String name;
    private int age;
}
