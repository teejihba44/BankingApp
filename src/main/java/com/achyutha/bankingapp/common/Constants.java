package com.achyutha.bankingapp.common;

import com.achyutha.bankingapp.domain.model.enums.AccountType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {

    public static class BasicFormatting {
        public static final String FORMAT_2 = "%s %s";
    }
    public static final String BLANK_SPACE = " ";
    public static final String CANNOT_DELETE_ADMIN = "Cannot delete user - %s, since the user is an admin.";
    public static final String USER_DELETED_SUCCESS = "User %s deleted successfully.";


    public static final String USER_NOT_FOUND = "user.not.found";
    public static final String KYC_NOT_FOUND = "kyc.not.found";

    public static final String EMPLOYEE_EMAIL_SUFFIX = "@bankapp.com";
    public static final String EMPLOYEE_EMAIL_PATTERN = "%s.%s%s";

    public static final String EMPLOYEE_ID_PREFIX = "BA";

    public static final LocalDate DEFAULT_DATE = LocalDate.of(1996, 4, 28);

    public static final String KYC_NOT_UPDATED = "kyc.not.updated.or.verified";
    public static final String CUSTOMER_NOT_ACTIVE = "customer.not.active";
    public static final String ACCOUNT_REQUEST_NOT_FOUND = "account.request.not.found";
    public static final String ACCOUNT_NOT_FOUND = "account.not.found";

    public static final String DEPOSIT_MESSAGE = "%s money credited.";
    public static final String WITHDRAW_MESSAGE = "%s money withdrawn";
    public static final String WITHDRAW_REQUEST_GREATER = "Withdraw request amount greater than balance - %s.";
    public static final String WITHDRAW_REQUEST_EXCEEDED = "Withdraw request limit exceeded.";
    public static final String FIRST_TRANSACTION_SAVINGS = "First transaction, a deposit of %s is necessary.";
    public static final String LOAN_MESSAGE = "Repayment of %s successful.";
    public static final String TRANSFER_AMOUNT = "Transferred amount - %s from %s to %s (%s)";
    public static final String RECEIVE_AMOUNT = "Received amount - %s from %s (%s)";
    public static final String LOAN_AMOUNT_CREDITED = "Loan approved, credited amount - %s successfully.";
    public static final String BANK_APP_NO_REPLY = "noreply@bankApp.com";
    public static final String BANK_APP_EMAIL_SUBJECT = "Sign-in information";
    public static final String BANK_APP_EMAIL_USER_SUBJECT = "Hello Customer, your sign-in information";
    public static final String BANK_APP_EMAIL_LOAN_SUBJECT = "Loan repayment reminder.";
    public static final String BANK_APP_EMAIL_LOAN_TEXT = "Hello %s,\nThis is an autogenerated email, to remind you about the loan repayment schedule." +
            "\nPlease ignore if you have paid the EMI already.\nRegards,\nBank App";
    public static final String SIGN_IN_RESPONSE = "Hello %s,\nYour details:\nuser id - %s\ntemporary password - " +
            "%s\nPlease login and change your password.\nRegards,\nBank App";
    public static final String EXPORT_USER_DETAILS = "User ID - %s\nFull Name - %s\nTotal Accounts - %s\nUser Status - %s\nStatement Printed on - %s";
    public static final String APPROVE_CONSTANT = "approve";
    public static final List<Integer> VALID_MONTH = List.of(1,3,6,12);


    public static final List<String> EXPORT_TRANSACTION_INFO = List.of("Transaction Date", "Balance before transaction", "Balance after transaction", "Message");

    public static final List<String> EXPORT_BASIC_ACCOUNT_INFO = List.of("Account ID", "Account Type", "Account Balance");
    public static final Map<AccountType, List<String>> EXPORT_ACCOUNT_TYPE_INFO = Map.of(
            AccountType.savings, Stream.concat(EXPORT_BASIC_ACCOUNT_INFO.stream(), List.of("Interest Accrued Last Month", "Transactions remaining").stream()).collect(Collectors.toList()),
            AccountType.current, Stream.concat(EXPORT_BASIC_ACCOUNT_INFO.stream(), List.of("Employer").stream()).collect(Collectors.toList()),
            AccountType.loan, Stream.concat(EXPORT_BASIC_ACCOUNT_INFO.stream(), List.of("Loan Amount", "Tenure chosen", "Last Repayment").stream()).collect(Collectors.toList())
    );
}