package com.pk.electionappserver.controller;

import com.pk.electionappserver.domain.EntityNotFoundException;
import com.pk.electionappserver.domain.dto.*;
import com.pk.electionappserver.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/election")
public class ElectionController {

    @Autowired
    private ElectionService service;

    //Candidate
    @GetMapping(value = "/getCandidates")
    public List<CandidateDto> getCandidates() {
        return service.getCandidates();
    }

    @GetMapping(value = "/getCandidatesByPart/{electoralPartyId}")
    public List<CandidateDto> getCandidatesByParty(@PathVariable long electoralPartyId) {
        return getCandidatesByParty(electoralPartyId);
    }

    @GetMapping(value = "/getCandidate/{candidateId}")
    public CandidateDto getCandidate(@PathVariable long candidateId) throws EntityNotFoundException {
        return service.getCandidate(candidateId);
    }

    @DeleteMapping(value = "/deleteCandidate/{candidateId}")
    public void deleteCandidate(@PathVariable long candidateId) {
        service.deleteCandidateById(candidateId);
    }

    @PostMapping(value = "/createCandidate")
    public void createCandidate(@RequestBody CandidateDto candidateDto) {
        service.createCandidate(candidateDto);
    }

    @GetMapping(value = "/getCandidateByElectionListElectoralParty/{electoralPartyId}")
    public List<CandidateDto> getCandidateByElectionListElectoralParty(@PathVariable long electoralPartyId) {
        return service.getCandidateByElectionListElectoralParty(electoralPartyId);
    }


    @GetMapping(value = "/getCandidatesElection/{constituencyId}/{electoralPartyId]")
    public List<CandidateDto> getCandidatesElection(@PathVariable long constituencyIdm, @PathVariable long electoralPartyId) throws EntityNotFoundException {
        return service.getCandidatesElection(constituencyIdm, electoralPartyId);
    }

    @GetMapping(value = "/candidateInAnotherConstituency/{constituencyId}")
    public Boolean candidateInAnotherConstituency(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.candidateInAnotherConstituency(constituencyId);
    }

    @GetMapping(value = "/setCandidateElectoralParty/{candidateId}/{electoralPartyId}")
    public CandidateDto setCandidateElectoralParty(@PathVariable long candidateId, @PathVariable long electoralPartyId) throws EntityNotFoundException {
        return service.setCandidateElectoralParty(candidateId, electoralPartyId);
    }

    //Constituency
    @GetMapping(value = "/getConstituencies")
    public List<ConstituencyDto> getConstituencies() {
        return service.getConstituencies();
    }

    @GetMapping(value = "/getConstituency/{constituencyId}")
    public ConstituencyDto getConstituency(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getConstituency(constituencyId);
    }

    @DeleteMapping(value = "/deleteConstituency/{constituencyId}")
    public void deleteConstituency(@PathVariable long constituencyId) {
        service.deleteConstituencyById(constituencyId);
    }

    @PostMapping(value = "/createConstituency")
    public void createConstituency(@RequestBody ConstituencyDto constituencyDto) {
        service.createConstituency(constituencyDto);
    }

    @GetMapping(value = "/getConstituency/{electionId}/{cityId}")
    public ConstituencyDto getConstituencyListByUserCityId(@PathVariable long electionId, @PathVariable long cityId) throws EntityNotFoundException {
        return service.getConstituencyListByUserCityId(electionId, cityId);
    }

    @GetMapping(value = "/getConstituencyByElectionID/{electionId}")
    public List<ConstituencyDto> getConstituencyByElectionID(@PathVariable long electionId) throws EntityNotFoundException {
        return service.getConstituencyByElectionID(electionId);
    }

    //Election
    @GetMapping(value = "/getElections")
    public List<ElectionDto> getElections() {
        return service.getElections();
    }

    @GetMapping(value = "/getElection/{electionId}")
    public ElectionDto getElection(@PathVariable long electionId) throws EntityNotFoundException {
        return service.getElection(electionId);
    }

    @PutMapping(value = "/updateElection")
    public ElectionDto updateElection(@PathVariable long electionId, @RequestBody ElectionDto electionDto) throws EntityNotFoundException {
        return service.updateElection(electionId, electionDto);
    }

