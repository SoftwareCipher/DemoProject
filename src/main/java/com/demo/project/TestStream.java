package com.demo.project;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStream {
    public static List<Account> accounts = Arrays.asList(
            new Account(1L, "Justin", "Butler", "justin.butler@gmail.com",
                    LocalDate.parse("2003-04-17"), Account.Sex.MALE, LocalDate.parse("2016-06-13"),
                    BigDecimal.valueOf(3_000_000_000L)),

            new Account(2L, "Olivia", "Cardenas", "cardenas@mail.com",
                    LocalDate.parse("1930-01-19"), Account.Sex.FEMALE, LocalDate.parse("2014-06-21"),
                    BigDecimal.valueOf(38029)),

            new Account(3L, "Nolan", "Donovan", "nolandonovan@gmail.com",
                    LocalDate.parse("1925-04-19"), Account.Sex.MALE, LocalDate.parse("2011-03-10"),
                    BigDecimal.valueOf(13889)),

            new Account(4L, "Lucas", "Lynn", "lucas.lynn@yahoo.com",
                    LocalDate.parse("1987-05-25"), Account.Sex.MALE, LocalDate.parse("2009-03-05"),
                    BigDecimal.valueOf(16980))
    );

    public Optional<Account> findRichestPerson() {
        return accounts.stream()
                .max(Comparator.comparing(Account::getBalance));
    }

    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        return accounts.stream()
                .filter(account -> account.getBirthday().getMonth().equals(birthdayMonth))
                .toList();
    }

    public Map<Boolean, List<Account>> partitionMaleAccounts() {
        return accounts.stream()
                .collect(Collectors.partitioningBy(account -> account.getSex().equals(Account.Sex.MALE)));
    }


    public Map<String, List<Account>> groupAccountsByEmailDomain() {
        return accounts.stream()
                .collect(Collectors.groupingBy(account -> account.getEmail().split("@")[1]));
    }

    public int getNumOfLettersInFirstAndLastNames() {
        return accounts.stream()
                .mapToInt(value -> value.getFirstName().length() + value.getLastName().length())
                .sum();
    }

    //TODO
    public BigDecimal calculateTotalBalance() {
//        return BigDecimal.valueOf(accounts.stream().mapToInt(value -> value.getBalance().toBigInteger()).sum());

        return accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Account> sortByFirstAndLastNames() {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::getFirstName)
                        .thenComparing(Account::getLastName))
                .toList();
    }

    public boolean containsAccountWithEmailDomain(String emailDomain) {
        return accounts.stream()
                .anyMatch(account -> account.getEmail().endsWith(emailDomain));
    }

    public BigDecimal getBalanceByEmail(String email) {
        return accounts.stream()
                .filter(account -> account.getEmail()
                        .endsWith(email))
                .map(Account::getBalance)
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(String.format("Account with %s not found", email)));
    }

    public List<Account> getEmailsOfAccountsCreatedAfter(LocalDate localDate) {
        return accounts.stream()
                .filter(account -> account.getCreationDate().isAfter(localDate))
                .toList();
    }

    public Optional<Account> getOldestAccountHolder() {
        return accounts.stream()
                .min(Comparator.comparing(Account::getCreationDate));
    }

    public Optional<Account> getYoungestAccountHolder() {
        return accounts.stream()
                .max(Comparator.comparing(Account::getCreationDate));
    }

    public List<Account> getAccountsWithBalanceGreaterThan(BigDecimal bigDecimal) {
        return accounts.stream()
                .filter(account -> account.getBalance().compareTo(bigDecimal) > 0)
                .toList();
    }

    public Map<String, BigDecimal> getTotalBalanceByDomain() {
//        return accounts.stream()
//                .collect(Collectors.groupingBy(
//                        Account::getEmail,
//                        accounts.stream().map(Account::getBalance)
//                                .reduce(BigDecimal.ZERO, BigDecimal::add)));


        return accounts.stream()
                .collect(Collectors.groupingBy(
                        account -> account.getEmail().substring(account.getEmail().indexOf("@") + 1),
                        Collectors.mapping(Account::getBalance,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }

    public Map<Account.Sex, List<String>> getEmailsByGenderWithBalanceGreaterThan(BigDecimal minBalance) {
        return accounts.stream()
                .filter(account -> account.getBalance().compareTo(minBalance) > 0)
                .collect(Collectors.groupingBy(
                        Account::getSex,
                        Collectors.mapping(Account::getEmail, Collectors.toList())
                ));
    }

    public List<Account> getAccountsSortedByBalance() {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .toList();
    }

    public BigDecimal getAverageBalance() {
        return accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(accounts.size()), RoundingMode.HALF_UP);
    }

    public Optional<Account> getAccountWithLongestName() {
        return accounts.stream()
                .max(Comparator.comparing(name -> name.getFirstName().length()));
    }

    public Map<Account.Sex, Long> countAccountsByGender() {
        return accounts.stream()
                .collect(Collectors.groupingBy(
                        Account::getSex,
                        Collectors.counting()));
    }

    public Map<Long, Account> collectAccountsById() {
        return accounts.stream()
                .collect(Collectors.toMap(Account::getId, Function.identity()));
    }

    public Map<Month, BigDecimal> groupTotalBalanceByMonth() {
        return accounts.stream()
                .collect(Collectors.groupingBy(account -> account.getCreationDate().getMonth(),
                        Collectors.mapping(Account::getBalance,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }

    public Map<Character, Long> getCharacterFrequencyInFirstNames() {
        return accounts.stream()
                .map(Account::getFirstName)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

//    public Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames(int nameLengthBound) {
//        return Stream.concat()
//    }

    public List<Account> getAccountsBornBetween(LocalDate start, LocalDate end) {
        return accounts.stream()
                .filter(account -> account.getBirthday().isAfter(start))
                .filter(account -> account.getBirthday().isBefore(end))
                .toList();
    }

    public boolean hasAccountWithBalanceGreaterThan(BigDecimal amount) {
        return accounts.stream()
                .anyMatch(account -> account.getBalance().compareTo(amount) > 0);
    }

    //Сгруппировать email-адреса по полу и вернуть их в виде списка
    public Map<Account.Sex, List<Account>> groupEmailsByGender() {
        return accounts.stream()
                .collect(Collectors.groupingBy(
                        Account::getSex
                ));
    }

    //Получить сумму балансов всех мужчин
    public BigDecimal getTotalBalanceOfMaleAccounts() {
        return accounts.stream()
                .filter(account -> account.getSex().equals(Account.Sex.MALE))
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Сортировать аккаунты по дате рождения в порядке убывания
    public List<Account> sortAccountsByDateOfBirthDescending() {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::getBirthday).reversed())
                .toList();
    }

    //Посчитать количество уникальных доменов email
    public long countUniqueEmailDomains() {
        return accounts.stream()
                .map(account -> account.getEmail()
                        .substring(account.getEmail().indexOf("@") + 1))
                .distinct()
                .count();
    }

    //Создать строку с именами всех пользователей, разделёнными запятой
    public String getAllAccountNamesCommaSeparated() {
        return accounts.stream()
                .map(Account::getFirstName)
                .collect(Collectors.joining(", "));
    }

    //Сгруппировать аккаунты по длине имени (имя + фамилия)
    public Map<Integer, List<Account>> groupAccountsByNameLength() {
        return accounts.stream()
                .collect(Collectors.groupingBy(
                        account -> account.getFirstName().length() + account.getLastName().length()
                ));
    }

    //Получить дату создания самого нового аккаунта
    public Optional<LocalDate> getNewestAccountCreationDate() {
        return accounts.stream()
                .map(Account::getCreationDate)
                .max(Comparator.comparing(Function.identity()));
    }
}
