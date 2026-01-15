package collections_streams.optional;

import java.util.Optional;

public class User {

    private Address address;

    public User(Address address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