    @DeleteMapping(value = "/deleteElection/{electionId}")
    public void deleteElection(@PathVariable long electionId) {
        service.deleteElection(electionId);
    }

    @PostMapping(value = "/createElection")
    public void createElection(@RequestBody ElectionDto electionDto) {
        service.createElection(electionDto);
    }

    @GetMapping(value = "/getElectionByConstituencyId/{constituencyId}")
    public ElectionDto getElectionByConstituencyId(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getElectionByConstituencyId(constituencyId);
    }

    @GetMapping(value = "/electionSetConstituency/{electionId}/{constituencyId}")
    public ElectionDto electionSetConstituency(@PathVariable long electionId, @PathVariable long constituencyId) throws EntityNotFoundException {
        return service.electionSetConstituency(electionId, constituencyId);
    }

    //ElectionList
    @GetMapping(value = "/getElectionLists")
    public List<ElectionListDto> getElectionLists() {
        return service.getElectionLists();
    }

    @GetMapping(value = "/getElectionList/{electionListId}")
    public ElectionListDto getElectionList(@PathVariable long electionListId) throws EntityNotFoundException {
        return service.getElectionList(electionListId);
    }

    @DeleteMapping(value = "/deleteElectionList/{electionListId}")
    public void deleteElectionList(@PathVariable long electionListId) {
        service.deleteElectionList(electionListId);
    }

    @PostMapping(value = "/createElectionList")
    public void createElectionList(@RequestBody ElectionListDto electionListDto) {
        service.createElectionList(electionListDto);
    }

    @GetMapping(value = "/getElectionListByConstituency/{constituencyId}")
    public List<ElectionListDto> getElectionListByConstituency(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getElectionListByConstituency(constituencyId);
    }

    @GetMapping(value = "/getElectionListsByConstituencyId/{constituencyId}")
    public List<ElectionListDto> getElectionListsByConstituencyId(@PathVariable long constituencyId) {
        return service.getElectionListsByConstituencyId(constituencyId);
    }

    @GetMapping(value = "/containPartyElectionlist/{constituencyId}/{electoralPartyId}")
    public Boolean containPartyElectionlist(@PathVariable long constituencyId, @PathVariable long electoralPartyId) throws EntityNotFoundException {
        return service.containPartyElectionlist(constituencyId, electoralPartyId);
    }

    //ElectionType
    @GetMapping(value = "/getElectionTypes")
    public List<ElectionTypeDto> getElectionTypes() {
        return service.getElectionTypes();
    }

    @GetMapping(value = "/getElectionType/{electionTypeId}")
    public ElectionTypeDto getElectionType(@PathVariable long electionTypeId) throws EntityNotFoundException {
        return service.getElectionType(electionTypeId);
    }

    @DeleteMapping(value = "/deleteElectionType/{electionTypeId}")
    public void deleteElectionType(@PathVariable long electionTypeId) {
        service.deleteElectionType(electionTypeId);
    }

    @PostMapping(value = "/createElectionType")
    public void createElectionType(@RequestBody ElectionTypeDto electionTypeDto) {
        service.createElectionType(electionTypeDto);
    }

    //ElectoralParty
    @GetMapping(value = "/getElectoralParties")
    public List<ElectoralPartyDto> getElectoralParties() {
        return service.getElectoralParties();
    }

    @GetMapping(value = "/getElectoralParty/{electoralPartyId}")
    public ElectoralPartyDto getElectoralParty(@PathVariable long electoralPartyId) throws EntityNotFoundException {
        return service.getElectoralParty(electoralPartyId);
    }

    @DeleteMapping(value = "/deleteElectoralParty/{electoralPartyId}")
    public void deleteElectoralParty(@PathVariable long electoralPartyId) {
        service.deleteElectoralParty(electoralPartyId);
    }

    @PostMapping(value = "/createElectoralParty")
    public void createElectoralParty(@RequestBody ElectoralPartyDto electoralPartyDto) {
        service.createElectoralParty(electoralPartyDto);
    }

    @GetMapping(value = "/getElectoralPartiesByElectionList")
    public List<ElectoralPartyDto> getElectoralPartiesByElectionList() {
        return service.getElectoralPartiesByElectionList();
    }

