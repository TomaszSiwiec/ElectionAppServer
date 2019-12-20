package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Report;
import com.pk.electionappserver.domain.dto.ReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {

    @Autowired
    private UserMapper userMapper;

    public Report mapToReport(ReportDto reportDto) {
        return new Report(
                reportDto.getId(),
                reportDto.getTitle(),
                reportDto.getDate(),
                reportDto.getDescription(),
                userMapper.mapToUser(reportDto.getReporter())
        );
    }

    public ReportDto mapToReportDto(Report report) {
        return new ReportDto(
                report.getId(),
                report.getTitle(),
                report.getDate(),
                report.getDescription(),
                userMapper.mapToUserDto(report.getReporter())
        );
    }

    public List<ReportDto> mapToReportDtoList(List<Report> reports) {
        return reports.stream()
                .map(report -> mapToReportDto(report))
                .collect(Collectors.toList());
    }

    public List<Report> mapToReportList(List<ReportDto> reports) {
        return reports.stream()
                .map(report -> mapToReport(report))
                .collect(Collectors.toList());
    }
}
