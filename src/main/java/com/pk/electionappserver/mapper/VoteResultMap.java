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
                0L,
                voteResultDto.getUser(),
                voteResultDto.getElection(),
                voteResultDto.getCandidate(),
                voteResultDto.getLocalDateTime()
        );
    }

    public VoteResultDto mapToVoteResultDto(VoteResult voteResult) {
        return new VoteResultDto(
                voteResult.getUser(),
                voteResult.getElection(),
                voteResult.getCandidate(),
                voteResult.getLocalDateTime()
        );
    }

    public List<VoteResultDto> mapToVoteResultDtoList(List<VoteResult> voteResults) {
        return voteResults.stream()
                .map(voteResult -> new VoteResultDto(
                        voteResult.getUser(),
                        voteResult.getElection(),
                        voteResult.getCandidate(),
                        voteResult.getLocalDateTime()
                ))
                .collect(Collectors.toList());
    }
}