    @GetMapping(value = "/getPartyByConstituency/{constituencyId}")
    public List<ElectoralPartyDto> getPartyByConstituency(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getPartyByConstituency(constituencyId);
    }

    @GetMapping(value = "/getElectoralPartyByCandidateId/{candidateId}")
    public ElectoralPartyDto getElectoralPartyByCandidateId(@PathVariable long candidateId) throws EntityNotFoundException {
        return service.getElectoralPartyByCandidateId(candidateId);
    }

    //ElectoralProgramme
    @GetMapping(value = "/getElectoralProgrammes")
    public List<ElectoralProgrammeDto> getElectoralProgrammes() {
        return service.getElectoralProgramms();
    }

    @GetMapping(value = "/getElectoralProgramme/{electoralProgrammeId}")
    public ElectoralProgrammeDto getElectoralProgramme(@PathVariable long electoralProgrammeId) throws EntityNotFoundException {
        return service.getElectoralProgramme(electoralProgrammeId);
    }

    @DeleteMapping(value = "/deleteElectoralProgramme/{electoralProgrammeId}")
    public void deleteElectoralProgramme(@PathVariable long electoralProgrammeId) {
        service.deleteElectoralProgramme(electoralProgrammeId);
    }

    @PostMapping(value = "/createElectoralProgramme")
    public void createElectoralProgramme(@RequestBody ElectoralProgrammeDto electoralProgrammeDto) {
        service.createElectoralProgramme(electoralProgrammeDto);
    }

    //User
    @GetMapping(value = "/getUsers")
    public List<UserDto> getUsers() {
        return service.getUsers();
    }

    @GetMapping(value = "/getUser/{userId}")
    public UserDto getUser(@PathVariable long userId) throws EntityNotFoundException {
        return service.getUser(userId);
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public void deleteUser(@PathVariable long userId) {
        service.deleteUser(userId);
    }

    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody UserDto userDto) {
        service.createUser(userDto);
    }

    //VoteResult
    @GetMapping(value = "/getVoteResults")
    public List<VoteResultDto> getVoteResults() {
        return service.getVoteResults();
    }

    @GetMapping(value = "/getVoteResult/{voteResultId}")
    public VoteResultDto getVoteResult(@PathVariable long voteResultId) throws EntityNotFoundException {
        return service.getVoteResult(voteResultId);
    }

    @DeleteMapping(value = "/deleteVoteResult/{voteResultId}")
    public void deleteVoteResult(@PathVariable long voteResultId) {
        service.deleteVoteResult(voteResultId);
    }

    @PostMapping(value = "/createVoteResult")
    public void createVoteResult(@RequestBody VoteResultDto voteResultDto) {
        service.createVoteResult(voteResultDto);
    }

    @PutMapping(value = "/updateVoteResult/{voteResultId}/{parameter}/{value}")
    public void updateVoteResult(@PathVariable long voteResultId, String parameter, String value) throws EntityNotFoundException {
        service.updateVoteResult(voteResultId, parameter, value);
    }

    @GetMapping(value = "/getVotesForCandidateInConstituency/{candidateId}/{constituencyId}")
    public List<VoteResultDto> getVotesForCandidateInConstituency(@PathVariable long candidateId, @PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getVotesForCandidateInConstituency(candidateId, constituencyId);
    }

    //City
    @GetMapping(value = "/getCities")
    public List<CityDto> getCities() {
        return service.getCities();
    }

    @GetMapping(value = "/getCity/{cityId}")
    public CityDto getCity(@PathVariable long cityId) throws EntityNotFoundException {
        return service.getCty(cityId);
    }

    @DeleteMapping(value = "/deleteCity/{cityId}")
    public void deleteCity(@PathVariable long cityId) {
        service.deleteCity(cityId);
    }

    @PostMapping(value = "/createCity")
    public void createCity(@RequestBody CityDto cityDto) {
        service.createCity(cityDto);
    }

    @GetMapping(value = "/getCityByConstituencyId/{constituencyId}")
    public CityDto getCityByConstituencyId(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getCityByConstituencyId(constituencyId);
    }

    @GetMapping(value = "/checkLoginData/{login}/{password}")
    public UserDto checkLoginData(@PathVariable String login, @PathVariable String password) throws EntityNotFoundException {
        return service.checkLoginData(login, password);
    }
}
