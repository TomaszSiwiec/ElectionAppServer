package com.pk.electionappserver.service;

import com.pk.electionappserver.domain.*;
import com.pk.electionappserver.domain.dto.*;
import com.pk.electionappserver.mapper.*;
import com.pk.electionappserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private CityRepository cityRepository;

    @Autowired
    private ElectoralPartyMapper electoralPartyMapper;

    @Autowired
    private ElectoralProgrammeRepository electoralProgrammeRepository;

    @Autowired
    private ElectoralProgrammeMapper electoralProgrammeMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VoteResultRepository voteResultRepository;

    @Autowired
    private VoteResultMap voteResultMap;

    @Autowired
    private CityMapper cityMapper;

    //Candidate
    public List<CandidateDto> getCandidates() {
        return candidateMapper.mapToCadidateDtoList(candidateRepository.findAll());
    }

    public List<CandidateDto> getCandidatesByParty(long electoralPartyId) throws EntityNotFoundException {
        ElectoralParty electoralParty = electoralPartyRepository.findById(electoralPartyId).orElseThrow(EntityNotFoundException::new);
        List<Candidate> candidates = candidateRepository.findAll().stream()
                .filter(o -> o.getElectoralParty().getId().equals(electoralParty.getId()))
                .collect(Collectors.toList());
        return candidateMapper.mapToCadidateDtoList(candidates);
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

    public List<CandidateDto> getCandidateByElectionListElectoralParty(long electoralPartyId) {
        List<ElectionList> electionLists = electionListRepository.findAll();
        List<Candidate> temp = new ArrayList<>();
        for (ElectionList e : electionLists) {
            if (e.getElectoralParty().getId().equals(electoralPartyId))
                temp = e.getCandidates();
        }
        return candidateMapper.mapToCadidateDtoList(temp);
    }

    public List<CandidateDto> getCandidatesElection(long constituencyId, long electoralPartyId) throws EntityNotFoundException {
        List<Candidate> candidates = new ArrayList<>();
        List<Constituency> constituencies = constituencyRepository.findAll();
        ElectoralParty electoralParty = electoralPartyRepository.findById(electoralPartyId).orElseThrow(EntityNotFoundException::new);
        for (Constituency c : constituencies) {
            if (c.getId().equals(constituencyId)) {
                for (ElectionList cc : c.getElectionLists()) {
                    if (cc.getElectoralParty().getId() == electoralParty.getId())
                        candidates = cc.getCandidates();
                }
            }
        }
        return candidateMapper.mapToCadidateDtoList(candidates);
    }

    public CandidateDto setCandidateElectoralParty(long candidateId, long electoralPartyId) throws EntityNotFoundException {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(EntityNotFoundException::new);
        candidate.setElectoralParty(electoralPartyRepository.findById(electoralPartyId).orElseThrow(EntityNotFoundException::new));
        return candidateMapper.mapToCandidateDto(candidate);
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

    public ConstituencyDto getConstituencyListByUserCityId(long electionId, long cityId) throws EntityNotFoundException {
        Election election = electionRepository.findById(electionId).orElseThrow(EntityNotFoundException::new);
        Constituency constituency = null;
        for (Constituency c : election.getConstituencies()) {
            for (City city : c.getCityList()) {
                if (city.getId() == cityId) {
                    constituency = c;
                }
            }
        }
        return constituencyMapper.mapToConstituencyDto(constituency);
    }

    public List<ConstituencyDto> getConstituencyByElectionID(long electionId) {
        List<Constituency> constituencies = constituencyRepository.findAll();
        List<Constituency> result = new ArrayList<>();
        for (Constituency tmp : constituencies) {
            if (tmp.getElection().getId().equals(electionId)) {
                result.add(tmp);
            }
        }
        return constituencyMapper.mapToConstituencyDtoList(result);
    }

    public List<ElectionListDto> getElectionListsByConstituencyId(long constituencyId) {
        List<ElectionList> electionLists = electionListRepository.findAll().stream()
                .filter(o -> o.getConstituency().getId().equals(constituencyId))
                .collect(Collectors.toList());
        return electionListMapper.mapToElectionListDtoList(electionLists);
    }

    public Boolean candidateInAnotherConstituency(long constituencyId) throws EntityNotFoundException {
        List<Candidate> candidates = candidateRepository.findAll();
        List<ElectionList> electionLists = electionListRepository.findAll();
        Constituency constituency = constituencyRepository.findById(constituencyId).orElseThrow(EntityNotFoundException::new);
        for (Candidate c : candidates) {
            if(electionLists.stream().filter(o -> o.getConstituency().getElection().getId() == constituency.getElection().getId() && o.getCandidates().contains(c)).findAny().isPresent()) {
                return true;
            }
        }
        return false;
    }

    //Election
    public List<ElectionDto> getElections() {
        return electionMapper.mapToElectionDtoList(electionRepository.findAll());
    }

    public ElectionDto getElection(long id) throws EntityNotFoundException {
        Election election = electionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return electionMapper.mapToElectionDto(election);
    }

    public ElectionDto updateElection(long id, ElectionDto electionDto) throws EntityNotFoundException {
        Election election = electionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        election.setConstituencies(constituencyMapper.mapToConstituencyList(electionDto.getConstituencies()));
        election.setElectionType(electionTypeMapper.mapToElectionType(electionDto.getElectionType()));
        election.setFinishDate(electionDto.getFinishDate());
        election.setStartDate(electionDto.getStartDate());
        election.setElectionName(electionDto.getElectionName());
        election.setListElectionList(electionListMapper.mapToElectionListList(electionDto.getListElectionList()));
        election.setActive(electionDto.isActive());
        return electionMapper.mapToElectionDto(electionRepository.save(election));
    }

    public Election createElection(ElectionDto electionDto) {
        return electionRepository.save(electionMapper.mapToElection(electionDto));
    }

    public void deleteElection(long electionId) {
        constituencyRepository.deleteById(electionId);
    }

    public ElectionDto getElectionByConstituencyId(long constituencyId) {
        List<Election> elections = electionRepository.findAll();
        Election election = null;
        for (Election tmp : elections) {
            for (Constituency constituency : tmp.getConstituencies()) {
                if (constituency.getId().equals(constituencyId)) {
                    election = tmp;
                    break;
                }
            }
        }
        return electionMapper.mapToElectionDto(election);
    }

    public CityDto getCityByConstituencyId(long constituencyId) {
        List<City> cities = cityRepository.findAll();
        City city  = null;
        for (City tmp : cities) {
            if (tmp.getConstituency().getId().equals(constituencyId)) {
                city = tmp;
                break;
            }
        }
        return cityMapper.mapToCityDto(city);
    }

    public ElectionDto electionSetConstituency(long electionId, long constituencyId) throws EntityNotFoundException {
        Election election = electionRepository.findById(electionId).orElseThrow(EntityNotFoundException::new);
        Constituency constituency = constituencyRepository.findById(constituencyId).orElseThrow(EntityNotFoundException::new);
        List<Constituency> constituencies = election.getConstituencies();
        constituencies.add(constituency);
        return electionMapper.mapToElectionDto(electionRepository.save(election));
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

    public List<ElectionListDto> getElectionListByConstituency(long constituencyId) throws EntityNotFoundException {
        Constituency constituency = constituencyRepository.findById(constituencyId).orElseThrow(EntityNotFoundException::new);
        List<ElectionList> electionLists = constituency.getElectionLists();
        return electionListMapper.mapToElectionListDtoList(electionLists);
    }


    public Boolean containPartyElectionlist(long constituencyId, long electoralPartyId) throws EntityNotFoundException {
        Constituency constituency = constituencyRepository.findById(constituencyId).orElseThrow(EntityNotFoundException::new);
        ElectoralParty electoralParty = electoralPartyRepository.findById(electoralPartyId).orElseThrow(EntityNotFoundException::new);
        List<ElectionList> electionLists = electionListRepository.findAll();
        if(electionLists.stream().filter(o -> o.getElectoralParty().getId()==(electoralParty.getId()) && o.getConstituency().getId() == constituency.getId()).findAny().isPresent()) {
            return true;
        }
        return false;
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

    public ElectoralPartyDto getElectoralPartyByCandidateId(long candidateId) throws EntityNotFoundException {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(EntityNotFoundException::new);
        if (candidate.getElectoralParty() == null) {
            return new ElectoralPartyDto();
        }
        ElectoralParty electoralParty = candidate.getElectoralParty();
        return electoralPartyMapper.mapToElectoralPartyDto(electoralParty);
    }

    public ElectoralParty createElectoralParty(ElectoralPartyDto electoralPartyDto) {
        return electoralPartyRepository.save(electoralPartyMapper.mapToElectoralParty(electoralPartyDto));
    }

    public void deleteElectoralParty(long electoralPartyId) {
        electoralPartyRepository.deleteById(electoralPartyId);
    }

    public List<ElectoralPartyDto> getElectoralPartiesByElectionList() {
        List<ElectionList> electionLists = electionListRepository.findAll();
        List<ElectoralParty> temp = new ArrayList<>();
        for (ElectionList e : electionLists) {
            temp.add(e.getElectoralParty());
        }
        return electoralPartyMapper.mapToElectoralPartyDtoList(temp);
    }

    public List<ElectoralPartyDto> getPartyByConstituency(long constituencyId) throws EntityNotFoundException {
        Constituency constituency = constituencyRepository.findById(constituencyId).orElseThrow(EntityNotFoundException::new);
        List<Election> elections = electionRepository.findAll();
        List<ElectoralParty> electoralParties = new ArrayList<>();
        for (Election e : elections) {
            for (Constituency c : e.getConstituencies()) {
                if (c.getId() == constituency.getId()) {
                    for (ElectionList el : c.getElectionLists()) {
                        System.out.println("ElectionList el:" + el);
                        if (el.getConstituency().getId() == constituency.getId()) {
                            electoralParties.add(el.getElectoralParty());
                        }
                    }

                }
            }
        }
        return electoralPartyMapper.mapToElectoralPartyDtoList(electoralParties);
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

    public VoteResultDto updateVoteResult(long voteResultId, String parameter, String value) throws EntityNotFoundException {
        VoteResult voteResult = voteResultRepository.findById(voteResultId).orElseThrow(EntityNotFoundException::new);
        switch (parameter) {
            case "election_id":
                Long id = new Long(value);
                Election election = electionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
                voteResult.setElection(election);
                break;
            case "candidate_id":
                Long id2 = new Long(value);
                List<Candidate> candidates = voteResult.getCandidates();
                Candidate candidate = candidateRepository.findById(id2).orElseThrow(EntityNotFoundException::new);
                candidates.add(candidate);
                voteResult.setCandidates(candidates);

                break;
            case "constituency_id":
                Long id3 = new Long(value);
                Constituency constituency = constituencyRepository.findById(id3).orElseThrow(EntityNotFoundException::new);
                voteResult.setConstituency(constituency);
                break;
        }
        return voteResultMap.mapToVoteResultDto(voteResultRepository.save(voteResult));
    }

    public List<VoteResultDto> getVotesForCandidateInConstituency(long candidateId, long constituencyId) throws EntityNotFoundException {
        List<VoteResult> allVoteResults = voteResultRepository.findAll();
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(EntityNotFoundException::new);
        List<VoteResult> filteredVoteResults = new ArrayList<>();
        for (VoteResult voteResult : allVoteResults) {
            if (voteResult.getConstituency().equals(constituencyId) && voteResult.getCandidates().contains(candidate)) {
                filteredVoteResults.add(voteResult);
            }
        }
        return voteResultMap.mapToVoteResultDtoList(filteredVoteResults);
    }

    //City
    public List<CityDto> getCities() {
        return cityMapper.mapToCityDtoList(cityRepository.findAll());
    }

    public CityDto getCty(long id) throws EntityNotFoundException {
        City city = cityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return cityMapper.mapToCityDto(city);
    }

    public City createCity(CityDto cityDto) {
        return cityRepository.save(cityMapper.mapToCity(cityDto));
    }

    public void deleteCity(long cityId) {
        cityRepository.deleteById(cityId);
    }

    public UserDto checkLoginData(String login, String password) {
        List<User> users = userRepository.findAll();
        User user = null;
        for (User tmp : users) {
            if (tmp.getPesel().equals(login)) {
                user = tmp;
                return userMapper.mapToUserDto(user);
            }
        }
        return null;
    }
}
