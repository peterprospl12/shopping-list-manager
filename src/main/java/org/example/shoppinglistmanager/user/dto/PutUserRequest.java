package org.example.shoppinglistmanager.user.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutUserRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birthDate;
}
