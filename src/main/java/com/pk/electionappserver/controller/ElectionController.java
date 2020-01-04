package com.pk.electionappserver.controller;

import com.pk.electionappserver.domain.EntityNotFoundException;
import com.pk.electionappserver.domain.dto.*;
import com.pk.electionappserver.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //Election
    @GetMapping(value = "/getElections")
    public List<ElectionDto> getElections() {
        return service.getElections();
    }

    @GetMapping(value = "/getElection/{electionId}")
    public ElectionDto getElection(@PathVariable long electionId) throws EntityNotFoundException {
        return service.getElection(electionId);
    }

    @DeleteMapping(value = "/deleteElection/{electionId}")
    public void deleteElection(@PathVariable long electionId) {
        service.deleteElection(electionId);
    }

    @PostMapping(value = "/createElection")
    public void createElection(@RequestBody ElectionDto electionDto) {
        service.createElection(electionDto);
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

    //Report
    @GetMapping(value = "/getReports")
    public List<ReportDto> getReports() {
        return service.getReports();
    }

    @GetMapping(value = "/getReport/{reportId}")
    public ReportDto getReport(@PathVariable long reportId) throws EntityNotFoundException {
        return service.getReport(reportId);
    }

    @DeleteMapping(value = "/deleteReport/{reportId}")
    public void deleteReport(@PathVariable long reportId) {
        service.deleteReport(reportId);
    }

    @PostMapping(value = "/createReport")
    public void createReport(@RequestBody ReportDto reportDto) {
        service.createReport(reportDto);
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
}
