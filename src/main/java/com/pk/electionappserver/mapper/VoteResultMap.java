package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.VoteResult;
import com.pk.electionappserver.domain.dto.VoteResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VoteResultMap {

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private ElectionMapper electionMapper;

    @Autowired
    private UserMapper userMapper;

    public VoteResult mapToVoteResult(VoteResultDto voteResultDto) {
        return new VoteResult(
                voteResultDto.getId(),
                userMapper.mapToUser(voteResultDto.getUser()),
                electionMapper.mapToElection(voteResultDto.getElection()),
                candidateMapper.mapToCadidateList(voteResultDto.getCandidates()),
                voteResultDto.getVoteTime()
        );
    }

    public VoteResultDto mapToVoteResultDto(VoteResult voteResult) {
        return new VoteResultDto(
                voteResult.getId(),
                userMapper.mapToUserDto(voteResult.getUser()),
                electionMapper.mapToElectionDto(voteResult.getElection()),
                candidateMapper.mapToCadidateDtoList(voteResult.getCandidates()),
                voteResult.getVoteTime()
        );
    }

    public List<VoteResultDto> mapToVoteResultDtoList(List<VoteResult> voteResults) {
        return voteResults.stream()
                .map(voteResult -> mapToVoteResultDto(voteResult))
                .collect(Collectors.toList());
    }

    public List<VoteResult> mapToVoteResultList(List<VoteResultDto> voteResults) {
        return voteResults.stream()
                .map(voteResult -> mapToVoteResult(voteResult))
                .collect(Collectors.toList());
    }
}
