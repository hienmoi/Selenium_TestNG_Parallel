package Common;

public class LocatorCRM {
    //Login Page
    public static String headerLogin = "//h1[normalize-space() = 'Login']";
    public static String inputEmail = "//input[@id = 'email']";
    public static String inputPassword = "//input[@id = 'password']";
    public static String checkboxRememberMe = "//input[@id = 'remember']";
    public static String buttonLogin = "//button[normalize-space() = 'Login']";
    public static String linkFogotPassword = "public static String";
    public static String alertErrorMessage = "//div[normalize-space() = 'Invalid email or password' and @class = 'text-center alert alert-danger']";

    //Dashboard page
    public static String menuDashBoard = "//span[normalize-space() = 'Dashboard']";
    public static String iconProfile = "//li[contains(@class , 'icon header-user-profile')]/descendant::img";
    public String totalInvoicesAwaitingPayment = "(//span[normalize-space() = 'Invoices Awaiting Payment']/parent::div)/following-sibling::span";
    public String totaConvertedLeads = "(//span[normalize-space() = 'Converted Leads']/parent::div)/following-sibling::span";

    //Task page
    public static String menuTask = "//span[normalize-space() = 'Tasks']";
    public static String buttonNewTask = "//a[contains(@onclick, 'new_task') and @class = 'btn btn-primary pull-left new']";


    //Customer page
    public static String menuCustomer = "//span[normalize-space() = 'Customers']";
    public static String headerCustomer = "//span[normalize-space() = 'Customers Summary']";
    public static String AddNewCustomer ="//a[normalize-space() = 'New Customer']";
    public static String searchCustomer ="//div[@id = 'clients_filter']//input";
    public static String inputCompany ="//input[@id='company']";
    public static String inputVAT ="//input[@id='vat']";
    public static String inputPhone ="//input[@id='phonenumber']";
    public static String inputWebsite ="//input[@id='website']";
    public static String dropdownGroup ="//button[@data-id = 'groups_in[]']";
    public static String inputSearchGroup ="//button[@data-id = 'groups_in[]']/following-sibling::div//input";
    public static String optionVIP ="//span[normalize-space()= 'VIP']";
    public static String dropdownLanguage ="//button[@data-id = 'default_language']";
    public static String optionVietnamese ="//span[normalize-space()= 'Vietnamese']";
    public static String inputAddress ="//textarea[@id = 'address']";
    public static String inputCity ="//input[@id = 'city']";
    public static String inputState ="//input[@id = 'state']";
    public static String inputZipCode ="//input[@id = 'zip']";
    public static String dropdownCountry ="//button[@data-id = 'country']";
    public static String inputSearchCountry ="//button[@data-id = 'country']/following-sibling::div//input";
    public static String optionVietnam ="//span[normalize-space()= 'Vietnam']";
    public static String buttonSave ="//div[@id = 'profile-save-section']/button[normalize-space() = 'Save']";
    public static String searchListCustomer ="//div[@id = 'clients_filter']//input[@type = 'search']";
    public static String itemCustomerFirst ="//table[@id = 'clients']//tr/td[3]/a";
}
