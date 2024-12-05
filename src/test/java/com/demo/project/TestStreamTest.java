package com.demo.project;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static com.demo.project.TestStream.accounts;
import static org.junit.jupiter.api.Assertions.*;

class TestStreamTest {

    private TestStream testStream = new TestStream();

    @Test
    void testFindRichestPerson() {
        Optional<Account> account = Optional.of(accounts.getFirst());

        assertEquals(account, testStream.findRichestPerson());
    }

    @Test
    void testFindAccountsByBirthdayMonth() {
        List<Account> list = new ArrayList<>() {
        };
        list.add(accounts.get(0));
        list.add(accounts.get(2));

        assertEquals(list, testStream.findAccountsByBirthdayMonth(Month.APRIL));
    }

    @Test
    void partitionMaleAccounts() {
        Map<Boolean, List<Account>> expected = new HashMap<>(2);
        expected.put(Boolean.TRUE, List.of(accounts.get(0),
                accounts.get(2),
                accounts.get(3)));
        expected.put(Boolean.FALSE, List.of(accounts.get(1)));

        assertEquals(expected, testStream.partitionMaleAccounts());
    }

    @Test
    void testGroupAccountsByEmailDomain() {
        Map<String, List<Account>> expected = new HashMap<>(3);
        expected.put("gmail.com", List.of(accounts.get(0), accounts.get(2)));
        expected.put("mail.com", List.of(accounts.get(1)));
        expected.put("yahoo.com", List.of(accounts.get(3)));

        assertEquals(expected, testStream.groupAccountsByEmailDomain());
    }

    @Test
    void tesGetNumOfLettersInFirstAndLastNames() {
        assertEquals(47, testStream.getNumOfLettersInFirstAndLastNames());
    }

    @Test
    void testCalculateTotalBalance() {
        assertEquals(BigDecimal.valueOf(3000068898L), testStream.calculateTotalBalance());
    }

    @Test
    void testSortByFirstAndLastNames() {
        List<Account> list = new ArrayList<>() {
        };
        list.add(accounts.get(0));
        list.add(accounts.get(3));
        list.add(accounts.get(2));
        list.add(accounts.get(1));

        assertEquals(list, testStream.sortByFirstAndLastNames());
    }

    @Test
    void testContainsAccountWithEmailDomain() {

        assertTrue(testStream.containsAccountWithEmailDomain("gmail.com"));
        assertTrue(testStream.containsAccountWithEmailDomain("mail.com"));
    }

    @Test
    void testGetBalanceByEmail() {
        List<Account> list = new ArrayList<>();
        list.add(accounts.get(0));

        assertEquals(list.get(0).getBalance(), testStream.getBalanceByEmail("gmail.com"));
    }

    @Test
    void testGetEmailsOfAccountsCreatedAfter() {
        List<Account> list = new ArrayList<>();
        list.add(accounts.get(0));
        list.add(accounts.get(1));

        assertEquals(list, testStream.getEmailsOfAccountsCreatedAfter(
                LocalDate.of(2014, 1, 1)));
    }

    @Test
    void testGetOldestAccountHolder() {
        Optional<Account> account = Optional.of(accounts.get(3));

        assertEquals(account, testStream.getOldestAccountHolder());
    }

    @Test
    void testGetYoungestAccountHolder() {
        Optional<Account> account = Optional.of(accounts.getFirst());

        assertEquals(account, testStream.getYoungestAccountHolder());
    }

    @Test
    void testGetAccountsWithBalanceGreaterThan() {
        List<Account> list = new ArrayList<>();
        list.add(accounts.get(0));
        list.add(accounts.get(1));

        assertEquals(list, testStream.getAccountsWithBalanceGreaterThan(BigDecimal.valueOf(30000L)));
    }

    @Test
    void testGetTotalBalanceByDomain() {
        Map<String, BigDecimal> expected = new HashMap<>(3);
        expected.put("gmail.com", BigDecimal.valueOf(3_000_013_889L));
        expected.put("mail.com", BigDecimal.valueOf(38029L));
        expected.put("yahoo.com", BigDecimal.valueOf(16980L));

        assertEquals(expected, testStream.getTotalBalanceByDomain());
    }

    @Test
    void testGetEmailsByGenderWithBalanceGreaterThan() {
        Map<Account.Sex, List<String>> expected = new HashMap<>(3);
        expected.put(Account.Sex.MALE, List.of(accounts.get(0).getEmail(),
                accounts.get(3).getEmail()));
        expected.put(Account.Sex.FEMALE, List.of(accounts.get(1).getEmail()));

        assertEquals(expected, testStream.getEmailsByGenderWithBalanceGreaterThan(BigDecimal.valueOf(15_000L)));
    }

    @Test
    void testGetAccountsSortedByBalance() {
        List<Account> list = new ArrayList<>();
        list.add(accounts.get(0));
        list.add(accounts.get(1));
        list.add(accounts.get(3));
        list.add(accounts.get(2));

        assertEquals(list, testStream.getAccountsSortedByBalance());
    }

