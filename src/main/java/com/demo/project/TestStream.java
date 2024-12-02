package com.demo.project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static List<Account> accounts = Arrays.asList(
            new Account(1L, "Justin", "Butler", "justin.butler@gmail.com",
                    LocalDate.parse("2003-04-17"), Account.Sex.MALE, LocalDate.parse("2016-06-13"), BigDecimal.valueOf(172966)),
            new Account(2L, "Olivia", "Cardenas", "cardenas@mail.com",
                    LocalDate.parse("1930-01-19"), Account.Sex.FEMALE, LocalDate.parse("2014-06-21"), BigDecimal.valueOf(38029)),
            new Account(3L, "Nolan", "Donovan", "nolandonovan@gmail.com",
                    LocalDate.parse("1925-04-19"), Account.Sex.MALE, LocalDate.parse("2011-03-10"), BigDecimal.valueOf(13889)),
            new Account(4L, "Lucas", "Lynn", "lucas.lynn@yahoo.com",
                    LocalDate.parse("1987-05-25"), Account.Sex.MALE, LocalDate.parse("2009-03-05"), BigDecimal.valueOf(16980))
    );

    public Optional<Account> findRichestPerson() {
        return accounts.stream()
                .max(Comparator.comparing(Account::getBalance));
    }

    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        return accounts.stream()
                .filter(a -> a.getBirthday().getMonth().equals(birthdayMonth))
                .toList();
    }

    public Map<Boolean, List<Account>> partitionMaleAccounts() {
        return accounts.stream().collect(Collectors.partitioningBy(account -> account.getSex()
                .equals(Account.Sex.MALE)));
    }


    public Map<String, List<Account>> groupAccountsByEmailDomain() {
        if (accounts == null || accounts.isEmpty()) {
            return new HashMap<>();
        }

        return accounts.stream()
                .collect(Collectors.groupingBy(account -> account.getEmail()
                        .substring(account.getEmail()
                                .indexOf("@") + 1)));
    }

    public int getNumOfLettersInFirstAndLastNames(){
        return accounts.stream()
                .mapToInt(value -> value.getFirstName().length() + value.getLastName().length())
                .sum();
    }

    public BigDecimal calculateTotalBalance(){
        return BigDecimal.valueOf(accounts.stream()
                .mapToInt(value -> value.getBalance().intValue()).sum());
    }
}
