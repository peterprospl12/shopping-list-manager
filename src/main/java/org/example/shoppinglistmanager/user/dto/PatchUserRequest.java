package org.example.shoppinglistmanager.user.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchUserRequest {
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
}
