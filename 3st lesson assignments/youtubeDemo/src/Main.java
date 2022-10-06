public class Main {

    public static void main(String[] args) {
        // IoC Container
        CustomerManager customerManager = new CustomerManager(new Customer(), new TeacherCreditManager());
        customerManager.giveCredit();
    }
}

class CreditManager {
    public void calculate() {
        System.out.println("Hesaplandı");
    }

    public void save() {
        System.out.println("Kredi verildi.");
    }
}

interface CreditService {
    void calculate();

    void save();
}

abstract class BaseCreditManager implements CreditService {
    public abstract void calculate();

    public void save() {
        System.out.println("Kaydedildi.");
    }
}

class TeacherCreditManager extends BaseCreditManager implements CreditService {

    @Override
    public void calculate() {
        System.out.println("Öğretmen kredisi hesaplandı.");
    }
}

class MilitaryCreditManager extends BaseCreditManager implements CreditService {

    @Override
    public void calculate() {
        System.out.println("Asker kredisi hesaplandı.");
    }
}

class CarCreditManager extends BaseCreditManager implements CreditService {

    @Override
    public void calculate() {
        System.out.println("Araç kredisi hesaplandı.");
    }
}

class Customer {

    public Customer() {
        System.out.println("Müşteri başlatıldı");
    }

    public int id;
    public String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class Person extends Customer {
    public String nationalIdentity;
    public String firstName;
    public String lastName;

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class Company extends Customer {
    public String companyName;
    public String taxNumber;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}

// Katmanlı mimari

class CustomerManager {
    private Customer customer;
    private CreditService creditService;

    public CustomerManager(Customer customer, CreditService creditService) {
        this.customer = customer;
        this.creditService = creditService;
    }

    public void save() {
        System.out.println("Müşteri kaydedildi");
    }

    public void delete() {
        System.out.println("Müşteri silindi");
    }

    public void giveCredit() {
        creditService.calculate();
        System.out.println("Kredi verildi");
    }
}