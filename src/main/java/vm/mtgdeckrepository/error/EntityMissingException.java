package vm.mtgdeckrepository.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityMissingException extends RuntimeException {

    private static final long serialVersionUID = 10L;

    public EntityMissingException(String message) {
        super(message);
    }
}
