package com.pk.electionappserver.service;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.Constituency;
import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.ElectionType;
import com.pk.electionappserver.domain.ElectoralParty;
import com.pk.electionappserver.domain.ElectoralProgramme;
import com.pk.electionappserver.domain.EntityNotFoundException;
import com.pk.electionappserver.domain.Report;
import com.pk.electionappserver.domain.User;
import com.pk.electionappserver.domain.VoteResult;
import com.pk.electionappserver.domain.dto.CandidateDto;
import com.pk.electionappserver.domain.dto.ConstituencyDto;
import com.pk.electionappserver.domain.dto.ElectionDto;
import com.pk.electionappserver.domain.dto.ElectionListDto;
import com.pk.electionappserver.domain.dto.ElectionTypeDto;
import com.pk.electionappserver.domain.dto.ElectoralPartyDto;
import com.pk.electionappserver.domain.dto.ElectoralProgrammeDto;
import com.pk.electionappserver.domain.dto.ReportDto;
import com.pk.electionappserver.domain.dto.UserDto;
import com.pk.electionappserver.domain.dto.VoteResultDto;
import com.pk.electionappserver.mapper.CandidateMapper;
import com.pk.electionappserver.mapper.ConstituencyMapper;
import com.pk.electionappserver.mapper.ElectionListMapper;
import com.pk.electionappserver.mapper.ElectionMapper;
import com.pk.electionappserver.mapper.ElectionTypeMapper;
import com.pk.electionappserver.mapper.ElectoralPartyMapper;
import com.pk.electionappserver.mapper.ElectoralProgrammeMapper;
import com.pk.electionappserver.mapper.ReportMapper;
import com.pk.electionappserver.mapper.UserMapper;
import com.pk.electionappserver.mapper.VoteResultMap;
import com.pk.electionappserver.repository.CandidateRepository;
import com.pk.electionappserver.repository.ConstituencyRepository;
import com.pk.electionappserver.repository.ElectionListRepository;
import com.pk.electionappserver.repository.ElectionRepository;
import com.pk.electionappserver.repository.ElectionTypeRepository;
import com.pk.electionappserver.repository.ElectoralPartyRepository;
import com.pk.electionappserver.repository.ElectoralProgrammeRepository;
import com.pk.electionappserver.repository.ReportRepository;
import com.pk.electionappserver.repository.UserRepository;
import com.pk.electionappserver.repository.VoteResultRepository;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ElectionService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private ConstituencyRepository constituencyRepository;

    @Autowired
    private ConstituencyMapper constituencyMapper;

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private ElectionMapper electionMapper;

    @Autowired
    private ElectionListRepository electionListRepository;

    @Autowired
    private ElectionListMapper electionListMapper;

    @Autowired
    private ElectionTypeRepository electionTypeRepository;

    @Autowired
    private ElectionTypeMapper electionTypeMapper;

    @Autowired
    private ElectoralPartyRepository electoralPartyRepository;

    @Autowired
    private ElectoralPartyMapper electoralPartyMapper;

    @Autowired
    private ElectoralProgrammeRepository electoralProgrammeRepository;

    @Autowired
    private ElectoralProgrammeMapper electoralProgrammeMapper;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VoteResultRepository voteResultRepository;

    @Autowired
    private VoteResultMap voteResultMap;

    //Candidate
    public List<CandidateDto> getCandidates() {
        return candidateMapper.mapToCadidateDtoList(candidateRepository.findAll());
    }

    public CandidateDto getCandidate(long id) throws EntityNotFoundException {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return candidateMapper.mapToCandidateDto(candidate);
    }

    public Candidate createCandidate(CandidateDto candidateDto) {
        return candidateRepository.save(candidateMapper.mapToCandidate(candidateDto));
    }

    public void deleteCandidateById(long candidadeId){
        candidateRepository.deleteById(candidadeId);
    }

    //Constituency
    public List<ConstituencyDto> getConstituencies() {
        return constituencyMapper.mapToConstituencyDtoList(constituencyRepository.findAll());
    }

    public ConstituencyDto getConstituency(long id) throws EntityNotFoundException {
        Constituency constituency = constituencyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return constituencyMapper.mapToConstituencyDto(constituency);
    }

    public Constituency createConstituency(ConstituencyDto constituencyDto) {
        return constituencyRepository.save(constituencyMapper.mapToConstituency(constituencyDto));
    }

    public void deleteConstituencyById(long constituencyId) {
        constituencyRepository.deleteById(constituencyId);
    }

    //Election
    public List<ElectionDto> getElections() {
        return electionMapper.mapToElectionDtoList(electionRepository.findAll());
    }

    public ElectionDto getElection(long id) throws EntityNotFoundException {
        Election election = electionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return electionMapper.mapToElectionDto(election);
    }

    public Election createElection(ElectionDto electionDto) {
        return electionRepository.save(electionMapper.mapToElection(electionDto));
    }

    public void deleteElection(long electionId) {
        constituencyRepository.deleteById(electionId);
    }

    //ElectionList
    public List<ElectionListDto> getElectionLists() {
        return electionListMapper.mapToElectionListDtoList(electionListRepository.findAll());
    }

    public ElectionListDto getElectionList(long id) throws EntityNotFoundException {
        ElectionList electionList = electionListRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return electionListMapper.mapToElectionListDto(electionList);
    }

    public ElectionList createElectionList(ElectionListDto electionListDto) {
        return electionListRepository.save(electionListMapper.mapToElectionList(electionListDto));
    }

    public void deleteElectionList(long electionListId) {
        electionListRepository.deleteById(electionListId);
    }

    //ElectionType
    public List<ElectionTypeDto> getElectionTypes() {
        return electionTypeMapper.mapToElectionTypeDtoList(electionTypeRepository.findAll());
    }

    public ElectionTypeDto getElectionType(long id) throws EntityNotFoundException {
        ElectionType electionType = electionTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return electionTypeMapper.mapToElectionTypeDto(electionType);
    }

    public ElectionType createElectionType(ElectionTypeDto electionTypeDto) {
        return electionTypeRepository.save(electionTypeMapper.mapToElectionType(electionTypeDto));
    }

    public void deleteElectionType(long electionTypeId) {
        electionTypeRepository.deleteById(electionTypeId);
    }

    //ElectoralParty
    public List<ElectoralPartyDto> getElectoralParties() {
        return electoralPartyMapper.mapToElectoralPartyDtoList(electoralPartyRepository.findAll());
    }

    public ElectoralPartyDto getElectoralParty(long id) throws EntityNotFoundException {
        ElectoralParty electoralParty = electoralPartyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return electoralPartyMapper.mapToElectoralPartyDto(electoralParty);
    }

    public ElectoralParty createElectoralParty(ElectoralPartyDto electoralPartyDto) {
        return electoralPartyRepository.save(electoralPartyMapper.mapToElectoralParty(electoralPartyDto));
    }

    public void deleteElectoralParty(long electoralPartyId) {
        electoralPartyRepository.deleteById(electoralPartyId);
    }

    //ElectoralProgramme
    public List<ElectoralProgrammeDto> getElectoralProgramms() {
        return electoralProgrammeMapper.mapToElectoralProgrammeDtoList(electoralProgrammeRepository.findAll());
    }

    public ElectoralProgrammeDto getElectoralProgramme(long id) throws EntityNotFoundException {
        ElectoralProgramme electoralProgramme = electoralProgrammeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return electoralProgrammeMapper.mapToElectoralProgrammeDto(electoralProgramme);
    }

    public ElectoralProgramme createElectoralProgramme(ElectoralProgrammeDto electoralProgrammeDto) {
        return electoralProgrammeRepository.save(electoralProgrammeMapper.mapToElectoralProgramme(electoralProgrammeDto));
    }

    public void deleteElectoralProgramme(long electoralProgrammeId) {
        electoralProgrammeRepository.deleteById(electoralProgrammeId);
    }

    //Report
    public List<ReportDto> getReports() {
        return reportMapper.mapToReportDtoList(reportRepository.findAll());
    }

    public List<ReportDto> getReportsByUserId(long userId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        return reportMapper.mapToReportDtoList(user.getReports());
    }

    public ReportDto getReport(long id) throws EntityNotFoundException {
        Report report = reportRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return reportMapper.mapToReportDto(report);
    }

    public Report createReport(ReportDto reportDto) {
        return reportRepository.save(reportMapper.mapToReport(reportDto));
    }

    public void deleteReport(long reportId) {
        reportRepository.deleteById(reportId);
    }

    //User
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userRepository.findAll());
    }

    public UserDto getUser(long id) throws EntityNotFoundException {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return userMapper.mapToUserDto(user);
    }

    public User createUser(UserDto userDto) {
        return userRepository.save(userMapper.mapToUser(userDto));
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    //VoteResult
    public List<VoteResultDto> getVoteResults() {
        return voteResultMap.mapToVoteResultDtoList(voteResultRepository.findAll());
    }

    public VoteResultDto getVoteResult(long id) throws EntityNotFoundException {
        VoteResult voteResult = voteResultRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return voteResultMap.mapToVoteResultDto(voteResult);
    }

    public VoteResult createVoteResult(VoteResultDto voteResultDto) {
        return voteResultRepository.save(voteResultMap.mapToVoteResult(voteResultDto));
    }

    public void deleteVoteResult(long voteResultId) {
        voteResultRepository.deleteById(voteResultId);
    }
}
