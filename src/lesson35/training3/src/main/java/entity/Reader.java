package entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement
public class Reader {

    private Long readerId;
    private String name;
    private String email;
    private String phone;

    public Reader(Long readerId, String name, String email, String phone) {
        this.readerId = readerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Reader() {
    }

    @XmlElement
    public Long getReaderId() {
        return readerId;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(readerId, reader.readerId) && Objects.equals(name, reader.name) && Objects.equals(email, reader.email) && Objects.equals(phone, reader.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, name, email, phone);
    }

    @Override
    public String toString() {
        return "Reader{" +
               "readerId=" + readerId +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", phone='" + phone + '\'' +
               '}';
    }
}
