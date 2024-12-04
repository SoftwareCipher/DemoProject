package com.demo.project;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestStreamTest {

    private TestStream testStream = new TestStream();
    @Test
    void testFindRichestPerson() {
        Optional<Account> account = Optional.of(TestStream.accounts.get(0));

        assertEquals(account, testStream.findRichestPerson());
    }

    @Test
    void testFindAccountsByBirthdayMonth(){
        List<Account> list = new ArrayList<>(){};
        list.add(TestStream.accounts.get(0));
        list.add(TestStream.accounts.get(2));

       assertEquals(list, testStream.findAccountsByBirthdayMonth(Month.APRIL));
    }
    @Test
    void partitionMaleAccounts(){
        Map<Boolean, List<Account>> expected = new HashMap<>(2);
        expected.put(Boolean.TRUE, List.of(TestStream.accounts.get(0),
                TestStream.accounts.get(2),
                TestStream.accounts.get(3)));
        expected.put(Boolean.FALSE, List.of(TestStream.accounts.get(1)));

        assertEquals(expected, testStream.partitionMaleAccounts());
    }

    @Test
    void testGroupAccountsByEmailDomain(){
        Map<String, List<Account>> expected = new HashMap<>(3);
        expected.put("gmail.com", List.of(TestStream.accounts.get(0), TestStream.accounts.get(2)));
        expected.put("mail.com", List.of(TestStream.accounts.get(1)));
        expected.put("yahoo.com", List.of(TestStream.accounts.get(3)));

        assertEquals(expected, testStream.groupAccountsByEmailDomain());
    }

    @Test
    void tesGetNumOfLettersInFirstAndLastNames(){
        assertEquals(47, testStream.getNumOfLettersInFirstAndLastNames());
    }

    @Test
    void testCalculateTotalBalance(){
        assertEquals(BigDecimal.valueOf(3000068898L), testStream.calculateTotalBalance());
    }

    @Test
    void testSortByFirstAndLastNames(){
        List<Account> list = new ArrayList<>(){};
        list.add(TestStream.accounts.get(0));
        list.add(TestStream.accounts.get(3));
        list.add(TestStream.accounts.get(2));
        list.add(TestStream.accounts.get(1));

        assertEquals(list, testStream.sortByFirstAndLastNames());
    }

    @Test
    void testContainsAccountWithEmailDomain(){

        assertTrue(testStream.containsAccountWithEmailDomain("gmail.com"));
        assertTrue(testStream.containsAccountWithEmailDomain("mail.com"));
    }

    @Test
    void testGetBalanceByEmail(){
        List<Account> list = new ArrayList<>();
        list.add(TestStream.accounts.get(0));

        assertEquals(list.get(0).getBalance(), testStream.getBalanceByEmail("gmail.com"));
    }

    @Test
    void testGetEmailsOfAccountsCreatedAfter(){
        List<Account> list = new ArrayList<>();
        list.add(TestStream.accounts.get(0));
        list.add(TestStream.accounts.get(1));

        assertEquals(list, testStream.getEmailsOfAccountsCreatedAfter(
                LocalDate.of(2014, 1, 1)));
    }

    @Test
    void testGetOldestAccountHolder(){
        Optional<Account> account = Optional.of(TestStream.accounts.get(3));

        assertEquals(account, testStream.getOldestAccountHolder());
    }

    @Test
    void testGetYoungestAccountHolder(){
        Optional<Account> account = Optional.of(TestStream.accounts.getFirst());

        assertEquals(account, testStream.getYoungestAccountHolder());
    }

    @Test
    void testGetAccountsWithBalanceGreaterThan(){
        List<Account> list = new ArrayList<>();
        list.add(TestStream.accounts.get(0));
        list.add(TestStream.accounts.get(1));

        assertEquals(list, testStream.getAccountsWithBalanceGreaterThan(BigDecimal.valueOf(30000L)));
    }

    @Test
    void testGetTotalBalanceByDomain(){
        Map<String, BigDecimal> expected = new HashMap<>(3);
        expected.put("gmail.com", BigDecimal.valueOf(3_000_013_889L));
        expected.put("mail.com", BigDecimal.valueOf(38029L));
        expected.put("yahoo.com", BigDecimal.valueOf(16980L));

        assertEquals(expected, testStream.getTotalBalanceByDomain());
    }

    @Test
    void testGetEmailsByGenderWithBalanceGreaterThan(){
        Map<Account.Sex, List<String>> expected = new HashMap<>(1);
        expected.put(Account.Sex.MALE, List.of(TestStream.accounts.get(0).getEmail(),
                TestStream.accounts.get(3).getEmail()));
        expected.put(Account.Sex.FEMALE, List.of(TestStream.accounts.get(1).getEmail()));

        assertEquals(expected, testStream.getEmailsByGenderWithBalanceGreaterThan(BigDecimal.valueOf(15_000L)));
    }
}