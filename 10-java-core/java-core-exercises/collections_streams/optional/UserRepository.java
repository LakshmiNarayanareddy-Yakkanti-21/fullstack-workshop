package collections_streams.optional;

import java.util.Optional;

public class UserRepository {

    public Optional<User> findById(Long id) {
        return Optional.of(new User(new Address("A-101")));
    }
}
