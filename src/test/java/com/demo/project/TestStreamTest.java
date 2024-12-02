package com.demo.project;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
        assertEquals(BigDecimal.valueOf(241864), testStream.calculateTotalBalance());
    }
}