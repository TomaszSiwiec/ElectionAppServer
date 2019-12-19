package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDto {
    private Long id;

    private String title;

    private LocalDateTime date;

    private String description;

    private User reporter;
}