    @Test
    void testGetAverageBalance() {
        assertEquals(BigDecimal.valueOf(750_017_225), testStream.getAverageBalance());
    }

    @Test
    void testGetAccountWithLongestName() {
        Optional<Account> account = Optional.of(accounts.get(0));

        assertEquals(account, testStream.getAccountWithLongestName());
    }

    @Test
    void testCountAccountsByGender() {
        Map<Account.Sex, Long> expected = new HashMap<>(2);
        expected.put(Account.Sex.MALE, 3L);
        expected.put(Account.Sex.FEMALE, 1L);

        assertEquals(expected, testStream.countAccountsByGender());
    }

    @Test
    void testCollectAccountsById() {
        Map<Long, Account> expected = new HashMap<>(4);
        expected.put(1L, accounts.get(0));
        expected.put(2L, accounts.get(1));
        expected.put(3L, accounts.get(2));
        expected.put(4L, accounts.get(3));

        assertEquals(expected, testStream.collectAccountsById());
    }

    @Test
    void testGroupTotalBalanceByMonth() {
        List<Account> accounts = TestStream.accounts;
        Map<Month, BigDecimal> expected = new HashMap<>(2);
        expected.put(Month.JUNE, accounts.get(0).getBalance().add(accounts.get(1).getBalance()));
        expected.put(Month.MARCH, accounts.get(2).getBalance().add(accounts.get(3).getBalance()));

        assertEquals(expected, testStream.groupTotalBalanceByMonth());
    }

    @Test
    void testGetCharacterFrequencyInFirstNames() {
        Map<Character, Long> characterFrequencyInFirstAndLastNames = testStream.getCharacterFrequencyInFirstNames();

        assertEquals(3, characterFrequencyInFirstAndLastNames.get('a').longValue());
        assertEquals(1, characterFrequencyInFirstAndLastNames.get('c').longValue());
        assertEquals(3, characterFrequencyInFirstAndLastNames.get('i').longValue());
        assertEquals(1, characterFrequencyInFirstAndLastNames.get('J').longValue());
        assertEquals(1, characterFrequencyInFirstAndLastNames.get('L').longValue());
        assertEquals(2, characterFrequencyInFirstAndLastNames.get('l').longValue());
        assertEquals(2, characterFrequencyInFirstAndLastNames.get('u').longValue());
    }

    @Test
    void testGetAccountsBornBetween() {
        List<Account> list = new ArrayList<>();
        list.add(accounts.get(0));
        list.add(accounts.get(3));

        assertEquals(list, testStream.getAccountsBornBetween(
                LocalDate.of(1980, 05, 25),
                LocalDate.of(2005, 4, 17)));
    }

    @Test
    void testHasAccountWithBalanceGreaterThan() {
        assertTrue(testStream.hasAccountWithBalanceGreaterThan(BigDecimal.valueOf(38000)));
    }

    @Test
    void testGroupEmailsByGender() {
        Map<Account.Sex, List<Account>> sexListMap = new HashMap<>(2);
        sexListMap.put(Account.Sex.MALE, List.of(accounts.get(0),
                accounts.get(2),
                accounts.get(3)));
        sexListMap.put(Account.Sex.FEMALE, List.of(accounts.get(1)));

        assertEquals(sexListMap, testStream.groupEmailsByGender());
    }

    @Test
    void testGetTotalBalanceOfMaleAccounts() {
        BigDecimal bigDecimal = accounts.get(0).getBalance()
                  .add(accounts.get(2).getBalance()
                  .add(accounts.get(3).getBalance()));

        assertEquals(bigDecimal, testStream.getTotalBalanceOfMaleAccounts());
    }

    @Test
    void testSortAccountsByDateOfBirthDescending(){
        List<Account> list = new ArrayList<>(4);
        list.add(accounts.get(0));
        list.add(accounts.get(3));
        list.add(accounts.get(1));
        list.add(accounts.get(2));

        assertEquals(list, testStream.sortAccountsByDateOfBirthDescending());
    }

    @Test
    void testCountUniqueEmailDomains(){
        assertEquals(3L, testStream.countUniqueEmailDomains());
    }

    @Test
    void testGetAllAccountNamesCommaSeparated(){
        String strNames = "Justin, Olivia, Nolan, Lucas";

        assertEquals(strNames, testStream.getAllAccountNamesCommaSeparated());
    }

    @Test
    void testGroupAccountsByNameLength(){
        Map<Integer, List<Account>> listMap = new HashMap<>(4);
        listMap.put(12, List.of(accounts.get(0), accounts.get(2)));
        listMap.put(14, List.of(accounts.get(1)));
        listMap.put(9, List.of(accounts.get(3)));

        assertEquals(listMap, testStream.groupAccountsByNameLength());
    }

    @Test
    void testGetNewestAccountCreationDate(){
        Optional<LocalDate> localDate = Optional.of(accounts.get(0).getCreationDate());

        assertEquals(localDate, testStream.getNewestAccountCreationDate());
    }
}