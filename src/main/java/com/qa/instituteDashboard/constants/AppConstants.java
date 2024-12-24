package com.qa.instituteDashboard.constants;

import java.util.List;

public class AppConstants {
//    time for waits
    public static final int DEFAULT_SHORT_TIME_OUT =5;
    public static final int DEFAULT_MEDIUM_TIME_OUT =10;
    public static final int DEFAULT_LONG_TIME_OUT =20;

//    page titles
    public static final String LOGIN_PAGE_TITLE= "Institute Login - LEO 1 | Pay fees and get rewarded";
    public static final String HOME_PAGE_TITLE ="Institute Login - LEO 1 | Pay fees and get rewarded";
    public static final String STUDENT_LIST_PAGE_TITLE="institute.leo1.in/GTPL LEO1 CARD/fee-payment/student-list";
    public static final String REGISTER_ACCOUNT_SUCCESS_PAGE_TITLE="Your Account Has Been Created!";
    public static final String FEE_STRUCTURE_PAGE_TITLE="institute.leo1.in/GTPL LEO1 CARD//fee-payment/fee-structure";
    public static final String COINS_PAGE_TITLE="institute.leo1.in/GTPL LEO1 CARD/fee-payment/students-coins-requests";
    public static final String BULK_ACTIONS_PAGE_TITLE="institute.leo1.in/GTPL LEO1 CARD/fee-payment/bulk-actions";


    //    Page url's
    public static final String LOGIN_PAGE_FRACTION_URL ="institute/login";
    public static final String STUDENT_LIST_PAGE_FRACTION_URL= "fee-payment/student-list";
    public static final String DASHBOARD_PAGE_FRACTION_URL="/GTPL%20LEO1%20CARD";
    public static final String LOANS_PAGE_FRACTION_URL="applications/all-applications";
    public static final String ADD_STUDENT_PAGE_FRACTION_URL="/add-student";
    public static final String FEE_STRUCTURE_PAGE_FRACTION_URL="/fee-payment/fee-structure";
    public static final String COINS_PAGE_FRACTION_URL="/fee-payment/students-coins-requests";
    public static final String BULK_ACTIONS_PAGE_FRACTION_URL="fee-payment/bulk-actions";
    public static final String LEO1_CARD_PAGE_FRACTION_URL= "leo1-card/pre-issuance/dashboard";


    //    Headers List
    public static final List<String> EXPECTED_DASHBOARD_HEADERS_LIST = List.of("Dashboard","Add Student", "File Manager");
    public static final List<String> EXPECTED_FEEPAYMENT_HEADERS_LIST = List.of("Summary","Student List", "Fee Structure","Coins Request", "Bulk Actions");
    public static final List<String> EXPECTED_STUDENT_LIST_HEADERS_LIST = List.of("Student ID","Student Details", "Institute Details","Actions", "Fee Details");

    public static final int ACCOUNT_PAGE_HEADERS_COUNT = 3;
    public static final int STUDENT_LIST_HEADERS_COUNT = 5;

    public static final String STUDENT_MOBILE_NO = "7842290549";
    public static final String LOAN_STATUS = "Approved";
    public static final String ADD_STUDENT_HEADER = "Add Student";


}
