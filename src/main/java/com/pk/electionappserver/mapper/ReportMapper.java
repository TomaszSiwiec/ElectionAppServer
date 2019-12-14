package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Report;
import com.pk.electionappserver.domain.dto.ReportDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {
    public Report mapToReport(ReportDto reportDto) {
        return new Report(
                0L,
                reportDto.getTitle(),
                reportDto.getDate(),
                reportDto.getDescription()
        );
    }

    public ReportDto mapToReportDto(Report report) {
        return new ReportDto(
                report.getTitle(),
                report.getDate(),
                report.getDescription()
        );
    }

    public List<ReportDto> mapToReportDtoList(List<Report> reports) {
        return reports.stream()
                .map(report -> new ReportDto(
                        report.getTitle(),
                        report.getDate(),
                        report.getDescription()
                ))
                .collect(Collectors.toList());
    }
}
