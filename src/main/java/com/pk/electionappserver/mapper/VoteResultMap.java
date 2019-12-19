package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.VoteResult;
import com.pk.electionappserver.domain.dto.VoteResultDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VoteResultMap {
    public VoteResult mapToVoteResult(VoteResultDto voteResultDto) {
        return new VoteResult(
                voteResultDto.getId(),
                voteResultDto.getUser(),
                voteResultDto.getElection(),
                voteResultDto.getCandidate(),
                voteResultDto.getVoteTime()
        );
    }

    public VoteResultDto mapToVoteResultDto(VoteResult voteResult) {
        return new VoteResultDto(
                voteResult.getId(),
                voteResult.getUser(),
                voteResult.getElection(),
                voteResult.getCandidate(),
                voteResult.getVoteTime()
        );
    }

    public List<VoteResultDto> mapToVoteResultDtoList(List<VoteResult> voteResults) {
        return voteResults.stream()
                .map(voteResult -> mapToVoteResultDto(voteResult))
                .collect(Collectors.toList());
    }
}
