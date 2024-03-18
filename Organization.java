
import java.util.Objects;
class Organization1 implements Cloneable {
    private String organizationCode;
    private String organizationName;
    private String organizationAddress;

    public Organization1(String organizationCode, String organizationName, String organizationAddress) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.organizationAddress = organizationAddress;
    }


    public String getOrganizationCode() {
        return organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    @Override
    public Organization1 clone() {
        try {
            return (Organization1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization1 that = (Organization1) o;
        return Objects.equals(organizationCode, that.organizationCode) &&
                Objects.equals(organizationName, that.organizationName) &&
                Objects.equals(organizationAddress, that.organizationAddress);
    }
    @Override
    public int hashCode() {
        return Objects.hash(organizationCode, organizationName, organizationAddress);
    }
}

public class Organization {
    public static void main(String[] args) {
        
        Organization1 org1 = new Organization1("001", "ABC Corp", "123 Main St");
        Organization1 org2 = org1.clone();
        System.out.println("Original Object:");
        org1.printDetails();
        System.out.println("\nCloned Object:");
        org2.printDetails();
    }
}
